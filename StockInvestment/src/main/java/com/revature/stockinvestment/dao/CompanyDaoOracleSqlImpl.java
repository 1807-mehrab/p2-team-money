/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCompanyStock(Company companyStock) throws SIPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.save(companyStock);
		//session.getTransaction().commit();
		
	}

	@Override
	public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
		Company company = new Company();
    	company.setCompany_id(companyStockId);
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
    	session.delete(company);
    	//session.getTransaction().commit();
		
	}

	@Override
	public void updateCompanyStock(Company companyStock) throws SIPersistenceException {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		Company c = (Company) session.get(Company.class, companyStock.getCompany_id());
		c.setCompany_name(companyStock.getCompany_name());
		session.update(c);
		//session.getTransaction().commit();
		
	}

	@Override
	public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
		Company c = null;
		List<Company> companies = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		companies = session.createQuery("from Company where company_id = :idVar").setInteger("idVar", companyStockId).list();
		if (!companies.isEmpty()) {
			c = companies.get(0);
		}
		return c;
	}

	@Override
	public List<Company> getAllCompanyStocks() throws SIPersistenceException {
		List<Company> companies = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		companies = session.createQuery("from Company").list();
		return companies;
	}
    
}
