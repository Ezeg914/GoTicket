package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.UserModel;
import com.Api.GoTicket.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Api.GoTicket.services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;

        @Autowired
        private IUserRepository userRepository;

        @GetMapping
        public List<UserModel> getUsers(
                @RequestParam(value = "name", required = false) String name,
                @RequestParam(value = "lastName", required = false) String lastName,
                @RequestParam(value = "email", required = false) String email) {
                return userService.getUsersByFilters(name, lastName, email);
        }

        @PostMapping
        public UserModel saveUser(@RequestBody UserModel user){
                return this.userService.saveUser(user);
        }

        @GetMapping(path = "/{id}")
        public Optional<UserModel> getUserById(@PathVariable("id") Long id){
                return this.userService.getById(id);
        }

        @PutMapping(path = "/{id}")
        public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
                return this.userService.updateById(request, id);
        }

        @DeleteMapping(path = "/{id}")
        public String deleteUserById(@PathVariable("id") Long id){
                boolean ok = this.userService.deleteById(id);
                if(ok){
                        return "User with id: " + id + " was deleted";
                } else {
                        return "Error, we have a problem and can´t delete user with id" + id + " was not deleted";
                }
        }

        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody UserModel user) {
                UserModel existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

                if (existingUser != null) {
                        return ResponseEntity.ok("Inicio de sesión exitoso");
                } else {
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
                }
        }

        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody UserModel user) {
                UserModel existingUser = userRepository.findByEmail(user.getEmail());

                if (existingUser != null) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo electrónico ya está en uso");
                }

                userRepository.save(user);

                return ResponseEntity.ok("Registro exitoso");
        }

}


