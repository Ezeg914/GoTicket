package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Bus;
import com.GoTicket.GoTicket.repositories.BusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

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
    public Bus save(Bus entity) throws Exception {
        try{
            entity = busRepository.save(entity);
            return entity;
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
