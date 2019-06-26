package com.revature.model;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4469579435408922126L;
	
	private int empNum;
	private String fullnamme;
	private String email;
	private int managerId;
	private int isManager;
	
	public Employee() {
		super();
	}

	public Employee(int empNum, String fullnamme, String email, int managerId, int isManager) {
		super();
		this.empNum = empNum;
		this.fullnamme = fullnamme;
		this.email = email;
		this.managerId = managerId;
		this.isManager = isManager;
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public String getFullnamme() {
		return fullnamme;
	}

	public void setFullnamme(String fullnamme) {
		this.fullnamme = fullnamme;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "Employee [empNum=" + empNum + ", fullnamme=" + fullnamme + ", email=" + email + ", managerId="
				+ managerId + ", isManager=" + isManager + "]";
	}
	
	
}
