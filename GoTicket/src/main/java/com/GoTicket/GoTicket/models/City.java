package com.GoTicket.GoTicket.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id_city")
    private Long id_city;
    @column(name = "name")
    private String name;

    public Long getId_city() {
        return id_city;
    }
    public void setId_city(Long id_city) {
        this.id_city = id_city;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
