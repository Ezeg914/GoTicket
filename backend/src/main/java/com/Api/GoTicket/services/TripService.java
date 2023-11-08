package com.Api.GoTicket.services;


import com.Api.GoTicket.models.CompanyModel;
import com.Api.GoTicket.models.TripModel;
import com.Api.GoTicket.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    ITripRepository tripRepository;

    @Autowired
    private CompanyService companyService;


    public ArrayList<TripModel> getTrip(){
        return (ArrayList<TripModel>) tripRepository.findAll();
    }



    public TripModel saveTrip(TripModel trip) {
        CompanyModel company = companyService.getById(trip.getCompany().getId()).orElse(null);
        if (company != null) {
            company.getTrips().add(trip);
            trip.setCompany(company);
        }
        return tripRepository.save(trip);
    }


    public Optional<TripModel>getById(Long id){
        return tripRepository.findById(id);
    }
    public Boolean deleteById (Long id){
        try{
            tripRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }
}

