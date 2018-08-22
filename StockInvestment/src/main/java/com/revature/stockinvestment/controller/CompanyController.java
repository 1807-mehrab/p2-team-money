package com.revature.stockinvestment.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyServiceLayerImpl cs;
	
	 @Inject
	 public CompanyController(CompanyServiceLayerImpl cs) {
		 this.cs = cs;
	 }
	
	 /*
	public void setCs (CompanyServiceLayerImpl cs) {
		this.cs = cs;
	}
	*/
	 
	 @RequestMapping("addCompany")
	 public void addCompanyStock(@RequestBody Company companyStock) throws SIPersistenceException {
		 cs.addCompanyStock(companyStock);
	 }
	    
	 @DeleteMapping("remove/{id}")
	 public void deleteCompanyStock(@PathVariable("id") int companyStockId) throws SIPersistenceException {
		 cs.deleteCompanyStock(companyStockId);
	 }
	    
	 @RequestMapping("updateCompany")
	 public void updateCompanyStock(@RequestBody Company companyStock) throws SIPersistenceException {
		 cs.updateCompanyStock(companyStock);
	 }
	    
	 @GetMapping("/company/{id}")
	 public Company getCompanyStockByCompanyStockId(@PathVariable("id") int companyStockId) throws SIPersistenceException {
		return cs.getCompanyStockByCompanyStockId(companyStockId);
		 
	 }
	    
	 @GetMapping("/companies")
	 public List<Company> getAllCompanyStocks() throws SIPersistenceException {
		return cs.getAllCompanyStocks();
		 
	 }

}
