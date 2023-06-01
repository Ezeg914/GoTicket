package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Bus;
import java.util.List;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BusService implements BaseService<Bus>{

    private BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }



    @Override
    @Transactional
    public List<Bus> findAll() throws Exception {
        try {
            List<Bus> models = busRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public Bus findById(Long id) throws Exception {
        try {
            Optional<Bus> modelOptional = busRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @Override
    @Transactional
    public Bus save(Bus model) throws Exception {
        try {
            model = busRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) throws Exception {
        try {
            if(busRepository.existsById(id)){
                busRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
