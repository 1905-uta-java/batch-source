package com.revature.BankingApp.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.BankingApp.model.Employee;
import com.revature.BankingApp.util.ConnectionUtil;

public class EmployeeDoaImpl implements EmployeeDoa  {

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection c = ConnectionUtil.getHardCodedConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {	
				int empId = 	rs.getInt("EMPLOYEE_ID");
				String fn = 	rs.getString("FIRSTNAME");
				String ln = 	rs.getString("LASTNAME");
				String un = 	rs.getString("USERNAME");
				String pass = 	rs.getString("EMPLOYEE_PASSWORD");
				String pho = 	rs.getString("PHONE");
				String addr = 	rs.getString("ADDRESS");
				String city = 	rs.getString("CITY");
				String cou = 	rs.getString("COUNTRY");
				int sup = 		rs.getInt("SUPERVISOR_ID");
				String dept = 	rs.getString("DEPARTMENT");
				String dAdded = rs.getString("HIRE_DATE");
				String dRemov = rs.getString("RELEASE_DATE");
				Employee temp = new Employee(empId, fn, ln, un, pass,
						pho, addr, city, cou, sup, dept, dAdded, dRemov);
				employees.add(temp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int d) {
		List<Employee> temp = getEmployees();
		return temp.get(d);
	}

	@Override
	public int createEmployee(Employee d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee d) {
		// TODO Auto-generated method stub
		return 0;
	}

}
