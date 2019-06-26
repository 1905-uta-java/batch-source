package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public List<Employee> getAllEmployees() throws SQLException{
		return empDao.getEmployees();
	}
	
//	public Employee getById(int id) {
//		return empDao.getEmployeeById(id);
//	}
//	
//	public int create(Employee e) {
//		return empDao.createEmployee(e);
//	}
	
	/// implement for the rest of our crud methods

}
