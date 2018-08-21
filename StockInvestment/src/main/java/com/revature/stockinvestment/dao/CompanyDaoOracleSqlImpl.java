/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.util.ConnectionUtil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author James
 */
@Repository

public class CompanyDaoOracleSqlImpl implements CompanyDao { 
    
    //***************************************
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//***************************************
    
    @Override
    public void addCompanyStock(Company companyStock) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(companyStock);
        t.commit();
    }

    @Override
    public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
        Company companyStock = getCompanyStockByCompanyStockId(companyStockId);
    	Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(companyStock);
        t.commit();
    }

    @Override
    public void updateCompanyStock(Company companyStock) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(companyStock);
        t.commit();
    }

    @Override
    public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
        Company c = null;
        List<Company> companies = new ArrayList<Company>();
        Session s = sessionFactory.getCurrentSession();
        
        companies = s.createQuery("from Company where company_id = :cId")
        		.setInteger("cId", companyStockId).list();
        
        if(!companies.isEmpty()) {
        	c = companies.get(0);
        }
        
        return c;
    }

    @Override
    public List<Company> getAllCompanyStocks() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from company").list();
    }
}
