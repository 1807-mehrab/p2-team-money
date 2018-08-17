package com.revature.stockinvestment.controller;

import com.revature.stockinvestment.service.CompanyStockServiceLayer;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

@Controller
public class CompanyStockController {

    private CompanyStockServiceLayer companyStockServiceLayer;
    
    @Inject
    public CompanyStockController(CompanyStockServiceLayer companyStockServiceLayer) {
        this.companyStockServiceLayer = companyStockServiceLayer;
    }
    
    
}
