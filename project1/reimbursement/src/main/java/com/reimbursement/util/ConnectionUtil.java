package com.reimbursement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	public static Connection getHardCodedConnection() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@reimbursement.cdawj0lgggde.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "mantu";
		String password = "marionraven";
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}

		return connection;
		
		
	
	}

	public static Connection getConnectionWithNameAndPassword(String user, String password) throws SQLException {
		String url = "jdbc:oracle:thin:@reimbursement.cdawj0lgggde.us-east-2.rds.amazonaws.com:1521:ORCL";
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}

}
