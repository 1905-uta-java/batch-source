package com.revature.BankingApp.doa;

import java.util.List;

import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;


public interface AccountDoa {
	public List<Account> getAccount();
	public Account getAccountById(int d);
	public void createAccount(Customer c, double balance, String accType);
	public int updateAccount(Account d);
	public int deleteAccount(Account d);
}
