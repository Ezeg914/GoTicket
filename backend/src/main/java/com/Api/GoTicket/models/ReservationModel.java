package com.Api.GoTicket.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "reservation")
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;




    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnoreProperties({"reservations"})
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


}
