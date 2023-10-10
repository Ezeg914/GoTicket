package com.Api.GoTicket.services;

import com.Api.GoTicket.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Api.GoTicket.models.CityModel;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    ICityRepository cityRepository;

    public ArrayList<CityModel> getCities() {return (ArrayList<CityModel>) cityRepository.findAll();}

    public Page<CityModel> getAllCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    public Page<CityModel> getCitiesByName(String name, Pageable pageable) {
        return cityRepository.findByName(name, pageable);
    }
    public CityModel saveCity(CityModel city) {return cityRepository.save(city);}

    public Optional<CityModel> getCityById(Long id) {return cityRepository.findById(id);}

    public CityModel updateById(CityModel request, Long id){
        CityModel city = cityRepository.findById(id).get();

        city.setName(request.getName());

        return cityRepository.save(city);
    }

    public Boolean deleteCity (Long id){
        try{
            cityRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }

}

