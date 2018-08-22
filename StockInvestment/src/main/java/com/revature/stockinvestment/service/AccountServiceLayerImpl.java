/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.AccountDao;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class AccountServiceLayerImpl implements AccountServiceLayer {

    private AccountDao accountDao;
    
    @Inject
    public AccountServiceLayerImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    @Override
    public void addAccount(Account account) throws SIPersistenceException { 
        accountDao.addAccount(account);
    }

    @Override
    public void deleteAccount(int accountId) throws SIPersistenceException {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void updateAccount(Account account) throws SIPersistenceException {
        accountDao.updateAccount(account);
    }

    @Override
    public Account getAccountByAccountId(int accountId) throws SIPersistenceException {
        return accountDao.getAccountByAccountId(accountId);
    }

    @Override
    public List<Account> getAllAccounts() throws SIPersistenceException {
        return accountDao.getAllAccounts();
    }
    
}
