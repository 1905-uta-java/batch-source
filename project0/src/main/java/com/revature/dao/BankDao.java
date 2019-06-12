package com.revature.dao;

import java.util.List;

import com.revature.models.User;
import com.revature.models.BankAccount;

public interface BankDao {
	public List<BankAccount> getBankAccounts();
	public int createBankAccount(BankAccount d);
	public void updateBankAccount(BankAccount d);
	public void deleteBankAccount(int bankId, User a);
	public int getNewAccNum();
	public List<BankAccount> getAllBankAccounts(User a);
}
