package com.Api.GoTicket.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id_bus;

    @Column(nullable = false)
    private int capacity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    // Getters and Setters
    public long getId_bus() {
        return id_bus;
    }

    public void setId_bus(long id_bus) {
        this.id_bus = id_bus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CompanyModel getCompany(){
        return company;
    }
    public void setCompany(CompanyModel company){
        this.company = company;
    }
}
