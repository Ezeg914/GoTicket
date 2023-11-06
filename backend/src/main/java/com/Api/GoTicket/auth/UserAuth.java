package com.Api.GoTicket.auth;

import com.Api.GoTicket.models.DataLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.Api.GoTicket.utils.JWTUtil;
import com.Api.GoTicket.utils.ResponseUtil;
import com.Api.GoTicket.models.UserModel;
import org.springframework.stereotype.Component;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import com.Api.GoTicket.repositories.IUserRepository;


@Component
public class UserAuth {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    public UserModel userLogged(UserModel user) {
        UserModel current_user = userRepository.findByEmail(user.getEmail());

        String passwordHash = current_user.getPassword();

        if (this.verifyPassword(user.getPassword(), passwordHash)) {
            return current_user;
        }
        return null;
    }


    public ResponseUtil createToken(UserModel current_user) {
        if(current_user != null){
            String token = jwtUtil.create(String.valueOf(current_user.getId()), current_user.getEmail());
            DataLogModel data = new DataLogModel(token, current_user.getId());
            return new ResponseUtil("Token succesfully generated", true, 200, data);
        }
        return new ResponseUtil("Incorrect credentials", false, 401, null);
    }

    public String generatePasswordHash(String password) {
        return argon2.hash(1, 1024, 1, password);
    }

    public boolean verifyPassword(String password, String hash) {
        return argon2.verify(hash, password);
    }

    public ResponseUtil verifyEmailDuplicated(UserModel userModel){
        UserModel existingUser = userRepository.findByEmail(userModel.getEmail());

        if(existingUser != null){
            return new ResponseUtil("Email already exists", false, 409, null);
        }

        String password = this.generatePasswordHash(userModel.getPassword());
        userModel.setPassword(password);
        userRepository.save(userModel);

        return new ResponseUtil("User successfully created", true, 200, null);
    }

}