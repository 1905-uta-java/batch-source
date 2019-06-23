package com.revature.project1.auth;

import java.sql.Timestamp;

public class AuthToken {
	
	private int userId;
	private boolean isManager;
	private Timestamp timestamp;
	
	public AuthToken() {
		super();
	}
	
	public AuthToken(int userId, boolean isManager) {
		super();
		this.userId = userId;
		this.isManager = isManager;
		timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public boolean getIsManager() {
		return isManager;
	}
	
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
