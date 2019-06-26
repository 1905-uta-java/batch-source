package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
	private static Connection connection;
	
	//In the future don't establish a connection to the DB with hard coded credentials!
	public static Connection getHardCodedConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@java-may28.cvdi2ikw3pvp.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "sensei";
		//change the password to the DB master password
		String password = "*********";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	
	}
}
