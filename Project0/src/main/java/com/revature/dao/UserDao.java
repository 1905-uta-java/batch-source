package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.User;


public interface UserDao {
	public void createBankUser() throws SQLException;
	public void login() throws SQLException;
	public void deposit() throws SQLException;
}
