package com.revature.BankingApp.model;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = -9151833555491066043L;
	private int accountNumber;
	private int customerId;
	private int employeeId;
	private String type;
	private double balance;
	private double interestRate;
	private String dateOpen;
	private String dateClose;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountNumber, int customerId, int employeeId, String type, 
			double balance, double interestRate,
			String dateOpen, String dateClose) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.type = type;
		this.balance = balance;
		this.interestRate = interestRate;
		this.dateOpen = dateOpen;
		this.dateClose = dateClose;
	}

	public int getAccountNumber() {	return accountNumber;	}
	public int getCustomerId() {	return customerId;	}
	public int getEmployeeId() {	return employeeId;	}
	public String getType() {	return type;	}
	public double getBalance() {	return balance;	}
	public double getInterestRate() {	return interestRate;	}
	public String getDateOpen() {	return dateOpen;	}
	public String getDateClose() {	return dateClose; }

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", employeeId=" + employeeId
				+ ", type=" + type + ", balance=" + balance + ", interestRate=" + interestRate + ", dateOpen="
				+ dateOpen + ", dateClose=" + dateClose + "]";
	}
	
	
	
	
	
	
	
	
	
}
