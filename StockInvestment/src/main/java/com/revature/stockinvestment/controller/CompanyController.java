package com.revature.stockinvestment.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;

import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class CompanyController {

    @Autowired
    private CompanyServiceLayerImpl companyServiceLayer;

    @PostMapping("/company")
    public void addCompany(@Valid @RequestBody Company company) {
        companyServiceLayer.addCompanyStock(company);
    }

    @DeleteMapping("/company/{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companyServiceLayer.deleteCompanyStock(id);
    }

    @PutMapping("/company/{id}")
    public void updateCompanyStock(@PathVariable("id") int id, @Valid @RequestBody Company company) {
        companyServiceLayer.updateCompanyStock(company);
    }

    @GetMapping("/company/{id}")
    public Company getCompanyStockByCompanyStockId(@PathVariable("id") int id) {
        return companyServiceLayer.getCompanyStockByCompanyStockId(id);
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanyStocks() {
        return companyServiceLayer.getAllCompanyStocks();
    }

}
