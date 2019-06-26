package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	public void createEmployee(Employee e);
	public void updateEmployeeInfo(Employee e);
	

}
