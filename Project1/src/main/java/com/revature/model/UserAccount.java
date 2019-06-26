package com.revature.model;

import java.io.Serializable;

public class UserAccount implements Serializable{

	private static final long serialVersionUID = 5184490025241072825L;
	
	private int id, isManager;
	private String username, password;
	
	public UserAccount() {
		super();
	}
	
	public UserAccount(int id, String username, String password, int isManager) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isManager = isManager;
	}

	
	// ToString
	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", isManager=" + isManager + ", username=" + username + ", password="
				+ password + "]";
	}

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
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

	// HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + isManager;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (id != other.id)
			return false;
		if (isManager != other.isManager)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	

}
