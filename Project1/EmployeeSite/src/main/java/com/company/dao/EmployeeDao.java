package com.company.dao;

import java.util.List;

import com.company.model.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployeeByEmpId(int empId);
	public Employee getEmployeeByEmail(String email);
	public List<Employee> getEmployeesByManager(int mangId);
	public int createEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(int EmpId);
	public int getNextEmployeeID();
	public int changePassword(int id, String password);

}
