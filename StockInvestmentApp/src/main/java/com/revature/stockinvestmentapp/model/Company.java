/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @Column(name = "COMPANY_ID")
    private int company_id;

    @Column(name = "COMPANY_NAME")
    private String company_name;

    public Company() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Company(int company_id, String company_name) {
        super();
        this.company_id = company_id;
        this.company_name = company_name;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    @Override
    public String toString() {
        return "Company [company_id=" + company_id + ", company_name=" + company_name + "]";
    }
}
