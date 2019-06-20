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
			byte[] passwordSalt, Date hireDate, String address, String city, String state, String country,
			String postalCode) {
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeID;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + managerID;
		result = prime * result + Arrays.hashCode(passwordHash);
		result = prime * result + Arrays.hashCode(passwordSalt);
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (managerID != other.managerID)
			return false;
		if (!Arrays.equals(passwordHash, other.passwordHash))
			return false;
		if (!Arrays.equals(passwordSalt, other.passwordSalt))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public boolean hasValidValues() {
		
		if(firstName == null || firstName.isEmpty())
			return false;
		
		if(lastName == null || lastName.isEmpty())
			return false;
		
		if(title == null || title.isEmpty())
			return false;
		
		if(email == null || email.isEmpty())
			return false;
		
		if(phone == null || phone.isEmpty())
			return false;
		
		if(passwordHash == null || passwordHash.length == 0)
			return false;
		
		if(passwordSalt == null || passwordSalt.length == 0)
			return false;
		
		if(hireDate == null)
			return false;
		
		if(address == null || address.isEmpty())
			return false;
		
		if(city == null || city.isEmpty())
			return false;
		
		if(country == null || country.isEmpty())
			return false;
		
		if(postalCode == null || postalCode.isEmpty())
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
