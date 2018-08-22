/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.TransactionDao;
import com.revature.stockinvestment.model.Transaction;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class TransactionServiceLayerImpl implements TransactionServiceLayer {

    private TransactionDao transactionDao;
    
    @Inject
    public TransactionServiceLayerImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }
    
    @Override
    public void addTransaction(Transaction transaction) {
        transactionDao.addTransaction(transaction);
    }

    @Override
    public void deleteTransaction(int transactionId) {
        transactionDao.deleteTransaction(transactionId);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        transactionDao.updateTransaction(transaction);
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) {
        return transactionDao.getTransactionByTransactionId(transactionId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }
    
}
