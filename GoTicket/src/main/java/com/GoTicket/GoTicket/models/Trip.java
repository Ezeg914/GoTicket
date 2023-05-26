package com.GoTicket.GoTicket.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id_trip")
    private Long id_trip;

    @column(name = "date")
    private String date;

    @column(name = "time")
    private String time;

    public Long getId_trip() {return id_trip;}
    public String getDate() {return date;}
    public String getTime() {return time;}

    public void setId_trip(Long id_trip) {this.id_trip = id_trip;}
    public void setDate(String date) {this.date = date;}
    public void setTime(String time) {this.time = time;}
    
}
