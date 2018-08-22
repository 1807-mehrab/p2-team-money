/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.TransactionDaoOracleSqlImpl;
import com.revature.stockinvestment.model.Transaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class TransactionServiceLayerImpl {

    @Autowired
    private TransactionDaoOracleSqlImpl transactionDao;
    
    public void setTransactionDao(TransactionDaoOracleSqlImpl transactionDao) {
        this.transactionDao = transactionDao;
    }
    
    public void addTransaction(Transaction transaction) {
        transactionDao.addTransaction(transaction);
    }

    public void deleteTransaction(int transactionId) {
        transactionDao.deleteTransaction(transactionId);
    }

    public void updateTransaction(Transaction transaction) {
        transactionDao.updateTransaction(transaction);
    }

    public Transaction getTransactionByTransactionId(int transactionId) {
        return transactionDao.getTransactionByTransactionId(transactionId);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }
    
}
