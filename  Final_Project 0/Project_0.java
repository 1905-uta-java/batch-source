package com.revature.String;

import java.util.*;

public class Project_0 {
	
	public static void main(String[] args) {
		
		boolean correct = false;
		int ampt=0;
		String userInput;
		int userGuess;
		int random = 0;
		
		Scanner sc = new Scanner(System.in);
		
		
		for (int i = 0; i <= 100 ; i++)
	       {
	        random = (int)(Math.random()*100);
	        
	       }
		try {
			
			while(!correct) {
				
				ampt ++;
				
			System.out.println("Enter a number between 0 -100 ");
			
			userInput = sc.nextLine();
				
			userGuess = Integer.parseInt(userInput);
			
			if(userGuess>random) {
				
				System.out.println("Too High Try again "+ random);
				
			}else if(userGuess<random) {
				if(random>=0 && random<=25) {
					
				System.out.println("Too Low try Again Higher Range");
				
				}if(random>=25 && random<=50) {
					
					System.out.println("Too Low try Again Higher Range ' 25 - 50 '");
					
				}if(random>=50 && random<=75) {
					
					System.out.println("Too Low try Again Higher Range ' 50 - 75 '");
					
				}if(random>=75 && random<=100) {
					
					System.out.println("Too Low try Again Higher Range ' 75 - 100 '");
				}
			}else {
				System.out.println("-----Do did it--- Attempt it took is : "+ampt);
				correct = true;
				
				}
			}
			
		}catch(Exception e) {
			
			System.out.println("Error ' ENTER A NUMBER ' : "+e.getMessage());
		}
		
	}

}
