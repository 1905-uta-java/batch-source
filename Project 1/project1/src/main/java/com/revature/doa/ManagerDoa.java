package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.util.ConnectionDb;

/*
 * This is the class that accesses the manager table and allows me to use that data
 */


public class ManagerDoa {
	//get managers, get manager by id
	
	
	//gets a list of all the managers in the manager table with all thier information
	public List<Manager> getManagers(){
		List<Manager> managers = new ArrayList();
		String statement = "SELECT * FROM MANAGER_TBL";
		try(Connection conn = ConnectionDb.getConnection();
				PreparedStatement ps = conn.prepareStatement(statement);
				ResultSet rs = ps.executeQuery();){
			while(rs.next()) {
				int id = 	rs.getInt("MANAGER_ID");
				String fn = rs.getString("MANAGER_FIRSTNAME");
				String ln = rs.getString("MANAGER_LASTNAME");
				String un = rs.getString("MANAGER_USERNAME");
				String pw = rs.getString("MANAGER_PASSWORD");
				Manager m = new Manager(id, fn, ln, un, pw);
				managers.add(m);
			}
			return managers;
		}
		catch(SQLException e) {
			
		}
		System.out.println("Oh no getManagers error ManagerDoa");
		return null;
	}
	
	public Manager getManagerById(int i) {
		List<Manager> managers = getManagers();
		for(Manager m : managers) {
			if(i == m.getId()) {
				return m;
			}
		}
		return null;
	}
	
	public int managerCount() {
		int i = 0;
		for(Manager m : getManagers()) {
			i++;
		}
		return i;
	}
	
	public int highestIdNumber() {
		int id = 0;
		List<Manager>managers = getManagers();
		for(Manager m : managers) {
			if(m.getId() > id)
				id = m.getId();
		}
		id++;
		return id;
	}
	
	public List<Employee>employeesUnderManager(int manId){
		EmployeeDoa ed = new EmployeeDoa();
		List<Employee> e = ed.getEmployees();
		List<Employee> emps = new ArrayList();
		for(Employee emp : e) {
			if(emp.getManagerId() == manId) {
				emps.add(emp);
			}
		}
		return emps;
	}
	
}
