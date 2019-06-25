package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.model.Employee;

public class EmployeeDaoImp implements EmployeeDao {

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		// Attempt to retrieve the Employees from the table
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int empId = rs.getInt("EMPLOYEEID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("EMPUSERNAME");
				String pWord = rs.getString("EMPPASSWORD");
				String eMail = rs.getString("EMAIL");
				int manId = rs.getInt("MANAGERID");
				employees.add(new Employee(empId, fName, lName, uName, pWord, eMail, manId));
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve all employees");
		}
		return employees;
	}
	
	public List<Employee> getEmployeesByManId(int mId) {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "SELECT * FROM EMPLOYEE WHERE MANAGERID = ?";
		
		// Attempt to retrieve the Employees from the table
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  mId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("EMPLOYEEID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("EMPUSERNAME");
				String pWord = rs.getString("EMPPASSWORD");
				String eMail = rs.getString("EMAIL");
				int manId = rs.getInt("MANAGERID");
				employees.add(new Employee(empId, fName, lName, uName, pWord, eMail, manId));
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve employees by manager id");
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		Employee emp = null;

		// Attempt to retrieve the specified Employee from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("EMPLOYEEID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("EMPUSERNAME");
				String pWord = rs.getString("EMPPASSWORD");
				String eMail = rs.getString("EMAIL");
				int manId = rs.getInt("MANAGERID");
				emp = new Employee(empId, fName, lName, uName, pWord, eMail, manId);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve employee by their id");
		}
		return emp;
	}
	
	public Employee getEmployeeByLogin(String eName, String eWord) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPUSERNAME = ?";
		Employee emp = null;

		// Attempt to retrieve the specified Employee from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1,  eName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("EMPLOYEEID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("EMPUSERNAME");
				String pWord = rs.getString("EMPPASSWORD");
				String eMail = rs.getString("EMAIL");
				int manId = rs.getInt("MANAGERID");
				if(pWord.equals(eWord)) {
					emp = new Employee(empId, fName, lName, uName, pWord, eMail, manId);
				}
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve employees by their login information");
		}
		return emp;
	}

	public int createEmployee(Employee emp) {
		int empCreated = 0;
		String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?)";
		
		// Attempt to insert the new Employee
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, emp.getId());
			ps.setString(2,  emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getUserName());
			ps.setString(5, emp.getPassWord());
			ps.setString(6, emp.geteMail());
			ps.setInt(7, emp.getManagerId());
			empCreated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to create an employee");
		}
		return empCreated;
	}

	public int deleteEmployee(int id) {
		int rowsDel = 0;
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		
		// Attempt to delete the specified Employee
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			rowsDel = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to delete an employee");
		}
		return rowsDel;
	}

	public int changeEmail(int id, String eMail) {
		int empUpdated = 0;
		String sql = "UPDATE EMPLOYEE " + 
				"SET EMAIL = ? " + 
				"WHERE EMPLOYEEID = ?";
		
		// Attempt to update the email of the Employee
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, eMail);
			ps.setInt(2, id);
			empUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to change the employee's email");
		}
		return empUpdated;
	}
	
	public int changePWord(int id, String pWord) {
		int empUpdated = 0;
		String sql = "UPDATE EMPLOYEE " + 
				"SET EMPPASSWORD = ? " + 
				"WHERE EMPLOYEEID = ?";
		
		// Attempt to update the password of the Employee
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, pWord);
			ps.setInt(2, id);
			empUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to change the employee's password");
		}
		return empUpdated;
	}
	
	public int changeUName(int id, String uName) {
		int empUpdated = 0;
		String sql = "UPDATE EMPLOYEE " + 
				"SET EMPUSERNAME = ? " + 
				"WHERE EMPLOYEEID = ?";
		
		// Attempt to update the username of the Employee
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, uName);
			ps.setInt(2, id);
			empUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to change the employee's username");
		}
		return empUpdated;
	}

}
