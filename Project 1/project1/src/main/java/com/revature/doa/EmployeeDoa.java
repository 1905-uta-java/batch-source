package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;

import util.ConnectionDb;

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
	
}
