package com.revature.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.UserAccount;
import com.revature.util.ConnectionUtil;

public class UserAccountDaoImpl implements UserAccountDao{
	
	List<UserAccount> users = new ArrayList<>();

	@Override
	public List<UserAccount> getUserAccounts() {
		List<UserAccount> users = new ArrayList<>();
		
		String sql = "SELECT * FROM USERACCOUNTS";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			
			while(rs.next()) {
				UserAccount u = new UserAccount();
				int id = rs.getInt("UA_ID");
				u.setId(id);
				String username = rs.getString("UA_USERNAME");
				u.setUsername(username);
				String password = rs.getString("UA_PASSWORD");
				u.setPassword(password);
				int isManager = rs.getInt("UA_ISMANAGER");
				u.setIsManager(isManager);
				
				users.add(u);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}
	
	public UserAccount authenticatedUser(String username, String password, List<UserAccount> users) {
		for (UserAccount u: users) {
			if (u.getUsername()!=null && u.getUsername().equals(username)) {
				if (u.getPassword()!=null && u.getPassword().equals(password)) {
					return u;
				}
			}
		}
		System.out.println("Not Returning User");
		return null;
	}

	// ---------------- CREATE USER ACCOUNT --------------
	@Override
	public int createUserAccount(UserAccount u) {
		int userAccountCreated = 0;
		
		String sql = "INSERT INTO USERACCOUNTS VALUES (?,?,?,?)";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getIsManager());
			
			userAccountCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return userAccountCreated;
	}
	
	
// ------------------- UPDATE USER ACCOUNT ------------------
	@Override
	public int updateUserAccount(UserAccount u, int id) {
		int userUpdated = 0;
		String sql = "UPDATE USERACCOUNTS" 
				+ " SET UA_USERNAME = ?, "
				+ " UA_PASSWORD = ?, "
				+ " UA_ISMANAGER = ?"
				+ " WHERE UA_ID = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getIsManager());
			ps.setInt(4, id);

			
			userUpdated = ps.executeUpdate();
			System.out.println("User Updated");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return userUpdated;
	}

	@Override
	public int deleteUserAccount(int id) {
		int userRemoved = 0;
		String sql = "DELETE FROM USERACCOUNTS WHERE UA_ID = ?";
		UserAccount u = new UserAccount();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			
			System.out.println("User Deleted");
			userRemoved = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return userRemoved;
	}

	@Override
	public UserAccount getUserAccountByUsername(String userName) {
		UserAccount u = new UserAccount();

		String sql = "SELECT * FROM USERACCOUNTS WHERE UA_USERNAME = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("UA_ID");
				u.setId(id);
				String username = rs.getString("UA_USERNAME");
				u.setUsername(username);
				String password = rs.getString("UA_PASSWORD");
				u.setPassword(password);
				int isManager = rs.getInt("UA_ISMANAGER");
				u.setIsManager(isManager);
				
				u = new UserAccount(id, username, password, isManager);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}
	
	

}
