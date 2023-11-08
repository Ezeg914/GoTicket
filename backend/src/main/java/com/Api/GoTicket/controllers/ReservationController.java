package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.BusModel;
import com.Api.GoTicket.models.UserModel;
import com.Api.GoTicket.models.ReservationModel;
import com.Api.GoTicket.services.BusService;
import com.Api.GoTicket.services.ReservationService;
import com.Api.GoTicket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private BusService busService;

    @GetMapping
    public ArrayList<ReservationModel> getReservation() {
        return reservationService.getReservation();
    }

    @GetMapping("/filtered")
    public Page<ReservationModel> getReservationsByUserId(@PathVariable("userId") Long userId, Pageable pageable) {
        return reservationService.getReservationsByUserId(userId, pageable);
    }



    @PostMapping
    public BusModel savesReservation(@RequestBody ReservationModel reserva) {
        UserModel user = reserva.getUser();
        long busId = reserva.getBusId();

        // Verificar si el usuario y el bus existen
        if (user != null && busId > 0) {
            BusModel bus = busService.getBusById(busId).orElse(null);
            if (bus != null) {
                reserva.setBusId(busId);
                return busService.reserveBus(busId); // Cambiado el método para pasar el busId
            }
        }

            // Manejar el caso en el que el usuario o el bus no existen
            // Puedes lanzar una excepción, devolver un mensaje de error, etc.
            return null; // Otra opción es lanzar una excepción en lugar de devolver null
        }





    @GetMapping(path = "/{id}")
    public Optional<ReservationModel> getReservationById(@PathVariable("id") Long id) {
        return reservationService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteReservationById(@PathVariable("id") Long id) {
        boolean ok = reservationService.deleteById(id);
        if (ok) {
            return "Reservation with id: " + id + " was deleted";
        } else {
            return "Error, we have a problem and can´t delete reservation with id " + id + " was not deleted";
        }
    }


}


