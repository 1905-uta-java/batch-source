package com.revature.delegates;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbursementDelegate {
	
	private ReimbursementDao rd = new ReimbursementDaoImpl();
	private EmployeeDao ed = new EmployeeDaoImpl();
	
	public Reimbursement addingReimbursement(int id, String amount, String reason) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		reimbursements = rd.getReimbursements();
		int numOfReimbursements = reimbursements.size() + 1;
		int intAmount = Integer.valueOf(amount);
		String status = "Pending";
		int completedBy = 0;
		int placeholder = 0;
		
		Reimbursement r = new Reimbursement(id, intAmount, reason, status, completedBy, numOfReimbursements);		
		
		return r;
	}

}
