package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Reservation;
import com.GoTicket.GoTicket.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements BaseService<Reservation> {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    @Transactional
    public List<Reservation> findAll() throws Exception {
        try {
            List<Reservation> models = reservationRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Reservation findById(Long id) throws Exception {
        try {
            Optional<Reservation> modelOptional = reservationRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Reservation save(Reservation model) throws Exception {
        try {
            model = reservationRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Reservation update(Long id, Reservation model) throws Exception {
        try {
            Optional<Reservation> modelOptional = reservationRepository.findById(id);
            Reservation reservation = modelOptional.get();
            reservation = reservationRepository.save(reservation);
            return reservation;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(reservationRepository.existsById(id)) {
                reservationRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
