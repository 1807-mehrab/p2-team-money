/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

/**
 *
 * @author James
 */
public class Company { 
    
    private int companyStockId;
    private String companyName;

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

}
