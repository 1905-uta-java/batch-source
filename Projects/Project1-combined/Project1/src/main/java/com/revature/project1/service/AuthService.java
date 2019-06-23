package com.revature.project1.service;

import java.util.List;

import com.revature.project1.auth.AuthToken;
import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.models.Employee;
import com.revature.project1.util.PasswordResult;
import com.revature.project1.util.PasswordUtil;

public class AuthService {
	
	private ReimbursementDAO dao;
	
	public AuthService(ReimbursementDAO dao) {
		System.out.println("AuthService constructor");
		this.dao = dao;
	}
	
	public AuthToken verifyPassword(String password, String email) {
		
		Employee emp = dao.getEmployeeByEmail(email);
		
		if(emp == null)
			return null;
		
		PasswordResult storedPass = new PasswordResult(emp.getPasswordHash(), emp.getPasswordSalt());
		
		if(storedPass.equals(PasswordUtil.hashPassword(password, emp.getPasswordSalt()))) {
			
			List<Employee> subordinates = dao.getSubordinates(emp.getEmployeeID());
			
			if(subordinates == null || subordinates.isEmpty()) {
				
				return new AuthToken(emp.getEmployeeID(), false);
				
			} else {
				
				return new AuthToken(emp.getEmployeeID(), true);
			}
			
		} else {
			
			return null;
		}
	}
}
