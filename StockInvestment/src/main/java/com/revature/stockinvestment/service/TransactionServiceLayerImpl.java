/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.SIPersistenceException;
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
public class TransactionServiceLayerImpl { //implements TransactionServiceLayer {

    private TransactionDao transactionDao;
    
    @Inject
    public TransactionServiceLayerImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }
    
<<<<<<< HEAD
    @Override
=======
	public void setADao(AccountDaoOracleSqlImpl dao) {
		this.accountDao = dao;
	}
	
	public void setCDao(CompanyDaoOracleSqlImpl dao) {
		this.companyDao = dao;
	}
    //@Override
>>>>>>> d1ab951f8bebd4aed32c5509e38bd91f76073197
    public void addTransaction(Transaction transaction) throws SIPersistenceException {
        transactionDao.addTransaction(transaction);
    }

    //@Override
    public void deleteTransaction(int transactionId) throws SIPersistenceException {
        transactionDao.deleteTransaction(transactionId);
    }

    //@Override
    public void updateTransaction(Transaction transaction) throws SIPersistenceException {
        transactionDao.updateTransaction(transaction);
    }

    //@Override
    public Transaction getTransactionByTransactionId(int transactionId) throws SIPersistenceException {
        return transactionDao.getTransactionByTransactionId(transactionId);
    }

    //@Override
    public List<Transaction> getAllTransactions() throws SIPersistenceException {
        return transactionDao.getAllTransactions();
    }
    
}
