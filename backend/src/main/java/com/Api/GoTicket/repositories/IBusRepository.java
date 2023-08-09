package com.Api.GoTicket.repositories;

import com.Api.GoTicket.models.BusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusRepository extends JpaRepository<BusModel, Long> {
}
