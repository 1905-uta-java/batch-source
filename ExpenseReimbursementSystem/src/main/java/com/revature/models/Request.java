package com.revature.models;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = 4993335180496553604L;
	private int reqID;
	private int empId;
	private double amount;
	private String description;
	private String status;
	private String resolvedBy;
	
	public Request() {
		super();
	}

	
	
	public Request(int reqID, int empId, double amount, String description, String status, String resolvedBy) {
		super();
		this.reqID = reqID;
		this.empId = empId;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.resolvedBy = resolvedBy;
	}
	
	public Request(int empId, double amount, String description, String status, String resolvedBy) {
		super();
		this.empId = empId;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.resolvedBy = resolvedBy;
	}

	public Request(int empId, String status, String resolvedBy) {
		
		this.empId = empId;
		this.status = status;
		this.resolvedBy = resolvedBy;
	}



	public int getReqID() {
		return reqID;
	}



	public void setReqID(int reqID) {
		this.reqID = reqID;
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getResolvedBy() {
		return resolvedBy;
	}



	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + empId;
		result = prime * result + reqID;
		result = prime * result + ((resolvedBy == null) ? 0 : resolvedBy.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (empId != other.empId)
			return false;
		if (reqID != other.reqID)
			return false;
		if (resolvedBy == null) {
			if (other.resolvedBy != null)
				return false;
		} else if (!resolvedBy.equals(other.resolvedBy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [reqID=" + reqID + ", empId=" + empId + ", amount=" + amount + ", description=" + description
				+ ", status=" + status + ", resolvedBy=" + resolvedBy + "]";
	}

	

}
