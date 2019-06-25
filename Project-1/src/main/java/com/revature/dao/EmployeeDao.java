package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByManId(int mId);
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByLogin(String eName, String eWord);
	public int createEmployee(Employee emp);
	public int deleteEmployee(int id);
	public int changeEmail(int id, String email);
	public int changePWord(int id, String pWord);
	public int changeUName(int id, String uName);
}
