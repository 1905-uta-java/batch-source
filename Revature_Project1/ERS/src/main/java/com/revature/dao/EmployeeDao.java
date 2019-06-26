package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	public boolean isLogIn(Employee e);
	public boolean isManager(Employee e);
	public Employee getEmployeeById(int Id);
	
	public void updateFulltime(Employee e,boolean newFullTime);
	public void updatePassword(Employee e, String newPassword);
	public boolean createReimbursement(Employee e);
	public void approveReimbursement(Employee e);
	public List<Employee> getEmployees();
	
	public Employee authenticatedUser(int userID, String pass);
	
}
