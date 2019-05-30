package com.revature.game;

import java.util.Scanner;

public class Game {
	public static Scanner sc = new Scanner(System.in);
	private int counter;
	private int lowNum = 0;
	private int highNum = 100;
	
	
	public void play() {
		int num = randomNum();
		boolean correctAnswer = false;
		
		System.out.println("Welcome to the game!"); 
		
		while(!correctAnswer) {
			System.out.println("Guess a number between " + lowNum + " and "+ highNum + ": ");			
			correctAnswer = checkAnswer(getNum(), num, counter);
		}
	}
	
	private int randomNum() {
		int num = (int) (Math.random() * 100);
		return num;
	}
	
	private int getNum() {
		// making sure the user input can be parsed to an int
		String input = sc.nextLine();
		int num;
		counter++;
		
		try { 
			num = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Yo, not cool ,try again");
			return getNum();
		}
		return num;
	}
	
	private boolean checkAnswer(int userInput, int ranNum, int counter) {
		//checking if input is within 0 or 100
		if(userInput < 0) {
			System.out.println("You're out of bounds! Too low!");
			return false;
		} else if(userInput > 100) {
			System.out.println("You're out of bounds. Too high!");
			return false;
		} else {
			// if the user is within the bounds
			if(userInput < ranNum) {
				System.out.println("Too low!");
				lowNum = userInput;
				return false;
			}
			else if (userInput > ranNum) { 
				System.out.println("Too high!");
				highNum = userInput;
				return false;
			}
			else {
				System.out.println("You Win! It took you " + counter + " time(s) to guess.");
				return true;
			}
		}
		
	}

}
