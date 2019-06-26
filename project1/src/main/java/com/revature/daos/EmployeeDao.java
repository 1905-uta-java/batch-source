package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.User;

public interface EmployeeDao {
	public ArrayList<Employee> getAllEmployees();
	public Employee getEmpById(int id);
	public int addEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(int id);
}
