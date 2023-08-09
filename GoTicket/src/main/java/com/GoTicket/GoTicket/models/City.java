package com.GoTicket.GoTicket.models;

import javax.persistence.*;
import java.io.Serializable; // To be able to pass objects between activities


@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private Long id_city;
    @Column(name = "name")
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
