package com.bankname.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bankname.model.BankUser;
import com.bankname.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class BankUserDaoImpl implements BankUserDao{

	//Get all the users in the Bank_User Table
	@Override
	public List<BankUser> getBankUsers() {
		//Store the users into the array
				List<BankUser> users = new ArrayList<>();
				
				//SQL Statement to get all from Bank User
				String sql = "SELECT * FROM BANK_USER";
				
				//Try connecting to the database and Run SQL
				try(Connection con = ConnectionUtil.getConnection();
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery(sql);){
					
					//Get the information from SQL and put into an BankUser Object
					while(rs.next()) {
						int userID = rs.getInt("USER_ID");
						String email = rs.getString("EMAIL");
						String passwordHash = rs.getString("PASSWORD_HASH");
						
						//Add the account to the list
						users.add(new BankUser(userID,email,passwordHash));
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				
				return users;
	}

	//Get the user information from the table using userID
	@Override
	public BankUser getBankUserById(int userID) {
		BankUser user = null;
		
		//SQL statement to get the Bank User by the userID
		String sql = "SELECT * FROM BANK_USER WHERE USER_ID = ?";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
					
			//Get the information from SQL and put into an BankUser Object
			while(rs.next()) {
				int thisUserID = rs.getInt("USER_ID");
				String email = rs.getString("EMAIL");
				String passwordHash = rs.getString("PASSWORD_HASH");
						
				//Create the Account Object
				user = new BankUser(thisUserID,email,passwordHash);
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}

	//Get the Bank User Account by the email
	@Override
	public BankUser getBankUserByEmail(String email) {
		BankUser user = null;
		
		//SQL statement to get the Bank User by the email
		String sql = "SELECT * FROM BANK_USER WHERE EMAIL = ?";
		
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
					
			//Get the information from SQL and put into an BankUser Object
			while(rs.next()) {
				int userID = rs.getInt("USER_ID");
				String thisEmail = rs.getString("EMAIL");
				String passwordHash = rs.getString("PASSWORD_HASH");
						
				//Create the Account Object
				user = new BankUser(userID,thisEmail,passwordHash);
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	//Create a Bank User table record 
	@Override
	public int createBankUser(BankUser b) {
		int usersCreated = 0;
		
		//SQL statement to add a new user
		String sql = "INSERT INTO BANK_USER VALUES (?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, b.getUserID());
			ps.setString(2, b.getEmail());
			ps.setString(3, b.getPassword());
			
			usersCreated = ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return usersCreated;
	}

	//Update a Bank User table record
	@Override
	public int updateBankUser(BankUser b) {
		int usersUpdated = 0;
		
		//SQL statement to update a user
		String sql = "UPDATE BANK_USER "
				+ "EMAIL = ?, "
				+ "PASSWORD_HASH = ? "
				+ "WHERE USER_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(3, b.getUserID());
			ps.setString(1, b.getEmail());
			ps.setString(2, b.getPassword());
			
			usersUpdated = ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return usersUpdated;
	}

	//Delete a Bank User table record
	@Override
	public int deleteBankUser(int userID) {
		int rowsDeleted = 0;
		//SQL statement to Delete accounts from accounts on USER_ID
		String sql1 = "DELETE FROM ACCOUNT WHERE USER_ID = ?";
		
		//SQL statement to Delete an user based on USER_ID
		String sql2 = "DELETE FROM BANK_USER WHERE USER_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps1 = con.prepareStatement(sql1);
				PreparedStatement ps2 = con.prepareStatement(sql2)){
			
			ps1.setInt(1, userID);
			ps2.setInt(1, userID);
			rowsDeleted = ps1.executeUpdate();
			rowsDeleted = ps2.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		return rowsDeleted;
	}
	
	//Get the next available UserID from the Bank User table
	@Override
	public int getNextBankUserID() {
		//SQL Call statement to call a stored procedure
		String sql = "{? = call GET_NEXT_USER_ID}";
		
		//Hold the value given
		int maxUserID = 0;
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				){
			
			//Get the result set
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			//Get the result as an integer
			while(rs.next()) {
				maxUserID = rs.getInt("MAX(USER_ID)");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return maxUserID+1;
	}

}
