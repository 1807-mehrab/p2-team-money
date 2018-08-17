/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.test;

import com.revature.stockinvestment.dao.MemberDao;
import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Member;
import com.revature.stockinvestment.service.MemberServiceLayer;
import com.revature.stockinvestment.service.MemberServiceLayerImpl;

/**
 *
 * @author James
 */
public class App {

    public static void main(String[] args) {
        
        // NEED TO ALTER THE ACCOUNTDAO TO INCLUDE SHARES BEFORE MEMBER_ID
        MemberDao memberDao = new MemberDaoOracleSqlImpl();
        MemberServiceLayer memberServiceLayer = new MemberServiceLayerImpl(memberDao);
//        AccountDao accountDao = new AccountDaoOracleSqlImpl();
//        CompanyStockDao companyStockDao = new CompanyStockDaoOracleSqlImpl();
        
        Member member = new Member();
        member.setFirstName("Joe");
        member.setLastName("Smith");
        member.setEmail("test2@email.com");
        member.setPassword("test");
        
//        Account account = new Account();
//        account.setBalance(100.00);
//        account.setShares(50);
        
//        List<Account> accounts = new ArrayList<>();
//        CompanyStock companyStock = new CompanyStock();
//        companyStock.setCompanyName("Apple");
//        companyStock.setStockPrice(25.00);
        
        
        try {
            memberServiceLayer.addMember(member);
            
//            account.setMember(memberDao.getMemberByMemberId(1));
//            accountDao.addAccount(account);
//            
//            accounts.add(accountDao.getAccountByAccountId(1));
//            
//            companyStock.setAccountList(accounts);
//            companyStockDao.addCompanyStock(companyStock);
            
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
