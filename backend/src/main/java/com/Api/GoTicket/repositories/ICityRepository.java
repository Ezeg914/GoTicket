package com.Api.GoTicket.repositories;

import com.Api.GoTicket.models.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<CityModel, Long> {
    Page<CityModel> findByName(String name, Pageable pageable);
}