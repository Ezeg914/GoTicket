package com.GoTicket.GoTicket.models;

import javax.persistence.*;
import java.io.Serializable; // To be able to pass objects between activities


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reservation")
    private Long id_reservation;

    


    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

}

