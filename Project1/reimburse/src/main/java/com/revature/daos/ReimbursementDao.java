package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {

	public List<Reimbursement> getReimbursements() throws SQLException;

	public void createReimbursement(Reimbursement r) throws SQLException;
	
	public Reimbursement getReimbursementById(int id) throws SQLException;

	public void approveReimbursement(Reimbursement r) throws SQLException;

}