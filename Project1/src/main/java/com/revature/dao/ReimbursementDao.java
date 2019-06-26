package com.revature.dao;

import java.util.List;
import com.revature.model.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getReimbursements();
	public int submitReimbursement(Reimbursement r);
	public List<Reimbursement> getReimbursementById(int empId);
	public List<Reimbursement> getReimbursementByStatus(String status);
	public List<Reimbursement> getReimbursementByIdAndStatus (int empId, String status);
	public void deleteReimbursement(int id);
	public void updateReimbursement(int amount, String status, int num);
}
