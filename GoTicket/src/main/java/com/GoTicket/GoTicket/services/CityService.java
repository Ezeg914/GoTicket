package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.City;
import com.GoTicket.GoTicket.repositories.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityService  implements BaseService<City>{

    private CityRepository cityRepository;
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public List<City> findAll() throws Exception {
        try{
            List<City> models = cityRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public City findById(Long id) throws Exception {
        try{
            Optional<City> modelOptional = cityRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public City save(City model) throws Exception {
        try{
            model = cityRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public City update(Long id, City model) throws Exception {
        try{
            Optional<City> modelOptional = cityRepository.findById(id);
            City city = modelOptional.get();
            city = cityRepository.save(city);
            return city;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            Optional<City> modelOptional = cityRepository.findById(id);
            if(!modelOptional.isPresent()){
                throw new Exception();
            }
            cityRepository.delete(modelOptional.get());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
