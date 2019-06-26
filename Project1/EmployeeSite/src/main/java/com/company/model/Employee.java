package com.company.model;

public class Employee {
	
	private String email;
	private String password;
	private int empId;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private int managerId;
	
	//Default Constructor
	public Employee() {
		super();
	}
	
	//Constructor with all data
	public Employee(String email, String password, int empId, String firstName, String lastName, long phoneNumber, int managerId) {
		super();
		
		this.email = email;
		this.password = password;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.managerId = managerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", password=" + password + ", empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", managerId=" + managerId + "]";
	}
	
	
	
	
	

}
