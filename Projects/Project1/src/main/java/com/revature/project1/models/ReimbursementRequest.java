package com.revature.project1.models;

import java.util.Date;

/*
 * A class representing the reimbursement requests by employees 
 * to be approved of, or rejected by, their supervisors
 */
public class ReimbursementRequest {
	
	private int requestID;
	private int employeeID;
	private float amount;
	private Date dateRequested;
	private int managerID;
	private boolean wasApproved;
	
	public ReimbursementRequest(int requestID, int employeeID, float amount, Date dateRequested, int managerID, boolean wasApproved) {
		super();
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.amount = amount;
		this.dateRequested = dateRequested;
		this.managerID = managerID;
		this.wasApproved = wasApproved;
	}
	
	public ReimbursementRequest() {
		this(0, 0, 0f, new Date(), 0, false);
	}
	
	public int getRequestID() {
		return requestID;
	}
	
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public Date getDateRequested() {
		return dateRequested;
	}
	
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	
	public int getManagerID() {
		return managerID;
	}
	
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	public boolean isWasApproved() {
		return wasApproved;
	}
	
	public void setWasApproved(boolean wasApproved) {
		this.wasApproved = wasApproved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((dateRequested == null) ? 0 : dateRequested.hashCode());
		result = prime * result + employeeID;
		result = prime * result + managerID;
		result = prime * result + requestID;
		result = prime * result + (wasApproved ? 1231 : 1237);
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
		ReimbursementRequest other = (ReimbursementRequest) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (dateRequested == null) {
			if (other.dateRequested != null)
				return false;
		} else if (!dateRequested.equals(other.dateRequested))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (managerID != other.managerID)
			return false;
		if (requestID != other.requestID)
			return false;
		if (wasApproved != other.wasApproved)
			return false;
		return true;
	}
	
	public boolean hasValidValues() {
		
		if(requestID <= 0)
			return false;
		
		if(employeeID <= 0)
			return false;
					
		if(amount <= 0f)
			return false;
		
		if(dateRequested == null)
			return false;
		
		if(managerID <= 0)
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "ReimbursementRequest [requestID=" + requestID + ", employeeID=" + employeeID + ", amount=" + amount
				+ ", dateRequested=" + dateRequested + ", managerID=" + managerID + ", wasApproved=" + wasApproved
				+ "]";
	}
}
