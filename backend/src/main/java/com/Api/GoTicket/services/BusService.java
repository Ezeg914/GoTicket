package com.Api.GoTicket.services;


import com.Api.GoTicket.models.CompanyModel;
import com.Api.GoTicket.repositories.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Api.GoTicket.services.CompanyService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Api.GoTicket.models.BusModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    IBusRepository busRepository;
    @Autowired
    private CompanyService companyService;




    public ArrayList<BusModel> getBuses() {
        return (ArrayList<BusModel>) busRepository.findAll();
    }


    public Page<BusModel> getAllBuses(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

    public Page<BusModel> getBusesByCapacity(int capacity, Pageable pageable) {
        return busRepository.findByCapacityEquals(capacity, pageable);
    }

    public BusModel saveBus(BusModel bus) {
        CompanyModel company = companyService.getById(bus.getCompany().getId()).orElse(null);
        if (company != null) {
            company.getBuses().add(bus);
            bus.setCompany(company);
        }
        return busRepository.save(bus);
    }




    public Optional<BusModel> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public BusModel updateById(BusModel request, Long id){
        BusModel bus = busRepository.findById(id).get();

        bus.setCapacity(request.getCapacity());
        bus.setCompany(request.getCompany());
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
    public BusModel savesBus(BusModel bus) {
        // Establece los asientos disponibles a la capacidad cuando se crea un nuevo autobús
        bus.setAsientosDisponibles(bus.getCapacity());
        return busRepository.save(bus);
    }
    public BusModel reserveBus(long busId) {
        BusModel bus = busRepository.findById(busId).orElse(null);

        if (bus != null) {
            reserveSeats(busId); // Utiliza el método reserveSeats del servicio BusService
            return busRepository.save(bus); // Guarda el autobús actualizado
        } else {
            throw new RuntimeException("Autobús no encontrado");
        }
    }

    public void reserveSeats(Long busId) {
        BusModel bus = busRepository.findById(busId).orElse(null);

        if (bus != null) {
            int availableSeats = bus.getAsientosDisponibles();
            if (availableSeats > 0) {
                bus.setAsientosDisponibles(availableSeats - 1);
            } else {
                throw new RuntimeException("No hay suficientes asientos disponibles");
            }
            busRepository.save(bus); // Guarda el autobús actualizado
        } else {
            throw new RuntimeException("Autobús no encontrado");
        }
    }
}
