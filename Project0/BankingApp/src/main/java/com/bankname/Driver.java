package com.bankname;

import com.bankname.menu.UserMenu;
//import com.bankname.util.PasswordEncryptionUtil;

public class Driver {

	
	
	public static void main(String[] args) {
	
		//Email and Password for Testing
		/*
		 * Email: johnsmith@gmail.com
		 * Password: Passw0rd
		 * Hash: d41e98d1eafa6d6011d3a70f1a5b92f0
		 * 
		 * Email: debbyarnold@yahoo.com
		 * Password: P4ssword
		 * Hash: 431301000c51954230c969f2e04c3add
		 * 
		 */
		
		//Create menu object and run starting menu
		UserMenu m = new UserMenu();
		m.loginCreateOptionMenu();
		
		
	}
}
