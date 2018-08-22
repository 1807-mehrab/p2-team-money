/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;

/**
 *
 * @author James
 */
@Repository
public class CompanyServiceLayerImpl /*implements CompanyServiceLayer*/ {

	@Autowired
	CompanyDaoOracleSqlImpl dao;

	public void setDao(CompanyDaoOracleSqlImpl dao) {
		this.dao = dao;
	}
	
	//@Transactional
	public void addCompanyStock(Company companyStock) throws SIPersistenceException {
		dao.addCompanyStock(companyStock);
		
	}

	//@Transactional
	public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
		dao.deleteCompanyStock(companyStockId);
		
	}

	//@Transactional
	public void updateCompanyStock(Company companyStock) throws SIPersistenceException {
		dao.updateCompanyStock(companyStock);
		
	}

	//@Transactional
	public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
		return dao.getCompanyStockByCompanyStockId(companyStockId);
	}

	//@Transactional
	public List<Company> getAllCompanyStocks() throws SIPersistenceException {
		return dao.getAllCompanyStocks();
	}
}