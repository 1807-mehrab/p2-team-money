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
import com.revature.stockinvestment.model.Account;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author James
 */
@Service
public class AccountServiceLayerImpl {


	@Autowired
    private AccountDaoOracleSqlImpl accountDao;
       
	public void setDao(AccountDaoOracleSqlImpl dao) {
		this.accountDao = dao;
	}
        
    //@Override
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

    @Autowired
    private AccountDaoOracleSqlImpl accountDao;
    
    public void setAccountDao(AccountDaoOracleSqlImpl accountDao) {
        this.accountDao = accountDao;
    }
    
    public void addAccount(Account account) { 
        accountDao.addAccount(account);
    }

    public void deleteAccount(int accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public Account getAccountByAccountId(int accountId) {
        return accountDao.getAccountByAccountId(accountId);
    }

    public List<Account> getAllAccounts() {

        return accountDao.getAllAccounts();
    }
    
}
