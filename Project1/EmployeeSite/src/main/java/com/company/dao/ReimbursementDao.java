package com.company.dao;

import java.util.List;

import com.company.model.Reimbursement;


public interface ReimbursementDao {
	public List<Reimbursement> getReimbursements();
	public Reimbursement getReimbursementById(int id);
	
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId);
	public List<Reimbursement> getAllReimbursementsByManager(int mangId);
	public int createReimbursement(Reimbursement a);
	public int updateReimbursement(Reimbursement a);
	public int deleteReimbursement(int EmpId);
	public int getNextReimbursementID();
}
