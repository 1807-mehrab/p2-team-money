/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.dao.TransactionDaoOracleSqlImpl;
import com.revature.stockinvestment.model.Transaction;

/**
 *
 * @author James
 */
@Service
public class TransactionServiceLayerImpl { //implements TransactionServiceLayer {

	@Autowired
	private TransactionDaoOracleSqlImpl transactionDao;
	
	@Autowired
	private AccountDaoOracleSqlImpl accountDao;
	
	@Autowired
	private CompanyDaoOracleSqlImpl companyDao;

	public void setTDao(TransactionDaoOracleSqlImpl dao) {
		this.transactionDao = dao;
	}
    
	public void setADao(AccountDaoOracleSqlImpl dao) {
		this.accountDao = dao;
	}
	
	public void setCDao(CompanyDaoOracleSqlImpl dao) {
		this.companyDao = dao;
	}
    //@Override
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
    
    public void createTransaction(int accountid, String companyname, int shares, double purchaseprice) throws SIPersistenceException {
    	Transaction t = new Transaction();
    	t.setAccount(accountDao.getAccountByAccountId(accountid));
    	t.setCompany(companyDao.getCompanyByName(companyname));
    	t.setPurchasePrice(purchaseprice);
    	t.setShares(shares);
    }
    
}
