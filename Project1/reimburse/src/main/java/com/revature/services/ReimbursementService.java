package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	ReimbursementDao reimburseDao = new ReimbursementDaoImpl();
	
	public List<Reimbursement> getAllReimbursements() throws SQLException{
		return reimburseDao.getReimbursements();
	}
	
	public void create(Reimbursement r) throws SQLException {
		reimburseDao.createReimbursement(r);
	}
	
	public Reimbursement getReimbursementById(int id) throws SQLException {
		return reimburseDao.getReimbursementById(id);
	}

	public void approve(Reimbursement r) throws SQLException {
		reimburseDao.approveReimbursement(r);
	}

}
