package com.GoTicket.GoTicket.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "bus")
public class Bus implements Serializable{
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id_bus")
    private Long id_bus;
    @column(name = "capacity")
    private int capacity;

    public Long getId_bus() {return id_bus;}
    public int getCapacity() {return capacity;}

    public void setId_bus(Long id_bus) {this.id_bus = id_bus;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
}
