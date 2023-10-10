package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Api.GoTicket.services.CityService;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ArrayList<CityModel> getCities() {return cityService.getCities();}

    @GetMapping("/filtered")
    public ResponseEntity<Page<CityModel>> getCities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CityModel> cities;

        if (name != null) {
            cities = cityService.getCitiesByName(name, pageable);
        } else {
            cities = cityService.getAllCities(pageable);
        }

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping
    public CityModel saveCity(@RequestBody CityModel city) {return this.cityService.saveCity(city);}

    @GetMapping(path = "/{id}")
    public Optional<CityModel> getCityById(@PathVariable("id") Long id) {return this.cityService.getCityById(id);}

    @PutMapping(path = "/{id}")
    public CityModel updateById(@RequestBody CityModel request,@PathVariable("id") long id) {return this.cityService.updateById(request, id);}

}
