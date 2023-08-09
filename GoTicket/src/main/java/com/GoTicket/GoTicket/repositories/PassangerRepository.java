package com.GoTicket.GoTicket.repositories;

import com.GoTicket.GoTicket.models.Passanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassangerRepository extends JpaRepository<Passanger, Long> {
}
