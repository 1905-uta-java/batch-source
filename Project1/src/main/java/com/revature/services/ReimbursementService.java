package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService {
	
	ReimbursementDao reDao = new ReimbursementDaoImpl();

	public List<Reimbursement> getReimbursements(){
		return reDao.getReimbursements();
	}
	
	public int submitReimbursement(Reimbursement r) {
		return reDao.submitReimbursement(r);
	}
	
	public List<Reimbursement> getReimbursementById(int empId) {
		return reDao.getReimbursementById(empId);
	}
	
	public List<Reimbursement> getReimbursementByStatus(String status) {
		return reDao.getReimbursementByStatus(status);
	}
	
	public List<Reimbursement> getReimbursementByIdAndStatus (int empId, String status) {
		return reDao.getReimbursementByIdAndStatus(empId, status);
	}
	
	public void deleteReimbursement (int id) {
		
	}
	
}

