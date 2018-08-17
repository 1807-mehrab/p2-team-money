/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.revature.stockinvestment.dao.CompanyDao;

/**
 *
 * @author James
 */
@Service
public class CompanyServiceLayerImpl implements CompanyServiceLayer { 

    private CompanyDao companyStockDao;
    
    @Inject
    public CompanyServiceLayerImpl(CompanyDao companyStockDao) {
        this.companyStockDao = companyStockDao;
    }
    
    @Override
    public void addCompanyStock(Company companyStock) throws SIPersistenceException {
        companyStockDao.addCompanyStock(companyStock);
    }

    @Override
    public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
        companyStockDao.deleteCompanyStock(companyStockId);
    }

    @Override
    public void updateCompanyStock(Company companyStock) throws SIPersistenceException {
        companyStockDao.updateCompanyStock(companyStock);
    }

    @Override
    public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
        return companyStockDao.getCompanyStockByCompanyStockId(companyStockId);
    }

    @Override
    public List<Company> getAllCompanyStocks() throws SIPersistenceException {
        return companyStockDao.getAllCompanyStocks();
    }
    
}
