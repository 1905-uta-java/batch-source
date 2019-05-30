package com.revature.game;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private int min = 0;
	private int max = 100;
	
	
	
	public Game() {
		super();
	}
	
	public void play(){
		boolean win = false;
		Random rand = new Random();
		int intRand = rand.nextInt(101);
		Scanner sc = new Scanner(System.in);
		//int intRand = 40;
		int guess = -1;
		min = 0;
		max = 100;
		
		while(!win) {
			
			while(guess == -1) {
				guess = getNum(sc);
			}
			
			if( guess == intRand) {
				System.out.println("You Win!");
				win = true;
			}else if(guess < intRand) {
				min = guess;
				System.out.println("Guess is too low");
			}else {
				max = guess;
				System.out.println("Guess is too high");
			}
			guess = -1;
		}
		
		sc.close();
		
	}
	
	private int getNum(Scanner sc) {
		int n = 0;
		System.out.println("Enter number between "+min+" and "+max);
		try {
			n = sc.nextInt();
		}catch(InputMismatchException e) {
			sc.next();
			System.out.println("Invalid Number entered");
			return -1;
		}
		
		if (n < min || n > max) {
			System.out.println("Guess not in range");
			return -1;
		}
		
		return n;
	}
	

}
