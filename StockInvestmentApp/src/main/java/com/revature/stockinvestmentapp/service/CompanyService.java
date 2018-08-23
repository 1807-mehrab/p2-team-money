/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.service;

import com.revature.stockinvestmentapp.dao.CompanyDao;
import com.revature.stockinvestmentapp.model.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

//    public void addCompany(Company company) {
//        companyDao.addCompany(company);
//
//    }
//
//    public void deleteCompany(int companyId) {
//        companyDao.deleteCompany(companyId);
//    }
//
//    public void updateCompany(Company company) {
//        companyDao.updateCompany(company);
//
//    }

//    public Company getCompanyByCompanyId(int companyStockId) {
//        return companyDao.getCompanyByCompanyId(companyStockId);
//    }
//
//    public List<Company> getAllCompanies() {
//        return companyDao.getAllCompanies();
//    }
}
