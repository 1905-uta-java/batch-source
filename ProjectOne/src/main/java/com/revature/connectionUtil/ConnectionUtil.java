package com.revature.connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
	private static Connection connection;

	synchronized public static Connection getHardCodedConnection() throws SQLException
	{
		String url = "jdbc:oracle:thin:@projectzero.ck7ngjs4z3ik.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "admin";
		String password = "Ccrfox56";
		if (connection == null || connection.isClosed()) 
		{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
	
	synchronized public static Connection getConnection() throws SQLException
	{
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER ");
		String password = System.getenv("DB_PASSWORD");
		if (connection == null || connection.isClosed())
		{
		connection = DriverManager.getConnection(url, user, password);
		}
		
		return connection;
	}
}
