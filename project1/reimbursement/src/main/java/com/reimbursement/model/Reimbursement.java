package com.reimbursement.model;

import java.util.Date;

public class Reimbursement {

	private int id;
	private int employeeId;
	private int supervisorId;

	private String title;
	private Date submissionDate;
	private Double amount;
	private String status = "P";

	public Reimbursement() {
	}

	public Reimbursement(int id, int employeeId, int supervisorId, String title, Date submissionDate, Double amount, String status) {
		this.id = id;
		this.employeeId = employeeId;
		this.supervisorId = supervisorId;
		this.title = title;
		this.submissionDate = submissionDate;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSupervisorId() {
		return this.supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getSubmissionDate() {
		return this.submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + id;
		result = prime * result + employeeId;
		result = prime * result + supervisorId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
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
		if (id != other.id)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (supervisorId != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		if (amount.compareTo(other.amount) != 0)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeId=" + employeeId + ", supervisorId=" + supervisorId + ", title="
				+ title + ", submissionDate=" + submissionDate + ", amount=" + amount + "]";
	}
}
