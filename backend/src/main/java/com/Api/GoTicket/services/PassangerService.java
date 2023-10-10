package com.Api.GoTicket.services;

import com.Api.GoTicket.models.PassangerModel;
import com.Api.GoTicket.repositories.IPassangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PassangerService {
    @Autowired
    IPassangerRepository passangerRepository;

    public ArrayList<PassangerModel> getPassangers()
    {
        return (ArrayList<PassangerModel>) passangerRepository.findAll();

    }



    public PassangerModel savePassanger (PassangerModel passanger){

        return passangerRepository.save(passanger);
    }

    public Optional<PassangerModel> getById(Long id){
        return passangerRepository.findById(id);
    }
    public Boolean deleteById (Long id){
        try{
            passangerRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }
}



