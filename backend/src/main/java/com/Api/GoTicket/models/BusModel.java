package com.Api.GoTicket.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private TripModel trip;


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

    @JsonIgnoreProperties({"company"})
    public CompanyModel getCompany(){
        return company;
    }
    public void setCompany(CompanyModel company){
        this.company = company;
    }
    @JsonIgnoreProperties({"trip"})
    public TripModel getTrip(){
        return trip;
    }
    public void setTrip(TripModel trip){
        this.trip = trip;
    }
}
