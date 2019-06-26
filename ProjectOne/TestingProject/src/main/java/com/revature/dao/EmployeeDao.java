package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;



public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(String position);
	public int createEmloyee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(int id);

}
