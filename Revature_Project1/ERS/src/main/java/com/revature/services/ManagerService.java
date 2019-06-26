package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class ManagerService {

	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public List<Employee> getAll(){
		return empDao.getEmployees();
	}
}
