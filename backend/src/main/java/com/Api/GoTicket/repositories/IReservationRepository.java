package com.Api.GoTicket.repositories;

import com.Api.GoTicket.models.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {

}
