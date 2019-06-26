package com.revature.models;

public class Reimburse {
	private int rem_id;
	private String desc;
	private double amount;
	private String issueDate;
	private String fulfillDate;
	private String status;
	private int manId;
	private int empId;
	
	public Reimburse() {
		super();
	}
	
	public Reimburse(int rem_id, String desc, double amount, String issueDate, String fulfillDate, String status,
			int manId, int empId) {
		super();
		this.rem_id = rem_id;
		this.desc = desc;
		this.amount = amount;
		this.issueDate = issueDate;
		this.fulfillDate = fulfillDate;
		this.status = status;
		this.manId = manId;
		this.empId = empId;
	}
	
	public int getRem_id() {
		return rem_id;
	}
	
	public void setRem_id(int rem_id) {
		this.rem_id = rem_id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	
	}
	
	public String getIssueDate() {
		return issueDate;
	}
	
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	public String getFulfillDate() {
		return fulfillDate;
	}
	
	public void setFulfillDate(String fulfillDate) {
		this.fulfillDate = fulfillDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getManId() {
		return manId;
	
	}
	
	public void setManId(int manId) {
		this.manId = manId;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + empId;
		result = prime * result + ((fulfillDate == null) ? 0 : fulfillDate.hashCode());
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result + manId;
		result = prime * result + rem_id;
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
		Reimburse other = (Reimburse) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (empId != other.empId)
			return false;
		if (fulfillDate == null) {
			if (other.fulfillDate != null)
				return false;
		} else if (!fulfillDate.equals(other.fulfillDate))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		if (manId != other.manId)
			return false;
		if (rem_id != other.rem_id)
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
		return "Reimburse [rem_id=" + rem_id + ", desc=" + desc + ", amount=" + amount + ", issueDate=" + issueDate
				+ ", fulfillDate=" + fulfillDate + ", status=" + status + ", manId=" + manId + ", empId=" + empId + "]";
	}
	
	
	
}
