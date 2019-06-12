package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = -3382496897527519471L;
	
	private int id, accountNum;
	private double accountBalance;
	private String accountType;
	
	public Account() {
		super();
	}

	public Account(int id, int accountNum, String accountType, double d) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.accountBalance = d;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountNum;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + id;
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
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountNum != other.accountNum)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNum=" + accountNum + ", accountBalance=" + accountBalance
				+ ", accountType=" + accountType + "]";
	}
	
	
}
