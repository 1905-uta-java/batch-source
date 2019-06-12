package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.UniqueUser;
import com.revature.util.ConnectionUtil;

public class UniqueUserDAOImpl implements UniqueUserDAO{

	@Override
	public List<String> getAllUserNames() {
		String sql = "SELECT USERNAME FROM UNIQUEUSER";
		List<String> users = new ArrayList<>();
		
		try (Connection conMan = ConnectionUtil.getHardCodedConnection();
				Statement s = conMan.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				String currUser = rs.getString("USERNAME");
				users.add(currUser);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public UniqueUser getUser(int id) {
		String sql = "SELECT * FROM UNIQUEUSER WHERE USER_ID = ?";
		UniqueUser user = null;
		
		try (Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int uId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int pId = rs.getInt("PROFILE_ID");
				ProfileAccDAO prof = new ProfileAccDAOImpl();
				user = new UniqueUser(uId, username, password, prof.getProfile(pId));
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public int checkCreds(String username, String password) {
		String sql = "SELECT USER_ID FROM UNIQUEUSER WHERE USERNAME = ? AND PASSWORD = ?";
		int uId = 0;
		try(Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 uId = rs.getInt("USER_ID");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong...");
			uId =  -1;
		}
		return uId;
	}

	/*createUser should use a callable statement to call a stored procedure which executes 
	 * a transaction that inserts a user record into the UNIQUE_USER table and a profile record into the PROFILE_INFO table(non-Javadoc)
	 * @see com.revature.dao.UniqueUserDAO#createUser()
	 */
	@Override
	public boolean createUser(String username, String password) {
		String sql = "{CALL CREATEUSER(?,?,?)}";
		boolean success = false;
		//int increment will be a variable that finds the length of a result set and increments by 1 to create a unique id
		int increment = getAllUserNames().size() +1;
		try (Connection conMan = ConnectionUtil.getHardCodedConnection();
				CallableStatement ps = conMan.prepareCall(sql)){
			ps.setInt(1, increment);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.executeQuery();
			
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		
		
		return success;
	}

}
