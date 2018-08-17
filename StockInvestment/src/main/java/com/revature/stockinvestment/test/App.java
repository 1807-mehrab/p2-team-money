/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.test;

import com.revature.stockinvestment.dao.AccountDao;
import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.CompanyStockDao;
import com.revature.stockinvestment.dao.CompanyStockDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.MemberDao;
import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.model.CompanyStock;
import com.revature.stockinvestment.model.Member;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class App {

    public static void main(String[] args) {
        
        // NEED TO ALTER THE ACCOUNTDAO TO INCLUDE SHARES BEFORE MEMBER_ID
        
        MemberDao memberDao = new MemberDaoOracleSqlImpl();
        AccountDao accountDao = new AccountDaoOracleSqlImpl();
        CompanyStockDao companyStockDao = new CompanyStockDaoOracleSqlImpl();
        
        Member member = new Member();
        member.setFirstName("Jimmy");
        member.setLastName("D");
        member.setEmail("fake@email.com");
        member.setPassword("password");
        
        Account account = new Account();
        account.setBalance(100.00);
        account.setShares(50);
        
        List<Account> accounts = new ArrayList<>();
        CompanyStock companyStock = new CompanyStock();
        companyStock.setCompanyName("Apple");
        companyStock.setStockPrice(25.00);
        
        
        try {
            //memberDao.addMember(member);
            
            account.setMember(memberDao.getMemberByMemberId(1));
            accountDao.addAccount(account);
            
            accounts.add(accountDao.getAccountByAccountId(1));
            
            companyStock.setAccountList(accounts);
            companyStockDao.addCompanyStock(companyStock);
            
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
