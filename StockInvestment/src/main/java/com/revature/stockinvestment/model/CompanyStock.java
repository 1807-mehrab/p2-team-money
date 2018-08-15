/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

import java.math.BigDecimal;

/**
 *
 * @author James
 */
public class CompanyStock { 
    
    private int companyStockId;
    private String companyName;
    private BigDecimal stockPrice;
    // private List<Account> accountList;     this could be used if we use the int shares in the accounts model object

    public int getCompanyStockId() {
        return companyStockId;
    }

    public void setCompanyStockId(int companyStockId) {
        this.companyStockId = companyStockId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }
    
}
