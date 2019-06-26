package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection HardCodedConnection() throws SQLException {
		
		String url = "jdbc:oracle:thin:@java.cnmtduf3ubsh.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "swaminarayan";
		String password="Darshan$09";
		
		if(connection==null||connection.isClosed()) {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
		
	}

}
