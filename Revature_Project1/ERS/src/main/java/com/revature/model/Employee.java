package com.revature.model;

import java.io.Serializable;

public class Employee  implements Serializable {

	private static final long serialVersionUID = -195102502914716002L;

	public Employee(){
		super();
	}
	
	private int empId;
	private int reId;
	private String password;
	private String empName;
	private String startDate;
	private double monthSal;
	private double reAmount;
	private boolean isFullTime;
	private boolean isManager;
	private boolean isAproved;
	
	
	public Employee(int empId, String password, String empName, String startDate, double monthSal, boolean isFullTime,
			boolean isManager) {
		super();
		this.empId = empId;
		this.password = password;
		this.empName = empName;
		this.startDate = startDate;
		this.monthSal = monthSal;
		this.isFullTime = isFullTime;
		this.isManager = isManager;
	}
	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public double getMonthSal() {
		return monthSal;
	}
	public void setMonthSal(double monthSal) {
		this.monthSal = monthSal;
	}
	public double getReAmount() {
		return reAmount;
	}
	public void setReAmount(double reAmount) {
		this.reAmount = reAmount;
	}
	public boolean isFullTime() {
		return isFullTime;
	}
	public void setFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	public boolean isAproved() {
		return isAproved;
	}
	public void setAproved(boolean isAproved) {
		this.isAproved = isAproved;
	}
	
	
	
	
	
	

}
