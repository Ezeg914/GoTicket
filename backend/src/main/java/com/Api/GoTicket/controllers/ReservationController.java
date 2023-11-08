package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.UserModel;
import com.Api.GoTicket.models.ReservationModel;
import com.Api.GoTicket.services.ReservationService;
import com.Api.GoTicket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<ReservationModel>getReservation(){
        return reservationService.getReservation();
    }

    @GetMapping("/filtered")
    public Page<ReservationModel> getReservationsByUserId(@PathVariable("userId") Long userId, Pageable pageable) {
        return reservationService.getReservationsByUserId(userId, pageable);
    }

    @PostMapping
    public ReservationModel saveReservation(@RequestBody ReservationModel reservation, @RequestParam("userId") Long userId){
        UserModel user = userService.getById(userId).get();
        return this.reservationService.saveReservation(reservation, user);
    }



    @GetMapping(path = "/{id}")
    public Optional<ReservationModel> getReservationById(@PathVariable("id") Long id){
        return this.reservationService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteResevationById(@PathVariable("id") Long id){
        boolean ok = this.reservationService.deleteById(id);
        if(ok){
            return "Reservation with id: " + id + "was deleted";
        } else {
            return "Error, we have a problem and can´t delete reservation with id " + id + "was not deleted";
        }
    }

}
