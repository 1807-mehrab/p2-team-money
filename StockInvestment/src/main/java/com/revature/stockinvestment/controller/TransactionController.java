/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.controller;

import com.revature.stockinvestment.service.TransactionServiceLayer;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

/**
 *
 * @author James
 */
@Controller
public class TransactionController {
    
    private TransactionServiceLayer transactionServiceLayer;
    
    @Inject
    public TransactionController(TransactionServiceLayer transactionServiceLayer) {
        this.transactionServiceLayer = transactionServiceLayer;
    }
}
