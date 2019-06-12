package com.revature.project0.data;

public class BankAccount {
	
	private int accountID;
	private double currentBalance;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(int accountID, double currentBalance) {
		super();
		this.accountID = accountID;
		this.currentBalance = currentBalance;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
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
		BankAccount other = (BankAccount) obj;
		if (accountID != other.accountID)
			return false;
		return true;
	}
}
