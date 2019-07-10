package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Account {
	
	@Id
	private int id;
	
	private int balance;
	
	private AccountType type;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Account(int id, int balance, AccountType type, User user) {
//		super();
//		this.id = id;
//		this.balance = balance;
//		this.type = type;
//		this.user = user;
//	}
	
	

	public int getId() {
		return id;
	}



	public Account(int id, int balance, AccountType type) {
	super();
	this.id = id;
	this.balance = balance;
	this.type = type;
}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + "]";
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	
	
}
