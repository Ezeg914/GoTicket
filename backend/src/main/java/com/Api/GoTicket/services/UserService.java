package com.Api.GoTicket.services;

import com.Api.GoTicket.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.GoTicket.models.UserModel;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id){
            UserModel user = userRepository.findById(id).get();

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

    public Boolean deleteById(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
