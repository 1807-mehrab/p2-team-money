/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author James
 */
@Entity
@Table(name = "EXCHANGE")
public class Exchange {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="exchSeq")
    @SequenceGenerator(allocationSize=1, name="exchSeq", sequenceName="SQ_EXCHANGE_PK")
    @Column(name="EXCHANGE_ID")
    private int exchangeId;
    
    @Min(0)
    @Column(name="SHARES")
    private int shares;
    
    @Min(0)
    @Column(name="PURCHASE_PRICE")
    private double purchasePrice;
    
    @Autowired
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EXCHANGE_ACCOUNT")
    private Account account;
    
    @Autowired
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EXCHANGE_COMPANY")
    private Company company;

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
