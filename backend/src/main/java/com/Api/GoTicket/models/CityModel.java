package com.Api.GoTicket.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "city")
public class CityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_city;

    @Column
    private String name;


    //getters and setters
    public long getId_city() {return id_city;}

    public void setId_city(long id_city) {this.id_city = id_city;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
