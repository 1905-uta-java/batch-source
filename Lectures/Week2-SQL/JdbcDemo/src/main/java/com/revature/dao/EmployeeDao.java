package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public int createEmployee(Employee d);
	public int updateEmployee(Employee d);
	public int deleteEmployee(int id);

}
