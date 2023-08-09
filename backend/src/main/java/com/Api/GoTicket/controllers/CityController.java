package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public CityModel saveCity(@RequestBody CityModel city) {return this.cityService.saveCity(city);}

    @GetMapping(path = "/{id}")
    public Optional<CityModel> getCityById(@PathVariable("id") Long id) {return this.cityService.getCityById(id);}

    @PutMapping(path = "/{id}")
    public CityModel updateById(@RequestBody CityModel request,@PathVariable("id") long id) {return this.cityService.updateById(request, id);}

}
