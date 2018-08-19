/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author James
 */
@Entity
@Table
public class Transaction {
    @Id
    @Column(name="TRANSACTION_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tranSeq")
    @SequenceGenerator(allocationSize=1, name="tranSeq", sequenceName="SQ_TRANSACTION_PK")
    private int transactionId;
    
    @Column(name="SHARES")
    private int shares;
    
    @Column(name="PURCHASE_PRICE")
    private double purchasePrice;
    
    @Autowired
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TRANSACTION_ACCOUNT")
    private Account account;
    
    @Autowired
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TRANSACTION_COMPANY")
    private Company company;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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
