package com.Api.GoTicket.controllers;



import com.Api.GoTicket.models.TripModel;
import com.Api.GoTicket.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Api.GoTicket.services.TripService;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @Autowired
    private ITripRepository tripRepository;

    @GetMapping
    public ResponseEntity<Page<TripModel>> getTrips(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "company", required = false) Long companyId,
            @RequestParam(value = "cityFrom", required = false) Long cityFromId,
            @RequestParam(value = "cityTo", required = false) Long cityToId
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<TripModel> trips = tripRepository.findFilteredTrips(companyId, cityFromId, cityToId, pageable);

        return new ResponseEntity<>(trips, HttpStatus.OK);
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