package com.revature.driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.services.EmployeeService;
import com.revature.services.RequestService;
import com.revature.utils.ConnectionUtil;

public class DriverTest {

	public static void main(String[] args) {
		
		
		  try { Connection c = ConnectionUtil.getHardCodedConnection();
		  System.out.println(c.getMetaData().getDriverName()); }
		  
		  catch (SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 

		RequestService rd = new RequestService();
		EmployeeService ed = new EmployeeService();
		
		List<Request> request = rd.getAllRequests();
		
		List<Employee> employee = ed.getAllEmployees();
		
		Employee e = new Employee(100, "Ten", "Ben", "Benjamin720", "jEWN4cDIiFJ", "Data Coordiator", 3, "4/24/2019", "42 Randy Pass", "Boston", "Massachusetts", "02124", "617-772-4221", "bpavluk2@admin.ch");
		//ed.updateEmployeeInfo(e);
		Request r = new Request(1, 10.00, "Cookies", "APPROVED", "Ben O");
		//r = new Request(1, "APPROVED", "Ben Mod");
		//rd.createRequest(r);
		//rd.updateRequestStatus(r);
		//request = rd.getAllRequests();
		//employee = ed.getAllEmployees();
		int count =  0;
		
		for(Employee ll : employee) {
			System.out.println(ll);
		}
		Employee tk = ed.getEmployeeById(3);
		System.out.println(tk);
		

	}

}
