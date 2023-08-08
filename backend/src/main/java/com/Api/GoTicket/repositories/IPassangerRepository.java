package com.Api.GoTicket.repositories;


import com.Api.GoTicket.models.PassangerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPassangerRepository extends JpaRepository<PassangerModel, Long> {
}
