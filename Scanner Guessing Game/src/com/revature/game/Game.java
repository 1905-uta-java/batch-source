package com.revature.game;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private static Scanner sc = new Scanner(System.in);
	
	public void play() {
		
	int randomNum = GenerateRandomNumber();	
	int upperBound = 100;
	int lowerBound = 0;
	int count = 1;
	// System.out.println(randomNum); // <-- Testing
	
	System.out.println("Enter a number between 0 and 100.");
	int userInput = getNum(lowerBound, upperBound);
	
	while (userInput != randomNum) {
		count++;
		if (userInput > randomNum) {
			System.out.println("Too high!");
			upperBound = userInput;
		} else if (userInput < randomNum) {
			System.out.println("Too low!");
			lowerBound = userInput;
		}
		System.out.println("Enter a number between " + lowerBound + " and " + upperBound);
		userInput = getNum(lowerBound, upperBound);
	}
	
	if (userInput == randomNum) {
		System.out.println("Congratulations! You guessed the number in " + count + " tries!");
	} 

	
	
	
		
	}
	
	public int GenerateRandomNumber() {
		int max = 100;
		int min = 0;
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
		
	}
	
	private int getNum(int lower, int upper) {
		String input = sc.nextLine();
		
		int num;
		
		try {
			num = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter an integer between " + lower + " - " + upper);
				return getNum(lower, upper);
			}	
		
		if (num < lower || num > upper) {
			System.out.println("Invalid input, please enter an integer between " + lower + " - " + upper);
			return getNum(lower, upper);
		}
		
		return num;
	}
	 
	
	

}
