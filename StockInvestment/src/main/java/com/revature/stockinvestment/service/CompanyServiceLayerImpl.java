/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class CompanyServiceLayerImpl /*implements CompanyServiceLayer*/ {

    @Autowired
    private CompanyDaoOracleSqlImpl companyDao;

    public void setDao(CompanyDaoOracleSqlImpl dao) {
        this.companyDao = dao;
    }

    public void addCompany(Company company) throws SIPersistenceException {
        companyDao.addCompany(company);

    }

    public void deleteCompany(int companyId) throws SIPersistenceException {
        companyDao.deleteCompany(companyId);

    }

    public void updateCompany(Company company) throws SIPersistenceException {
        companyDao.updateCompany(company);

    }

    public Company getCompanyByCompanyId(int companyId) throws SIPersistenceException {
        return companyDao.getCompanyByCompanyId(companyId);
    }

    public List<Company> getAllCompanies() throws SIPersistenceException {
        return companyDao.getAllCompanies();
    }

}
