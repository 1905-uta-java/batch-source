package com.revature.model;

import java.io.Serializable;

public class Bank implements Serializable{
	
	private static final long serialVersionUID = -4168833361998693594L;
	
	private String username;
	private String password;
	private double checkingBalance;
	private double savingsBalance;
	private String accountType;
	
	public Bank() {
		super();
	}
	
	public Bank(String username,String password,double checkingBalance,double savingsBalance,String accountType) {
		super();
		this.username=username;
		this.password=password;
		this.checkingBalance=checkingBalance;
		this.savingsBalance=savingsBalance;
		this.accountType = accountType;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}


	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	

}
