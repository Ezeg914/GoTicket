package com.Api.GoTicket.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name = "passanger")
public class PassangerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @OneToOne
    @JoinColumn(name = "reservation")
    private ReservationModel reservation;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @JsonIgnoreProperties({"reservation"})
    public ReservationModel getReservation(){return reservation;}

    public void setReservation(ReservationModel reservation){this.reservation = reservation;}

}
