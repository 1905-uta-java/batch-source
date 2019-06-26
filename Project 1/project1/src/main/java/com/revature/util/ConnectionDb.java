package com.revature.util;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;


public class ConnectionDb {
	/*
	 * Create a txt file that holds the url, username and password and add it to the 
	 * .gitnore so that when i upload to github i dont have to worry about someone enter
	 * my database and mining bit coin with it
	 */
	
	private static Connection connection;
	
	//creates a connections from java to the database and allows me to use the data there
	public static Connection getConnection(){
		
		String url = "jdbc:oracle:thin:@[transactiondb.ccitm10gpxjr.us-east-2.rds.amazonaws.com]:1521:ORCL";
		String username = "Admin";
		String password = "Password123";
		try {
			if(connection == null || connection.isClosed()) {
				Driver d = new oracle.jdbc.OracleDriver();
				DriverManager.registerDriver(d);
				connection = DriverManager.getConnection(url, username, password);
				System.out.println("DataBase call made in ConnectionDB");
			}
		} catch (Exception e) {
			System.out.println("No luck");
		}
		return connection;
	}
}
