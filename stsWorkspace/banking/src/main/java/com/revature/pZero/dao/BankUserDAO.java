package com.revature.pZero.dao;

import com.revature.pZero.model.BankUser;

public interface BankUserDAO {
	public BankUser login(String username, String password);
	public int createBankUser(BankUser b);
	public int updateBankUser(BankUser b);
	public int deleteBankUser(BankUser b);
	public int getNextUserId();
}
