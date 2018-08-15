/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.model.CompanyStock;
import java.util.List;

/**
 *
 * @author James
 */
public interface CompanyStockServiceLayer { 
    
    public void addCompanyStock(CompanyStock companyStock);
    
    public void deleteCompanyStock(int companyStockId);
    
    public void updateCompanyStock(CompanyStock companyStock);
    
    public CompanyStock getCompanyStockByCompanyStockId(int companyStockId);
    
    public List<CompanyStock> getAllCompanyStocks();
    
}
