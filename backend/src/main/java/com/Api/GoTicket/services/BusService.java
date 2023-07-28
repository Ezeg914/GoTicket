package com.Api.GoTicket.services;


import com.Api.GoTicket.repositories.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.GoTicket.models.BusModel;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    IBusRepository busRepository;

    public ArrayList<BusModel> getBuses() {
        return (ArrayList<BusModel>) busRepository.findAll();
    }

    public BusModel saveBus(BusModel bus) {
        return busRepository.save(bus);
    }

    public Optional<BusModel> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public BusModel updateById(BusModel request, Long id){
        BusModel bus = busRepository.findById(id).get();

        bus.setCapacity(request.getCapacity());
        bus.setCompany_id(request.getCompany_id());

        return busRepository.save(bus);
    }

    public Boolean deleteBus (Long id){
        try{
            busRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }
}
