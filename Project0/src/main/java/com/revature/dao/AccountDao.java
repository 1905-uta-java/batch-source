package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDao {
	
	public List<Account> getAccounts();
	public int insertAccount(Account a);
	public Account getAccountByNum(int accountNum);
	public double getBalance(int accountNum);
	public int deposit (double amount, int accountNum);
	public int deposit2 (Account a, double amount);
	public int withdraw (Account a, double amount);

}
