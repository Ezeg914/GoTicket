package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Trip;
import com.GoTicket.GoTicket.repositories.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TripService implements BaseService<Trip>{

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    @Transactional
    public List<Trip> findAll() throws Exception {
        try {
            List<Trip> models = tripRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Trip findById(Long id) throws Exception {
        try {
            Optional<Trip> modelOptional = tripRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Trip save(Trip model) throws Exception {
        try {
            model = tripRepository.save(model); //corregir // corregido
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Trip update(Long id, Trip model) throws Exception {
        try {
            Optional<Trip> modelOptional = tripRepository.findById(id);
            Trip trip = modelOptional.get();
            trip = tripRepository.save(trip);
            return trip;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (tripRepository.existsById(id)) {
                tripRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
