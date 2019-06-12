//imports
import java.util.ArrayList;
import java.util.List;

import com.mdo.util.Input;
import com.revature.pZero.dao.BankAccountsDAO;
import com.revature.pZero.dao.BankAccountsDAOImpl;
import com.revature.pZero.dao.BankUserDAO;
import com.revature.pZero.dao.BankUserDAOImpl;
import com.revature.pZero.model.BankAccount;
import com.revature.pZero.model.BankUser;

public class BankService {

	public static void main(String[] args) {
		//instance variables
		int loginMenu = 0;
		BankUserDAO userDAO = new BankUserDAOImpl();
		BankUser bu = null;
		
		do {
			
			loginMenu = Input.getInputInt(
					"Welcome to United Banks,"
					+ "\nPlease login or create a new user account:"
					+ "\n1. Login."
					+ "\n2. Create New User Account."
					+ "\n0. Exit.");
			//Login or Create User switch
			switch(loginMenu) {
			case 1: //User login
				bu = userDAO.login(
						Input.getInputString("Please enter your username: "),
						Input.getInputString("Please enter your password: "));
				
				if(bu == null)
					System.out.println("Login failed.");
				
				break;
			case 2: //Account creation
				bu = new BankUser(
						0,
						Input.getInputString("Please enter your first name: "),
						Input.getInputString("Please input your last name: "),
						Input.getInputString("Please enter your desired username: "),
						Input.getInputString("Please enter your desired password: "),
						Input.getInputString("Please enter your email address: ")
						);
				
					if(userDAO.createBankUser(bu) == 0)
						System.out.println("Unable to create a new user account.");
					else
						System.out.println("Account created successfully!");
				break;
			case 0:
				break;
			default:
				break;
			}//end login switch
			
		//Account Operations (deposit, withdraw, get balance, get statements)
			if(bu != null)
				bu.acctOps();
			bu = null;
		} while(loginMenu != 0); //end login menu and application
		
		System.out.println("Thank you for using United Bank's services. Please come again!");
		System.exit(0);
	}
	
	

}
