package com.bankname.model;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = 1312253581854160819L;
	
	private int acctNumber;
	private String acctType;
	private double balance;
	private int userID;
	
	public Account() {
		super();
	}
	
	public Account(int acctNumber, String acctType, double balance, int userID) {
		super();
		this.acctNumber = acctNumber;
		this.acctType = acctType;
		this.balance = balance;
		this.userID = userID;
	}

	public void withdraw(double amount) {
		//Make sure the amount is two decimal points
		double amt = (double) Math.round(amount * 100)/100;
		
		//Take money out of the balance
		this.balance = (double) Math.round((this.balance-amt) * 100)/100;
	}
	
	public void deposit(double amount) {
		//Make sure amount is two decimal points
		double amt = (double) Math.round(amount * 100)/100;
		
		//Do the computation and keep at 2 decimal points
		this.balance = (double) Math.round((this.balance+amt)* 100)/100;
	}
	
	@Override
	public String toString() {
		return "Account [acctNumber=" + acctNumber + ", acctType=" + acctType + ", balance=" + balance + ", userID="
				+ userID + "]";
	}

	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acctNumber;
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (acctNumber != other.acctNumber)
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
}
