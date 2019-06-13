package com.revature.dao;

import com.revature.model.Bank;

public interface BankDao {
	
	public void createAccount(Bank b);
	public void accountType(Bank b);
	public double depositMoney(Bank b);
	public double withdrawMoney(Bank b);
	public void logIn(Bank b);
	public void logOut(Bank b);
	public double viewBalance(Bank b);
	
	public void start(Bank b);
	public void mainMenu(Bank b);

}
