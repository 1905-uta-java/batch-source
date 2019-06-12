package com.banking.dao;

public interface UserDao {

	public boolean isAvailable(String name);

	public boolean createUser(String name, String password);

	public int deposit(String name, double amount);

	public int withdraw(String name, double amount);
	
	public int transfer(String name, double amount);

	public double checkBalance(String name);

	public double checkBalance_forDeposit(String name);

	public double checkBalance_forWithdraw(String name);

}
