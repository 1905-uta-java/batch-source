package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection connection;
	
	public static Connection getHardCodedConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@project1.cgma4gobqosk.us-east-2.rds.amazonaws.com:1521:project1";
		String username = "admin";
		String password = "chumBucket47$";
		
		
		if(connection == null || connection.isClosed()) {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url, username, password);
		}		
		
		return connection;
	}
	
}
