package com.revature.guessing_game;
import java.util.Scanner;

public class Game {
	int min=0;
	int max=100;
	
	
	private static Scanner sc = new Scanner(System.in);
	// generate a random number
	public static double getRandomNumber() {
		double randomNumber = (int)(Math.random()*((100-0)+1))+0;
		randomNumber = (int) randomNumber;
		return randomNumber;
	}
	
	
	
	private int getNum() {
		int guess=0;
		String input = sc.nextLine();

		
		if(guess<min || guess>max) {
			System.out.println("outside of range. invalid input");
			return getNum();
		}
		try {
			guess = Integer.parseInt(input);
		}
		catch (NumberFormatException e){
			System.out.println("Invalid input, please enter an integer: ");
			return getNum();
		}
	
		return guess;
	}
	
	public void play() {
		// make randomNumber available
		int randomNumber = (int)getRandomNumber();
		
		System.out.println("Welcome to scanner guess game. Rando is "+ randomNumber);
		System.out.println("Guess which random number was generated.");

		System.out.println("Please enter your guess from 0 to 100: ");
		int guess = getNum();
		// check if user provided number
		
		
		
		while(guess != randomNumber) {
			// data validation
			if(guess>randomNumber) {
				max = guess;
				System.out.println("That number was too high. Guess a number between: " + min + "and " + max);
				guess = getNum();
			} else {
				min = guess;
				System.out.println("That number was too low. Guess a number between: " + min + " and " + max);
				guess = getNum();
			}
		}
		sc.close();
		System.out.println("Congratulations. " + guess + " was indeed the correct number.");
		
	}
}
