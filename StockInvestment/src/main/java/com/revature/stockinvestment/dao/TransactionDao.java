/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Transaction;
import java.util.List;

/**
 *
 * @author James
 */
public interface TransactionDao {
    
    public void addTransaction(Transaction transaction) throws SIPersistenceException;
    
    public void deleteTransaction(int transactionId) throws SIPersistenceException;
    
    public void updateTransaction(Transaction transaction) throws SIPersistenceException;
    
    public Transaction getTransactionByTransactionId(int transactionId) throws SIPersistenceException;
    
    public List<Transaction> getAllTransactions() throws SIPersistenceException;
    
    
}
