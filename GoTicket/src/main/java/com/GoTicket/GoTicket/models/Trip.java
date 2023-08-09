package com.GoTicket.GoTicket.models;

import javax.persistence.*;
import java.io.Serializable; // To be able to pass objects between activities


@Entity
@Table(name = "trip")
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trip")
    private Long id_trip;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    public Long getId_trip() {return id_trip;}
    public String getDate() {return date;}
    public String getTime() {return time;}

    public void setId_trip(Long id_trip) {this.id_trip = id_trip;}
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {this.time = time;}
    
}
