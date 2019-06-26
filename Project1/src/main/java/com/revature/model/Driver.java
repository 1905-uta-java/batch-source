package com.revature.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	static EmployeeDao ed = new EmployeeDaoImpl();
	static ReimbursementDao rd = new ReimbursementDaoImpl();
	static UserAccountDao uad = new UserAccountDaoImpl();
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		List<Reimbursement> reimbursements = new ArrayList<>();
		List<UserAccount> users = new ArrayList<>();
		Reimbursement r = new Reimbursement();
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// employees = ed.getEmployees();
		//ed.createEmp(e);
		//ed.deleteEmp(2);
		// ed.updateEmp(e, 1);
		
		//rd.submitReimbursement(new Reimbursement(2, 100, "Reimbursement", "Pending", 0, 2));
		//r = rd.getReimbursementById(1);
		// reimbursements = rd.getReimbursementByIdAndStatus(1, "Pending");
		//System.out.println(reimbursements);
		
		uad.createUserAccount(new UserAccount (5, "arizelli", "pass123", 0));
		uad.createUserAccount(new UserAccount (6, "angelkel", "password", 0));
		uad.createUserAccount(new UserAccount (7, "leesegrease", "password", 0));
		uad.createUserAccount(new UserAccount (8, "maggeeh", "password", 0));
		uad.createUserAccount(new UserAccount (9, "arisano", "pass123", 0));
		uad.createUserAccount(new UserAccount (10, "burgessstaresmeare", "wordpass", 0));

		//uad.deleteUserAccount(1);
		// UserAccount u = new UserAccount(1, "basimonson1", "password", 1);
		// uad.updateUserAccount(u, 1);
		
		//ed.updateEmp2(e, 1);
//		
//		users = uad.getUserAccounts();
//		System.out.println(users);
		
		
	}
	
	

}
