package com.banking;

import java.sql.SQLException;
import java.util.Scanner;
import com.banking.dao.UserDao;
import com.banking.dao.UserDaoImpl;
import com.banking.util.ConnectionUtil;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Driver {
	final static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
        BasicConfigurator.configure();

		UserDao u = new UserDaoImpl();
		int input = 0;
		String username = "";
		String password = "";
		boolean flag = true;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Press 1 to log in. Press 2 to open an account. Press any other number to quit: ");
			while (!sc.hasNextInt()) {
				if (!sc.hasNextInt()) {
					logger.error("Please input a number only: ");
					sc.next();
				}
			}
			input = sc.nextInt();
			if (input == 1) {
				flag = true;
				System.out.print("Please enter username: ");
				username = sc.next();
				System.out.print("Please enter the password: ");
				password = sc.next();
				try {
					ConnectionUtil.getConnectionWithNameAndPassword(username, password);

				} catch (SQLException e) {
					e.getMessage();
					logger.error("Wrong username or password");
					System.out.println();
					flag = false;
				}

				while (flag) {
					System.out.println();
					System.out.println("1. Check account balance");
					System.out.println("2. Deposit money");
					System.out.println("3. Withdraw money");
					System.out.println("4. Transfer money");
					System.out.println("5. Log out");
					System.out.print("Pick an option: ");

					while (!sc.hasNextInt()) {
						if (!sc.hasNextInt()) {
							logger.error("Please input a number only: ");
							sc.next();
						}
					}
					input = sc.nextInt();
					System.out.println();
					switch (input) {
					case 1:
						u.checkBalance(username);
						System.out.println();
						break;
					case 2:
						System.out.print("Please enter the amount you wish to deposit: ");
						while (!sc.hasNextInt()) {
							if (!sc.hasNextInt()) {
								logger.error("Please input a number only: ");
								sc.next();
							}
						}
						input = sc.nextInt();
						u.deposit(username, input);
						System.out.println();
						break;
					case 3:
						System.out.print("Please enter the amount you wish to withdraw: ");
						while (!sc.hasNextInt()) {
							if (!sc.hasNextInt()) {
								logger.error("Please input a number only: ");
								sc.next();
							}
						}
						input = sc.nextInt();
						if (u.checkBalance_forWithdraw(username) - input < 0) {
							logger.info("You balance will be negative after the withdrawal. Can't proceed.");
							break;
						}
						u.withdraw(username, input);
						break;

					case 5:
						flag = false;
						break;
					}

				}

			} else if (input == 2) {
				while (true) {
					System.out.print("Please enter username: ");
					username = sc.next();
					System.out.print("Please enter the password: ");
					password = sc.next();

					if (!u.isAvailable(username)) {
						logger.info("This username already exists");
						System.out.println();
					} else {
						u.createUser(username, password);
						System.out.println();
					}
					break;
				}
			} else {
				break;
			}
		}
		sc.close();
	}
}
