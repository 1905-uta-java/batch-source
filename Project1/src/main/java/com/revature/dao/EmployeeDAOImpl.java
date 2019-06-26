package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{
	

	@Override
	public int setName(String fullname, int empId) {
		String sql = "UPDATE EMPLOYEE SET FULLNAME = ? WHERE EMP_NUM = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  fullname);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating name");
			return 0;
		}
		return 1;
	}

	@Override
	public int setEmail(String email, int empId) {
		String sql = "UPDATE EMPLOYEE SET EMAIL = ? WHERE EMP_NUM = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  email);
			ps.setInt(2,  empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating email");
			return 0;
		}
		return 1;
	}

	@Override
	public int setManager(int managerId, int empId) {
		String sql = "UPDATE EMPLOYEE SET MANAGER_ID = ? WHERE EMP_NUM = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, managerId);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Eror setting manager");
			return 0;
		}
		return 1;
	}

	@Override
	public int setManagerRole(int aNum, int empId) {
		String sql = "UPDATE EMPLOYEE SET ISMANAGER = ? WHERE EMP_NUM = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, aNum);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating manager role");
			return 0;
		}
		return 1;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_NUM = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empNum = rs.getInt("EMP_NUM");
				String fullname = rs.getString("FULLNAME");
				String email = rs.getString("EMAIL");
				int managerId = rs.getInt("MANAGER_ID");
				int isManager = rs.getInt("ISMANAGER");
				emp = new Employee(empNum, fullname, email, managerId, isManager);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting employee by id");
		}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int empNum = rs.getInt("EMP_NUM");
				String fullname = rs.getString("FULLNAME");
				String email = rs.getString("EMAIL");
				int managerId = rs.getInt("MANAGER_ID");
				int isManager = rs.getInt("ISMANAGER");
				Employee emp = new Employee(empNum, fullname, email, managerId, isManager);
				employees.add(emp);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting all employees");
		}
		return employees;
	}

	@Override
	public int newEmployee(int empId, String fullname, String email, int reportsTo, int isManager) {
		String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, empId);
			ps.setString(2, fullname);
			ps.setString(3, email);
			ps.setInt(4, reportsTo);
			ps.setInt(5, isManager);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creating a new employee");
			return 0;
		}
		return 1;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		String sql = "SELECT * FROM EMPLOYEE WHERE FULLNAME = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empNum = rs.getInt("EMP_NUM");
				String fullname = rs.getString("FULLNAME");
				String email = rs.getString("EMAIL");
				int managerId = rs.getInt("MANAGER_ID");
				int isManager = rs.getInt("ISMANAGER");
				emp = new Employee(empNum, fullname, email, managerId, isManager);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting employee by name");
		}
		
		return emp;
	}


}
