package com.mdo.util;
/**
 * Description - This class is used for accepting and verifying user inputs.
 * @author mattd
 * @version 1.1.0
 */

//imports
import java.util.Scanner;
import javax.swing.JOptionPane;
	
public class Input {

		/**
		 * Description - no args constructor
		 *@return nothing
		 *@throws nothing
		 */
		public Input() { //constructor
			
		}
		
		/**
		 * Description: Checks a String if it is an integer.
		 * @param input - String of characters that is checked
		 * @return true if input is an int, false otherwise
		 * @throws NumberFormatException
		 */
		public static boolean isInputInt(String input) {
			try {
				Integer.parseInt(input);
				return true;
			} catch(NumberFormatException e) {
				return false;
			}
		}
		
		/**
		 * Description: Checks a String if it is an double.
		 * @param input - String of characters that is checked
		 * @return true if input is a double, false otherwise
		 * @throws NumberFormatException
		 */
		public static boolean isInputDouble(String input) {
			try {
				Double.parseDouble(input);
				return true;
			} catch(NumberFormatException e) {
				return false;
			}
		}
		
		/**
		 * Description: Checks a String if it is an float.
		 * @param input - String of characters that is checked
		 * @return true if input is a float, false otherwise
		 * @throws NumberFormatException
		 */
		public static boolean isInputFloat(String input) {
			try {
				Float.parseFloat(input);
				return true;
			} catch(NumberFormatException e) {
				return false;
			}
		}
		
		/*
		/**
		 * Description: Checks a string if it can be a double. Never accepts negative doubles
		 * @param input - String of characters to be checked
		 * @return true if input holds digits and up to 1 '.' else false
		 * @throws nothing
		 */
		/*public static boolean isInputDouble(String input) {
			if(input.compareTo("")==0) { //checks if string is empty
				return false;
			} else {
				int count = 0;
				for(int x = 0; x < input.length(); x++) { 
					if(!Character.isDigit(input.charAt(x)) && input.charAt(x) != '.') { //checks if char at index of input is a digit
						return false;
					} else if(input.charAt(x) == '.') { //Only allow 1 '.' for doubles
						count++;
						if(count > 1)
							return false;
					}
				}
			}
					
				return true;
		}
		*/
		
		/**
		 * Description: Prints a String prompting for an integer input. It will convert the input into an integer.
		 * @param prompt - String that will be printed to ask for user input
		 * @return an integer value of a converted String input
		 * @throws nothing
		 */
		public static int getInputInt(String prompt) {
			String input = new String(); //input to be converted to int
			int inputD; //integer to be returned
			Scanner scan = new Scanner(System.in);
			
			//get input
				do {
					System.out.println(prompt);
					input = scan.nextLine();
				}while(!isInputInt(input));
				
				inputD = Integer.parseInt(input); //convert string to int
				
			scan.close();
			return inputD;
		}
		
		
		/**
		 * Description: Prints a String prompting for an integer input. It will return the input into an integer if the input is not greater than max.
		 * @param prompt - String that will be printed to ask for user input
		 * @param max - integer value that input cannot be greater than
		 * @return an integer value of a converted String input
		 * @throws nothing
		 */
		public static int getInputInt(String prompt, int max) {
			String input = new String(); //input to be converted to int
			int inputD; //integer to be returned
			Scanner scan = new Scanner(System.in);
			
			//get input
			do {
				do {
					System.out.println(prompt);
					input = scan.nextLine();
				}while(!isInputInt(input));
				
				inputD = Integer.parseInt(input); //convert string to int
			}while(inputD > max);
			
			scan.close();
			return inputD;
		}
		
		/**
		 * Description: Prints a String prompting for a double input. It will convert the input into a double.
		 * @param prompt - String that will be printed to ask for user input
		 * @return an integer value of a converted String input
		 * @throws nothing
		 */
		public static double getInputDouble(String prompt) {
			String input = new String(); //input to be converted to a double
			double inputD; //double to be returned
			Scanner scan = new Scanner(System.in);
			
			//get input
				do {
					System.out.println(prompt);
					input = scan.nextLine();
				}while(!isInputDouble(input));
				
				inputD = Double.parseDouble(input); //convert string to double
			
			scan.close();
			return inputD;
		}
		
		/**
		 * Description: Prints a String prompting for a double input. It will return the input into an double if the input is not greater than max.
		 * @param prompt - String that will be printed to ask for user input
		 * @return an integer value of a converted String input
		 * @throws nothing
		 */
		public static double getInputDouble(String prompt, double max) {
			String input = new String(); //input to be converted to a double
			double inputD; //double to be returned
			Scanner scan = new Scanner(System.in);
			
			//get input
			do {
				do {
					System.out.println(prompt);
					input = scan.nextLine();
				}while(!isInputDouble(input));
				
				inputD = Double.parseDouble(input); //convert string to double
			}while(inputD > max);
			
			scan.close();
			return inputD;
		}
		
		/**
		 * Description - Gets input from user. User cannot enter an empty string.
		 * @param prompt - String that will be printed to ask for user input
		 * @return string from user input
		 * @throws - Nothing
		 */
		public static String getInputString(String prompt) {
			String input = new String();
			Scanner scan = new Scanner(System.in);
			do {
				System.out.println(prompt);
				input = scan.nextLine();
			}while(input.equals(null) || input.equals(""));
			
			scan.close();
			return input;
		}
		
		/**
		 * Description - Gets input from the user that must be a Double by displaying a window. This method does not take negatives.
		 * @param prompt - String that will be outputted to ask for user input
		 * @param min - the minimum amount that input must exceed
		 * @return a Double from user input
		 * @throws - Nothing
		 */
		public static double wGetInputDouble(String prompt, double min) {
			String input = new String();
			double dInput;
			do {
				do {
					input = JOptionPane.showInputDialog(prompt);
				}while(!isInputDouble(input));
				
				dInput = Double.parseDouble(input);
				if(dInput < min)
					JOptionPane.showMessageDialog(null, "The input must exceed: " + min);
			}while(dInput < min);
			
			return dInput;
		}
		
		/**
		 * Description - Gets input from the user that must be a Double by displaying a window. This method does not take negatives.
		 * @param prompt - String that will be outtputed to ask for user input
		 * @return a Double from user input
		 * @throws - Nothing
		 */
		public static double wGetInputDouble(String prompt) {
			String input = new String();
			@SuppressWarnings("unused")
			double dInput;
			do {
				input = JOptionPane.showInputDialog(prompt);
			}while(!isInputDouble(input));
			
			return dInput = Double.parseDouble(input);
		}
		
		/**
		 * Description - Gets input from the user that must be an Integer by displaying a window. This method does not take negatives.
		 * @param prompt - String that will be outputed to ask for user input
		 * @return a Integer from user input
		 * @throws - Nothing
		 */
		public static int wGetInputInt(String prompt) {
			String input = new String();
			@SuppressWarnings("unused")
			int intInput;
			do {
				input = JOptionPane.showInputDialog(prompt);
			}while(!isInputInt(input));
			
			return intInput = Integer.parseInt(input);
		}
		
		/**
		 * Description - Gets input from the user that must be an Integer and greater then the minimum by displaying a window. This method does not take negatives.
		 * @param prompt - String that will be outputed to ask for user input
		 * @param min - the minimum amount that the input must equal or exceed
		 * @return a Integer from user input
		 * @throws - Nothing
		 */
		public static int wGetInputInt(String prompt, int min) {
			String input = new String();
			int intInput;
			do {
				do {
					input = JOptionPane.showInputDialog(prompt);
				}while(!isInputInt(input));
				
				intInput = Integer.parseInt(input);
				if(intInput < min)
					JOptionPane.showMessageDialog(null, "The input must exceed: " + min);
			}while(intInput < min);
			
			return intInput;
		}
		
		/**
		 * Description - Gets a String input from user through a window prompt.
		 * @param prompt - String that is displayed through a window that prompts the user for an input
		 * @return A String from user input
		 * @throws - Nothing
		 */
		public static String wGetInputString(String prompt) {
			String input = new String();
			
			do {
				input = JOptionPane.showInputDialog(prompt);
			}while(input == null || input == "");
			
			return input;
		}
		
		/**
		 * Description - Gets input from the user that must be a Float by displaying a window.
		 * @param prompt - String that will be outputted to ask for user input
		 * @param min - the minimum amount that input must exceed
		 * @return a Float from user input
		 * @throws - Nothing
		 */
		public static float wGetInputFloat(String prompt, float min) {
			String input = new String();
			float dInput;
			do {
				do {
					input = JOptionPane.showInputDialog(prompt);
				}while(!isInputFloat(input));
				
				dInput = Float.parseFloat(input);
				if(dInput < min)
					JOptionPane.showMessageDialog(null, "The input must exceed: " + min);
			}while(dInput < min);
			
			return dInput;
		}
		
		
		/**
		 * Description - Gets input from the user that must be a Float by displaying a window.
		 * @param prompt - String that will be outputted to ask for user input
		 * @return a Float from user input
		 * @throws - Nothing.
		 */
		public static float wGetInputFloat(String prompt) {
			String input = new String();
			float fInput;
			
				do {
					input = JOptionPane.showInputDialog(prompt);
				}while(!isInputFloat(input));
				
				fInput = Float.parseFloat(input);
			
			return fInput;
		}
		
		/**
		 * Description - Prompts the user with a yes or no question. This method will loop until the user answers.
		 * @param prompt - String that will be shown to the user, should be in a form of a yes or no question
		 * @return - true if user answers yes, false if they select no.
		 * @throws - Nothing.
		 */
		public static boolean wGetInputConfirmation(String prompt) {
			String input = new String();
			do {
				input = wGetInputString(prompt);
			} while(input.compareTo("1") != 0 && input.compareTo("2") != 0);
			
			if(input.compareTo("1") == 0)
				return true;
			
			return false;
		}
		
		
		
		
}//end of class
