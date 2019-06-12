package com.revature.project0.Data;

public class UserAccess {
	
	private BankUser user;
	private BankAccount account;
	
	public UserAccess() {
		super();
	}
	
	public UserAccess(BankUser user, BankAccount account) {
		super();
		this.user = user;
		this.account = account;
	}
	
	public BankUser getUser() {
		return user;
	}
	
	public void setUser(BankUser user) {
		this.user = user;
	}
	
	public BankAccount getAccount() {
		return account;
	}
	
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserAccess other = (UserAccess) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
