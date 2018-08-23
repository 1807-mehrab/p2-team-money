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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author James
 */
@Transactional
@Repository
public class TransactionDaoOracleSqlImpl {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTransaction(Transaction transaction) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        org.hibernate.Transaction t = s.beginTransaction();
        s.save(transaction);
        t.commit();
    }

    public void deleteTransaction(int transactionId) throws SIPersistenceException {
        Transaction transaction = getTransactionByTransactionId(transactionId);
        Session s = sessionFactory.getCurrentSession();
        org.hibernate.Transaction t = s.beginTransaction();
        s.delete(transaction);
        t.commit();
    }

    public void updateTransaction(Transaction transaction) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        org.hibernate.Transaction t = s.beginTransaction();
        s.save(transaction);
        t.commit();
    }

    public Transaction getTransactionByTransactionId(int transactionId) throws SIPersistenceException {
        Transaction transaction = null;
        List<Transaction> transactions = new ArrayList<Transaction>();
        Session s = sessionFactory.getCurrentSession();
        transactions = s.createQuery("from Transaction where transaction_id = :tId")
                .setInteger("tId", transactionId).list();
        if (!transactions.isEmpty()) {
            transaction = transactions.get(0);
        }
        return transaction;
    }

    public List<Transaction> getAllTransactions() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Transaction").list();
    }

}
