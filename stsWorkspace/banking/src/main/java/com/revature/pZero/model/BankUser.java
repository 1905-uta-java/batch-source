package com.revature.pZero.model;

import java.io.Serializable;
import java.util.List;

import com.mdo.util.Input;
import com.revature.pZero.dao.BankAccountsDAO;
import com.revature.pZero.dao.BankAccountsDAOImpl;

public class BankUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2444762840504253582L;
	
	//Class attributes
	private BankAccountsDAO  dao = new BankAccountsDAOImpl();
	private List<BankAccount> ba;
	
	private int id;
	private String firstName, lastName, username, password, email;
	
	public BankUser() {
		super();
	}
	
	public BankUser(int id, String firstName, String lastName, String username, String password, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankUser other = (BankUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BankUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}
	
	public void getAccounts() {
		this.ba = this.dao.getAccounts(this.id);
	}
	
	
	//Displays account operation menu and calls said operations
	public void acctOps() {
		int opsMenu = 0;
		BankAccount tempAcct = null;
		
		do {
			opsMenu = Input.getInputInt( //Display options that this user can perform
					"Welcome " + this.getFirstName() + " " + this.getLastName() + "."
							+ "\nWhat would you like to do today?"
							+ "\n1. Create a new checking account."
							+ "\n2. Create a new savings account."
							+ "\n3. Access current accounts."
							+ "\n4. Get a statement of all existing accounts."
							+ "\n0. Log out."
							);
			//option selection
			switch(opsMenu) {
			case 1:
				tempAcct = new CheckingAccount(
						dao.getNextBankId(((BankAccount) new CheckingAccount())),
						this.getId(),
						Input.getInputDouble("How much would you like to initially deposit?")
						);
				if(dao.createBankAccount(tempAcct) >= 1)
					System.out.println("Checking account created.");
				else
					System.out.println("Failed to create account.");
				break;
			case 2:
				tempAcct = new SavingsAccount(
						dao.getNextBankId(((BankAccount) new SavingsAccount())),
						this.getId(),
						Input.getInputDouble("How much would you like to initially deposit?"),
						Input.getInputDouble("What would you like your interest rate to be?")
						);
				if(dao.createBankAccount(tempAcct) >= 1)
					System.out.println("Saving account created.");
				else
					System.out.println("Failed to create account.");
				break;
			case 3:
				if(ba.size() > 0)
					this.existingAcctOps();
				else
					System.out.println("You do not have any open accounts.");
				break;
			case 4:
				System.out.println(this.getStatements());
				break;
			case 0:
				break;
			default:
				break;
			}
			this.getAccounts();
		} while (opsMenu != 0);
	}
	
	//returns a String of statements from the BankAccounts held by the ba arraylist
	public String getStatements() {
		String statements = "";
		for(int x = 0; x < ba.size(); x++)
			statements += ba.get(x).getStatement() + "\n";
		return statements;
	}
	
	
	//returns a list of String representations of each bank account under this BankUser
	public String getAcctList() {
		String list = "";
		
		for(int x = 0; x < this.ba.size(); x++) {
			list += x+1 + "." + ba.get(x) + "\n";
		}
		return list;
	}
	
	//returns false if no change has occured on the account, true if there has been a change
	public boolean operateOnAcct(BankAccount b) {
		boolean aChangeHasOccured = false;
		int opsMenu = 0;
		
		do {
			opsMenu = Input.getInputInt(
					"Please select the operation you wish to perform for this account:"
					+ "\n1. Deposit."
					+ "\n2. Withdraw."
					+ "\n3. Get Balance."
					+ "\n4. Get an account statement."
					+ "\n0. Exit."
					);
			
			switch(opsMenu) { //Operations for the account
			case 1: //attempts to deposit an amount into bank account. returns true if a deposit is successful.
				if(b.deposit(Input.getInputDouble("How much would you like to deposit?"))) {
					System.out.println("Deposit successful.");
					aChangeHasOccured = true;
				} else {
					System.out.println("Deposit cannot be less than 0.");
				}
				break;
			case 2: //attempts to withdraw an amount from bank account. returns true if a withdraw is successful.
				if(b.withdraw(Input.getInputDouble("How much would you like to withdraw?"))) {
					System.out.println("Withdraw successful."
							+ "\nCurrent Balance: " + b.getAmount());
					aChangeHasOccured = true;
				} else {
					System.out.println("Withdrawing amount is higher than current balance.");
				}
				break;
			case 3: //prints the accounts current balance
				System.out.println(b.getAmount());
				break;
			case 4: //prints a bank statement of the bank account
				System.out.println(b.getStatement());
				break;
			case 0:
				break;
			default:
				break;
			}
		} while (opsMenu != 0);
		
		
		return aChangeHasOccured;
	}
	
	public void existingAcctOps() {
		boolean opsMenu = false;
		BankAccount tempAcct = null;
		
		do {
			System.out.println(
					"Please select an account you wish to access: "
					+ "\n" + this.getAcctList()
					+ "0. Exit.");
			int acctSelection = Input.getInputInt("");
			if(acctSelection <= 0)
				opsMenu = false; //User wishes to exit acctOps()
			else if(acctSelection >= ba.size())
				opsMenu = true; //loop back to menu
			else {
				tempAcct = ba.get(acctSelection - 1); //Menu starts at 1 but index starts at 0
				
				if(this.operateOnAcct(tempAcct)) //Run operations on the account. If there are changes then return true.
					dao.updateBankAccount(tempAcct); //changes have occured, not update the db.
				opsMenu = true; //sets to true so that menu can be looped back.
			}
			
		} while (opsMenu);//loop while true until user wants to exit operations
	}
	

}//end of class
