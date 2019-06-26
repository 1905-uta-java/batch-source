package com.revature.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//this annotation is for the Jackson Databind object mapper to ignore the password field so we don't pass passwords to the client.
@JsonIgnoreProperties(value = { "password" })
public class Profile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7308046490107929248L;
	
	private String username;
	private String password;
	private Employee empId = new Employee();
	
	public Profile() {
		super();
	}

	public Profile(String username, String password, int empId) {
		super();
		this.username = username;
		this.password = password;
		this.empId.setEmpNum(empId);
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

	public int getEmpId() {
		return empId.getEmpNum();
	}

	public void setEmpId(int empId) {
		this.empId.setEmpNum(empId);
	}
	
	public Employee getEmp() {
		return this.empId;
	}
	
	public void setEmp(Employee emp) {
		this.empId = emp;
	}

	@Override
	public String toString() {
		return "Profile [username=" + username + ", password=" + password + ", empId=" + empId + "]";
	}
	
	
	

}
