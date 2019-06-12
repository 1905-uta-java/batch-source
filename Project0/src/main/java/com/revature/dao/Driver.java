package com.revature.dao;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

import java.util.Scanner;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
	public static void main(String[] args) {		
		showPublicMenu();
	}

	public static void showPublicMenu() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		char option = '0';
		Scanner scanner = new Scanner(System.in);
		
		do { 
		System.out.println(dateFormat.format(date)); 
		System.out.println("welcome to satoshi bank");
        System.out.println("\n");
        System.out.println("a. log into account");
		System.out.println("b. create new account");
		System.out.println("c. deposit into an account");
		System.out.println("d. exit");
		System.out.println("enter an option: ");

		option = scanner.next().charAt(0);
		System.out.println("\n");

		switch(option) {
			case 'a':
				try {
					UserDao userDao = new UserDaoImpl();
					userDao.login();
				} catch (SQLException e) {
					System.out.println("SQLException encounter at login\nStack trace: " + e);
				}
				break;
			case 'b':
				try {
					UserDao userDao = new UserDaoImpl();
					userDao.createBankUser();
					System.out.println("Account successfully created.");
				} catch (SQLException e) {
					System.out.println("SQLException encounter at create bank user\nStack trace: " + e);
				}
				break;
			case 'c':
				try {
					UserDao userDao = new UserDaoImpl();
					userDao.deposit();
					System.out.println("Deposit was succesful.");
				} catch (SQLException e) {
					System.out.println("SQLException encounter at login\nStack trace: " + e);
				}
				break;
			case 'd':
				break;
			default:
				System.out.println("Not a valid option. Try again.");
				break; 
			} 
		} while (option != 'd');
		System.out.println("Thank you for using satoshi bank. Goodbye.");
		scanner.close();
	}
}

