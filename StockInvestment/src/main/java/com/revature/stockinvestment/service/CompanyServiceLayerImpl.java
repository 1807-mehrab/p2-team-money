/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.revature.stockinvestment.dao.CompanyDao;

/**
 *
 * @author James
 */
@Service
public class CompanyServiceLayerImpl { 

    @Autowired
	CompanyDaoOracleSqlImpl dao;

	public void setDao(CompanyDaoOracleSqlImpl dao) {
		this.dao = dao;
	}
	
	@Transactional
	public void addCompanyStock(Company companyStock) throws SIPersistenceException {
		dao.addCompanyStock(companyStock);
		
	}

	@Transactional
	public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
		dao.deleteCompanyStock(companyStockId);
		
	}

	@Transactional
	public void updateCompanyStock(Company companyStock) throws SIPersistenceException {
		dao.updateCompanyStock(companyStock);
		
	}

	@Transactional
	public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
		return dao.getCompanyStockByCompanyStockId(companyStockId);
	}

	@Transactional
	public List<Company> getAllCompanyStocks() throws SIPersistenceException {
		return dao.getAllCompanyStocks();
	}
    
}
