package com.banking.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@banking.cdawj0lgggde.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "mantu";
		String password = "marionraven";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url,username,password);
		}
		return connection;
	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
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
	
	public static Connection getConnectionWithNameAndPassword(String user, String password) throws SQLException {
		String url = "jdbc:oracle:thin:@banking.cdawj0lgggde.us-east-2.rds.amazonaws.com:1521:ORCL";
		if(connection==null || connection.isClosed()) {
		        connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
    public static void closeConnection() throws SQLException {
        if (connection != null) {
        	connection.close();
        }
    }
}

