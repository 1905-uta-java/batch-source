package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private Logger log = Logger.getLogger(AccountController.class);
	
	private List<Account> accounts = new ArrayList<>();
	
	public AccountController() {
		accounts.add(new Account(1,1,345.00));
		accounts.add(new Account(2,2,653.00));
		accounts.add(new Account(3,1,146.00));
		accounts.add(new Account(4,3,862.00));
		accounts.add(new Account(5,4,1200.00));
		accounts.add(new Account(6,3,281.00));
		accounts.add(new Account(7,1,366.00));
	}
	
	@GetMapping
	public List<Account> getAllAccounts(){
		log.info("GET /accounts  -  getting all accounts");
		return accounts;
	}
	
	@GetMapping("{accountId}")
	public Account getAccountById(@PathVariable("accountId") Integer accountId) {
		if(accountId == null) {
			return null;
		}
		for(Account a: accounts) {
			if(accountId == a.getAccountId()) {
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable("customerId") Integer customerId){
		return accounts.stream().filter(acct -> acct.getCustomerId() == customerId)
				.collect(Collectors.toList());
	}

}
