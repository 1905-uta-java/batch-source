package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {
	EmployeeDao empDao = new EmployeeDaoImpl();
	ArrayList<Employee> employeeList = new ArrayList<>();
	ArrayList<Employee> empUserList = new ArrayList<>();
	Employee e = null;
	
	
	public EmployeeService(){
		employeeList = getAll();
		System.out.println("LETS PRINT A LIST OF EMPLOYEES");
		System.out.println(employeeList);
	}
	
	public ArrayList<Employee> getAll(){
		return empDao.getAllEmployees();
	}
	
	public int create(Employee e) {
		employeeList.add(e);
		return empDao.addEmployee(e);
	}
	
	public Employee returnEmployeeFromId(int id) {
		System.out.println("Looking for Employee with ID: " + id);
		for (int i = 0; i < employeeList.size(); i++) {
			System.out.println(employeeList.get(i));
			if(employeeList.get(i).getId() == id) {
				e = employeeList.get(i);
				return e;
			}
		}
		System.out.println("COuldn't find employee with id " + id + ", returning null");
		return null;
	}
	
	
	public Employee updateEmployee(Employee e) {
		this.e = e;
		return e;
	}
	
	public void updateEmployeeDB(Employee e) {
		empDao.updateEmployee(e);
	}
	
	public Employee getCurrentEmployee() {
		return e;
	}
	
	
	public ArrayList<Employee> getManEmps(int manId){
		for(int i = 0; i < employeeList.size(); i++) {
			if(employeeList.get(i).getManagerId()== manId ) {
				empUserList.add(employeeList.get(i));
			}
		}
		return empUserList;
	}

	public void logout() {
		e=new Employee();
	}
	
	public int getNewEmpNum() {
		int maxId = 0;
		for(int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() > maxId){
				maxId = employeeList.get(i).getId();
			}
		}
		
		return ++maxId;
	}

}


