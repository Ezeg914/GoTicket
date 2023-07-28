package com.Api.GoTicket.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id_bus;

    @Column
    private int capacity;

    @Column
    private int company_id;

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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
