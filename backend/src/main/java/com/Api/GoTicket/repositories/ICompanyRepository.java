package com.Api.GoTicket.repositories;


import com.Api.GoTicket.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Repository
public interface ICompanyRepository extends JpaRepository<CompanyModel, Long> {
    Page<CompanyModel> findByName(String name, Pageable pageable);
}
