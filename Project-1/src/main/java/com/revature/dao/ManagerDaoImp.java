package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerDaoImp implements ManagerDao {

	public List<Manager> getManagers() {
		List<Manager> managers = new ArrayList<Manager>();
		
		String sql = "SELECT * FROM MANAGER_TB";
		
		// Attempt to retrieve the Manager from the table
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int manId = rs.getInt("MANAGERID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("MANUSERNAME");
				String pWord = rs.getString("MANPASSWORD");
				String eMail = rs.getString("EMAIL");
				managers.add(new Manager(manId, fName, lName, uName, pWord, eMail));
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve all managers");
		}
		return managers;
	}

	public Manager getManagerById(int id) {
		String sql = "SELECT * FROM MANAGER_TB WHERE MANAGERID = ?";
		Manager man = null;

		// Attempt to retrieve the specified Manager from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int manId = rs.getInt("MANAGERID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("MANUSERNAME");
				String pWord = rs.getString("MANPASSWORD");
				String eMail = rs.getString("EMAIL");
				man = new Manager(manId, fName, lName, uName, pWord, eMail);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve the manager by their id");
		}
		return man;
	}
	
	public Manager getManagerByLogin(String mName, String mWord) {
		String sql = "SELECT * FROM MANAGER_TB WHERE MANUSERNAME = ?";
		Manager man = null;

		// Attempt to retrieve the specified Manager from the table
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1,  mName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int manId = rs.getInt("MANAGERID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String uName = rs.getString("MANUSERNAME");
				String pWord = rs.getString("MANPASSWORD");
				String eMail = rs.getString("EMAIL");
				if(pWord.equals(mWord)) {
					man = new Manager(manId, fName, lName, uName, pWord, eMail);
				}
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Failed to retrieve the manager by their login information");
		}
		return man;
	}

	public int createManager(Manager m) {
		int manCreated = 0;
		String sql = "INSERT INTO MANAGER_TB VALUES (?,?,?,?,?,?)";
		
		// Attempt to insert the new Manager
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, m.getId());
			ps.setString(2,  m.getFirstName());
			ps.setString(3, m.getLastName());
			ps.setString(4, m.getUserName());
			ps.setString(5, m.getPassWord());
			ps.setString(6, m.geteMail());
			manCreated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to create a new manager");
		}
		return manCreated;
	}

	public int deleteManager(int id) {
		int rowsDel = 0;
		String sql = "DELETE FROM MANAGER_TB WHERE MANAGERID = ?";
		
		// Attempt to delete the specified Manager
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,  id);
			rowsDel = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to delete the manager");
		}
		return rowsDel;
	}

	public int changeEmail(int id, String eMail) {
		int manUpdated = 0;
		String sql = "UPDATE MANAGER_TB " + 
				"SET EMAIL = ? " + 
				"WHERE MANAGERID = ?";
		
		// Attempt to update the email of the Manager
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, eMail);
			ps.setInt(2, id);
			manUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to change the manager's email");
		}
		return manUpdated;
	}
	
	public int changePWord(int id, String pWord) {
		int manUpdated = 0;
		String sql = "UPDATE MANAGER_TB " + 
				"SET MANPASSWORD = ? " + 
				"WHERE MANAGERID = ?";
		
		// Attempt to update the password of the Manager
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, pWord);
			ps.setInt(2, id);
			manUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to change the manager's password");
		}
		return manUpdated;
	}
	
	public int changeUName(int id, String uName) {
		int manUpdated = 0;
		String sql = "UPDATE MANAGER_TB " + 
				"SET MANUSERNAME = ? " + 
				"WHERE MANAGERID = ?";
		
		// Attempt to update the username of the Manager
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, uName);
			ps.setInt(2, id);
			manUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to change the manager's username");
		}
		return manUpdated;
	}

}
