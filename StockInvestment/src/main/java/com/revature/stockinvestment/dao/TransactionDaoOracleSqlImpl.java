/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Exchange;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public void addTransaction(Exchange exchange) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(exchange);
        t.commit();
    }

    public void deleteTransaction(int exchangeId) throws SIPersistenceException {
        Exchange exchange = getTransactionByTransactionId(exchangeId);
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(exchange);
        t.commit();
    }

    public void updateTransaction(Exchange exchange) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(exchange);
        t.commit();
    }

    public Exchange getTransactionByTransactionId(int exchangeId) throws SIPersistenceException {
        Exchange exchange = null;
        List<Exchange> exchanges = new ArrayList<Exchange>();
        Session s = sessionFactory.getCurrentSession();
        exchanges = s.createQuery("from Exchange where exchange_id = :tId")
                .setInteger("tId", exchangeId).list();
        if (!exchanges.isEmpty()) {
            exchange = exchanges.get(0);
        }
        return exchange;
    }

    public List<Exchange> getAllTransactions() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Exchange").list();
    }

}
