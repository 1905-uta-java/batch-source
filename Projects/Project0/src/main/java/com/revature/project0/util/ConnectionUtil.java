package com.revature.project0.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		if(connection == null || connection.isClosed())
			connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
}
