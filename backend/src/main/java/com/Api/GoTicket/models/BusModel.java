package com.Api.GoTicket.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_bus")
@Entity
@Table(name = "bus")
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id_bus;

    @Column(nullable = false)
    private int capacity;


    @ManyToOne
    @JoinColumn(name = "bus_id")
    private BusModel bus;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private TripModel trip;

    // Agrega este campo a BusModel
    @Column(nullable = false)
    private int asientosDisponibles;

    // Agrega getter y setter para asientosDisponibles
    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    // Getters and Setters
    public long getId_bus() {
        return id_bus;
    }

    public void setId_bus(long id_bus) {
        this.id_bus = id_bus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public CompanyModel getCompany(){
        return company;
    }
    public void setCompany(CompanyModel company){
        this.company = company;
    }
    public TripModel getTrip(){
        return trip;
    }
    public void setTrip(TripModel trip){
        this.trip = trip;
    }

}
