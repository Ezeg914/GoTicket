package com.Api.GoTicket.models;

import jakarta.persistence.*;

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
}
