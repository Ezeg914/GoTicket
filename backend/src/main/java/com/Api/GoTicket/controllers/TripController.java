package com.Api.GoTicket.controllers;



import com.Api.GoTicket.models.TripModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Api.GoTicket.services.TripService;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping
    public ArrayList<TripModel> getTrip(){
        return tripService.getTrip();
    }

    @PostMapping
    public TripModel saveTrip(@RequestBody TripModel trip){
        return this.tripService.saveTrip(trip);
    }

    @GetMapping(path = "/{id}")
    public Optional<TripModel> getTripById(@PathVariable("id") Long id){
        return this.tripService.getById(id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteTripById(@PathVariable("id") Long id){
        boolean ok = this.tripService.deleteById(id);
        if (ok){
                return "Trip with id:" + id + "was deleted";

        }else {
            return "Error, we have a problem and can´t delete trip with id" + id + "was not deleted";
        }
    }

}

