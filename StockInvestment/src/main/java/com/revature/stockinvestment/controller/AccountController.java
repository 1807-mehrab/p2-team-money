package com.revature.stockinvestment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Account;
import com.revature.stockinvestment.model.Member;
import com.revature.stockinvestment.service.AccountServiceLayerImpl;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class AccountController {

    @Autowired
    private AccountServiceLayerImpl accountServiceLayer;

    public AccountController(AccountServiceLayerImpl accountServiceLayer) {
        this.accountServiceLayer = accountServiceLayer;
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@Valid @RequestBody Account account) throws SIPersistenceException {
        accountServiceLayer.addAccount(account);
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable("id") int id) throws SIPersistenceException {
        accountServiceLayer.deleteAccount(id);
    }

    @PutMapping("/account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable("id") int id, @Valid @RequestBody Account account) throws SIPersistenceException {
        accountServiceLayer.updateAccount(account);
    }

    @GetMapping("/account/{id}")
    public Account getAccountByAccountId(@PathVariable("id") int id) throws SIPersistenceException {
        return accountServiceLayer.getAccountByAccountId(id);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() throws SIPersistenceException {
        return accountServiceLayer.getAllAccounts();
    }

    //TODO: update account with money to account by id using POST method
    //TODO: create account using post method
    private boolean doesAccountIdExist(int accountId) throws SIPersistenceException {
        if (accountServiceLayer.getAccountByAccountId(accountId) != null) {
            return true;
        }
        return false;
    }

}
