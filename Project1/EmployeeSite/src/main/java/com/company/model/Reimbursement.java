package com.company.model;

import java.sql.Date;

public class Reimbursement {
	
	private int reqId;
	private int empId;
	private String status;
	private double amount;
	private String reason;
	//Variable for image
	private int managerId;
	private String empNotes;
	private String managerNotes;
	private Date date;
	
	//Default Constructor
	public Reimbursement() {
		super();
	}
	
	//Constructor with all fields
	public Reimbursement(int reqId, int empId, String status, double amount, String reason, int managerId,String empNotes, String managerNotes, Date date){	
		super();
		
		this.reqId = reqId;
		this.empId = empId;
		this.status = status;
		this.amount = amount;
		this.reason = reason;
		this.managerId = managerId;
		this.empNotes = empNotes;
		this.managerNotes = managerNotes;
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empNotes == null) ? 0 : empNotes.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((managerNotes == null) ? 0 : managerNotes.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reqId;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (empId != other.empId)
			return false;
		if (empNotes == null) {
			if (other.empNotes != null)
				return false;
		} else if (!empNotes.equals(other.empNotes))
			return false;
		if (managerId != other.managerId)
			return false;
		if (managerNotes == null) {
			if (other.managerNotes != null)
				return false;
		} else if (!managerNotes.equals(other.managerNotes))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reqId != other.reqId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reimbursement [reqId=" + reqId + ", empId=" + empId + ", status=" + status + ", amount=" + amount
				+ ", reason=" + reason + ", managerId=" + managerId + ", empNotes=" + empNotes + ", managerNotes="
				+ managerNotes + ", date=" + date + "]";
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getEmpNotes() {
		return empNotes;
	}

	public void setEmpNotes(String empNotes) {
		this.empNotes = empNotes;
	}

	public String getManagerNotes() {
		return managerNotes;
	}

	public void setManagerNotes(String managerNotes) {
		this.managerNotes = managerNotes;
	}
	
	
}
