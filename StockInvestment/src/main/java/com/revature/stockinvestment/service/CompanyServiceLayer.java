/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import java.util.List;

/**
 *
 * @author James
 */
public interface CompanyServiceLayer { 
    
    public void addCompanyStock(Company companyStock) throws SIPersistenceException;
    
    public void deleteCompanyStock(int companyStockId) throws SIPersistenceException;
    
    public void updateCompanyStock(Company companyStock) throws SIPersistenceException;
    
    public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException;
    
    public List<Company> getAllCompanyStocks() throws SIPersistenceException;
    
}
