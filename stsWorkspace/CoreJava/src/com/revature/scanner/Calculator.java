package com.revature.scanner;
//imports
import java.util.Scanner;

public class Calculator {
	//Class attributes
	private static Scanner scan = new Scanner(System.in);
	
	public Calculator() {
	}
	
	public void calculate() {
		System.out.println("Please enter an operation you want to perform(Spell it out!): ");
		String operation = scan.nextLine();
		int[] nums;
		int result = 0;
		System.out.println(operation);
		
		switch(operation) {
		case "addition": //add two numbers
			nums = getNums();
			result = (nums[0] + nums[1]);
			break;
		case "subtraction": //subtract two numbers
			nums = getNums();
			result = (nums[0] - nums[1]);
			break;
		case "multiplication": //multiply two numbers
			nums = getNums();
			result = (nums[0] * nums[1]);
			break;
		case "division": //divide two numbers
			nums = getNums();
			while(nums[1] == 0 ){
				System.out.println("Cannot divide by 0. Please try again.");
				nums = getNums();
			}
			result = (nums[0] / nums[1]);
			break;
		case "exit": //exit
			break;
		default:
			System.out.println("Invalid operation.");
			calculate();
			return;
		}
		
		System.out.println("Results = " + result);
		scan.close();
		
	}
	
	public int[] getNums() {
		int[] nums = new int[2];
		//ask user for first and second number
		System.out.println("Please enter first number: ");
		nums[0] = getNum();
		
		System.out.println("Please enter second number: ");
		nums[1] = getNum();
		
		return nums;
	}
	
	private int getNum() {
		int num;
		try {
			num = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException nfe) {
			System.out.println("Not a number! Please enter an integer.");
			return getNum();
			//nfe.printStackTrace();
		}
		
		return num;
	}
	
}
