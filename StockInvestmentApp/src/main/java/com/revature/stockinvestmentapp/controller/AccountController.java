/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.controller;

import com.revature.stockinvestmentapp.model.Account;
import com.revature.stockinvestmentapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @GetMapping("/accounts")
//    public List<Account> getAllAccounts() {
//
//        List<Account> accounts = accountService.getAllAccounts();
//
//        return accounts;
//    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable("id") int accountId) {
        Account account = null;
//        if (doesAccountIdExist(accountId)) {
//            account = accountServiceLayer.getAccountByAccountId(accountId);
//        }

        return account;
    }

//    @DeleteMapping("/account/{id}")
//    public BodyBuilder deleteAccountById(@PathVariable("id") int accountId) {
////        if (doesAccountIdExist(accountId)) {
////            return ResponseEntity.ok();
////        }
//
//        return ResponseEntity.badRequest();
//
//    }

    //TODO: update account with money to account by id using POST method
    //TODO: create account using post method
//    private boolean doesAccountIdExist(int accountId) {
//        if (accountServiceLayer.getAccountByAccountId(accountId) != null) {
//            return true;
//        }
//
//        return false;
//    }
}
