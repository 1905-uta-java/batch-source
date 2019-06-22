package com.revature.model;

public class Transaction {
	int id;
	double amount;
	int employeeId;
	int managerId;
	String log;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int id, double amount, int employeeId, int managerId, String log) {
		super();
		this.id = id;
		this.amount = amount;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.log = log;
	}
	public int getId() {
		return id;
	}
	public double getAmount() {
		return amount;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public int getManagerId() {
		return managerId;
	}
	public String getLog() {
		return log;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + employeeId;
		result = prime * result + id;
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + managerId;
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (id != other.id)
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (managerId != other.managerId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", employeeId=" + employeeId + ", managerId="
				+ managerId + ", log=" + log + "]";
	}
	
	
}
