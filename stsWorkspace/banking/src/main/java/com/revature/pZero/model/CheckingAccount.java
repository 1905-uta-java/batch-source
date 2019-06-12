package com.revature.pZero.model;

public class CheckingAccount extends BankAccount {
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(int id, int userId, double amount) {
		super(id, userId, amount);
	}

	@Override
	public String toString() {
		return "CheckingAccount [Account ID= " + getId() + ", User ID= " + getUserId() + ", Balance= " + getAmount()
				+ "]";
	}

	public String getStatement() {
		return "Checking Account - "
				+ "\n" + super.getStatement();
	}
	
	
	

}
