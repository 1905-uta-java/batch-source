package com.revature.pZero.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		if(connection==null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@java-may28.coeznpxgwkui.us-east-2.rds.amazonaws.com:1521:ORCL"; //:url,port,SID
		String username = "Admin";
		String password = "606820Gh";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url,username,password);
		}
		return connection;
	}
}
