package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Company;
import com.GoTicket.GoTicket.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Trasactional;

@Service
public class CompanyService implements BaseService<Company> {
    
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
        
    @Override
    @Transactional
    public List<Company> findAll() throws Exception {
        try{
            List<Company> models = companyRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Company findById(Long id) throws Exception {
        try{
            Optional<Company> modelOptional = companyRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Company save(Company model) throws Exception {
        try{
            model = companyRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Company update(Long id, Company model) throws Exception {
        try{
            Optional<Company> modelOptional = companyRepository.findById(id);
            Company company = modelOptional.get();
            company = companyRepository.save(company);
            return company;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(companyRepository.existsById(id)){
                companyRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
