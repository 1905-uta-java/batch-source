package com.revature.model;

import java.io.Serializable;

public class Reimbursement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -374604956999684104L;
	
	private int reqId;
	private int empId;
	private int amount;
	private int status;
	private int resolvedby;
	private String comments;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reqId, int empId, int amount, int status, int resolvedby, String comments) {
		super();
		this.reqId = reqId;
		this.empId = empId;
		this.amount = amount;
		this.status = status;
		this.resolvedby = resolvedby;
		this.comments = comments;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getResolvedby() {
		return resolvedby;
	}

	public void setResolvedby(int resolvedby) {
		this.resolvedby = resolvedby;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Reimbursement [reqId=" + reqId + ", empId=" + empId + ", amount=" + amount + ", status=" + status
				+ ", resolvedby=" + resolvedby + ", comments=" + comments + "]";
	}

	
	
}
