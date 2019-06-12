package com.revature.models;

import java.io.Serializable;

public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8154117081788566281L;
	
	private int id;
	private String type;
	private String username;
	private double currBalance;
	private int usrAccId;
	private User userAccount = new User();
	
	
	public BankAccount() {
		super();
	}


	/**
	 * @param id
	 * @param type
	 * @param username
	 * @param currBalance
	 * @param usrAccId
	 * @param userAccount
	 */
	public BankAccount(int id, String type, String username, double currBalance, int usrAccId, User userAccount) {
		super();
		this.id = id;
		this.type = type;
		this.username = username;
		this.currBalance = currBalance;
		this.usrAccId = usrAccId;
		this.userAccount = userAccount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public double getCurrBalance() {
		return currBalance;
	}


	public void setCurrBalance(double currBalance) {
		this.currBalance = currBalance;
	}


	public int getUsrAccId() {
		return usrAccId;
	}


	public void setUsrAccId(int userAccId) {
		this.usrAccId = userAccId;
	}


	public User getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", type=" + type + ", username=" + username + ", currBalance=" + currBalance
				+ ", usrAccId=" + usrAccId + "]\n";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(currBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + usrAccId;
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
		if (Double.doubleToLongBits(currBalance) != Double.doubleToLongBits(other.currBalance))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userAccount == null) {
			if (other.userAccount != null)
				return false;
		} else if (!userAccount.equals(other.userAccount))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usrAccId != other.usrAccId)
			return false;
		return true;
	}
	
}
