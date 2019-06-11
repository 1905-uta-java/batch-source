package com.bankname.dao;

import java.util.List;

import com.bankname.model.Account;

public interface AccountDao {
	
	public List<Account> getAccounts();
	public Account getAccountByAcctNumber(int acctNumber);
	public List<Account> getAccountsByUserID(int userID);
	public int createAccount(Account a);
	public int updateAccount(Account a);
	public int deleteAccount(int acctNumber);
	public int getNextAccountNumber();
}
