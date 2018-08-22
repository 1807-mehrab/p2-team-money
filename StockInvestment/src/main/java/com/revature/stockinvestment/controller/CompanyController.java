package com.revature.stockinvestment.controller;

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
