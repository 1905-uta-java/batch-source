package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	/*
	 * Returns all users in DB inside List
	 * */
	@Override
	public List<User> getUsers() {
		List<User> accounts = new ArrayList<>();
		
		String sqlStr = "SELECT * FROM ACCOUNTS";
		
		//try with resources
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sqlStr);){
			
			while(rs.next()) {
				int accId = rs.getInt("ACC_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String email = rs.getString("EMAIL");
				String firstName = rs.getString("F_NAME");
				String lastName = rs.getString("L_NAME");
				
				accounts.add(new User(accId, username, password, email, firstName, lastName));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	/*
	 * Retrieves a single user from the DB
	 * */
	@Override
	public User getSingleUser(String username) {
		String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ?";
		User a = null;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accNum = rs.getInt("ACC_ID");
				String outUsername = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String email = rs.getString("EMAIL");
				String firstName = rs.getString("F_NAME");
				String lastName = rs.getString("L_NAME");
				
				a = new User(accNum, username, password, email, firstName, lastName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/*
	 * Creates a user in the DB
	 * */
	@Override
	public int createUser(User u) {
		int id = getNewAccNum();
		int accountsCreated = 0;
		String sql = "INSERT INTO ACCOUNTS VALUES (?,?,?,?,?,?)";
		
		// set a unique id
		u.setId(id);
		//first, check to make sure that username is not taken and is unique
		
		if(checkUsername(u.getUsername())) {
			System.out.println("Username " + u.getUsername() + " is taken");
		} else {
			try (Connection con = ConnectionUtil.getHardCodedConnection();
					PreparedStatement ps = con.prepareStatement(sql)){
				
				
				ps.setInt(1, id);
				ps.setString(2, u.getUsername());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getEmail());
				ps.setString(5, u.getFirstName());
				ps.setString(6, u.getLastName());
				
				accountsCreated = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accountsCreated;
	}
	
	
	
	/*
	 * 
	 * Make sure that the username you're about to set is unique
	 * 
	 * */
	public boolean checkUsername(String usrChk) {
		String username = "";
		String sql = "SELECT USERNAME FROM ACCOUNTS WHERE USERNAME = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, usrChk);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				username = rs.getString("USERNAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return username.equals(usrChk);
	}
	
	
	/*
	 * Checks with the DB and returns boolean if entered password matches with password in DB
	 * */
	public boolean checkPassword(String usrChk, String password) {
		String chkPass = "";
		String sql = "SELECT PASSWORD FROM ACCOUNTS WHERE USERNAME = ?";
		
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, usrChk);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				chkPass = rs.getString("PASSWORD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password.equals(chkPass);
	}

	
	
	/*
	 * Gets the top Account and then iterates it for a new, unique, ID
	 * 
	 * */
	public int getNewAccNum() {
		int newAccNum = 0;
		String sql = "SELECT MAX(ACC_ID) AS ID FROM ACCOUNTS";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				newAccNum = rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ++newAccNum;
	}
}
