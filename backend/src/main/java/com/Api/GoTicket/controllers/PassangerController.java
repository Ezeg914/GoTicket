package com.Api.GoTicket.controllers;


import com.Api.GoTicket.models.PassangerModel;
import com.Api.GoTicket.services.PassangerService;
import org.hibernate.boot.model.source.internal.hbm.AttributesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/passanger")
public class PassangerController {
    @Autowired
    private PassangerService passangerService;

    @GetMapping
    public ArrayList<PassangerModel> getPassangers(){
        return passangerService.getPassangers();
    }

    @PostMapping
    public PassangerModel savePassanger(@RequestBody PassangerModel passanger){
        return this.passangerService.savePassanger(passanger);
    }

    @GetMapping(path = "/{id}")
    public Optional<PassangerModel> getPassangerById(@PathVariable("id") Long id){
        return this.passangerService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePassangerById(@PathVariable("id") Long id){
        boolean ok = this.passangerService.deleteById(id);
        if (ok){
            return "Passanger with id: " + id + "was deleted";
        } else {
            return "Error, we have a problem and can´t delete passanger with id " + id + "was not deleted";
        }
    }


}