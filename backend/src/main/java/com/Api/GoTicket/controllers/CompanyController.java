package com.Api.GoTicket.controllers;

import com.Api.GoTicket.models.CompanyModel;
import com.Api.GoTicket.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public CompanyModel saveCompany(@RequestBody CompanyModel company){
        return this.companyService.saveCompany(company);
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
