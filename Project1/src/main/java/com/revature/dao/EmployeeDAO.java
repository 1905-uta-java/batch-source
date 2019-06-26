package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {
	
	public int setName(String fullname, int empId);
	public int setEmail(String email, int empId);
	public int setManager(int managerId, int empId);
	public int setManagerRole(int aNum, int empId);
	public Employee getEmployeeById(int empId);
	public List<Employee> getAllEmployees();
	public int newEmployee(int empId, String fullname, String email, int reportsTo, int isManager);
	public Employee getEmployeeByName(String name);
	

}
