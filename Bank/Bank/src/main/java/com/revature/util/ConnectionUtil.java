package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@java-may28.ckgud978ubld.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "admin";
		String password = "NotAPassword";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url,username,password);
		}
		return connection;
	}

}
