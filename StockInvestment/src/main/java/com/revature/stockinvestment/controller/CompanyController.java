package com.revature.stockinvestment.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import com.revature.stockinvestment.service.CompanyServiceLayer;

@Controller
public class CompanyController {

    private CompanyServiceLayer companyStockServiceLayer;
    
    @Inject
    public CompanyController(CompanyServiceLayer companyStockServiceLayer) {
        this.companyStockServiceLayer = companyStockServiceLayer;
    }
    
    
}
