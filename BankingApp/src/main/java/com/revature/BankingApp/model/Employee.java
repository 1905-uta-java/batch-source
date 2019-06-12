package com.revature.BankingApp.model;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String phone;
	private String address;
	private String city;
	private String country;
	private int supervisor;
	private String dept;
	private String dateAdded;
	private String dateRemoved;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String firstName, String lastName, String username,
			String password, String phone, String address, String city, String country,
			int supervisor, String dept, String dateAdded,
			String dateRemoved) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.supervisor = supervisor;
		this.dept = dept;
		this.dateAdded = dateAdded;
		this.dateRemoved = dateRemoved;
	}
	
	public int getEmployeeId() {	return employeeId;	}
	public String getFirstName() {	return firstName;	}
	public String getLastName() {	return lastName;	}
	public String getUsername() {	return username;	}
	public String getPassword() {	return password;	}
	public String getPhone() {	return phone;	}
	public String getAddress() {	return address;	}
	public String getCity() {	return city;	}
	public String getCountry() {	return country;	}
	public String getDateAdded() {	return dateAdded;	}
	public String getReleaseDate() {	return dateRemoved;	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", phone=" + phone + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", supervisor=" + supervisor + ", dept=" + dept
				+ ", dateAdded=" + dateAdded + ", dateRemoved=" + dateRemoved + "]";
	}
	
	
}
