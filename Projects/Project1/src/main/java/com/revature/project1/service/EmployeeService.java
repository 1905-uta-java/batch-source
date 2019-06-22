package com.revature.project1.service;

import java.util.List;

import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.models.Employee;
import com.revature.project1.util.PasswordResult;
import com.revature.project1.util.PasswordUtil;

public class EmployeeService {
	
	ReimbursementDAO dao;
	
	public EmployeeService(ReimbursementDAO dao) {
		this.dao = dao;
	}
	
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}
	
	public Employee getEmployeeByEmail(String email) {
		return dao.getEmployeeByEmail(email);
	}
	
	public List<Employee> getSubordinates(int managerId) {
		return dao.getSubordinates(managerId);
	}
	
	public void updateEmployee(Employee employee) {
		
		dao.updateEmployee(employee);
	}
	
	public void updateEmail(int employeeId, String email) {
		
		Employee otherEmp = dao.getEmployeeByEmail(email);
		
		if(otherEmp != null)
			return;
		
		Employee currentUser = dao.getEmployee(employeeId);
		
		currentUser.setEmail(email);
		dao.updateEmployee(currentUser);
	}
	
	public void updatePassword(int employeeId, String password) {
		
		Employee currentUser = dao.getEmployee(employeeId);
		
		PasswordResult passResult = PasswordUtil.hashPassword(password);
		currentUser.setPasswordHash(passResult.getHash());
		currentUser.setPasswordSalt(passResult.getSalt());
		
		dao.updateEmployee(currentUser);
	}
	
	public boolean isEmailTaken(String email) {
		
		return dao.getEmployeeByEmail(email) != null;
	}
}
