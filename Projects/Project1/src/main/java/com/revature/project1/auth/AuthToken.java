package com.revature.project1.auth;

public class AuthToken {
	
	private int userId;
	private boolean isManager;
	
	public AuthToken(int userId, boolean isManager) {
		super();
		this.userId = userId;
		this.isManager = isManager;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public boolean isManager() {
		return isManager;
	}
	
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
}
