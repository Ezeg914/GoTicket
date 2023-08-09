package com.Api.GoTicket.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name = "passanger")
public class PassangerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "reservation")
    private ReservationModel reservation;

    @ManyToOne
    @JoinColumn(name = "trip")
    private TripModel trip;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }


    @JsonIgnoreProperties({"reservation"})
    public ReservationModel getReservation(){return reservation;}

    public void setReservation(ReservationModel reservation){this.reservation = reservation;}

    @JsonIgnoreProperties({"trip"})
    public TripModel getTrip(){return trip;}

    public void setTrip(TripModel trip){this.trip = trip;}

}
