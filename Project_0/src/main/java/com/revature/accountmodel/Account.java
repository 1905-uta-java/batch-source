package com.revature.accountmodel;

import java.io.Serializable;

// A class representing a bank account
public class Account implements Serializable {
	// Serial ID
	private static final long serialVersionUID = 1L;
	
	// Class attributes
	private int id;
	private int uId;
	private int pin;
	private double balance;
	
	// Default Constructor, we shouldn't need to use this
	public Account() {
		super();
	}
	// Parameterized constructor
	public Account(int id, int uId, int pin, double balance) {
		super();
		this.id = id;
		this.uId = uId;
		this.pin = pin;
		this.balance = balance;
	}
	// Getters and Setters for class attributes
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// Hash Code and Equals methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + pin;
		result = prime * result + uId;
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (pin != other.pin)
			return false;
		if (uId != other.uId)
			return false;
		return true;
	}
	
	// ToString method
	@Override
	public String toString() {
		return "Account [id=" + id + ", uId=" + uId + ", pin=" + pin + ", balance=" + balance + "]";
	}
}
