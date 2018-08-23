/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.service;

import com.revature.stockinvestmentapp.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
//    public void addAccount(Account account) { 
//        accountDao.addAccount(account);
//    }
//
//    public void deleteAccount(int accountId) {
//        accountDao.deleteAccount(accountId);
//    }
//
//    public void updateAccount(Account account) {
//        accountDao.updateAccount(account);
//    }

//    public Account getAccountByAccountId(int accountId) {
//        return accountDao.getAccountByAccountId(accountId);
//    }
//
//    public List<Account> getAllAccounts() {
//        return accountDao.getAllAccounts();
//    }
//    
}

