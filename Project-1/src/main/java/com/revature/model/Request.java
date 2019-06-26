package com.revature.model;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = -351965254179074518L;

	private int id;
	private int empId;
	private double amount;
	private String reason;
	private int approvedBy;
	private int deniedBy;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Request(int id, int empId, double amount, String reason, int approvedBy, int deniedBy) {
		super();
		this.id = id;
		this.empId = empId;
		this.amount = amount;
		this.reason = reason;
		this.approvedBy = approvedBy;
		this.deniedBy = deniedBy;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	public int getDeniedBy() {
		return deniedBy;
	}
	public void setDeniedBy(int deniedBy) {
		this.deniedBy = deniedBy;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + approvedBy;
		result = prime * result + deniedBy;
		result = prime * result + empId;
		result = prime * result + id;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
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
		Request other = (Request) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approvedBy != other.approvedBy)
			return false;
		if (deniedBy != other.deniedBy)
			return false;
		if (empId != other.empId)
			return false;
		if (id != other.id)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Request [id=" + id + ", empId=" + empId + ", amount=" + amount + ", reason=" + reason + ", approvedBy="
				+ approvedBy + ", deniedBy=" + deniedBy + "]";
	}
	
	
}
