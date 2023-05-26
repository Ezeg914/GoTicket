package com.GoTicket.GoTicket.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import jakarta.persistence.Column;

import java.io.Serializable;

@Entity
@Table(name = "passanger")
public class Passanger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_passanger")
    private Long id_passanger;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;


    public Long getId_passanger() {
        return id_passanger;
    }

    public void setId_passanger(Long id_passanger) {
        this.id_passanger = id_passanger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
