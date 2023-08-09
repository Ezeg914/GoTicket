package com.Api.GoTicket.services;

import com.Api.GoTicket.models.CompanyModel;
import com.Api.GoTicket.repositories.ICompanyRepository;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    ICompanyRepository companyRepository;

    public ArrayList<CompanyModel>getCompany(){
        return (ArrayList<CompanyModel>) companyRepository.findAll();
    }

    public CompanyModel saveCompany(CompanyModel company){
        return companyRepository.save(company);
    }

    public Optional<CompanyModel> getById(Long id){
        return companyRepository.findById(id);
    }

    public CompanyModel updateById(CompanyModel request, Long id){
        CompanyModel company = companyRepository.findById(id).get();

        company.setName(request.getName());

        return companyRepository.save(company);
    }

    public Boolean deleteById(Long id){
        try{
            companyRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }

}
