package com.revature.accountdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.accountmodel.User;
import com.revature.accountutil.ConnectionUtil;

//Class to implement the AccountDao interface
public class UserDaoImp implements UserDao {

	// ADMIN METHOD
	// Get a list of the users in the table
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		String sql = "SELECT * FROM USER_TABLE";
		
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int userId = rs.getInt("USERID");
				String uName = rs.getString("USERNAME");
				String pWord = rs.getString("USERPASSWORD");
				String eMail = rs.getString("EMAIL");
				users.add(new User(userId, uName, pWord, eMail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	// Get a user from the table by the user id
	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM USER_TABLE WHERE USERID = ?";
		User u = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USERID");
				String uName = rs.getString("USERNAME");
				String pWord = rs.getString("USERPASSWORD");
				String eMail = rs.getString("EMAIL");
				u = new User(userId, uName, pWord, eMail);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	//Get a user from the table by the username
	@Override
	public User getUserByLogin(String usName, String paWord) {
		String sql = "SELECT * FROM USER_TABLE WHERE USERNAME = ? AND USERPASSWORD = ?";
		User u = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1,  usName);
			ps.setString(2, paWord);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USERID");
				String uName = rs.getString("USERNAME");
				String pWord = rs.getString("USERPASSWORD");
				String eMail = rs.getString("EMAIL");
				u = new User(userId, uName, pWord, eMail);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	// Create a user and insert it into the table
	@Override
	public int createUser(User u) {
		int userCreated = 0;
		String sql = "INSERT INTO USER_TABLE VALUES (?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, u.getId());
			ps.setString(2,  u.getuName());
			ps.setString(3, u.getpWord());
			ps.setString(4, u.geteMail());
			userCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userCreated;
	}

	// Delete a user, specified by its id, from the table
	@Override
	public int deleteUser(int id) {
		int rowsDel = 0;
		String sql = "DELETE FROM USER_TABLE WHERE USERID = ?";
		
		// Attempt to delete the specified user
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			rowsDel = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDel;
	}

	// Change the specified user's password
	@Override
	public int changePassword(User u) {
		int userUpdated = 0;
		String sql = "UPDATE USER_TABLE " + 
				"USERPASSWORD = ?, " +
				"WHERE USERID = ?";
		
		// Attempt to update the password of the specified user
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, u.getpWord());
			ps.setInt(2, u.getId());
			userUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userUpdated;
	}

	// Change the specified user's username
	@Override
	public int changeUsername(User u) {
		int userUpdated = 0;
		String sql = "UPDATE USER_TABLE " + 
				"SET USERNAME = ?, " +
				"WHERE USERID = ?";
		
		// Attempt to update the username of the specified user
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1,  u.getuName());
			ps.setInt(2, u.getId());
			userUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userUpdated;
	}

	// Change the specified user's email
	@Override
	public int changeEmail(User u) {
		int userUpdated = 0;
		String sql = "UPDATE USER_TABLE " +
				"EMAIL = ? " + 
				"WHERE USERID = ?";
		
		// Attempt to update the information of the specified user
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, u.geteMail());
			ps.setInt(2, u.getId());
			userUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userUpdated;
	}

}
