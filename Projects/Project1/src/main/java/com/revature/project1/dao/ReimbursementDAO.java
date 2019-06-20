package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.models.*;

public interface ReimbursementDAO {
	
	public Employee getEmployee(int employeeID);
	public List<Employee> getSubordinates(int managerId);
	public boolean hasManager(int employeeID);
	public Employee getEmployeeByEmail(String email);
	public void updateEmployee(Employee employee);
	
	public void createReimbursementRequest(ReimbursementRequest request);
	public ReimbursementRequest getReimbursementRequest(int requestID);
	public List<ReimbursementRequest> getRequestsForEmployee(int employeeId);
	public List<ReimbursementRequest> getRequestsForEmployees(List<Employee> subordinates);
	public void updateReimbursementRequest(ReimbursementRequest request);
	public void removeReimbursementRequest(ReimbursementRequest request);
}