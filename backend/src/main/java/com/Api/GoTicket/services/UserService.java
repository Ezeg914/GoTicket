package com.Api.GoTicket.services;

import com.Api.GoTicket.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.GoTicket.models.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public List<UserModel> getUsersByFilters(String name, String lastName, String email) {
        return userRepository.findUsersByFilters(name, lastName, email);
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

        return userRepository.save(user);
    }

    public Boolean deleteById(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public Object getUserByEmail(UserModel userModel){
        String query = "FROM UserModel WHERE email = :email";
        try {
            return (Object)entityManager.createQuery(query).setParameter("email", userModel.getEmail()).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
