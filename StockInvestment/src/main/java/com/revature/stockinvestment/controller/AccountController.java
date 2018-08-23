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
import com.revature.stockinvestment.service.AccountServiceLayerImpl;

@RestController
public class AccountController {
	
<<<<<<< HEAD
    @Autowired //TODO: Review Autowiring
=======
	@Autowired //TODO: Review Autowiring
>>>>>>> d1ab951f8bebd4aed32c5509e38bd91f76073197
    private AccountServiceLayerImpl accountServiceLayer;
	
	
	public void setAccountServiceLayer(AccountServiceLayerImpl accountServiceLayer) {
		this.accountServiceLayer = accountServiceLayer;
	}

	@GetMapping("/account")
	public List<Account> getAllAccounts() throws SIPersistenceException {
		
		List<Account> accounts = accountServiceLayer.getAllAccounts();
		
		return accounts;
	}
	
	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable("id") int accountId) throws SIPersistenceException {
		Account account = null;
		if (doesAccountIdExist(accountId)) {
			account = accountServiceLayer.getAccountByAccountId(accountId);
		}
		
		return account;
	}
	
	//TODO: delete account by id using HTTP DELETE method
	@DeleteMapping("/account/{id}")
	public BodyBuilder deleteAccountById(@PathVariable("id") int accountId) throws SIPersistenceException {
		if(doesAccountIdExist(accountId)) {
			return ResponseEntity.ok();
		}
		
		return ResponseEntity.badRequest();
		
	}
	
	//TODO: update account with money to account by id using POST method
	//TODO: create account using post method
	
	private boolean doesAccountIdExist(int accountId) throws SIPersistenceException {
		if(accountServiceLayer.getAccountByAccountId(accountId) != null) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
    
//    @Inject
//    public AccountController(AccountServiceLayer accountServiceLayer) {
//        this.accountServiceLayer = accountServiceLayer;
//    }
    
    
    
}
