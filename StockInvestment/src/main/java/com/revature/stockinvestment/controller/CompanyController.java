package com.revature.stockinvestment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class CompanyController {

    @Autowired
    private CompanyServiceLayerImpl companyServiceLayer;

    public CompanyController(CompanyServiceLayerImpl companyServiceLayer) {
        this.companyServiceLayer = companyServiceLayer;
    }

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCompany(@Valid @RequestBody Company company) throws SIPersistenceException {
        companyServiceLayer.addCompany(company);
    }

    @DeleteMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable("id") int id) throws SIPersistenceException {
        companyServiceLayer.deleteCompany(id);
    }

    @PutMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompanyStock(@PathVariable("id") int id, @Valid @RequestBody Company company) throws SIPersistenceException {
        companyServiceLayer.updateCompany(company);
    }

    @GetMapping("/company/{id}")
    public Company getCompanyStockByCompanyStockId(@PathVariable("id") int id) throws SIPersistenceException {
        return companyServiceLayer.getCompanyByCompanyId(id);
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanies() throws SIPersistenceException {
        return companyServiceLayer.getAllCompanies();
    }

}
