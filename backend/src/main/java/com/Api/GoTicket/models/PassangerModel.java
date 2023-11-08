    package com.Api.GoTicket.models;


    import com.fasterxml.jackson.annotation.*;
    import jakarta.persistence.*;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @Entity
    @Table (name = "passanger")
    public class PassangerModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;


        @OneToOne
        @JoinColumn(name = "reservation")
        private ReservationModel reservation;


        @ManyToOne
        @JoinColumn(name = "trip")
        private TripModel trip;

        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id = id;
        }


        public ReservationModel getReservation(){return reservation;}

        public void setReservation(ReservationModel reservation){this.reservation = reservation;}

        public TripModel getTrip(){return trip;}

        public void setTrip(TripModel trip){this.trip = trip;}

    }
