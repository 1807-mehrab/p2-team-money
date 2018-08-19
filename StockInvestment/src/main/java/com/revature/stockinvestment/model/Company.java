/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

import javax.persistence.*;

/**
 *
 * @author James
 */
@Entity
@Table
public class Company { 
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comSeq")
    @SequenceGenerator(allocationSize=1, name="comSeq", sequenceName="SQ_COMPANY_PK")
    @Column(name="COMPANY_ID")
    private int companyStockId;
    
    @Column(name="COMPANY_NAME")
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
