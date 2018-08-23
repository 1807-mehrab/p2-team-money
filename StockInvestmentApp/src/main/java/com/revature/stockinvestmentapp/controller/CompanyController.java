/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.controller;

import com.revature.stockinvestmentapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

//    @PostMapping("/company")
//    public void addCompany(@Valid @RequestBody Company company) {
//        companyService.addCompany(company);
//    }
//
//    @DeleteMapping("/company/{id}")
//    public void deleteCompany(@PathVariable("id") int id) {
//        companyService.deleteCompany(id);
//    }
//
//    @PutMapping("/company/{id}")
//    public void updateCompanyStock(@PathVariable("id") int id, @Valid @RequestBody Company company) {
//        companyService.updateCompany(company);
//    }

//    @GetMapping("/company/{id}")
//    public Company getCompanyStockByCompanyStockId(@PathVariable("id") int id) {
//        return companyService.getCompanyByCompanyId(id);
//    }

//    @GetMapping("/companies")
//    public List<Company> getAllCompanyStocks() {
//        return companyService.getAllCompanies();
//    }

}