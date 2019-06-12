package com.revature.model;

import java.io.Serializable;

public class ProfileAcc implements Serializable{

	private static final long serialVersionUID = -7494942565945017175L;
	
	private int pId;
	private String fullname;
	private String email;
	private String address;
	private AccountInfo aId = new AccountInfo();
	private String city;
	private String state;
	private String country;
	private int zipCode;
	
	
	public ProfileAcc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfileAcc(int pId, String fullname, String email, String address, AccountInfo aId, String city,
			String state, String country, int zipCode) {
		super();
		this.pId = pId;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.aId = aId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "ProfileAcc [pId=" + pId + ", fullname=" + fullname + ", email=" + email + ", address=" + address
				+ ", aId=" + aId.getaId() + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + "]";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AccountInfo getaId() {
		return aId;
	}

	public void setaId(AccountInfo aId) {
		this.aId = aId;
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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	
}
