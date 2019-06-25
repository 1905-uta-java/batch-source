package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO
{
	// THESE METHODS SEND SANITIZED INPUT TO THE DATABASE
	public List<Employee> getEmployees();
	public Employee getEmployeeByID(int id);
	public int createEmployee(Employee e);
	public int updateEmployee(Employee e);
	public Employee viewOwnInfo(int id);
	//public int deleteEmployee(int id);
}
