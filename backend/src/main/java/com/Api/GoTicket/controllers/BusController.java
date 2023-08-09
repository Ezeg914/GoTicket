package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.BusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Api.GoTicket.services.BusService;
import java.util.ArrayList;
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

    @PostMapping
    public BusModel saveBus(@RequestBody BusModel bus) {
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
