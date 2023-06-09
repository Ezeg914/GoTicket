package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Bus;
import com.GoTicket.GoTicket.repositories.BusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class BusService implements BaseService<Bus>{

    private BusRepository busRepository;
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    @Transactional
    public List<Bus> findAll() throws Exception {
        try{
            List<Bus> models = busRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Bus findById(Long id) throws Exception {
        try{
            Optional<Bus> modelOptional = busRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Bus save(Bus model) throws Exception {
        try{
            model = busRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Bus update(Long id, Bus model) throws Exception {
        try{
            Optional<Bus> modelOptional = busRepository.findById(id);
            Bus bus = modelOptional.get();
            bus = busRepository.save(bus);
            return bus;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            Optional<Bus> modelOptional = busRepository.findById(id);
            if(!modelOptional.isPresent()){
                throw new Exception();
            }
            busRepository.delete(modelOptional.get());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

