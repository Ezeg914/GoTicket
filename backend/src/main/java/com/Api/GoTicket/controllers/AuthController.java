package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.dto.LoginDTO;
import com.Api.GoTicket.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Api.GoTicket.auth.UserAuth;

@RestController
public class AuthController {

    @Autowired
    private UserAuth userAuth;

    @PostMapping("/login")
    public Object login(@RequestBody LoginDTO loginDTO){
        UserModel user = new UserModel();
        user.setEmail(loginDTO.getEmail());
        user.setPassword(loginDTO.getPassword());

        try {
            UserModel current_user = userAuth.userLogged(user);
            return userAuth.createToken(current_user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @PostMapping("/register")
    public Object register(@RequestBody UserModel userModel){
        return userAuth.verifyEmailDuplicated(userModel);
    }

}
