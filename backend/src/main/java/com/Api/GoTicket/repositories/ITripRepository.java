package com.Api.GoTicket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Api.GoTicket.models.TripModel;

@Repository
public interface ITripRepository extends JpaRepository<TripModel, Long>{
}
