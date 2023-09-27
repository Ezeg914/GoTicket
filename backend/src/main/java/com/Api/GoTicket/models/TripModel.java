package com.Api.GoTicket.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "trip")
public class TripModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String date;

    @Column
    private String time;

    @ManyToOne
    @JoinColumn(name = "company")
    @JsonBackReference
    private CompanyModel company;


    @ManyToOne
    @JoinColumn(name = "cityFromId")
    private CityModel city_from;

    @ManyToOne
    @JoinColumn(name = "cityToId")
    private CityModel city_to;

    @OneToOne
    @JoinColumn(name = "busId")
    private BusModel bus;

    @OneToMany(mappedBy = "trip")
    @JsonManagedReference
    private List<PassangerModel> passangers = new ArrayList<>();


    // Getters and Setters
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public CompanyModel getCompany(){
        return company;
    }
    public void setCompany(CompanyModel company){
        this.company = company;
    }

    public CityModel getCity_from() {return city_from;}
    public void setCity_from(CityModel city_from) {this.city_from = city_from;}

    public CityModel getCity_to() {return city_to;}
    public void setCity_to(CityModel city_to) {this.city_to = city_to;}


    public BusModel getBus() {return bus;}
    public void setBus(BusModel bus) {this.bus = bus;}


    public List<PassangerModel> getPassangers() {return passangers;}
    public void setPassangers(List<PassangerModel> passangers) {this.passangers = passangers;}
}
