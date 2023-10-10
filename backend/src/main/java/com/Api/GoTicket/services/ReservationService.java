package com.Api.GoTicket.services;


import com.Api.GoTicket.models.ReservationModel;
import com.Api.GoTicket.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    IReservationRepository reservationRepository;

    public ArrayList<ReservationModel> getReservation(){
        return (ArrayList<ReservationModel>) reservationRepository.findAll();
    }

    public Page<ReservationModel> getReservationsByUserId(Long userId, Pageable pageable) {
        return reservationRepository.findByUserId(userId, pageable);
    }
    public ReservationModel saveReservation(ReservationModel reservation){
        return reservationRepository.save(reservation);
    }

    public Optional<ReservationModel> getById(Long id){
        return reservationRepository.findById(id);
    }

    public Boolean deleteById (Long id){
        try{
            reservationRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }

    }

}
