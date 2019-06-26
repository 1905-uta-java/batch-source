package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				Employee e = new Employee();
				
				int empID = rs.getInt("EMPID_");
				e.setId(empID);
				
				String lastN = rs.getString("LASTNAME_");
				e.setLastName(lastN);
				
				String firstN = rs.getString("FIRSTNAME_");
				e.setFirsName(firstN);
				
				String user = rs.getString("USERNAME_");
				e.setUser(user);
				
				String pw = rs.getString("PASSWORD_");
				e.setPw(pw);
				
				String title = rs.getString("TITLE_");
				e.setTitle(title);
				
				int reportsTo = rs.getInt("REPORTSTO_");
				e.setReportsTo(reportsTo);
				
				String hireDate = rs.getString("HIREDATE_");
				e.setHireDate(hireDate);
				
				String address = rs.getString("ADDRESS_");
				e.setAddress(address);
				
				String city = rs.getString("CITY_");
				e.setCity(city);
				
				String state = rs.getString("STATE_");
				e.setState(state);
				
				String zip = rs.getString("ZIPCODE_");
				e.setZip(zip);
				
				String phone = rs.getString("PHONE_");
				e.setPhone(phone);
				
				String email = rs .getString("EMAIL_");
				e.setEmail(email);
				
				employees.add(e);
			}
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void createEmployee(Employee e) {

		int createEmployee = 0;
		
		String sql = "INSERT INTO EMPLOYEE VALUES(seq_emp.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, e.getLastName());
			ps.setString(2, e.getFirsName());
			ps.setString(3, e.getUser());
			ps.setString(4, e.getPw());
			ps.setString(5, e.getTitle());
			ps.setInt(6, e.getReportsTo());
			ps.setString(7, e.getHireDate());
			ps.setString(8, e.getAddress());
			ps.setString(9, e.getCity());
			ps.setString(10, e.getState());
			ps.setString(11, e.getZip());
			ps.setString(12, e.getPhone());
			ps.setString(13, e.getEmail());
			
			createEmployee = ps.executeUpdate();
		}
		
		catch(SQLException sq) {
			sq.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployeeInfo(Employee e) {

		int updateEmployee = 0;
		
		String sql = "UPDATE EMPLOYEE "
				+ "SET FIRSTNAME_ = ?, LASTNAME_ = ?, ADDRESS_ = ?, CITY_ = ?, STATE_ = ?, ZIPCODE_ = ?, PHONE_ = ?, EMAIL_ = ? "
				+ "WHERE USERNAME_ = ?";
		
		try {
			Connection con = ConnectionUtil.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, e.getFirsName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getCity());
			ps.setString(5, e.getState());
			ps.setString(6, e.getZip());
			ps.setString(7, e.getPhone());
			ps.setString(8, e.getEmail());
			ps.setString(9, e.getUser());
			
			updateEmployee = ps.executeUpdate();
		}
		
		catch(SQLException eq) {
			eq.printStackTrace();
		}
		
	}
		
	

}
