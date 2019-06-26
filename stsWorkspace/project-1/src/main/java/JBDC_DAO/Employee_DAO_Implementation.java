package JBDC_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ERS_Actors.Employee;
import JDBC_Conn.ERS_Connection;

public class Employee_DAO_Implementation implements Employee_DAO {
	
	/**
	 * Description - Returns an Employee object representing a successful login attempt from the user
	 * @param username - String of the username for the designated Employee, String of the password used to verify the user is the Employee
	 * @returns - An Employee Object that has been successfully instantiated by the attributes pulled from the Employee table
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public Employee empLogin(String username, String password) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.USERNAME = ?"; //SQL query statement to be executed
		Employee e = null;
		
		//This con method is only temporary, need a more secure form of connecting to db
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
				if(rs.getString("PASSWORD").compareTo(password) == 0) { //check if password entered is the correct password
				e = new Employee(
						rs.getInt("EMP_ID"),
						rs.getString("LASTNAME"),
						rs.getString("FIRSTNAME"),
						rs.getInt("EMP_POS"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getString("EMAIL")
						);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//initalize list somewhere
		
		return e;
	}
	
	/**
	 * Description - Returns a list of all Employees currently within the Employee table
	 * @param - none.
	 * @returns - a List of all Employees under the Employee table
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE"; //SQL query statement to be executed
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empList.add( //add an Employee to the employee list
						new Employee( //initialize an Employee object
							rs.getInt("EMP_ID"),
							rs.getString("LASTNAME"),
							rs.getString("FIRSTNAME"),
							rs.getInt("EMP_POS"),
							rs.getString("USERNAME"),
							rs.getString("PASSWORD"),
							rs.getString("EMAIL")
							));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return empList;
	}
	
	/**
	 * Description - Attempts to open the database and update an Employee in the Employee table
	 * @param e - An Employee object that will pass its attributes into the database
	 * @returns - Integer of the row count in Employee that was updated, otherwise 0
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public int updateEmpl(Employee e) {
		int updated = 0;
		String sql = "UPDATE EMPLOYEE " //SQL query statement to be executed
				+ "SET LASTNAME = ?, "
				+ "SET FIRSTNAME = ?, "
				+ "SET EMP_POS = ?, "
				+ "SET USERNAME = ?, "
				+ "SET PASSWORD = ?, "
				+ "SET EMAIL = ? "
				+ "WHERE EMP_ID = ?";
		
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, e.getLastname());
			ps.setString(2, e.getFirstname());
			ps.setInt(3, e.getEmp_pos());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getEmail());
			ps.setInt(7, e.getEmp_id());
			
			updated = ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return updated;
	}
	
	
	/**
	 * Description - Returns an Employee object representing the requested employee
	 * @param emp_id - Integer of the employee's ID.
	 * @returns - An Employee Object that has been successfully instantiated by the attributes pulled from the Employee table
	 * @throws - SQLException if database access causes an error or connection is closed
	 */
	@Override
	public Employee getEmployee(int emp_id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.EMP_ID = ?"; //SQL query statement to be executed
		Employee e = null;
		
		//This con method is only temporary, need a more secure form of connecting to db
		try (Connection con = ERS_Connection.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				e = new Employee(
						rs.getInt("EMP_ID"),
						rs.getString("LASTNAME"),
						rs.getString("FIRSTNAME"),
						rs.getInt("EMP_POS"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getString("EMAIL")
						);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return e;
	}

}
