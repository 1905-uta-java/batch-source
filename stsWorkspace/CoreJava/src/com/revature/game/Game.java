package com.revature.game;
//imports
import java.util.Random;
import java.util.Scanner;

public class Game {//class header
	//class attributes
	private static Scanner scan = new Scanner(System.in);
	
	public Game() {
	}
	
	public void playGame() {
		int num = generateInt();
		int input = 0;
		//System.out.println(num);
		
		do {
			System.out.println("Please enter a number between 0 and 100!");
			input = getNum();
		} while (input > 100);
		
		System.out.println("Correct! You tried: " + guess(num, input) + " times.");
		
		
		
	}
	
	private int generateInt() {
		int num;
		Random rand = new Random();
		//generate an int between 0 - 100
		num = rand.nextInt(101);
		return num;
	}
	
	//gets user input, must be a num
	public int getNum() {
		int num = 0;
		
		try {
				num = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException nfe) {
			System.out.println("Not a number! Please enter an integer.");
			return getNum();
		}
		return num;
	}
	
	public int guess(int genInt, int input) {
		int guess = 1;
		int upper = 100;
		int lower = 0;
		
		
		while(input != genInt) {
			guess++;
			if(input > genInt) {
				System.out.println("Too High!");
				upper = input;
				System.out.println("Please enter a number between " + lower + " and " + upper + ":");
			} else if(input < genInt) {
				System.out.println("Too Low!");
				lower = input;
				System.out.println("Please enter a number between " + lower + " and " + upper + ":");
			}
			
			input = getNum();
		}
		
		
		return guess;
	}
	
	
	
}//end of class
