package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public List<Employee> getAll(){
		return empDao.getEmployees();
	}
	
	public Employee getById(int id) {
		return empDao.getEmployeeById(id);
	}
	
	/// implement for the rest of our crud methods

}
