package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;
	
	public static Connection getHardCodedConnection() throws SQLException {
		
		String endpoint = "ers2.cwfgz6lanigk.us-east-2.rds.amazonaws.com";
		String dbName = "ERS";
		String url = "jdbc:oracle:thin:@" + endpoint +":1521:" + dbName;
		String user = "admin";
		String password = "password123";
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		if(connection==null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
}