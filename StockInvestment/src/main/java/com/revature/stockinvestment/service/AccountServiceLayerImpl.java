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
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;

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

    public void addAccount(Account account) throws SIPersistenceException {
        accountDao.addAccount(account);
    }

    public void deleteAccount(int accountId) throws SIPersistenceException {
        accountDao.deleteAccount(accountId);
    }

    public void updateAccount(Account account) throws SIPersistenceException {
        accountDao.updateAccount(account);
    }

    public Account getAccountByAccountId(int accountId) throws SIPersistenceException {
        return accountDao.getAccountByAccountId(accountId);
    }

    public List<Account> getAllAccounts() throws SIPersistenceException {
        return accountDao.getAllAccounts();
    }

}
