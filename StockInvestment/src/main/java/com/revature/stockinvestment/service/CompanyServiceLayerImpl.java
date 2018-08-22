/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.model.Company;
import java.util.List;
import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class CompanyServiceLayerImpl {

    @Autowired
    private CompanyDaoOracleSqlImpl companyDao;

    public void setCompanyDao(CompanyDaoOracleSqlImpl companyDao) {
        this.companyDao = companyDao;
    }

    public void addCompanyStock(Company companyStock) {
        companyDao.addCompanyStock(companyStock);

    }

    public void deleteCompanyStock(int companyStockId) {
        companyDao.deleteCompanyStock(companyStockId);
    }

    public void updateCompanyStock(Company companyStock) {
        companyDao.updateCompanyStock(companyStock);

    }

    public Company getCompanyStockByCompanyStockId(int companyStockId) {
        return companyDao.getCompanyStockByCompanyStockId(companyStockId);
    }

    public List<Company> getAllCompanyStocks() {
        return companyDao.getAllCompanyStocks();
    }
}
