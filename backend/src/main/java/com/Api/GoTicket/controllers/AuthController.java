package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Api.GoTicket.auth.UserAuth;

@RestController
public class AuthController {

    @Autowired
    private UserAuth userAuth;

    @PostMapping("/login")
    public Object login(@RequestBody UserModel userModel){
        UserModel current_user = userAuth.userLogged(userModel);
        return userAuth.createToken(current_user);
    }
}
