package com.revature.pZero.model;

public class SavingsAccount extends BankAccount {
	private double interestRate;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(int id, int userId, double amount, double interestRate) {
		super(id, userId, amount);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(interestRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavingsAccount other = (SavingsAccount) obj;
		if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SavingsAccount [Account ID= " + getId() + ", User ID= " + getUserId() + ", Balance= " + getAmount()
		+ ", Interest Rate= " + getInterestRate() +"]";
	}

	public String getStatement() {
		return "Savings Account - "
				+ "\n" + super.getStatement()
				+ "\nInterest rate: " + getInterestRate();
	}

	

}
