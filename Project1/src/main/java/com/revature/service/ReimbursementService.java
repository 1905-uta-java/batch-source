package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDAO rebeDAO = new ReimbursementDAOImpl();
	
	public int getAmount(int reqId) {
		if(reqId > 0) {
		return rebeDAO.getAmount(reqId);} else return 0;
	}
	
	public Reimbursement getRequest(int requestId) {
		if(requestId > 0) {
		return rebeDAO.getReReq(requestId); } else return null;
	}
	
	public List<Reimbursement> getEmployeeReimbursements(int empId){
		if(empId > 0) {
		return rebeDAO.getAllReimbursements(empId);} else return null;
	}
	
	public int changeStatus(int status, int reqId) {
		if(status == 1 || status == 0) {
			if(reqId > 0) {
				return rebeDAO.setStatus(status, reqId);
			}
		}
		return 0;
	}
	
	public int createRebe(int reqId, int empId, int amount, String comments) {
		if(empId > 0) {
			if(amount > 0) {
				if(comments != null && comments.length() < 256) {
					return rebeDAO.createReimbursement(reqId, empId, amount, comments);
				}
			}
		}
		return 0;
	}
	
	public int setResolvedBy(int managerId, int reqId) {
		if(managerId == 0 || managerId == 1) {
			if(reqId > 0) {
				return rebeDAO.setResolvedBy(managerId, reqId);
			}
		}
		return 0;
	}
	
	public List<Reimbursement> getAllReimbursements(){
		return rebeDAO.getAll();
	}

}
