package com.revature.models;

public class Reimbursement {

	private int id;
	private String category;
	private String status;
	private double amount;
	private String dateSubmitted;
	private int approvingManagerId;
	private String dateApproved;
	private int employeeId;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(int id, String category, String status, double amount, String dateSubmitted,
			int approvingManagerId, String dateApproved, int employeeId) {
		super();
		this.id = id;
		this.category = category;
		this.status = status;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.approvingManagerId = approvingManagerId;
		this.dateApproved = dateApproved;
		this.employeeId = employeeId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
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
	
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	public int getApprovingManagerId() {
		return approvingManagerId;
	}
	
	public void setApprovingManagerId(int approvingManagerId) {
		this.approvingManagerId = approvingManagerId;
	}
	
	public String getDateApproved() {
		return dateApproved;
	}
	
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + approvingManagerId;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateApproved == null) ? 0 : dateApproved.hashCode());
		result = prime * result + ((dateSubmitted == null) ? 0 : dateSubmitted.hashCode());
		result = prime * result + employeeId;
		result = prime * result + id;
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
		if (approvingManagerId != other.approvingManagerId)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateApproved == null) {
			if (other.dateApproved != null)
				return false;
		} else if (!dateApproved.equals(other.dateApproved))
			return false;
		if (dateSubmitted == null) {
			if (other.dateSubmitted != null)
				return false;
		} else if (!dateSubmitted.equals(other.dateSubmitted))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (id != other.id)
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
		return "Reimbursement [id=" + id + ", category=" + category + ", status=" + status + ", amount=" + amount
				+ ", dateSubmitted=" + dateSubmitted + ", approvingManagerId=" + approvingManagerId + ", dateApproved="
				+ dateApproved + ", employeeId=" + employeeId + "]";
	}
	
}
