/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Company;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author James
 */
@Transactional
@Repository
public class CompanyDaoOracleSqlImpl {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCompany(Company company) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(company);
        t.commit();
    }

    public void deleteCompany(int companyId) throws SIPersistenceException {
        Company companyStock = getCompanyByCompanyId(companyId);
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(companyStock);
        t.commit();
    }

    public void updateCompany(Company company) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(company);
        t.commit();
    }

    public Company getCompanyByCompanyId(int companyId) throws SIPersistenceException {
        Company c = null;
        List<Company> companies = new ArrayList<Company>();
        Session s = sessionFactory.getCurrentSession();
        companies = s.createQuery("from Company where company_id = :cId")
                .setInteger("cId", companyId).list();
        if (!companies.isEmpty()) {
            c = companies.get(0);
        }

        return c;
    }

    public List<Company> getAllCompanies() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Company").list();
    }

    public Company getCompanyByName(String companyname) throws SIPersistenceException {
        Company c = null;
        List<Company> companies = new ArrayList<Company>();
        Session s = sessionFactory.getCurrentSession();

        companies = s.createQuery("from Company where company_name = :cName")
                .setString("cName", companyname).list();

        if (!companies.isEmpty()) {
            c = companies.get(0);
        }

        return c;
    }
}
