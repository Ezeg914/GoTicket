package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Trip;
import com.GoTicket.GoTicket.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TripService implements BaseService<Trip>{

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    @Trasactional
    public List<Trip> findAll() throws Exception {
        try {
            List<Trip> models = tripRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Trasactional
    public Trip findById(Long id) throws Exception {
        try {
            Optional<Trip> modelOptional = tripRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Trasactional
    public Trip save(Trip entity) throws Exception {
        try {
            entity = tripRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Trasactional
    public Trip update(Long id, Trip entity) throws Exception {
        try {
            Optional<Trip> modelOptional = tripRepository.findById(id);
            Trip trip = modelOptional.get();
            trip = tripRepository.save(trip);
            return trip;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
