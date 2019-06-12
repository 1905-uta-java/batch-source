package com.banking.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.banking.util.ConnectionUtil;
import com.banking.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean createUser(String name, String password) {
		boolean created = false;
		
		String sql = "CREATE USER " + name + " IDENTIFIED BY " + password;
		int flag = 0;
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			flag++;
		} catch (SQLException e) {
			e.getMessage();
		}

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall("{call user_info(?)}")) {
			cs.setString(1, name);
			cs.execute();
			flag++;
		} catch (SQLException e) {
			e.getMessage();
		}
		
		if (flag == 2) {
			System.out.println("User created");
			created = true;
		}
		return created;
	}

	@Override
	public boolean isAvailable(String name) {
		boolean isAvailable = true;
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				CallableStatement cs = con.prepareCall("{? = call existuser(?)}")) {
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, name.toUpperCase());
			cs.execute();
			int output = cs.getInt(1);
			if (output == 1)
				isAvailable = false;
		} catch (SQLException e) {
			e.getMessage();
		}
		return isAvailable;
	}

	@Override
	public double checkBalance(String name) {
		double balance = 0.0;
		String sql = "SELECT BALANCE FROM MANTU." + name + "_INFO WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble("BALANCE");
				System.out.println("Your balance is: $" + balance);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public int deposit(String name, double amount) {
		int rowsAffected = 0;
		String deposit = "UPDATE MANTU." + name + "_info SET BALANCE = BALANCE + " + amount + " WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(deposit)) {
			ps.setString(1, name);
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rowsAffected > 0) {
			System.out.println(checkBalance_forDeposit(name));
		}
		return rowsAffected;
	}
	
	@Override
	public int transfer(String name, double amount) {
		int rowsAffected = 0;
		String deposit = "UPDATE MANTU." + name + "_info SET BALANCE = BALANCE + " + amount + " WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(deposit)) {
			ps.setString(1, name);
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	
	@Override
	public double checkBalance_forDeposit(String name) {
		double balance = 0.0;
		String sql = "SELECT BALANCE FROM MANTU." + name + "_INFO WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			balance = rs.getDouble("BALANCE");
			System.out.print("Transaction succeeded. Your new balance is: $");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}
	

	@Override
	public int withdraw(String name, double amount) {
		int rowsAffected = 0;
		String deposit = "UPDATE MANTU." + name + "_info SET BALANCE = BALANCE - " + amount + " WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(deposit)) {
			ps.setString(1, name);
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rowsAffected > 0) {
			System.out.println(checkBalance_forDeposit(name));
		}
		return rowsAffected;
	}

	@Override
	public double checkBalance_forWithdraw(String name) {
		double balance = 0.0;
		String sql = "SELECT BALANCE FROM MANTU." + name + "_INFO WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble("BALANCE");
				System.out.println("Your balance is: $" + balance);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}
}
