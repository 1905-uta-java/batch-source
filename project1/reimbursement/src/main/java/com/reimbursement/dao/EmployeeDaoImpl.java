package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.reimbursement.model.Employee;
import com.reimbursement.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> el = new ArrayList<>();
		String query = "SELECT * FROM EMPLOYEE";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				employee.setName(rs.getString("NAME"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setSupervisor(rs.getInt("SUPERVISOR"));
				
				el.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return el;
	}

	@Override
	public List<Employee> getSupervisors() {
		List<Employee> el = new ArrayList<>();
		String query = "SELECT * FROM EMPLOYEE WHERE SUPERVISOR = 1";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				employee.setName(rs.getString("NAME"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setSupervisor(rs.getInt("SUPERVISOR"));
				el.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return el;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = new Employee();
		String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee.setId(rs.getInt("ID"));
				employee.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				employee.setName(rs.getString("NAME"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setSupervisor(rs.getInt("SUPERVISOR"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = new Employee();
		String query = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee.setId(rs.getInt("ID"));
				employee.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				employee.setName(rs.getString("NAME"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setSupervisor(rs.getInt("SUPERVISOR"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public int updateEmployeeInformation(Employee employee) {
		int employeesUpdated = 0;
		String query = "UPDATE EMPLOYEE SET NAME = ?, " + "USERNAME = ? " + "WHERE ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			// con.setAutoCommit(false);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setInt(3, employee.getId());
			employeesUpdated = ps.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeesUpdated;
	}

}
