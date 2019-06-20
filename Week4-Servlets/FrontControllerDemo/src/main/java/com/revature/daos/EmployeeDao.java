package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public int createEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(int id);

}
