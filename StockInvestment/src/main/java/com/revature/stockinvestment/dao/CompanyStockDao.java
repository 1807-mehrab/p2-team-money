/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.CompanyStock;
import java.util.List;

/**
 *
 * @author James
 */
public interface CompanyStockDao { 
    
    public void addCompanyStock(CompanyStock companyStock);
    
    public void deleteCompanyStock(int companyStockId);
    
    public void updateCompanyStock(CompanyStock companyStock);
    
    public CompanyStock getCompanyStockByCompanyStockId(int companyStockId);
    
    public List<CompanyStock> getAllCompanyStocks();
    
}
