/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Company;
import java.util.List;

/**
 *
 * @author James
 */
public interface CompanyDao { 
    
    public void addCompanyStock(Company companyStock);
    
    public void deleteCompanyStock(int companyStockId);
    
    public void updateCompanyStock(Company companyStock);
    
    public Company getCompanyStockByCompanyStockId(int companyStockId);
    
    public List<Company> getAllCompanyStocks();
    
}
