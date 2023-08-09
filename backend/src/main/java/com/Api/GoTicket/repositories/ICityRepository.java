package com.Api.GoTicket.repositories;

import com.Api.GoTicket.models.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<CityModel, Long>{
}
