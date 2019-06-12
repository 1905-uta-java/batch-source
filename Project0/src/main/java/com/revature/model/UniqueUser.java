package com.revature.model;

import java.io.Serializable;

public class UniqueUser implements Serializable{


	private static final long serialVersionUID = -3808603541175443293L;
	
	private int uId;
	private String username;
	private String password;
	private ProfileAcc pId = new ProfileAcc();
	
	
	public UniqueUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UniqueUser(int uId, String username, String password, ProfileAcc pId) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "UniqueUser [uId=" + uId + ", username=" + username + ", password=" + password + ", pId=" + pId + "]";
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public ProfileAcc getpId() {
		return pId;
	}
	public void setpId(ProfileAcc pId) {
		this.pId = pId;
	}
	
	

}
