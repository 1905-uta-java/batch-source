package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	List<User> users = new ArrayList<>();

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM LOGIN";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String createDate = rs.getString("CREATE_DATE");
				int empId = rs.getInt("EMP_ID");
				String userRole = rs.getString("USER_ROLE");
				String token = username + ":" + empId;
				
				users.add(new User(username, password, createDate, empId, userRole, token));
			}
		} catch (SQLException e) {
			System.out.println("Error code: " + e.getErrorCode());
			return null;
		}

		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		String sql= "SELECT * FROM LOGIN WHERE USERNAME = ?";
		User u = null;

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1,  username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String createDate = rs.getString("CREATE_DATE");
				int empId = rs.getInt("EMP_ID");
				String userRole = rs.getString("USER_ROLE");
				String token = username + ":" + empId;
				
				u = new User(username, password, createDate, empId, userRole, token);
			}
			
		} catch (SQLException e) {
			System.out.println("Error code: " + e.getErrorCode());
			return null;
		}
		
		return u;
	}
	
	
	@Override
	public int createUser(User u) {
		String sql = "INSERT INTO LOGIN VALUES (?, ?, ?, ?, ?)";
		int createdCode = 0;
		//DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		//Date date = new Date();
		//String sendDate = dateFormat.format(date);//TODO - this may cause errors
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getCreateDate());
			ps.setInt(4, u.getEmployeeId());
			ps.setString(5, u.getUserRole());
			
			createdCode = ps.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println(e.getErrorCode());
			//return e.getErrorCode();
		}
		
		return createdCode;
	}

	@Override
	public boolean checkUsername(String username) {
		String userCheck = "";
		String sql = "SELECT USERNAME FROM LOGIN WHERE USERNAME = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userCheck = rs.getString("USERNAME");
			}
			
		} catch (SQLException e) {
			System.out.println("Error code: " + e.getErrorCode());
			return false;
		}
		
		return username.equals(userCheck);
	}

	@Override
	public boolean checkPassword(String username, String password) {
		String passCheck = "";
		String sql = "SELECT PASSWORD FROM LOGIN WHERE PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				passCheck = rs.getString("PASSWORD");
			}
			
		} catch (SQLException e) {
			System.out.println("Error code: " + e.getErrorCode());
			return false;
		}
		
		return password.equals(passCheck);
	}
	
	@Override
	public int updateLogin(User u) {
		String sql = "{call UPD_LOGIN (?,?,?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql);){
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getUserRole());
			
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
		}
		return 0;
	}

	@Override
	public int deleteAccount(String username) {
		String sql = "{call DEL_LOGIN(?)}";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql);){
			cs.setString(1, username);
			
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			return e.getErrorCode();
		}
		return 0;
	}

	public User authenticatedUser(String username, String password) {
		if(checkUsername(username)) {
			if(checkPassword(username, password)) {
				return getUserByUsername(username);
				
			}
		}
		return null;
	}

	
	
	
}
