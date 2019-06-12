package com.revature.BankingApp.util;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionUtil {
	private static Connection connection;
	
	public static Connection getHardCodedConnection(){
		
		String url = "jdbc:oracle:thin:@[bankingapp.ccitm10gpxjr.us-east-2.rds.amazonaws.com]:1521:ORCL";
		String username = "admin";
		String password = "password";
		try {
			if(connection == null || connection.isClosed()) {
				Driver d = new oracle.jdbc.OracleDriver();
				DriverManager.registerDriver(d);
				Class.forName("com.revature.BankingApp.BankDriver");
				connection = DriverManager.getConnection(url, username, password);
			}
		} catch (Exception e) {
			
		}
		return connection;
	}
	
	public static Connection getConnection(String url, String username, String password){
		
		try {
			if(connection == null || connection.isClosed()) {
				Driver d = new oracle.jdbc.OracleDriver();
				DriverManager.registerDriver(d);
				Class.forName("com.revature.BankingApp.util.ConnectionUtil");
				connection = DriverManager.getConnection(url, username,password);
			}
		}
		catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
		return connection;
	}
}
