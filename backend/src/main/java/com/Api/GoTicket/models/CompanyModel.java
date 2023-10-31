package com.Api.GoTicket.models;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    private List<BusModel> buses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TripModel> trips;

    // Getters and Setters
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public List<BusModel> getBuses(){
        return buses;
    }

    public void setBuses(List<BusModel> buses){
        this.buses = buses;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public List<TripModel> getTrips(){
        return trips;
    }
    public void setTrips(List<TripModel> trips){
        this.trips = trips;
    }
}

