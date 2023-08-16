package com.Api.GoTicket.models;

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
    private CompanyModel company;

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

    @JsonIgnoreProperties({"trips"})
    public CompanyModel getCompany(){
        return company;
    }
    public void setCompany(CompanyModel company){
        this.company = company;
    }
}
