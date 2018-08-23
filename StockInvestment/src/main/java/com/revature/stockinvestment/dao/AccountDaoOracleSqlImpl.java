/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.stockinvestment.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author James
 */
@Repository
<<<<<<< HEAD
public class AccountDaoOracleSqlImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
=======
public class AccountDaoOracleSqlImpl { 
    
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    //@Override
>>>>>>> d1ab951f8bebd4aed32c5509e38bd91f76073197
    public void addAccount(Account account) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(account);
        t.commit();
    }

    //@Override
    public void deleteAccount(int accountId) throws SIPersistenceException {
        Account account = getAccountByAccountId(accountId);
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(account);
        t.commit();
    }

    //@Override
    public void updateAccount(Account account) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(account);
        t.commit();
    }

    //@Override
    public Account getAccountByAccountId(int accountId) throws SIPersistenceException {
        Account a = null;
        List<Account> accounts = new ArrayList<Account>();
        Session s = sessionFactory.getCurrentSession();
        accounts = s.createQuery("from Account where account_id = :aId")
                .setInteger("aId", accountId).list();
        if (!accounts.isEmpty()) {
            a = accounts.get(0);
        }

        return a;
    }

    //@Override
    public List<Account> getAllAccounts() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Account").list();
    }

}
