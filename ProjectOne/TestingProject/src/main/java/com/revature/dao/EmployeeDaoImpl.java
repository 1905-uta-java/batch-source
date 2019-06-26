package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;


public class EmployeeDaoImpl {

	
	Employee e = new Employee();

	
	public List<Employee> getEmployees() {
		List<Employee> employee = new ArrayList<>();
		String sql = "SELECT * FROM MANAGER";
		try(Connection con = ConnectionUtil.HardCodedConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				e.setId(id);
				String email = rs.getString("EMAIL");
				e.setEmail(email);
				String password = rs.getString("PASSWORD");
				e.setPassword(password);
				String Position = rs.getString("POSITION");
				e.setPosition(Position);
				double reimburstment= rs.getDouble("REIMBURSTMENT");
				e.setReimburstment(reimburstment);
				String status = rs.getString("STATUS");
				e.setStatus(status);
				employee.add(new Employee(id,email,password,Position,reimburstment,status));
				
			}
			
		}catch(Exception e1) {
			System.out.println("Error : "+e1.getMessage());
		}
		return employee;
	}

	
	public List<Employee> getEmployeesByStatus() {
		List<Employee> employee = new ArrayList<>();
		String sql = "select * from manager where status = 'Pending'";
		try(Connection con = ConnectionUtil.HardCodedConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				e.setId(id);
				String email = rs.getString("EMAIL");
				e.setEmail(email);
				String password = rs.getString("PASSWORD");
				e.setPassword(password);
				String Position = rs.getString("POSITION");
				e.setPosition(Position);
				double reimburstment= rs.getDouble("REIMBURSTMENT");
				e.setReimburstment(reimburstment);
				String status = rs.getString("STATUS");
				e.setStatus(status);
				employee.add(new Employee(id,email,password,Position,reimburstment,status));
				
			}
			
		}catch(Exception e1) {
			System.out.println("Error : "+e1.getMessage());
		}
		return employee;
	}

	public boolean AuthenticatedUser(String email,String Password) {
		
		boolean auth = true;
		
		String sql="SELECT * FROM MANAGER WHERE email=? AND PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.HardCodedConnection();
			PreparedStatement ps  = con.prepareStatement(sql)) {
			ps.setString(1, email );
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			
			auth= rs.next();
			System.out.println("Auth : "+auth);
			
		}catch(Exception e ) {
			
			System.out.println("Error: "+e.getMessage());
		}
		
		
		return auth;
		
	}
	
	public boolean AuthenticatedPosition(String position,String email) {
			
			boolean auth = true;
			
			String sql="SELECT * FROM MANAGER WHERE POSITION=? AND EMAIL=?";
			
			try(Connection con = ConnectionUtil.HardCodedConnection();
				PreparedStatement ps  = con.prepareStatement(sql)) {
				ps.setString(1, position);
				ps.setString(2, email);
				ResultSet rs = ps.executeQuery();
				
				auth= rs.next();
				System.out.println("Auth : "+auth);
				
			}catch(Exception e ) {
				
				System.out.println("Error: "+e.getMessage());
			}
			
			
			return auth;
			
		}

	
	public int CreateEmployee(Employee eRef) {
		int UserCreated=0;
		
		String sql = "INSERT INTO MANAGER VALUES(NULL,?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.HardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			//ps.setInt(1, eRef.getId());
			ps.setString(1, eRef.getEmail());
			ps.setString(2, eRef.getPassword());
			ps.setString(3, eRef.getPosition());
			ps.setDouble(4, eRef.getReimburstment());
			ps.setString(5,eRef.getStatus());
			
			UserCreated = ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		
		return UserCreated;
	}

	
	public int updateEmployee(String email) {
		Employee employee = new Employee();
		int updateEmployee=0;
		String sql = "UPDATE MANAGER SET ID=?, PASSWORD=?,POSITION=?,reimburstment=?,STATUS=? WHERE EMAIL= ?";
		try(Connection con =ConnectionUtil.HardCodedConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getPosition());
			ps.setDouble(4, employee.getReimburstment());
			ps.setString(5, employee.getStatus());
			ps.setObject(6, email);
			
			updateEmployee = ps.executeUpdate();		
			
		}catch(Exception e1) {
			System.out.println("Error: "+e1.getMessage());
		}
		
		return updateEmployee;
	}
	
	public int updateReimburstment(double amount,String status,String email) {
		Employee employee = new Employee();
		int updateEmployee=0;
		String sql = "UPDATE MANAGER SET reimburstment=?, STATUS=? WHERE EMAIL= ?";
		try(Connection con =ConnectionUtil.HardCodedConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, amount);
			ps.setString(2, status);
			ps.setObject(3, email);
			
			updateEmployee = ps.executeUpdate();		
			
		}catch(Exception e1) {
			System.out.println("Error: "+e1.getMessage());
		}
		
		return updateEmployee;
	}
	
	public int updateEmployee2(String password,String email) {
		Employee employee = new Employee();
		int updateEmployee=0;
		String sql = "UPDATE MANAGER SET PASSWORD=? WHERE EMAIL= ?";
		try(Connection con =ConnectionUtil.HardCodedConnection(); 
			PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, password);
			ps.setString(2, email);
			
			updateEmployee = ps.executeUpdate();		
			
		}catch(Exception e1) {
			System.out.println("Error: "+e1.getMessage());
		}
		
		return updateEmployee;
	}

	
	public int deleteEmployee(String email) {
		
		int deleteEmployee=0;
		String sql = "delete from manager where email = ?";
		try(Connection con = ConnectionUtil.HardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			deleteEmployee=ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		return deleteEmployee;
	}
	
}
