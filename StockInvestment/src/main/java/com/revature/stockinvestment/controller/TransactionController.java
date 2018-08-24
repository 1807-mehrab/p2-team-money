/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.controller;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.stockinvestment.service.TransactionServiceLayerImpl;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.Transaction;
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
public class TransactionController {

    @Autowired
    private TransactionServiceLayerImpl transactionServiceLayer;

    public TransactionController(TransactionServiceLayerImpl transactionServiceLayer) {
        this.transactionServiceLayer = transactionServiceLayer;
    }

    @PostMapping("/exchange")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@Valid @RequestBody Exchange exchange) throws SIPersistenceException {
        transactionServiceLayer.addTransaction(exchange);
    }

    @DeleteMapping("/exchange/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable("id") int id) throws SIPersistenceException {
        transactionServiceLayer.deleteTransaction(id);
    }

    @PutMapping("/exchange/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTransaction(@PathVariable("id") int id, @Valid @RequestBody Exchange exchange) throws SIPersistenceException {
        transactionServiceLayer.updateTransaction(exchange);
    }

    @GetMapping("/exchange/{id}")
    public Exchange getTransactionByTransactionId(@PathVariable("id") int id) throws SIPersistenceException {
        return transactionServiceLayer.getTransactionByTransactionId(id);
    }

    @GetMapping("/exchanges")
    public List<Exchange> getAllTransactions() throws SIPersistenceException {
        return transactionServiceLayer.getAllTransactions();
    }

}
