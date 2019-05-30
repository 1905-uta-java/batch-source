package com.revature.tjbinarygame;

import java.util.Scanner;


// Made by Tristan Willis and Joey Gorombey
public class Game {
	public static void main(String[] args) {
		play();
	}
	
	public static void play() {
		Scanner scan = new Scanner(System.in);
		
		boolean playing = true;
		int lower_bound = 0;
		int upper_bound = 100;
		int rand_num = (int)(Math.random() * 101);
		int guess = -1;
		int guesses = 0;
		while(playing) {
			//playing = false;
			//System.out.println(rand_num);
			System.out.println("Enter a guess between " + lower_bound + " and " + upper_bound);
			if(scan.hasNextInt()) {
				guess = scan.nextInt();
			}
			else {
				System.out.println("Your guess must be an Integer");
				scan.next();
			}
			if(guess < lower_bound || guess > upper_bound) {
				System.out.println("Your guess must be between " + lower_bound + " and " + upper_bound);
			}
			else {
				if(guess > rand_num) {
					upper_bound = guess-1;
					guesses += 1;
					System.out.println("Your guess was too high! Try again.");
				}
				else if(guess < rand_num){
					lower_bound = guess+1;
					guesses += 1;
					System.out.println("Your guess was too low! Try again.");
				}
				else {
					guesses += 1;
					System.out.println("CONGRATULATIONS!");
					System.out.println("You got the right number in " + guesses + " guesses!");
					playing = false;
				}
			}
		}
	}
}
