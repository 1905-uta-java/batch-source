package com.revature;

import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class Driver {
	
	public static void main(String[] args) {
		/*
		try {
		
			Connection c = ConnectionUtil.getHardCodedConnection();
			System.out.println(c.getMetaData().getDriverName());

		} catch (SQLException e) {
			e.printStackTrace();
		*/
		
		DepartmentDao dd = new DepartmentDaoImpl();
//		List<Department> departments = dd.getDepartments();
//		for(Department d : departments) {
//			System.out.println(d);
//		}
		
		
//		System.out.println(dd.getDepartmentById(4));
		
//		Department dept = new Department(7,"ADVERTISING",7000);
//		
//		System.out.println(dd.createDepartment(dept));
		
		
		EmployeeDao ed = new EmployeeDaoImpl();
		List<Employee> employees = ed.getEmployees();
		
		for(Employee e : employees) {
			System.out.println(e);
		}
		
	}

}
