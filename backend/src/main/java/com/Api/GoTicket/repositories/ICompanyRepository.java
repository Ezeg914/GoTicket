package com.Api.GoTicket.repositories;


import com.Api.GoTicket.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<CompanyModel, Long> {
}
