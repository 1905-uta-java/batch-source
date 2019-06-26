package com.reimbursement.dao;

import com.reimbursement.model.Employee;
import java.util.List;


public interface EmployeeDao {
	public List<Employee> getEmployees();
	public List<Employee> getSupervisors();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByUsername(String username);
	public int updateEmployeeInformation(Employee employee);
}
