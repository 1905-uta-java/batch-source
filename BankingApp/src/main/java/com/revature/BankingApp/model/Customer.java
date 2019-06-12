package com.revature.BankingApp.model;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String SSN;
	private String email;
	private String username;
	private String password;
	private String phone;
	private String address;
	private String city;
	private String country;
	private String dateAdded;
	private String releaseDate;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String firstName, String lastName, String sSN, String email, String username,
			String password, String phone, String address, String city, String country, String dateAdded,
			String releaseDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		SSN = sSN;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.dateAdded = dateAdded;
		this.releaseDate = releaseDate;
	}
	public int getCustomerId() {	return customerId;	}
	public String getFirstName() {	return firstName;	}
	public String getLastName() {	return lastName;	}
	public String getSSN() {	return SSN;	}
	public String getEmail() {	return email;	}
	public String getUsername() {	return username;	}
	public String getPassword() {	return password;	}
	public String getPhone() {	return phone;	}
	public String getAddress() {	return address;	}
	public String getCity() {	return city;	}
	public String getCountry() {	return country;	}
	public String getDateAdded() {	return dateAdded;	}
	public String getReleaseDate() {	return releaseDate;	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", SSN="
				+ SSN + ", email=" + email + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + ", city=" + city + ", country=" + country + ", dateAdded=" + dateAdded
				+ ", releaseDate=" + releaseDate + "]";
	}
	
	
	
	
}
