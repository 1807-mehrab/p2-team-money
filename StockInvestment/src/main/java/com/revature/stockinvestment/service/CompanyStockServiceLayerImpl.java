/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.CompanyStockDao;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.CompanyStock;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class CompanyStockServiceLayerImpl implements CompanyStockServiceLayer { 

    private CompanyStockDao companyStockDao;
    
    @Inject
    public CompanyStockServiceLayerImpl(CompanyStockDao companyStockDao) {
        this.companyStockDao = companyStockDao;
    }
    
    @Override
    public void addCompanyStock(CompanyStock companyStock) throws SIPersistenceException {
        companyStockDao.addCompanyStock(companyStock);
    }

    @Override
    public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
        companyStockDao.deleteCompanyStock(companyStockId);
    }

    @Override
    public void updateCompanyStock(CompanyStock companyStock) throws SIPersistenceException {
        companyStockDao.updateCompanyStock(companyStock);
    }

    @Override
    public CompanyStock getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
        return companyStockDao.getCompanyStockByCompanyStockId(companyStockId);
    }

    @Override
    public List<CompanyStock> getAllCompanyStocks() throws SIPersistenceException {
        return companyStockDao.getAllCompanyStocks();
    }
    
}
