package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.BusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Api.GoTicket.services.BusService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public ArrayList<BusModel> getBuses() {
        return busService.getBuses();
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<BusModel>> getBuses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Integer capacity) {
        Pageable pageable = PageRequest.of(page, size);

        Page<BusModel> buses;
        if (capacity != null) {
            buses = busService.getBusesByCapacity(capacity, pageable);
        } else {
            buses = busService.getAllBuses(pageable);
        }

        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @PostMapping
    public BusModel saveBus(@RequestBody BusModel bus) {
        bus.setAsientosDisponibles(bus.getCapacity());
        return this.busService.saveBus(bus);
    }

    @GetMapping(path = "/{id}")
    public Optional<BusModel> getBusById(@PathVariable("id") Long id) {
        return this.busService.getBusById(id);
    }


    @PutMapping(path = "/{id}")
    public BusModel updateById(@RequestBody BusModel request,@PathVariable("id") long id) {
        return this.busService.updateById(request, id);
    }


}
