package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Profile;
import com.revature.utils.ConnectionUtil;

public class ProfileDAOImpl implements ProfileDAO{

	private List<String> userNames = new ArrayList<>();
	@Override
	public List<String> getUsernames() {
		String sql = "SELECT USERNAME FROM PROFILE";
				
		try(Connection con = ConnectionUtil.getHardCodedConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);){
				
		while(rs.next()) {
			String user = rs.getString("USERNAME");
			userNames.add(user);
		}
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting all usernames");
		}
		return userNames;
	}

	@Override
	public Profile getUser(String username, String password) {
		String sql = "SELECT * FROM PROFILE WHERE USERNAME = ? AND PASSWORD = ?";
		Profile prof = null;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String user = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				int empId = rs.getInt("EMP_ID");
				prof = new Profile(user, pass, empId);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error finding user");
		}
		
		return prof;
	}
	@Override
	public Profile getUserById(int id) {
		String sql = "SELECT * FROM PROFILE WHERE EMP_ID = ?";
		Profile prof = null;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String user = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				int empId = rs.getInt("EMP_ID");
				prof = new Profile(user, pass, empId);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error finding user");
		}
		
		return prof;
	}

	@Override
	public int createProfile(String username, String password, int empId) {
		String sql = "INSERT INTO PROFILE VALUES(? , ? , ?)";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  username);
			ps.setString(2, password);
			ps.setInt(3, empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creating new profile");
			return 0;
		}
		return 1;
	}

	@Override
	public int setPassword(String password, int empId) {
		String sql = "UPDATE PROFILE SET PASSWORD = ? WHERE EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  password);
			ps.setInt(2,  empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating password");
			return 0;
		}
		return 1;
	}

	@Override
	public int setUsername(String newusername, int empId) {
String sql = "UPDATE PROFILE SET USERNAME = ? WHERE EMP_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  newusername);
			ps.setInt(2,  empId);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating username");
			return 0;
		}
		return 1;
	}
	
	

}
