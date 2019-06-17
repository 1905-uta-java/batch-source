package com.revature.project0.data;

import com.revature.project0.exceptions.InvalidBankTransactionException;

public class Transaction {
	
	private int transactionID;
	private String transactionType;
	private double amount;
	private int fromAccountID;
	private int toAccountID;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int transactionID, String transactionType, double amount, int fromAccountID, int toAccountID) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.amount = amount;
		this.fromAccountID = fromAccountID;
		this.toAccountID = toAccountID;
	}
	
	public int getTransactionID() {
		return transactionID;
	}
	
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getFromAccountID() {
		return fromAccountID;
	}
	
	public void setFromAccountID(int fromAccountID) {
		this.fromAccountID = fromAccountID;
	}
	
	public int getToAccountID() {
		return toAccountID;
	}
	
	public void setToAccountID(int toAccountID) {
		this.toAccountID = toAccountID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionID;
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
		Transaction other = (Transaction) obj;
		if (transactionID != other.transactionID)
			return false;
		return true;
	}

	public String getStringRep(int accountID) {
		
		if("WITHDRAWAL".equals(transactionType)) {
			
			return "Transaction #" + transactionID + " Withdrawal: ($" + amount + ")";
			
		} else if("DEPOSIT".equals(transactionType)) {
			
			return "Transaction #" + transactionID + " Deposit: $" + amount;
			
		} else if("TRANSFER".equals(transactionType)) {
			
			if(accountID == fromAccountID)
				return "Transaction #" + transactionID + " Transfer: ($" + amount + ") to account #" + toAccountID;
			else
				return "Transaction #" + transactionID + " Transfer: $" + amount + " from account #" + fromAccountID;
		} else {
			
			throw new InvalidBankTransactionException();
		}
	}
}
