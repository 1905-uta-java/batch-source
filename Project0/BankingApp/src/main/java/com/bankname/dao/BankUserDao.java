package com.bankname.dao;

import java.util.List;

import com.bankname.model.BankUser;

public interface BankUserDao {
	
	public List<BankUser> getBankUsers();
	public BankUser getBankUserById(int userID);
	public BankUser getBankUserByEmail(String email);
	public int createBankUser(BankUser b);
	public int updateBankUser(BankUser b);
	public int deleteBankUser(int userID);
	public int getNextBankUserID();
	

}
