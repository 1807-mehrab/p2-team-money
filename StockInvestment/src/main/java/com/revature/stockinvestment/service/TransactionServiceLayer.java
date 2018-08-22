/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.model.Transaction;
import java.util.List;

/**
 *
 * @author James
 */
public interface TransactionServiceLayer {
    
    public void addTransaction(Transaction transaction);
    
    public void deleteTransaction(int transactionId);
    
    public void updateTransaction(Transaction transaction);
    
    public Transaction getTransactionByTransactionId(int transactionId);
    
    public List<Transaction> getAllTransactions();
    
}
