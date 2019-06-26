package com.revature.Driver;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.services.ManagerService;
import java.util.Scanner;

public class DaoDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDaoImpl bd = new EmployeeDaoImpl();
		System.out.println(bd.getEmployees());
		System.out.println("Enter Username");
		String name = sc.nextLine();
	
		System.out.println("Enter Password");
		String password = sc.nextLine();
		
		Employee b = new Employee();
		
		
		b.setEmpId(Integer.parseInt(name));
		b.setPassword(password);
		
		System.out.print(bd.isLogIn(b));
		//System.out.print(bd.isManager(b));
		System.out.println(b.getEmpId());
		System.out.println(b.getEmpName());
		System.out.println(b.getMonthSal());
		System.out.println(b.getStartDate());
		System.out.println(b.isFullTime());
		System.out.println(b.getPassword());
		System.out.println(b.isManager());
		
		b.setReAmount(256);
		System.out.print(bd.createReimbursement(b));
		
		
		
		
	}
	
}
