/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public void addAccount(Account account) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.save(account);
//        t.commit();
//    }
//
//    public void deleteAccount(int accountId) {
//        Account account = getAccountByAccountId(accountId);
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.delete(account);
//        t.commit();
//    }
//
//    public void updateAccount(Account account) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.save(account);
//        t.commit();
//    }

//    public Account getAccountByAccountId(int accountId) {
//        Account a = null;
//        List<Account> accounts = new ArrayList<Account>();
//        Session s = sessionFactory.getCurrentSession();
//        accounts = s.createQuery("from Account where account_id = :aId")
//                .setInteger("aId", accountId).list();
//        if (!accounts.isEmpty()) {
//            a = accounts.get(0);
//        }
//
//        return a;
//    }
//
//    public List<Account> getAllAccounts() {
//        Session s = sessionFactory.getCurrentSession();
//        return s.createQuery("from Account").list();
//    }

}
