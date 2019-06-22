package com.revature;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Driver {
	

	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		//create a collection of associates, shuffle them and implement its iterator
		AssociateCollection associateCollection = new AssociateCollection();
		//System.out.println(associateCollection);
		Collections.shuffle(associateCollection);
//		for(Associate a : associateCollection) {
//			System.out.println(a.getName());
//		}
		Iterator<Associate> itr = associateCollection.iterator();
		
		//create a collection of associates, shuffle them and implement its iterator
		QuestionCollection questionCollection = new QuestionCollection();
		Collections.shuffle(questionCollection);
		Iterator<Question> itrQ = questionCollection.iterator();

		System.out.println("Welcome to.. THE GAME!!");
		sc.nextLine();
		
		while(itrQ.hasNext()) {
			if(!itr.hasNext()) {
				Collections.shuffle(associateCollection);
				itr = associateCollection.iterator();
				itr.next();
			}
			System.out.println(itr.next().getName()+":");
			System.out.println(itrQ.next().getContent());
			sc.nextLine();
		}
	
		System.out.println("The game is over..");

	}

}