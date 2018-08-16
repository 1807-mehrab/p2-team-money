/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class AccountDaoOracleSqlImpl implements AccountDao { 

    private static final String SQL_INSERT_ACCOUNT 
            = "INSERT INTO ACCOUNT (BALANCE, SHARES, MEMBER_ID) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE_ACCOUNT 
            = "DELETE FROM ACCOUNT "
            + "WHERE ACCOUNT_ID = ?"; 
    
    private static final String SQL_UPDATE_ACCOUNT 
            = "UPDATE ACCOUNT "
            + "SET BALANCE = ?, SHARES = ?, MEMBER_ID = ? "
            + "WHERE ACCOUNT_ID = ?";
    
    private static final String SQL_SELECT_ACCOUNT_BY_ACCOUNT_ID 
            = "SELECT ACCOUNT_ID, BALANCE, SHARES "
            + "FROM ACCOUNT "
            + "WHERE ACCOUNT_ID = ?";
    
    private static final String SQL_SELECT_ALL_ACCOUNTS 
            = "SELECT ACCOUNT_ID, BALANCE, SHARES "
            + "FROM ACCOUNT";
    
    @Override
    public void addAccount(Account account) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_INSERT_ACCOUNT);
            ps.setDouble(1, account.getBalance());
            ps.setInt(2, account.getShares());
            ps.setInt(3, account.getMember().getMemberId());
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
        }
    }

    @Override
    public void deleteAccount(int accountId) throws SIPersistenceException {
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
        }
    }

    @Override
    public void updateAccount(Account account) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_UPDATE_ACCOUNT);
            ps.setDouble(1, account.getBalance());
            ps.setInt(2, account.getShares());
            ps.setInt(3, account.getMember().getMemberId());
            ps.setInt(4, account.getAccountId());
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
        }
    }

    @Override
    public Account getAccountByAccountId(int accountId) throws SIPersistenceException {
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
                account.setShares(rs.getInt("SHARES"));
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
        return account;
    }

    @Override
    public List<Account> getAllAccounts() throws SIPersistenceException {
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
                account.setShares(rs.getInt("SHARES"));
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
        return accounts;
    }
    
}
