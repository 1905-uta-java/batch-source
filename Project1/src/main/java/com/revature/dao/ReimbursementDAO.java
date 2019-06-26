package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDAO {
	
	public int getAmount(int reqId);
	public Reimbursement getReReq(int rereqId);
	public List<Reimbursement> getAllReimbursements(int empId);
	public int setStatus(int status, int reqId);
	public int createReimbursement(int reqId, int empId, int amount, String comments);
	public int setResolvedBy(int managerId, int reqId);
	public List<Reimbursement> getAll();

}
