package com.revature.project1.models;

import java.util.Arrays;
import java.util.Date;

/*
 * A class representing employee records
 */
public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private String title;
	private int managerID;
	private String email;
	private String phone;
	private byte[] passwordHash;
	private byte[] passwordSalt;
	private Date hireDate;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	
	public Employee(int employeeID, String firstName, String lastName, String title, int managerID, String email, String phone, byte[] passwordHash,
			byte[] passwordSalt, Date hireDate, String address, String city, String state, String country, String postalCode) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.managerID = managerID;
		this.email = email;
		this.phone = phone;
		this.passwordHash = passwordHash;
		this.passwordSalt = passwordSalt;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}
	
	public Employee() {
		this(0, "", "", "", 0, "", "", new byte[0], new byte[0], new Date(), "", "", "", "", "");
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getManagerID() {
		return managerID;
	}
	
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public byte[] getPasswordHash() {
		return passwordHash;
	}
	
	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public byte[] getPasswordSalt() {
		return passwordSalt;
	}
	
	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
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
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", title="
				+ title + ", managerID=" + managerID + ", email=" + email + ", phone=" + phone + ", passwordHash="
				+ Arrays.toString(passwordHash) + ", passwordSalt=" + Arrays.toString(passwordSalt) + ", hireDate="
				+ hireDate + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + "]";
	}
}
