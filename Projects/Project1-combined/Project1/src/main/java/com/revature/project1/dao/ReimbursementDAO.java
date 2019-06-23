package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.models.*;

public interface ReimbursementDAO {
	
	public Employee getEmployee(int employeeID);
	public List<Employee> getSubordinates(int managerID);
	public boolean hasManager(int employeeID);
	public Employee getEmployeeByEmail(String email);
	public void updateEmployee(Employee employee);
	
	public void createReimbursementRequest(ReimbursementRequest request);
	public ReimbursementRequest getReimbursementRequest(int requestID);
	public List<ReimbursementRequest> getRequestsForEmployee(int employeeID);
	public List<ReimbursementRequest> getRequestsForManager(int managerID);
	public void updateReimbursementRequest(ReimbursementRequest request);
	public void removeReimbursementRequest(int requestID);
}