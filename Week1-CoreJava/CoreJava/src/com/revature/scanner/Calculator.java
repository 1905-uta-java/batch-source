package com.revature.scanner;

import java.util.Scanner;

public class Calculator {
	
	private static Scanner sc = new Scanner(System.in);
	
	public void calculate() {
		
		System.out.println("Please enter the operation you'd like to perform:");
		String operation = sc.nextLine();
		
		int[] nums;
		int result = 0;
		
//		System.out.println(operation);
		switch(operation) {
		case "addition":
			nums = getNums();
			result = nums[0]+nums[1];
			break;
		case "subtraction":
			nums = getNums();
			result = nums[0] - nums[1];
			break;
		case "division":
			nums = getNums();
			while(nums[1]==0) {
				System.out.println("Cannot divide by 0, please enter valid operands");
				nums = getNums();
			}
			result = nums[0]/nums[1];
			break;
		case "multiplication":
			nums = getNums();
			result = nums[0]*nums[1];
			break;
		default:
			System.out.println("Invalid operation");
			calculate();
			return;
		}
		
		System.out.println("Result is: "+ result);
		sc.close();
		
	}
	
	private int[] getNums() {
		int[] nums = new int[2];
		System.out.println("Please enter first number:");
		//get number in the console from the user
		nums[0] = getNum();
		
		System.out.println("Please enter second number:");
		nums[1] = getNum();
		return nums;
	}
	
	private int getNum() {
		String input = sc.nextLine();
		int num;
		try {
			num = Integer.parseInt(input);			
		} catch (NumberFormatException e){
			System.out.println("Invalid input, please enter an integer");
			return getNum();
		}
		return num;
	}

}
