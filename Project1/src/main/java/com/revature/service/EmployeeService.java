package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.model.Employee;

public class EmployeeService {
	
	private EmployeeDAO empDao = new EmployeeDAOImpl();
	
	//In here are the crud methods that will interact with the DAO layer
	
	//Could do validation on this level to make sure inputs are valid or sanitized before causing an SQL error
	
	public List<Employee> getEmployees(){
		return empDao.getAllEmployees();
	}

	
	public int setEmployeeName(String fullname, int empId) {
		if(fullname != null && fullname != "") {
		return empDao.setName(fullname, empId);}
		//invalid name
		return 0;
	}
	
	public int setEmployeeEmail(String email, int empId) {
		if(email != null && email != "") {
			if(email.contains("@")) { return empDao.setEmail(email, empId);}
		}
		//invalid email
		return 0;
	}
	
	public int setEmployeeManager(int managerId, int empId) {
		if(managerId > 0) {
		return empDao.setManager(managerId, empId);}
		//manager id is a negative number or 0
		return 0;
	}
	
	public int setEmployeeManagerRole(int aNum, int empId) {
		if(aNum == 0 || aNum == 1) {
		return empDao.setManagerRole(aNum, empId);}
		//aNum is invalid
		return 0;
	}
	
	public Employee getById(int empId) {
		if(empId > 0) {
		return empDao.getEmployeeById(empId);}
		//empId is negative or 0
		return null;
	}
	
	public int createEmployee(String fullname, String email, int reportsTo, int isManager, int empId) {
		if(fullname != null && fullname != "") {
			if(email != null && email != "") {
				if(reportsTo > 0) {
					if(isManager == 0 || isManager == 1) {
						if(empId > 0) {
						return empDao.newEmployee(empId, fullname, email, reportsTo, isManager);
						}
					}
				}
			}
		}
		return 0;
	}
	
	public Employee getEmployeeByName(String fullname) {
		if(fullname != null && fullname != "") {
			return empDao.getEmployeeByName(fullname);
		} else return null;
	}
}
