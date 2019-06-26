package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.company.model.Employee;
import com.company.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	//Get all employees
	@Override
	public List<Employee> getEmployees() {
		//Store all the employees and store in a list
		List<Employee> employees = new ArrayList<>();
		
		//SQL statement to get all the employees from Employee
		String sql = "SELECT * FROM EMPLOYEE";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);){
					
			//Get the information from SQL and put into a employee Object
			while(rs.next()) {
				
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				int empID = rs.getInt("EMP_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				long phone = rs.getLong("PHONE");
				int managID = rs.getInt("MANAGER_ID");
						
				//Add the employee to the list
				employees.add(new Employee(email,password,empID,firstName,lastName,phone,managID));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
		return employees;
	}

	//Get employees by empId
	@Override
	public Employee getEmployeeByEmpId(int empId) {
		//Store all the employees and store in a list
		Employee employee = new Employee();
		
		//SQL statement to get all the employees from Employee
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
	
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
				
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();		
				
			//Get the information from SQL and put into an Employee Object
			while(rs.next()) {
				
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				int empID = rs.getInt("EMP_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				long phone = rs.getLong("PHONE");
				int managID = rs.getInt("MANAGER_ID");
							
				//Add the employee to the list
				employee = new Employee(email,password,empID,firstName,lastName,phone,managID);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
		return employee;
	}

	//Get employees by email
	@Override
	public Employee getEmployeeByEmail(String email) {
		//Store all the employees and store in a list
		Employee employee = new Employee();
		
		//SQL statement to get all the employees from Employee
		String sql = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?";
	
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
				
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();		
				
			//Get the information from SQL and put into an Employee Object
			while(rs.next()) {
				
				String Email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				int empID = rs.getInt("EMP_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				long phone = rs.getLong("PHONE");
				int managID = rs.getInt("MANAGER_ID");
							
				//Add the employee to the list
				employee = new Employee(Email,password,empID,firstName,lastName,phone,managID);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
		return employee;
	}

	//get all employees a manager has
	@Override
	public List<Employee> getEmployeesByManager(int mangId) {
		//Store all the employees and store in a list
		List<Employee> employees = new ArrayList<>();
		
		//SQL statement to get all the employees from Employee
		String sql = "SELECT * FROM EMPLOYEE WHERE MANAGER_ID = ?";
	
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
				
			ps.setInt(1, mangId);
			ResultSet rs = ps.executeQuery();		
				
			//Get the information from SQL and put into an Employee Object
			while(rs.next()) {
				
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				int empID = rs.getInt("EMP_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				long phone = rs.getLong("PHONE");
				int managID = rs.getInt("MANAGER_ID");
							
				//Add the employee to the list
				employees.add(new Employee(email,password,empID,firstName,lastName,phone,managID));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
		return employees;
	}

	//Create a new employee
	@Override
	public int createEmployee(Employee e) {
		int employeeCreated = 0;
		
		//SQL statement to add a new employee
		String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());
			ps.setInt(3, e.getEmpId());
			ps.setString(4, e.getFirstName());
			ps.setString(5, e.getLastName());
			ps.setLong(6, e.getPhoneNumber());
			ps.setInt(7, e.getManagerId());
			
			employeeCreated = ps.executeUpdate();
		
		}catch(SQLException x){
			x.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return employeeCreated;
	}

	//Update a current employee
	@Override
	public int updateEmployee(Employee e) {
		int employeeUpdated = 0;
		
		//SQL statement to update an employee
		String sql = "UPDATE EMPLOYEE "
						+ "SET EMP_ID = ?, "
						+ "PASSWORD = ?, "
						+ "FIRST_NAME = ?, "
						+ "LAST_NAME = ?, "
						+ "PHONE = ?," 
						+ "MANAGER_ID = ?"
						+ "WHERE EMAIL = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(7, e.getEmail());
			ps.setString(2, e.getPassword());
			ps.setInt(1, e.getEmpId());
			ps.setString(3, e.getFirstName());
			ps.setString(4, e.getLastName());
			ps.setLong(5, e.getPhoneNumber());
			ps.setInt(6, e.getManagerId());
			
			employeeUpdated = ps.executeUpdate();
		
		}catch(SQLException x){
			x.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return employeeUpdated;
	}

	//Delete an employee
	@Override
	public int deleteEmployee(int EmpId) {
		int rowsDeleted = 0;
		
		//SQL statement to Delete an employee based on id
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, EmpId);
			rowsDeleted = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return rowsDeleted;
	}
	
	//Get the next available employee ID;
	@Override
	public int getNextEmployeeID() {
		List<Employee> employees = getEmployees();
		int newId;

		Collections.sort(employees,new Comparator<Employee>() {

			public int compare(Employee e1, Employee e2) {
				String e1id = Integer.toString(e1.getEmpId());
				String e2id = Integer.toString(e2.getEmpId());
				int last5Digitse1;
				int last5Digitse2;
				
				if(e1.getEmpId() < 99999) {
					last5Digitse1 = e1.getEmpId();
				}else {
					last5Digitse1 = Integer.parseInt(e1id.substring(1));
				}
				
				if(e2.getEmpId() < 99999) {
					last5Digitse2 = e2.getEmpId();
				}else {
					last5Digitse2 = Integer.parseInt(e2id.substring(1));
				}
				
				
			    return Integer.compare(last5Digitse1, last5Digitse2);
			}
		});

		if(employees.get(employees.size()-1).getEmpId() >99999) {
			String strId = Integer.toString(employees.get(employees.size()-1).getEmpId());
			newId = Integer.parseInt(strId.substring(1));
		}else {
			newId = employees.get(employees.size()-1).getEmpId();
		}
		
		return newId;
	}

	//Change just the password of an employee
	@Override
	public int changePassword(int id, String password) {
		int employeeUpdated = 0;
		
		//SQL statement to update an employee
		String sql = "UPDATE EMPLOYEE "
						+ "SET PASSWORD = ? "
						+ "WHERE EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, password);
			ps.setInt(2, id);

			
			employeeUpdated = ps.executeUpdate();
		
		}catch(SQLException x){
			x.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employeeUpdated;
		
	}

}
