package com.revature.model;

import java.io.Serializable;

public class AccountInfo implements Serializable{


	private static final long serialVersionUID = -7493583351683645148L;
	
	private int aId;
	private int accountBalance;
	private String billingAddress;
	private String billingCity;
	private String billingState;
	private String billingCountry;
	private int billingZipCode;
	
	
	public AccountInfo() {
		super();
	}
	
	public AccountInfo(int aId, int accountBalance, String billingAddress, String billingCity, String billingState,
			String billingCountry, int billingZipCode) {
		super();
		this.aId = aId;
		this.accountBalance = accountBalance;
		this.billingAddress = billingAddress;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingCountry = billingCountry;
		this.billingZipCode = billingZipCode;
	}

	@Override
	public String toString() {
		return "AccountInfo [aId=" + aId + ", accountBalance=" + accountBalance + ", billingAddress=" + billingAddress
				+ ", billingCity=" + billingCity + ", billingState=" + billingState + ", billingCountry="
				+ billingCountry + ", billingZipCode=" + billingZipCode + "]";
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public int getBillingZipCode() {
		return billingZipCode;
	}
	public void setBillingZipCode(int billingZipCode) {
		this.billingZipCode = billingZipCode;
	}
	
	

}
