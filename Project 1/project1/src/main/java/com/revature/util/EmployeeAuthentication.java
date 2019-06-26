package com.revature.util;

import java.util.List;

import com.revature.doa.EmployeeDoa;
import com.revature.model.Employee;

public class EmployeeAuthentication {
	
	
	public static boolean isEmployeeLogIn(String user, String pass) {
		EmployeeDoa ed = new EmployeeDoa();
		List<Employee>employees =  ed.getEmployees();
		for(Employee e : employees) {
			if(e.getUsername().equals(user) && e.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
		
	}
	
	public static Employee user(String user, String pass) {
		Employee employee = null;
		EmployeeDoa ed = new EmployeeDoa();
		List<Employee>emp = ed.getEmployees();
		for(Employee e: emp) {
			if(e.getUsername().equals(user) && e.getPassword().equals(pass)) {
				employee = e;
			}
		}
		return employee.safeEmployee();
	}
	
	public static boolean employeeConfirmation(String fn, String ln, String un, String pass) {
		if(fn != null && ln !=null && un != null && pass != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmployeeId(String id) {
		EmployeeDoa ed = new EmployeeDoa();
		if( id != null && Integer.parseInt(id) > 10000) {
			int empId = Integer.parseInt(id);
			if(empId < ed.highestIdNumber()) {
				return true;
			}
		}
		return false;
	}
	
}
