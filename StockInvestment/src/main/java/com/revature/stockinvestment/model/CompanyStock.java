/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

import java.util.List;

/**
 *
 * @author James
 */
public class CompanyStock { 
    
    private int companyStockId;
    private String companyName;
    private double stockPrice;
    private List<Account> accountList;

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

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

}
