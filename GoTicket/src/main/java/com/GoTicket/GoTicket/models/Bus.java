package com.GoTicket.GoTicket.models;

import javax.persistence.*;
import java.io.Serializable; // To be able to pass objects between activities


@Entity
@Table(name = "bus")
public class Bus implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bus")
    private Long id_bus;
    @Column(name = "capacity")
    private int capacity;

    public Long getId_bus() {return id_bus;}
    public int getCapacity() {return capacity;}

    public void setId_bus(Long id_bus) {this.id_bus = id_bus;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
}
