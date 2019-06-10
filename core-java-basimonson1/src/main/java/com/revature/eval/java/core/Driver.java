package com.revature.eval.java.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Driver extends EvaluationService{

	public static void main(String[] args) {

		EvaluationService evalSer = new EvaluationService();
		int num = 0;
		EvaluationService.RotationalCipher rotate = new RotationalCipher(1);
		EvaluationService.AtbashCipher cipher = new AtbashCipher();
		String test = "Ramen";
		String result = "";
		boolean bool;
		
		HashMap<String, Integer> mapResult = new HashMap<>();
		
		int answer;
		
		result = evalSer.reverse(test);
		// System.out.println(test);
		// System.out.println(result);
		
		result = evalSer.acronym("Complementary metal-oxide semiconductor");
		// System.out.println(result);
		
		answer = evalSer.getScrabbleScore("Cabbage");
		// System.out.println(answer);
		
		result = evalSer.cleanPhoneNumber("(223) 456-8890");
		// System.out.println(result);
		
		mapResult = (HashMap<String, Integer>) evalSer.wordCount("one,\ntwo,\nthree");
		//System.out.println(mapResult);
		
		
		
		
//		List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));
//
//		EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedList);
//		
//		search.indexOf(1);
		
		
		
		
		
		bool = evalSer.isArmstrongNumber(1548);
		//System.out.println(bool);
		
		bool = evalSer.isPangram("a quick movement of the enemy will jeopardize five gunboats");
		//System.out.println(bool);
		
		num = 7;
		// rotate.rotate("abcdefgz");
		
//		cipher.encode("yes");
//		cipher.encode("OMG");
//		cipher.encode("Test this please");
//		 cipher.encode("The quick brown fox jumps over the lazy dog.");
//		
//		cipher.decode("vcvix rhn");
		
		
	}

}
