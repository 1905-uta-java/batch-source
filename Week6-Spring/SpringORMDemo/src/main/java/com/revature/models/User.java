package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="USERS")
public class User {
	
	@Id
	private int id;
	
	private String username;
	
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="USER_ACCOUNT",
			joinColumns= {@JoinColumn(name="USER_ID")},
			inverseJoinColumns = {@JoinColumn(name="ACCOUNT_ID")})
	private List<Account> accounts = new ArrayList<>();

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password, Account ...ats ) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		for(Account a : ats) {
			accounts.add(a);
		}
	}
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", accounts=" + accounts + "]";
	}


	
	

}
