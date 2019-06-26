package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;


public class EmployeeService {
	
EmployeeDao empDao = new EmployeeDaoImpl();
	
	public List<Employee> getEmployees() {
		return empDao.getEmployees();
	} 
	
	public int createEmp(Employee e) {
		return empDao.createEmp(e);
	}
	
	public int updateEmp2(Employee e, int id) {
		return empDao.updateEmp2(e, id);
	}
	
	public int deleteEmp(int id) {
		return empDao.deleteEmp(id);
	}
	

}
