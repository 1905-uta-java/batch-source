package com.reimbursement.dao;
import java.util.List;

import com.reimbursement.model.Reimbursement;

public interface ReimbursementDao {
	
	// return the ID of the new request
	public int makeRequest(Reimbursement r);
	// return a list of all requests
	public List<Reimbursement> getReimbursements();
	// get a specific request by its ID
	public Reimbursement getReimbursementById(int id);
	// get all the unsolved requests
	public List<Reimbursement> getUnsolvedReimbursements();
	// get all unsolved requests by an employee
	public List<Reimbursement> getUnsolvedReimbursementsByEmployeeId(int id);
	// get all the solved requests
	public List<Reimbursement> getSolvedReimbursements();
	// get all solved requests by an employee
	public List<Reimbursement> getSolvedReimbursementsByEmployeeId(int id);	
	// get all requests by an employee
	public List<Reimbursement> getReimbursementsByEmployeeId(int id);
	// approve a request
	public int approveRequest(int id);
	// reject a request
	public int rejectRequest(int id);

}
