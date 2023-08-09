package com.GoTicket.GoTicket.repositories;

import com.GoTicket.GoTicket.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
