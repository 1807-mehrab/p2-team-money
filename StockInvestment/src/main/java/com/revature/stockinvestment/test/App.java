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
import com.revature.stockinvestment.service.AccountServiceLayer;
import com.revature.stockinvestment.service.AccountServiceLayerImpl;
import com.revature.stockinvestment.service.CompanyStockServiceLayer;
import com.revature.stockinvestment.service.CompanyStockServiceLayerImpl;
import com.revature.stockinvestment.service.MemberServiceLayer;
import com.revature.stockinvestment.service.MemberServiceLayerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class App {

    public static void main(String[] args) {
        
        MemberDao memberDao = new MemberDaoOracleSqlImpl();
        MemberServiceLayer memberServiceLayer = new MemberServiceLayerImpl(memberDao);
        
        AccountDao accountDao = new AccountDaoOracleSqlImpl();
        AccountServiceLayer accountServiceLayer = new AccountServiceLayerImpl(accountDao);
        
        CompanyStockDao companyStockDao = new CompanyStockDaoOracleSqlImpl();
        CompanyStockServiceLayer companyStockServiceLayer = new CompanyStockServiceLayerImpl(companyStockDao);
        
        Member member = new Member();
        member.setFirstName("Joe");
        member.setLastName("Smith");
        member.setEmail("test2@email.com");
        member.setPassword("test");
        
        Account account = new Account();
        account.setBalance(100.00);
        account.setShares(50);
        
        List<Account> accounts = new ArrayList<>();
        CompanyStock companyStock = new CompanyStock();
        companyStock.setCompanyName("Apple");
        companyStock.setStockPrice(25.00);
        
        
        try {
            memberServiceLayer.addMember(member);
            
            account.setMember(memberDao.getMemberByMemberId(41));
            accountDao.addAccount(account);
            
            accounts.add(accountDao.getAccountByAccountId(1));
            
            companyStock.setAccountList(accounts);
            companyStockDao.addCompanyStock(companyStock);
            
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
