package com.revature.accountutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@project-0-db.csk9ce8yqpzl.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "admin";
		String password = "grank1885";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
