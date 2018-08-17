package com.revature.stockinvestment.controller;

import com.revature.stockinvestment.service.AccountServiceLayer;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    private AccountServiceLayer accountServiceLayer;
    
    @Inject
    public AccountController(AccountServiceLayer accountServiceLayer) {
        this.accountServiceLayer = accountServiceLayer;
    }
    
}
