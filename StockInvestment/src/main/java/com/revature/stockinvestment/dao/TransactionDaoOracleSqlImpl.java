/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author James
 */
@Repository
public class TransactionDaoOracleSqlImpl implements TransactionDao {
    
	//***************************************
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//***************************************
	
    @Override
    public void addTransaction(Transaction transaction) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        org.hibernate.Transaction t = s.beginTransaction();
        s.save(transaction);
        t.commit();
    }

    @Override
    public void deleteTransaction(int transactionId) throws SIPersistenceException {
    	Session s = sessionFactory.getCurrentSession();
    	org.hibernate.Transaction t = s.beginTransaction();
    	s.delete(transaction);
    	t.commit();
    }

    @Override
    public void updateTransaction(Transaction transaction) throws SIPersistenceException {
    	Session s = sessionFactory.getCurrentSession();
    	org.hibernate.Transaction t = s.beginTransaction();
    	s.save(transaction);
    	t.commit();
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) throws SIPersistenceException {
    	Transaction transaction = null;
    	List<Transaction> transactions = new ArrayList<Transaction>();
    	Session s = sessionFactory.getCurrentSession();
    	transactions = s.createQuery("from Transaction where transaction_id = :tId")
    			.setInteger("tId", transactionId).list();
    	if(!transactions.isEmpty()) {
    		transaction = transactions.get(0);
    	}
    	return transaction;
    }

    @Override
    public List<Transaction> getAllTransactions() throws SIPersistenceException {
    	Session s = sessionFactory.getCurrentSession();
    	return s.createQuery("from Transaction").list();
    }
    
}