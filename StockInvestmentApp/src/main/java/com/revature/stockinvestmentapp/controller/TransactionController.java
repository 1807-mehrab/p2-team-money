/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.controller;

import com.revature.stockinvestmentapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    
    
//    @Inject
//    public TransactionController(TransactionServiceLayer transactionServiceLayer) {
//        this.transactionServiceLayer = transactionServiceLayer;
//    }
}
