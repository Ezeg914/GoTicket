package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.User;
import com.GoTicket.GoTicket.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements BaseService<User>{

    private UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> findAll() throws Exception {
        try{
            List<User> models = userRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User findById(Long id) throws Exception {
        try{
            Optional<User> modelOptional = userRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User save(User model) throws Exception {
        try{
            model = userRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User update(Long id, User model) throws Exception {
        try{
            Optional<User> modelOptional = userRepository.findById(id);
            User user = modelOptional.get();
            user = userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) throws Exception {
        try {
            if(userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
