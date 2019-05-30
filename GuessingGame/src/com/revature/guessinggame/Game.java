package com.revature.guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private static Scanner sc = new Scanner(System.in);
	
	public void play() {
		
		Random rand = new Random();
		
		// generate the number the user will try to guess
		int correctNum = rand.nextInt(101);
		
		int lowerBound = 0;
		int upperBound = 100;
		
		// variable to store the unparsed input
		String guessInput;
		
		// initialized to -1 to ensure that it isn't equal to the correct number
		int currentGuess = -1;
		
		// guess counter
		int numGuesses = 0;
		
		System.out.println("Welcome to the numbmer guessing game");
		
		// loop until the user guesses the correct number
		while(currentGuess != correctNum) {
			
			System.out.print("Please enter an integer between " + lowerBound + " and " + upperBound + ": ");
			
			numGuesses++;
			
			try {
				
				guessInput = sc.nextLine();
				
				currentGuess = Integer.parseInt(guessInput);
				
				// check if the current guess is in the valid range
				if(currentGuess >= lowerBound && currentGuess <= upperBound) {
					
					// Check if the guess is correct. If not, check whether it is too low or too high
					if(currentGuess == correctNum) {
						
						System.out.println("Correct!");
						
					} else if(currentGuess > correctNum) {
						
						System.out.println("Your guess is too high.");
						
						upperBound = currentGuess;
						
					} else {
						
						System.out.println("Your guess is too low.");
						
						lowerBound = currentGuess;
					}
					
				} else {
					
					System.out.println("The guess is not in the valid range.");
				}
				
			} catch(NumberFormatException e) {
				
				// if the input cannot be parsed as an int, let the player know that the input was invalid
				System.out.println("Invalid input. The input must be an integer.");
			}
		}
		
		System.out.println("You took " + numGuesses + " guesses.");
	}
}
