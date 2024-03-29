package com.Api.GoTicket.repositories;

import com.Api.GoTicket.models.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {
    Page<ReservationModel> findByUserId(Long userId, Pageable pageable);

}
