package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.revature.model.Employee;
import com.revature.util.ConnectionDb;

/*
 * This is the class that access the employee table in the database and get's all the information there.
 */


public class EmployeeDoa {
	//get employees, get employee by id, get manager
	//List<Employee> employees;
	
	public EmployeeDoa(){
		super();
	}
	
	//gets every employee in the table with all of thier information
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList();
		
		String statement = "SELECT * FROM EMPLOYEE";
		
		try(Connection conn = ConnectionDb.getConnection();
				PreparedStatement ps = conn.prepareStatement(statement);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				int id = 	rs.getInt("EMP_ID");
				String fn = rs.getString("EMP_FIRSTNAME");
				String ln = rs.getString("EMP_LASTNAME");
				String un = rs.getString("EMP_USERNAME");
				String pw = rs.getString("EMP_PASSWORD");
				int mid = 	rs.getInt("MANAGER_ID");
				Employee e =  new Employee(id,ln,fn,un,pw,mid);
				employees.add(e);
			
			}
			return employees;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Employee getEmployeeById(int i) {
		List<Employee> employees = getEmployees();
		for(Employee e : employees) {
			if(i == e.getId())
				return e;
		}
		return null;
	}
	
	public Employee getEmployeeById(String i) {
		if(Integer.parseInt(i) > 10000) {
			int id = Integer.parseInt(i);
			return getEmployeeById(id);
		}
		System.out.println("gotta be null");
		return null;
	}
	
	public Employee getEmployeeById(String u, String p) {
		List<Employee> employees = getEmployees();
		for(Employee e : employees) {
			if(u.equals( e.getUsername()) && p.equals(e.getPassword()))
				return e;
		}
		return null;
	}
	
	public void createEmployee(String fn, String ln, String un, String pass) {
		//find the highest ID number and then make the id one more than that
		int id = highestIdNumber();
		//get random manager number for assignment
		ManagerDoa md = new ManagerDoa();
		int managerCounter = md.managerCount();
		Random rand = new Random();
		int managerNum = rand.nextInt(49) + 20001;
		
		String statement = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
		
		try(Connection conn = ConnectionDb.getConnection();
				PreparedStatement ps = conn.prepareStatement(statement);){
			int i = 1;
			ps.setInt(i++, id);
			ps.setString(i++, fn);
			ps.setString(i++, ln);
			ps.setString(i++, un);
			ps.setString(i++, pass);
			ps.setInt(i++, managerNum);
			ps.executeUpdate();
			System.out.println("employee added");
		}
		catch(SQLException e) {
			System.out.println("Employee Doa SQL Exception");
			e.printStackTrace();
		}
		
		
	}
	
	public int highestIdNumber() {
		int id = 0;
		List<Employee>employees = getEmployees();
		for(Employee e : employees) {
			if(e.getId() > id)
				id = e.getId();
		}
		id++;
		return id;
	}
	
	public int employeeCount() {
		int i = 0;
		List<Employee>employees = getEmployees();
		for(Employee e : employees) {
			i++;
		}
		return i;
	}
	
	public int getManagerId(int i) {
		List<Employee>employees = getEmployees();
		for(Employee e: employees) {
			if(e.getManagerId() == i) {
				return e.getManagerId();
			}
		}
		return 0;
	}
	
	public int getManagerId(String i) {
		if(Integer.valueOf(i) > 10000) {
			return getManagerId(Integer.valueOf(i));
		}
		return 0;
	}
	
	public List<Employee> getEmployeesByManagerId(int manId) {
		List<Employee>emps = getEmployees();
		List<Employee>employees = new ArrayList();
		for(Employee e : emps) {
			if(manId == e.getManagerId()) {
				employees.add(e);
			}
		}
		return employees;
	}
		
		
}

	

