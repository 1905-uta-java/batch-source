package com.revature.pZero.model;

public class BankAccount {
	private int id, userId;
	private double amount;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(int id, int userId, double amount) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + userId;
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [Account ID=" + id + ", User ID=" + userId + ", Balance=" + amount + "]";
	}
	
	public boolean deposit(double deposit) {
		if(deposit < 0.0)
			return false;
		this.amount += deposit;
		return true;
	}
	
	public boolean withdraw(double withdraw) {
		if(withdraw > this.amount || withdraw < 0)
			return false;
		this.amount -= withdraw;
		return true;
	}
	
	public String getStatement() {
		String statement = "Account_ID: " + getId()
				+ "\nUser_ID: " + getUserId()
				+ "\nBalance: " + getAmount();
		return statement;
	}
	
	
}
