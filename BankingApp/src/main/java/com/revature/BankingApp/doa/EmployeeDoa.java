package com.revature.BankingApp.doa;

import java.util.List;

import com.revature.BankingApp.model.Employee;

public interface EmployeeDoa {
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int d);
	public int createEmployee(Employee d);
	public int updateEmployee(Employee d);
	public int deleteEmployee(Employee d);
}
