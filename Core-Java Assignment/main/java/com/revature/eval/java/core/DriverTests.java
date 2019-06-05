package com.revature.eval.java.core;


import java.util.*;

public class DriverTests {
	EvaluationService es = new EvaluationService();
	
	public void Q1() {
		System.out.println(es.reverse("dog"));
		System.out.println(es.reverse("pickle"));
		System.out.println(es.reverse("racecar"));
		System.out.println(es.reverse("mighty clam"));
		System.out.println();
	}
	public void Q2() {
		System.out.println(es.acronym("mighty clam"));
		System.out.println(es.acronym("Portable Necromancer Generation"));
		System.out.println(es.acronym("Complementary metal-oxide semiconductor"));
		System.out.println();
	}
	public void Q3() {
		EvaluationService.Triangle t = new EvaluationService.Triangle();
		t.setSideOne(12);
		t.setSideTwo(12);
		t.setSideThree(12);
		System.out.println("Equalateral: " + t.isEquilateral());
		System.out.println("Isosolese: " + t.isIsosceles());
		System.out.println("Scalene: " + t.isScalene());
		

		System.out.println();
		t.setSideOne(12);
		t.setSideTwo(11);
		t.setSideThree(12);		
		System.out.println("Equalateral: " + t.isEquilateral());
		System.out.println("Isosolese: " + t.isIsosceles());
		System.out.println("Scalene: " + t.isScalene());
		
		
		System.out.println();
		t.setSideOne(12);
		t.setSideTwo(11);
		t.setSideThree(10);		
		System.out.println("Equalateral: " + t.isEquilateral());
		System.out.println("Isosolese: " + t.isIsosceles());
		System.out.println("Scalene: " + t.isScalene());
		System.out.println();
		
	}
	public void Q4() {
		System.out.println("Is it 14? : " + es.getScrabbleScore("cabbage"));
		System.out.println("Is it 6?: " + es.getScrabbleScore("aaaaaa"));
		System.out.println("Is it 9?: " + es.getScrabbleScore("doggie"));
		System.out.println();
	}
	public void Q5() {
		System.out.println("+1 (930) 564-2399: " + es.cleanPhoneNumber("+1 (930) 564-2399"));
		System.out.println("+1 (930) 564-2399: " + es.cleanPhoneNumber("223 456   7890   "));
		//System.out.println("+1 (930) 564-23992: " + es.cleanPhoneNumber("+1 (230) 564-23992"));
		//System.out.println("+1 (930) 564-23992: " + es.cleanPhoneNumber("123-abc-7890"));
		System.out.println();
	}
	public void Q6() {
		Map<String, Integer> actualWordCount = es.wordCount("one,\ntwo,\nthree");
		Iterator<String> itr = actualWordCount.keySet().iterator(); 

		while(itr.hasNext()) {
		   System.out.println(itr.next()); 
		}
		 
	}
	public void Q7() {
		//List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));
		//EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedList);
		//search.indexOf(1);
		//List<Integer> sortedListOfOddLength = Collections.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634));

		//EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedListOfOddLength);

		//search.indexOf(144);//(9, search.indexOf(144));
		
		//EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedListOfOddLength);
		//search.indexOf(144);
		List<String> sortedList = Collections.unmodifiableList(Arrays.asList("1", "3", "4", "6", "8", "9", "11"));

		EvaluationService.BinarySearch<String> search = new EvaluationService.BinarySearch<>(sortedList);

		search.indexOf("6");
	}
	public void Q8() {
		System.out.println();
		es.isArmstrongNumber(153);
		es.isArmstrongNumber(5);
		
	}
	public void Q9() {
		System.out.println();
		es.isPangram("abcdefghijklmnopqrstuvwxyz");
		es.isPangram("the quick brown fox jumps over the lazy dog");
		
	}
	
	public void Q10() {
		EvaluationService.RotationalCipher rc = new EvaluationService.RotationalCipher(5);
		
		
		System.out.println("Is it trl?: " + rc.rotate("omg"));
	}
	public void Q11() {
		EvaluationService.AtbashCipher ac = new EvaluationService.AtbashCipher();
		
		ac.encode("mindblowingly");
		ac.encode("The quick brown fox jumps over the lazy dog.");
	}
	public void Q12() {
		System.out.println("");
		EvaluationService.AtbashCipher ac = new EvaluationService.AtbashCipher();
		ac.decode("gvhgr mt123 gvhgr mt");
		
	}
	
	public void Q13() {
		es.isValidIsbn("3-598-21508-8");
		es.isValidIsbn("3-598-21508-9");
	}

	
}
