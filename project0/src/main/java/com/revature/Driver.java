package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

public class Driver {
	public static void main(String[] args) {
		String inStr = "";
		UserDao usr = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("[L]ogin or [C]reate Account? (-1 to exit): ");
			inStr = sc.nextLine();
			
			if(!inStr.equals("-1")) {
				if(inStr.equals("l")|| inStr.equals("L")) {
					Login login = new Login(usr,sc);
					login.checkCreds();
					
				} else if (inStr.equals("c") || inStr.equals("C")){
					Create create = new Create(usr, sc);
					create.createAccount();
				} else 
					System.out.println(inStr + " is not valid. Must be 'L' or 'C'.\n");
			} else 
				System.out.println("Exiting");
			
		} while(!inStr.equals("-1"));
		sc.close();
	}
}
