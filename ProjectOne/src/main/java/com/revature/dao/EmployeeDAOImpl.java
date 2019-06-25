package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.connectionUtil.ConnectionUtil;
import com.revature.models.Employee;

// ONLY USE THIS AFTER THE USER HAS DONE WHAT THEY NEED TO DO
public class EmployeeDAOImpl implements EmployeeDAO
{

	public List<Employee> getEmployees()
	{
		// This implementation needs to return a list
		// We need to make a list, and retrieve all employees in the database
		List <Employee> allEmployees = new ArrayList<Employee>();
		
		// Make a string to hold our query
		String sql = "SELECT * FROM EMPLOYEES";
		
		// To retrieve employees in the database using our string, we need to establish a connection
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			// once connection is established, make statement using connection object to send the read request
			Statement readStatement = connection.createStatement();
			// execute query and store results in a result set
			ResultSet readResults = readStatement.executeQuery(sql);
			
			// iterate over the result set to display the results
			while (readResults.next())
			{
				int employeeID = readResults.getInt("EMP_ID");
				String firstname = readResults.getString("FIRSTNAME");
				String lastname = readResults.getString("LASTNAME");
				String username = readResults.getString("USERNAME");
				String password = readResults.getString("PASSWORD");
				String position = readResults.getString("POSITION");
				allEmployees.add(new Employee(employeeID, firstname, lastname, username, password, position));
			}
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allEmployees;
	}

	public Employee getEmployeeByID(int id)
	{
		// establish a query to send to the database and create an empty object
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = " + id;
		Employee employee = null;
		
		// To retrieve an employee, we need a connection
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			// prepare a statement using the connection object
			Statement readStatement = connection.createStatement();
			// set a result set equal to the results of the exectuted querry
			ResultSet readResults = readStatement.executeQuery(sql);
			
			// iterate through the result set to return each field from the database
			while (readResults.next())
			{
				int employeeID = readResults.getInt("EMP_ID");
				String firstname = readResults.getString("FIRSTNAME");
				String lastname = readResults.getString("LASTNAME");
				String username = readResults.getString("USERNAME");
				String password = readResults.getString("PASSWORD");
				String position = readResults.getString("POSITION");
				
				employee = new Employee(employeeID, firstname, lastname, username, password, position);
			}
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	public int createEmployee(Employee e)
	{
		// prepare a query for the database-- prepared statement will use question marks
		// prepare an integer to return
		int employeesCreated = 0;
		
		String sql = "INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?)";
		
		// Create a connection object using try with resources and use the connection to prepare a statement
		try(Connection connection = ConnectionUtil.getHardCodedConnection();
			PreparedStatement createEmployee = connection.prepareStatement(sql))
		
		// bind the values in the prepared statement-- fill in the question marks
		{
			createEmployee.setInt(1, e.getEmpID());
			createEmployee.setString(2, e.getFirstname());
			createEmployee.setString(3, e.getLastname());
			createEmployee.setString(4, e.getUsername());
			createEmployee.setString(5, e.getPassword());
			createEmployee.setString(6, e.getPosition());
			
			// query is executed here
			employeesCreated = createEmployee.executeUpdate();
			
		} 
		
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// BE SURE TO RETURN SOMETHING HERE
		return employeesCreated;
	}

	public int updateEmployee(Employee e)
	{
		int employeesUpdated = 0;
		
		// craft SQL statement -- will use prepared statements
		String sql = "UPDATE EMPLOYEES SET "
					+ "FIRSTNAME = ?, "
					+ "LASTNAME = ?, "
					+ "USERNAME = ?, "
					+ "PASSWORD = ? WHERE EMP_ID = " + e.getEmpID();
		
		System.out.println(sql);
		
		// create connection object and use created connection to make prepared statement
		try(Connection connection = ConnectionUtil.getHardCodedConnection();
			PreparedStatement updateEmployee = connection.prepareStatement(sql))
		{
			// bind values using methods from prepared statement-- fill in the question marks
			updateEmployee.setString(1, e.getFirstname());
			updateEmployee.setString(2, e.getLastname());
			updateEmployee.setString(3, e.getUsername());
			updateEmployee.setString(4, e.getPassword());
			
			// execute query using execute update method from prepared statement
			employeesUpdated = updateEmployee.executeUpdate();
		} 
		
		catch (SQLException e1)
		{
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		// 
		
		// BE SURE TO RETURN SOMETHING HERE
		return employeesUpdated;
	}

	public int deleteEmployee(int id)
	{
		int employeesDeleted = 0;
		
		// Craft SQL statement-- will use prepared statements
		String sql = "DELETE * FROM EMPLOYEES WHERE ID = ?";
		
		// create connection and prepared statement objects using try with resources
		try(Connection connection = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement deleteEmployee = connection.prepareStatement(sql))
		{
			// bind the values in the prepared statement using prepared statement methods-- fill in the question marks
			deleteEmployee.setInt(1, id);
			
			// execute query using methods from the prepared statement
			employeesDeleted = deleteEmployee.executeUpdate();
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// BE SURE TO RETURN SOMETHING HERE
		return employeesDeleted;
	}

	public int getMaxEmpID()
	{
		// establish query string
		String sql = "SELECT MAX(EMP_ID) AS EMP_ID FROM EMPLOYEES";
		int maxID = 0;
		try
		{
			// establish connection
			Connection connection = ConnectionUtil.getHardCodedConnection();
			// use connection object to create a statement
			Statement getMaxID = connection.createStatement();
			ResultSet results = getMaxID.executeQuery(sql);
			
			while (results.next())
			{
				maxID = results.getInt("EMP_ID");
				System.out.println(maxID);
			}
			
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxID;
	}

	@Override
	public Employee viewOwnInfo(int id)
	{
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = " + id;
		Employee employee = null;
		
		// To retrieve an employee, we need a connection
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			// prepare a statement using the connection object
			Statement readStatement = connection.createStatement();
			// set a result set equal to the results of the exectuted querry
			ResultSet readResults = readStatement.executeQuery(sql);
			
			// iterate through the result set to return each field from the database
			while (readResults.next())
			{
				int employeeID = readResults.getInt("EMP_ID");
				String firstname = readResults.getString("FIRSTNAME");
				String lastname = readResults.getString("LASTNAME");
				String username = readResults.getString("USERNAME");
				String password = readResults.getString("PASSWORD");
				String position = readResults.getString("POSITION");
				
				employee = new Employee(employeeID, firstname, lastname, username, password, position);
			}
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

}

