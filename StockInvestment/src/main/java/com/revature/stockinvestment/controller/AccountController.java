package com.revature.stockinvestment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.service.AccountServiceLayerImpl;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    private AccountServiceLayerImpl accountServiceLayer;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {

        List<Account> accounts = accountServiceLayer.getAllAccounts();

        return accounts;
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable("id") int accountId) {
        Account account = null;
//        if (doesAccountIdExist(accountId)) {
//            account = accountServiceLayer.getAccountByAccountId(accountId);
//        }

        return account;
    }

    @DeleteMapping("/account/{id}")
    public BodyBuilder deleteAccountById(@PathVariable("id") int accountId) {
//        if (doesAccountIdExist(accountId)) {
//            return ResponseEntity.ok();
//        }

        return ResponseEntity.badRequest();

    }

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
