package com.Api.GoTicket.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BusModel> buses = new ArrayList<BusModel>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<TripModel> trips = new ArrayList<TripModel>();

    // Getters and Setters
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @JsonIgnoreProperties({"company"})
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

    @JsonIgnoreProperties({"company"})
    public List<TripModel> getTrips(){
        return trips;
    }
    public void setTrips(List<TripModel> trips){
        this.trips = trips;
    }
}
