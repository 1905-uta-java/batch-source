package com.revature.accountdao;

import java.util.List;

import com.revature.accountmodel.Account;

// Interface to handle DAO of the Account table communication
public interface AccountDao {
	// Interface Methods
	public List<Account> getAccounts();
	public Account getAccountById(int id);
	public Account getAccountByUId(int usId);
	public int createAccount(Account a);
	public int deleteAccount(int id);
	public int changePin(Account a, int pin);
	public double checkBalance(Account a);
	public int depositFunds(Account a, double funds);
	public int withdrawFunds(Account a, double funds);
}
