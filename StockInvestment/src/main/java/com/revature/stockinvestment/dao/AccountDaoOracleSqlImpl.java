/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.util.ConnectionUtil;

/**
 *
 * @author James
 */
@Repository
public class AccountDaoOracleSqlImpl implements AccountDao { 
	/*
    private static final String SQL_INSERT_ACCOUNT 
            = "INSERT INTO ACCOUNT (BALANCE, MEMBER_ID) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE_ACCOUNT 
            = "DELETE FROM ACCOUNT "
            + "WHERE ACCOUNT_ID = ?"; 
    
    private static final String SQL_UPDATE_ACCOUNT 
            = "UPDATE ACCOUNT "
            + "SET BALANCE = ?, MEMBER_ID = ? "
            + "WHERE ACCOUNT_ID = ?";
    
    private static final String SQL_SELECT_ACCOUNT_BY_ACCOUNT_ID 
            = "SELECT ACCOUNT_ID, BALANCE "
            + "FROM ACCOUNT "
            + "WHERE ACCOUNT_ID = ?";
    
    private static final String SQL_SELECT_ALL_ACCOUNTS 
            = "SELECT ACCOUNT_ID, BALANCE "
            + "FROM ACCOUNT";
    */
    
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    @Override
    public void addAccount(Account account) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(account);
        t.commit();
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_INSERT_ACCOUNT);
            ps.setDouble(1, account.getBalance());
            ps.setInt(2, account.getMember().getMemberId());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not write to db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }*/
    }

    @Override
    public void deleteAccount(int accountId) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(account);
        t.commit();
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_DELETE_ACCOUNT);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not write to db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }*/
    }

    @Override
    public void updateAccount(Account account) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.save(account);
        t.commit();
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_UPDATE_ACCOUNT);
            ps.setDouble(1, account.getBalance());
            ps.setInt(2, account.getMember().getMemberId());
            ps.setInt(3, account.getAccountId());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not write to db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }*/
    }

    @Override
    public Account getAccountByAccountId(int accountId) throws SIPersistenceException {
        Account a = null;
        List<Account> accounts = new ArrayList<Account>();
        Session s = sessionFactory.getCurrentSession();
        accounts = s.createQuery("from Account where account_id = :aId")
        		.setInteger("aId", accountId).list();
        if(!accounts.isEmpty()) {
        	a = accounts.get(0);
        }
        
        return a;
        
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_ACCOUNT_BY_ACCOUNT_ID);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setAccountId(rs.getInt("ACCOUNT_ID"));
                account.setBalance(rs.getDouble("BALANCE"));
            }
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not read from db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }
        return account;*/
    }

    @Override
    public List<Account> getAllAccounts() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Account").list();
        
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = null;
        List<Account> accounts = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
            rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setAccountId(rs.getInt("ACCOUNT_ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not read from db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }
        return accounts;*/
    }
    
}
