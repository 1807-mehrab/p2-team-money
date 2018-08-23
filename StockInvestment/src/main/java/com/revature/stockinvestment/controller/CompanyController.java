package com.revature.stockinvestment.controller;


import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Company;
import javax.inject.Inject;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyServiceLayerImpl cs;
	
	 @Inject
	 public CompanyController(CompanyServiceLayerImpl cs) {
		 this.cs = cs;
	 }
	
	 @PostMapping("/company")
         @ResponseStatus(HttpStatus.CREATED)
	 public void addCompany(@Valid @RequestBody Company company) throws SIPersistenceException {
		 cs.addCompanyStock(company);
	 }
	    
	 @DeleteMapping("/company/{id}")
         @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void deleteCompany(@PathVariable("id") int id) throws SIPersistenceException {
		 cs.deleteCompanyStock(id);
	 }
	    
	 @PutMapping("/company/{id}")
	 public void updateCompanyStock(@PathVariable("id") int id, @Valid @RequestBody Company company) throws SIPersistenceException {
		 cs.updateCompanyStock(company);
	 }
	    
	 @GetMapping("/company/{id}")
	 public Company getCompanyStockByCompanyStockId(@PathVariable("id") int id) throws SIPersistenceException {
		return cs.getCompanyStockByCompanyStockId(id);
	 }
	    
	 @GetMapping("/companies")
	 public List<Company> getAllCompanyStocks() throws SIPersistenceException {
		return cs.getAllCompanyStocks();
	 }

}
