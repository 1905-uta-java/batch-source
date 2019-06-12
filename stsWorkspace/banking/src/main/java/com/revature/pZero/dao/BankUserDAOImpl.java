package com.revature.pZero.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pZero.model.BankAccount;
import com.revature.pZero.model.BankUser;
import com.revature.pZero.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO{

	@Override
	public BankUser login(String username, String password) {
		
		//String for query
		String sql = "SELECT * FROM BANKUSER WHERE USERNAME = ?";
		BankUser bu = null;
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				if(rs.getString("PASSWD").compareTo(password) == 0)
					bu = new BankUser(
							rs.getInt("USER_ID"),
							rs.getString("FIRSTNAME"),
							rs.getString("LASTNAME"),
							rs.getString("USERNAME"),
							rs.getString("PASSWD"),
							rs.getString("EMAIL")
					);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bu.getAccounts();
		
		
		return bu;
	}

	@Override
	public int createBankUser(BankUser b) {
		//String for query
		String sql = "INSERT INTO BANKUSER VALUES (?, ?, ?, ?, ?, ?)";
		int bankUserCreated = 0;
		int nextKey = getNextUserId();//get the next primary key available
		
		try(Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, nextKey);
			ps.setString(2, b.getFirstName());
			ps.setString(3, b.getLastName());
			ps.setString(4, b.getUsername());
			ps.setString(5, b.getPassword());
			ps.setString(6, b.getEmail());
			bankUserCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankUserCreated;
	}

	@Override
	public int updateBankUser(BankUser b) {
		int bankUserUpdated = 0;
		// String for query
		String sql = "UPDATE BANKUSER "
				+ "SET FIRSTNAME = ?, "
				+ "SET LASTNAME = ?, "
				+ "SET USERNAME = ?, "
				+ "SET PASSWD = ?, "
				+ "SET EMAIL = ? "
				+ "WHERE USER_ID = ?";
		
		try(Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, b.getId());
			ps.setString(2, b.getFirstName());
			ps.setString(3, b.getLastName());
			ps.setString(4, b.getUsername());
			ps.setString(5, b.getPassword());
			ps.setString(6, b.getEmail());
			bankUserUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bankUserUpdated;
	}
	
	public int getNextUserId() {
		int index = 0;
		
		//String for query
		String sql = "SELECT MAX(BANKUSER.USER_ID) AS COUNT FROM BANKUSER";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				PreparedStatement ps = con.prepareCall(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				index = rs.getInt("COUNT") + 1; //Get the current highest value in primary key and INCREMENT FOR NEXT PKEY
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index; //returns the next value of primary key
	}

	@Override
	public int deleteBankUser(BankUser b) {
		int bankUserDeleted = 0;
		String sql = "CALL DELETE_USER(?)";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection(); //try to establish a connection to db
				CallableStatement cs = con.prepareCall(sql)){
			cs.setInt(1, b.getId());
			bankUserDeleted = cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bankUserDeleted;
	}

}
