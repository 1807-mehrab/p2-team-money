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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accSeq")
    @SequenceGenerator(allocationSize = 1, name = "accSeq", sequenceName = "SQ_ACCOUNT_PK")
    @Column(name = "ACCOUNT_ID")
    private int accountId;

    @Column(name = "BALANCE")
    private double balance;

    @Autowired
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Member member;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
