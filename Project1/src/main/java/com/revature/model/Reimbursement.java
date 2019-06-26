package com.revature.model;

import java.io.Serializable;

public class Reimbursement implements Serializable{

	private static final long serialVersionUID = 3082336176827941428L;
	
	
	// initialize variables
	private int id, num, amount, completedBy;
	private String reason, status;
	
	// Default no-argument constructor
	public Reimbursement() {
		super();
	}
	
	// Constructor with all arguments
	public Reimbursement(int id, int amount, String reason, String status, int completedBy, int num) {
		this.id = id;
		this.num = num;
		this.amount = amount;
		this.status = status;
		this.reason = reason;
		this.completedBy = completedBy;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", num=" + num + ", amount=" + amount + ", completedBy=" + completedBy
				+ ", reason=" + reason + ", status=" + status + "]";
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(int completedBy) {
		this.completedBy = completedBy;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + completedBy;
		result = prime * result + id;
		result = prime * result + num;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
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
		if (amount != other.amount)
			return false;
		if (completedBy != other.completedBy)
			return false;
		if (id != other.id)
			return false;
		if (num != other.num)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	

}
