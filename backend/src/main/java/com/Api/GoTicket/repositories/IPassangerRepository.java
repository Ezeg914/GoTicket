package com.Api.GoTicket.repositories;


import com.Api.GoTicket.models.PassangerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface IPassangerRepository extends JpaRepository<PassangerModel, Long> {

}