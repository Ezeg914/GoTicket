package com.GoTicket.GoTicket.models;

import javax.persistence.*;
import java.io.Serializable; // To be able to pass objects between activities

import lombok.*;

@Entity
@Table(name = "company")
public class Company implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id_company")
    private Long id_company;
    @column(name = "name")
    private String name;

    public Long getId_company() {
        return id_company;
    }
    public void setId_company(Long id_company) {
        this.id_company = id_company;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
