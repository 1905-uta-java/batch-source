package com.revature.dao;

import com.revature.model.AccountInfo;

public interface AccountInfoDAO {

	
	public AccountInfo pullUpAccount(int id);
	public int currentBalance(int id);
	public int deposit(int money, int id);
	public int withdraw(int money, int id);
	public boolean newAddress(String street, String city, String state, String country, int zipCode, int id);
}
