/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.test;

import com.revature.stockinvestment.dao.AccountDao;
import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.MemberDao;
import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.model.Company;
import com.revature.stockinvestment.model.Member;
import com.revature.stockinvestment.service.AccountServiceLayer;
import com.revature.stockinvestment.service.AccountServiceLayerImpl;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;
import com.revature.stockinvestment.service.MemberServiceLayer;
import com.revature.stockinvestment.service.MemberServiceLayerImpl;
import java.util.ArrayList;
import java.util.List;
import com.revature.stockinvestment.dao.CompanyDao;
import com.revature.stockinvestment.service.CompanyServiceLayer;

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
        
        CompanyDao companyStockDao = new CompanyDaoOracleSqlImpl();
        CompanyServiceLayer companyStockServiceLayer = new CompanyServiceLayerImpl(companyStockDao);
        
        Member member = new Member();
        member.setFirstName("Joe");
        member.setLastName("Smith");
        member.setEmail("test2@email.com");
        member.setPassword("test");
        
        Account account = new Account();
        account.setBalance(100.00);
        
        List<Account> accounts = new ArrayList<>();
        Company companyStock = new Company();
        companyStock.setCompanyName("Apple");
        
        
        try {
            memberServiceLayer.addMember(member);
            
            account.setMember(memberDao.getMemberByMemberId(41));
            accountDao.addAccount(account);
            
            accounts.add(accountDao.getAccountByAccountId(1));
            
            companyStockDao.addCompanyStock(companyStock);
            
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
