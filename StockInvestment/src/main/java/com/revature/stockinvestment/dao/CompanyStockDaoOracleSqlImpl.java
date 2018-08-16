/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.model.CompanyStock;
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
public class CompanyStockDaoOracleSqlImpl implements CompanyStockDao { 

    private static final String SQL_INSERT_COMPANY_STOCK 
            = "INSERT INTO COMPANY_STOCK (COMPANY_NAME, STOCK_PRICE, ACCOUNT_ID) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE_COMPANY_STOCK 
            = "DELETE FROM COMPANY_STOCK "
            + "WHERE COMPANY_STOCK_ID = ?"; 
    
    private static final String SQL_UPDATE_COMPANY_STOCK 
            = "UPDATE COMPANY_STOCK "
            + "SET COMPANY_NAME = ?, STOCK_PRICE = ?, ACCOUNT_ID = ? "
            + "WHERE COMPANY_STOCK_ID = ?";
    
    private static final String SQL_SELECT_COMPANY_STOCK_BY_COMPANY_STOCK_ID 
            = "SELECT COMPANY_STOCK_ID, COMPANY_NAME, STOCK_PRICE "
            + "FROM COMPANY_STOCK "
            + "WHERE COMPANY_STOCK_ID = ?";
    
    private static final String SQL_SELECT_ALL_COMPANY_STOCKS 
            = "SELECT COMPANY_STOCK_ID, COMPANY_NAME, STOCK_PRICE "
            + "FROM COMPANY_STOCK";
    
    @Override
    public void addCompanyStock(CompanyStock companyStock) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_INSERT_COMPANY_STOCK);
            for (Account account : companyStock.getAccountList()) {
                ps.setString(1, companyStock.getCompanyName());
                ps.setDouble(2, companyStock.getStockPrice());
                ps.setInt(3, account.getAccountId());
                rs = ps.executeQuery();
            }
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
            ps = conn.prepareStatement(SQL_DELETE_COMPANY_STOCK);
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
    public void updateCompanyStock(CompanyStock companyStock) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_UPDATE_COMPANY_STOCK);
            for (Account account : companyStock.getAccountList()) {
                ps.setString(1, companyStock.getCompanyName());
                ps.setDouble(2, companyStock.getStockPrice());
                ps.setInt(3, account.getAccountId());
                ps.setInt(4, companyStock.getCompanyStockId());
                rs = ps.executeQuery();
            }
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
    public CompanyStock getCompanyStockByCompanyStockId(int companyStockId) throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        CompanyStock companyStock = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_COMPANY_STOCK_BY_COMPANY_STOCK_ID);
            ps.setInt(1, companyStockId);
            rs = ps.executeQuery();
            while (rs.next()) {
                companyStock = new CompanyStock();
                companyStock.setCompanyStockId(rs.getInt("COMPANY_STOCK_ID"));
                companyStock.setCompanyName(rs.getString("COMPANY_NAME"));
                companyStock.setStockPrice(rs.getDouble("STOCK_PRICE"));
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
    public List<CompanyStock> getAllCompanyStocks() throws SIPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        CompanyStock companyStock = null;
        List<CompanyStock> companyStocks = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_ALL_COMPANY_STOCKS);
            rs = ps.executeQuery();
            while (rs.next()) {
                companyStock = new CompanyStock();
                companyStock.setCompanyStockId(rs.getInt("COMPANY_STOCK_ID"));
                companyStock.setCompanyName(rs.getString("COMPANY_NAME"));
                companyStock.setStockPrice(rs.getDouble("STOCK_PRICE"));
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
    
}
