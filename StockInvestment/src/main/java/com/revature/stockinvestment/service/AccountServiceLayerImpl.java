/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

<<<<<<< HEAD
import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
>>>>>>> d1ab951f8bebd4aed32c5509e38bd91f76073197

/**
 *
 * @author James
 */
@Service
public class AccountServiceLayerImpl {

<<<<<<< HEAD
    @Autowired
    private AccountDaoOracleSqlImpl accountDao;
    
    
    public AccountServiceLayerImpl(AccountDaoOracleSqlImpl accountDao) {
        this.accountDao = accountDao;
    }
    
    @Override
=======
	@Autowired
    private AccountDaoOracleSqlImpl accountDao;
       
	public void setDao(AccountDaoOracleSqlImpl dao) {
		this.accountDao = dao;
	}
        
    //@Override
>>>>>>> d1ab951f8bebd4aed32c5509e38bd91f76073197
    public void addAccount(Account account) throws SIPersistenceException { 
        accountDao.addAccount(account);
    }

    //@Override
    public void deleteAccount(int accountId) throws SIPersistenceException {
        accountDao.deleteAccount(accountId);
    }

    //@Override
    public void updateAccount(Account account) throws SIPersistenceException {
        accountDao.updateAccount(account);
    }

    //@Override
    public Account getAccountByAccountId(int accountId) throws SIPersistenceException {
        return accountDao.getAccountByAccountId(accountId);
    }

    //@Override
    public List<Account> getAllAccounts() throws SIPersistenceException {
        return accountDao.getAllAccounts();
    }
    
}
