package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.UserAccount;
import com.revature.util.ConnectionUtil;

public class UserAccountDaoImpl implements UserAccountDao{

	@Override
	public int createUserAccount(UserAccount u) {		
		int userAccountsCreated = 0;
		
		String sql = "INSERT INTO USERACCOUNT VALUES (?,?,?)";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql))
		{
			
			cs.setInt(1, u.getId());
			cs.setString(2, u.getUsername());
			cs.setString(3, u.getPassword());
			
			userAccountsCreated = cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userAccountsCreated;
	}


	@Override
	public int updateUserAccount(UserAccount u) {
		int userAccountsUpdated = 0;
		String sql = "UPDATE USERACCOUNT" 
				+ "SET USERID = ?, "
				+ "USERNMAE = ?, "
				+ "PASSWORD = ?";
		
			return 0;
	}

	@Override
	public int deleteUserAccount(UserAccount u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserAccount> getUserAccounts() {
		List<UserAccount> users = new ArrayList<>();
		
		String sql = "SELECT * FROM USERACCOUNT";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			
			while(rs.next()) {
				UserAccount u = new UserAccount();
				int userId = rs.getInt("USERID");
				u.setId(userId);
				String username = rs.getString("USERNAME");
				u.setUsername(username);
				String userPass = rs.getString("USERPASS");
				u.setPassword(userPass);
	
				users.add(u);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}


	@Override
	public UserAccount getUserAccountByID(int id) {
		UserAccount u = new UserAccount();
		String sql = "SELECT * FROM USERACCOUNT WHERE USERID = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall(sql)) {
			
			cs.setInt(1, id);
			
			cs.execute();
			
//			while (rs.next()) {
//				int userId = rs.getInt("USERID");
//				u.setId(userId);
//				String username = rs.getString("USERNAME");
//				u.setUsername(username);
//				String password = rs.getString("USERPASS");
//				u.setPassword(password);
//
//				
//				u = new UserAccount(userId, username, password);
//				
//			}
//			rs.close();
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return u;
	}

}
