package com.revature.guessingGame;

import java.util.Random;
import java.util.Scanner;


public class Game {
	//two imported classes we need for the program
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	//variables needed for the game
	private int randNum = rand.nextInt(99 + 1);
	private Integer userChoice;
	private int counter = 1;
	private int higher = 100;
	private int lower = 1;
	
	
	//calls all the functions for the game
	public void play() {
		start();
		userChoice = userChoice();
		while(!findTheNum(userChoice)) {
			counter++;
			userChoice = userChoice();
			findTheNum(userChoice);
		};
		victory(randNum);
		sc.close();
	}
	
	//Creates a starting prompt
	private void start() {
		System.out.println("The computer has chosen a number, can you guess it?"); 
	}
	
	//Makes sure the user chose a number between 1 and 100 using regular expressions
	//Also changes the string to an integer if it is an integer
	//It also uses recursion in 3 while loops to make sure the number is a usable number
	private Integer userChoice() {
		System.out.println("Highest Guess: " + higher + " Lowest Guess: " + lower + 
				"\nYour Guess: ");
		String temp = sc.nextLine();
		while(!temp.matches("^[1-9][0-9]?$|^100$")){
			System.out.println("That is not a number between 1 and 100");
			temp = userChoice().toString();
		}
		while(Integer.parseInt(temp) > higher) {
			System.out.println("That number is larger than " + higher);
			temp = userChoice().toString();
		}
		while(Integer.parseInt(temp) < lower) {
			System.out.println("That number is smaller than " + lower);
			temp = userChoice().toString();
		}
		return Integer.parseInt(temp);
	}
	
	//Checks to see if the number is equal to the random number and
	//adjusts the high and low numbers accordingly
	private boolean findTheNum(int i) {
		if(i == randNum)
			return true;
		
		System.out.println("Sorry that was incorrect.");
		if(i > randNum) {
			System.out.println("The number is lower");
			higher = i;
		}
		if(i < randNum) {
			System.out.println("The number is higher");
			lower = i;
		}
		return false;
		
		
	}
	
	//Victory screen. You've won!!
	private void victory(int answer) {
		System.out.println("Congrats, you've won! " + answer + " was the right answer!!");
		System.out.println("It only took you... " + counter + " tries");
	}
	
	
}
