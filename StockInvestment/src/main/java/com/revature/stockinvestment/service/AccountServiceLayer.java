/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
import java.util.List;

/**
 *
 * @author James
 */
public interface AccountServiceLayer { 
    
    public void addAccount(Account account) throws SIPersistenceException;
    
    public void deleteAccount(int accountId) throws SIPersistenceException;
    
    public void updateAccount(Account account) throws SIPersistenceException;
    
    public Account getAccountByAccountId(int accountId) throws SIPersistenceException;
    
    public List<Account> getAllAccounts() throws SIPersistenceException;
    
}
