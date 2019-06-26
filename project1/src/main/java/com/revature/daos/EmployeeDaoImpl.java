package com.revature.daos;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	//List<Employee> empList = new ArrayList<>();
	private SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy");
	
	@Override
	public ArrayList<Employee> getAllEmployees() {
		String sql = "SELECT * FROM EMPLOYEE";
		ArrayList<Employee>empList = new ArrayList<>(); //otherwise it duplicates
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			while(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("EMP_ID"));
				e.setFirstName(rs.getString("FIRSTNAME"));
				e.setLastName(rs.getString("LASTNAME"));
				e.setEmail(rs.getString("EMAIL"));
				Date bDate = rs.getDate("BIRTHDATE");
				e.setManagerId(rs.getInt("MANAGER"));
				e.setPosition(rs.getString("POSITION"));
				
				String birthdate = simpleFormat.format(bDate);
				e.setBirthDate(birthdate);
				
				empList.add(e);
				
			}
		} catch (SQLException e) {
			System.out.println("Error code : " + e.getErrorCode() + " and message " + e.getMessage());
			return null;
		}
		
		return empList;
	}

	@Override
	public Employee getEmpById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		//List<Employee>empList = new ArrayList<>(); //otherwise it duplicates
		Employee e = null;
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				Date bDate = rs.getDate("BIRTHDATE");
				int manId= rs.getInt("MANAGER");
				String pos = rs.getString("POSITION");

				
				String birthdate = simpleFormat.format(bDate);
				
				
				e = new Employee(empId, firstName, lastName, email, birthdate,
						manId, pos);
				System.out.println(e);
			}
			
		} catch (SQLException ex) {
			System.out.println("Error code: " + ex.getErrorCode());
			return null;
		}
		
		return e;
	}

	@Override
	public int addEmployee(Employee e) {
		String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?) commit";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, e.getId());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getBirthDate());
			ps.setInt(6, e.getManagerId());
			ps.setString(7, e.getPosition());
			
			ps.executeUpdate();
		} catch (SQLException ex) {			
			return ex.getErrorCode();
		}
		
		return 0;
	}
	
	
	@Override
	public int updateEmployee(Employee e) {
		String sql = "{call UPD_EMP (?,?,?,?,?,?,?)}";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql);){
			cs.setInt(1, e.getId());
			cs.setString(2, e.getFirstName());
			cs.setString(3, e.getLastName());
			cs.setString(4, e.getEmail());
			cs.setString(5, e.getBirthDate());
			cs.setInt(6, e.getManagerId());
			cs.setString(7, e.getPosition());
			
			cs.execute();
			cs.close();
		} catch (SQLException ex) {
			return ex.getErrorCode();
		}
		
		return 0; 
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "{call DEL_EMP (?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql);){
			cs.setInt(1, id);
			
			cs.execute();
			cs.close();
		} catch (SQLException ex) {
			return ex.getErrorCode();
		}
		return 0;
	}
	
}
