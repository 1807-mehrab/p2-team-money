/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author James
 */
@Repository
public class CompanyDaoOracleSqlImpl implements CompanyDao { 

    private static final String SQL_INSERT_COMPANY 
            = "INSERT INTO COMPANY (COMPANY_NAME) "
            + "VALUES (?, ?)";
    
    private static final String SQL_INSERT_COMPANY_ACCOUNTS 
            = "INSERT INTO TRANSACTION (SHARES, ACCOUNT_ID, COMPANY_ID) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE_COMPANY 
            = "DELETE FROM COMPANY "
            + "WHERE COMPANY_ID = ?"; 
    
    private static final String SQL_UPDATE_COMPANY 
            = "UPDATE COMPANY "
            + "SET COMPANY_NAME = ? "
            + "WHERE COMPANY_ID = ?";
    
    private static final String SQL_SELECT_COMPANY_BY_COMPANY_ID 
            = "SELECT COMPANY_ID, COMPANY_NAME "
            + "FROM COMPANY "
            + "WHERE COMPANY_ID = ?";
    
    private static final String SQL_SELECT_ALL_COMPANIES 
            = "SELECT COMPANY_ID, COMPANY_NAME "
            + "FROM COMPANY";
    
    @Override
    public void addCompanyStock(Company companyStock) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_INSERT_COMPANY);
            ps.setString(1, companyStock.getCompanyName());
            rs = ps.executeQuery();
            //insertCompanyStockAccounts(companyStock);
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
    public void deleteCompanyStock(int companyStockId) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_DELETE_COMPANY);
            ps.setInt(1, companyStockId);
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
    public void updateCompanyStock(Company companyStock) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_UPDATE_COMPANY);
            ps.setString(1, companyStock.getCompanyName());
            ps.setInt(2, companyStock.getCompanyStockId());
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
    public Company getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Company companyStock = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_COMPANY_BY_COMPANY_ID);
            ps.setInt(1, companyStockId);
            rs = ps.executeQuery();
            while (rs.next()) {
                companyStock = new Company();
                companyStock.setCompanyStockId(rs.getInt("COMPANY_STOCK_ID"));
                companyStock.setCompanyName(rs.getString("COMPANY_NAME"));
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
        return companyStock;
    }

    @Override
    public List<Company> getAllCompanyStocks() throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Company companyStock = null;
        List<Company> companyStocks = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_ALL_COMPANIES);
            rs = ps.executeQuery();
            while (rs.next()) {
                companyStock = new Company();
                companyStock.setCompanyStockId(rs.getInt("COMPANY_STOCK_ID"));
                companyStock.setCompanyName(rs.getString("COMPANY_NAME"));
                companyStocks.add(companyStock);
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
        return companyStocks;
    }
    
//    private void insertCompanyStockAccounts(Company companyStock) throws SIPersistenceException {
//        final int companyStockId = companyStock.getCompanyStockId();
//        final List<Account> accounts = companyStock.getAccountList();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            ps = conn.prepareStatement(SQL_INSERT_COMPANY_STOCK_ACCOUNTS);
//            for (Account account : accounts) {
//                ps.setInt(1, account.getShares());
//                ps.setInt(2, account.getAccountId());
//                ps.setInt(3, companyStockId);
//                rs = ps.executeQuery();
//            }
//        } catch (SQLException e) {
//            throw new SIPersistenceException("Could not connect to db.", e);
//        } catch (IOException e) {
//            throw new SIPersistenceException("Could not read from db.", e);
//        } finally {
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                throw new SIPersistenceException("Could not close db.", e);
//            }
//        }
//    }
    
}
