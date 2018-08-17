/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.CompanyStock;
import java.util.List;

/**
 *
 * @author James
 */
public interface CompanyStockServiceLayer { 
    
    public void addCompanyStock(CompanyStock companyStock) throws SIPersistenceException;
    
    public void deleteCompanyStock(int companyStockId) throws SIPersistenceException;
    
    public void updateCompanyStock(CompanyStock companyStock) throws SIPersistenceException;
    
    public CompanyStock getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException;
    
    public List<CompanyStock> getAllCompanyStocks() throws SIPersistenceException;
    
}
