package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Employee;
import com.revature.model.UserAccount;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	// ---------- GET EMPLOYEES ----------
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>(); // Create a list to store employees
		
		String sql = "SELECT * FROM EMPLOYEES"; // sql query
		
		try (Connection con = ConnectionUtil.getHardCodedConnection(); // check for connection
				Statement s = con.createStatement(); // create a statement to run
				ResultSet rs = s.executeQuery(sql);) { // Create a result set and execute the sql query
			
			while(rs.next()) {
				Employee e = new Employee(); // Create new Employee
				int id = rs.getInt("EMP_ID"); // Get ID from Employee table in database
				e.setId(id);
				String firstname = rs.getString("EMP_FIRSTNAME"); // Get Firstname from Employee table in database
				e.setFirstname(firstname);
				String lastname = rs.getString("EMP_LASTNAME"); // Get Lastname from Employee table in database
				e.setLastname(lastname);
				String email = rs.getString("EMP_EMAIL"); // Get Email from Employee table in database
				e.setEmail(email);
				int managerId = rs.getInt("EMP_MANAGERID"); // Get ManagerId from Employee table in database
				e.setManagerId(managerId);
				
				employees.add(e); // Add the new employee to the list of employees
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	// ------------ CREATE EMPLOYEE ---------------
	@Override
	public int createEmp(Employee e) {
		int employeeCreated = 0;
		
		String sql = "INSERT INTO EMPLOYEES VALUES (?,?,?,?,?)";
		
		e.toString();
		
		
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, e.getId());
			ps.setString(2, e.getFirstname());
			ps.setString(3, e.getLastname());
			ps.setString(4, e.getEmail());
			ps.setInt(5, e.getManagerId());			
			
			System.out.println(e);
			
			ps.executeQuery();
			System.out.println("Employee Created");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return employeeCreated;
	}

	// ------------- UPDATE EMPLOYEE --------------
	@Override
	public int updateEmp(Employee e, int id) {
		int employeeUpdated = 0;
		String sql = "UPDATE EMPLOYEES" 
				+ " SET EMP_FIRSTNAME = ?, "
				+ " EMP_LASTNAME = ?, "
				+ " EMP_EMAIL = ?, "
				+ " EMP_MANAGERID = ?"
				+ " WHERE EMP_ID = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getEmail());
			ps.setInt(4, e.getManagerId());
			ps.setInt(5, id);
			
			employeeUpdated = ps.executeUpdate();
			System.out.println("Employee Updated");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return employeeUpdated;
	}
	

	// ------------- DELETE EMPLOYEE --------------
	@Override
	public int deleteEmp(int id) {
		int employeeRemoved = 0;
		String sql = "DELETE FROM EMPLOYEES WHERE EMP_ID = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			
			System.out.println("Employee Deleted");
			employeeRemoved = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return employeeRemoved;
	}

	
	// ---------------- UPDATE EMPLOYEE VERSION 2 ---------------
	@Override
	public int updateEmp2(Employee e, int id) {
		String sql = "{call UPDATE_EMPLOYEE(?,?,?,?,?)}";
		int empsUpdated = 0;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement statement = con.prepareCall(sql)){
			
			statement.setInt(1, id);
			statement.setString(2, e.getFirstname());
			statement.setString(3, e.getLastname());
			statement.setString(4, e.getEmail());
			statement.setInt(5, e.getManagerId());
			
			statement.execute();
					
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return empsUpdated;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = new Employee();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID"); // Get ID from Employee table in database
				e.setId(empId);
				String firstname = rs.getString("EMP_FIRSTNAME"); // Get Firstname from Employee table in database
				e.setFirstname(firstname);
				String lastname = rs.getString("EMP_LASTNAME"); // Get Lastname from Employee table in database
				e.setLastname(lastname);
				String email = rs.getString("EMP_EMAIL"); // Get Email from Employee table in database
				e.setEmail(email);
				int managerId = rs.getInt("EMP_MANAGERID"); // Get ManagerId from Employee table in database
				e.setManagerId(managerId);
				
				e = new Employee(empId, firstname, lastname, email, managerId);
			}
			
			
		} catch (SQLException err) {
			err.printStackTrace();
		}
		
		
		return e;
	}
	
	
	

	
}
