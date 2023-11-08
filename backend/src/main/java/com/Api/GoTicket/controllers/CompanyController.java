package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.BusModel;
import com.Api.GoTicket.models.CompanyModel;
import com.Api.GoTicket.models.TripModel;
import com.Api.GoTicket.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @PostMapping
    public CompanyModel saveCompany(@RequestBody CompanyModel company){
        return this.companyService.saveCompany(company);
    }

    @GetMapping
    public ArrayList<CompanyModel> getCompany(){
        return this.companyService.getCompany();
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<CompanyModel>> getCompaniesByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CompanyModel> companies;

        if (name != null) {
            companies = companyService.getCompaniesByName(name, pageable);
        } else {
            companies = companyService.getAllCompanies(pageable);
        }

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    public Optional<CompanyModel> getCompanyById(@PathVariable("id") Long id){
        return this.companyService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public CompanyModel updateById(@RequestBody CompanyModel request, @PathVariable("id") Long id){
        return this.companyService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCompanyById(@PathVariable("id")Long id){
        boolean ok = this.companyService.deleteById(id);
        if (ok){
            return "Company with id: " + id + "was deleted";
        } else {
            return "Error, we have a problem and can´t delete company with id " + id + "was not deleted";
        }
    }


}
