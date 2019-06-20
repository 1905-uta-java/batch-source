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
	
	public boolean updateEmployee(Employee employee) {
		
		if(employee.hasValidValues()) {
			
			dao.updateEmployee(employee);
			
			return true;
		}
		
		return false;
	}
	
	public boolean updateEmail(int employeeId, String email) {
		
		if(email == null || email.length() == 0)
			return false;
		
		Employee otherEmp = dao.getEmployeeByEmail(email);
		
		if(otherEmp != null)
			return false;
		
		Employee currentUser = dao.getEmployee(employeeId);
		
		currentUser.setEmail(email);
		dao.updateEmployee(currentUser);
		
		return true;
	}
	
	public boolean updatePassword(int employeeId, String password) {
		
		if(!PasswordUtil.isValidPassword(password))
			return false;
		
		Employee currentUser = dao.getEmployee(employeeId);
		
		PasswordResult passResult = PasswordUtil.hashPassword(password);
		currentUser.setPasswordHash(passResult.getHash());
		currentUser.setPasswordSalt(passResult.getSalt());
		
		dao.updateEmployee(currentUser);
		
		return true;
	}
	
	@Override
	public String toString() {
		return "EmployeeService [dao=" + dao + "]";
	}
}
