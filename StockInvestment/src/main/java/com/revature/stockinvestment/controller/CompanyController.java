package com.revature.stockinvestment.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import com.revature.stockinvestment.service.CompanyServiceLayer;

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
