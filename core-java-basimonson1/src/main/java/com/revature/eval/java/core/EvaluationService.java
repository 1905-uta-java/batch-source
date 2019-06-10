package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		
		// initialize as nothing
		String result = "";
		
		/*
		 *  Use a for loop to cycle through the string one character at a time. Use string.length() - 1 to get the length. 
		 *  - 1 is necessary to prevent out of bounds
		 *  i -- so that the for loop moves backwards through the index (4, 3, 2, 1, 0)
		 *  save each character as it prints out to a new string and return that result
		 */
		
		for (int i = string.length() - 1; i >= 0; i --) {
			result = result + string.charAt(i);
		}

		return result;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		// Separate out each word and then take the first character of each word. Make it uppercase and add it to the acronym.
		
		String result = "";
		char[] words;
		words = phrase.toCharArray();
		
		for (int i = 0; i <= words.length -1; i ++) {
			if (i > 0 && words[i-1] != ' ') {
				words[i] = Character.toLowerCase(words[i]);
			}
			
			if ((i > 0 && words[i-1] == ' ') || (i > 0 && words[i-1] == '-')) {
				words[i] = Character.toUpperCase(words[i]);
			}
			
			if (Character.isUpperCase(words[i])) {
				result = result + words[i];
			}
			
		}
		
		
		
//		for (int i = 0; i <= phrase.length() - 1; i++) {
//			
//			if(i > 0 && phrase.charAt(i-1) != ' ') {
//				char curChar = phrase.charAt(i);
//				curChar = Character.toLowerCase(curChar);
//			}
//			
//			if (Character.isUpperCase(phrase.charAt(i))){
//				result = result + phrase.charAt(i);
//			}
//			
//		}
		
		return result;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			
			boolean result = false;

			if (sideOne == sideTwo && sideTwo == sideThree) {
				result = true;
			}
			
			return result;
		}

		public boolean isIsosceles() {

			boolean result = false;
			
			if (sideOne == sideTwo || sideTwo == sideThree || sideThree == sideOne) {
				result = true;
			}
			
			return result;
		}

		public boolean isScalene() {
			boolean result = false;

			if (sideOne == sideTwo || sideTwo == sideThree || sideThree == sideOne) {
				result = false;
			} else {
				result = true;
			}
			
			return result;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		String word = "";
		int score = 0;
		char[] value1 = {'A','E','I','O','U','L','N','R','S','T','a','e','i','o','u','l','n','r','s','t'};
		char[] value2 = {'D','G','d','g'};
		char[] value3 = {'B','C','M','P','b','c','m','p'};
		char[] value4 = {'F','H','V','W','Y','f','h','v','w','y'};
		char[] value5 = {'K','k'};
		char[] value8 = {'J','X','j','x'};
		char[] value10 = {'Q','Z','q','z'};
		
		
		
		for (int i = 0; i <= string.length() - 1; i++) {
			
			word = word + string.charAt(i);
			//System.out.println(word);
			
			for (int c = 0; c <= value1.length - 1; c++) {
				char cycle;
				cycle = value1[c];
				
				if (string.charAt(i) == cycle) {
					score++;
				}
			}
			
			for (int c = 0; c <= value2.length - 1; c++) {
				char cycle;
				cycle = value2[c];
				
				if (string.charAt(i) == cycle) {
					
					score = score + 2;
				}
			}
			
			for (int c = 0; c <= value3.length - 1; c++) {
				char cycle;
				cycle = value3[c];
				
				if (string.charAt(i) == cycle) {
					score = score + 3;
				}
			}
			
			for (int c = 0; c <= value4.length - 1; c++) {
				char cycle;
				cycle = value4[c];
				
				if (string.charAt(i) == cycle) {
					score = score + 4;
				}
			}
			
			for (int c = 0; c <= value5.length - 1; c++) {
				char cycle;
				cycle = value5[c];
				
				if (string.charAt(i) == cycle) {
					score = score + 5;
				}
			}
			
			for (int c = 0; c <= value8.length - 1; c++) {
				char cycle;
				cycle = value8[c];
				
				if (string.charAt(i) == cycle) {
					score = score + 8;
				}
			}
			
			for (int c = 0; c <= value10.length - 1; c++) {
				char cycle;
				cycle = value10[c];
				
				if (string.charAt(i) == cycle) {
					score = score + 10;
				}
			}
						
		}
			
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		String[] numbers = string.split("[1| |-|.|(|)|-]");
		
		String result = "";
		try {
			for (String test : numbers) {
				result = result + test;
						
				if ((result.length() > 10 && string.charAt(0) != '1')) {
					throw new IllegalArgumentException();
				} 	
			}
			
			if (result.matches("^[0-9]+$")){
			} else {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			throw e;
		}
		
		return result;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		HashMap<String, Integer> map = new HashMap<>();
		
		String[] phrase = string.split(" |,");
		
		String[]trimmedPhrase = new String[phrase.length];
		
		for (int i = 0; i < phrase.length; i++) {
		    trimmedPhrase[i] = phrase[i].trim();
		}
		
		String result = "";
		
		for (String test : trimmedPhrase) {
			result = test;
			
			if (map.containsKey(result)) {
				System.out.println("If statement");
				map.put(result, map.get(result) + 1);
			} else {
				map.put(result, 1);
			}
						
		}
		
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable> {
		private List<T> sortedList = new ArrayList<T>();
		
		static Integer key;
				


		public int indexOf(T t) {
			this.sortedList = sortedList;
			
			
			
			int lower = 0;
			int upper = sortedList.size()-1;
			int mid = (lower + upper) / 2;
			List<Integer> intList = new ArrayList<>();
			List<String> stringList = new ArrayList<>();
			
			System.out.println(t.getClass().toString() + " " + sortedList.get(mid).getClass().toString());
			for (int i = 0; i < sortedList.size(); i++) {
				stringList.add(sortedList.get(i).toString());
			}
			
			for (int i = 0; i < sortedList.size(); i++) {
				intList.add(Integer.parseInt(stringList.get(i)));
			}
			
			

		//	int result = (int)t.compareTo((int)intList.get(mid));
			
			int result = t.compareTo(sortedList.get(mid));
			
			if (result == 0) {
				key = mid;
			}
			
			
			
			while (result != 0) {
				if (result == 1) {
					lower = mid;
					System.out.println("Upper: " + upper + " Mid: " + mid + " Lower: " + lower);	
					mid = (upper + lower) / 2;
					if (lower == (upper - 1)) {
						mid = upper;
					} 
					System.out.println("Upper: " + upper + " Mid: " + mid + " Lower: " + lower );					
					result = t.compareTo(sortedList.get(mid));
					System.out.println(result);
					
				} else if (result == -1) {
					upper = mid;
					System.out.println("Upper: " + upper + " Mid: " + mid + " Lower: " + lower);
					mid = (upper + lower) / 2;
					if (upper == - 1) {
						mid = 0;
					}
					System.out.println("Upper: " + upper + " Mid: " + mid + " Lower: " + lower);
					//midVal = (int) sortedList.get(mid);
					System.out.println("Upper: " + upper + " Mid: " + mid + " Lower: " + lower);
					result = t.compareTo(sortedList.get(mid));
					System.out.println(result);
				} 
				
				key = mid;
			}
			System.out.println("KEY: " +key);

			return key;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
			sortedList.toArray();
			
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		String digits = Integer.toString(input);
		char[] singleDig = digits.toCharArray();
		char curChar;
		ArrayList<Integer> hold = new ArrayList<>();
		int output = 0;
		
		
		/*
		 * Take the input, convert to string, then store each character into a character array.
		 * Use Math.pow to take the curCharacter and exponentially multiply by the length of the input.
		 * Store that answer in an ArrayList
		 */
		for (int i = 0; i <= digits.length() -1; i++) {
			curChar = singleDig[i];
			
			curChar = (char) Integer.parseInt(String.valueOf(curChar));
			
			int answer = (int) Math.pow(curChar, digits.length());
			
			hold.add(answer);
			
		}
		
		/*
		 * Take each value in the ArrayList and add them together. 
		 * If they equal the input, return true, else return false
		 */
		
		for (int i = 0; i <= hold.size() - 1; i++) {
			output = output + hold.get(i);
			
		}
		
		digits.toCharArray();
		
		
		if (output == input) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		string = string.replaceAll("\\s", ""); // remove all white space from strings
				
		char[] letters = string.toCharArray(); // create a character array from the string
		
		for (char c = 'a'; c < 'z'; c++) { // put all letters of the alphabet into the map with a value of 0
			map.put(c, 0);
		}
				
		
		for (char c : letters) { // for each letter that the string contains, increase the value by one
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
				
		for (Map.Entry<Character, Integer> entry : map.entrySet()) { // Check if any map values = 0, if they do, they fail
			if ((int)entry.getValue() == 0) {
				return false;
			} 
		}
		
		if (map.isEmpty()) { //if the map has nothing, it returns false
			return false;
		}
		
		
		return true;
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		char curChar;
//
//		List<Character> letters = new ArrayList<>();
//		List<Character> words = new ArrayList<>();
//		List<Character> hold = new ArrayList<>();
//		List<Character> result = new ArrayList<>();
		
		int index;
		String result;
		
		HashMap<Integer, Character> letters = new HashMap<>();
		HashMap<Integer, Character> upper = new HashMap<>();

		
		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			//string = string.toLowerCase();
			
			char[] sentence = string.toCharArray();
			
			for (char c = 'a'; c <= 'z'; c++) {
				letters.put(index, c);
				index++;
			}
			
			index = 0;
			for (char c = 'A'; c <= 'Z'; c++) {
				upper.put(index, c);
				index++;
			}

			
			for (int i = 0; i < sentence.length; i++) {
				for (int j = 0; j < letters.size(); j++) {
					index = j;
					int newIndex = index + key;
					if (newIndex  > 25) {
						newIndex = newIndex - 26;
					}
					
					if (sentence[i] == upper.get(j)) {
						sentence[i] = upper.get(newIndex);
						break;
					}
					
					// System.out.println(letters.get(j));
					if (sentence[i] == letters.get(j)) {
						sentence[i] = letters.get(newIndex);
						break;
				
					}
				}
			}
			
			String result = new String(sentence);
			
			System.out.println(result);
			return result;
		}

	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 */
		
		static int index;
		String result;
		
		static HashMap<Integer, Character> letters = new HashMap<>();
		static HashMap<Integer, Character> reverse = new HashMap<>();
		static ArrayList<Character> sentence2 = new ArrayList<>();
		static ArrayList<Character> numbers = new ArrayList<>();
		static char[] sentence;
		static int count;

		
		public static String encode(String string) {
			string = string.toLowerCase();
			string = string.replaceAll(",", "");
			string = string.replaceAll("\\s", "");
			sentence = string.toCharArray();
			sentence2.clear();
						
			numbers.add('0');
			numbers.add('1');
			numbers.add('2');
			numbers.add('3');
			numbers.add('4');
			numbers.add('5');
			numbers.add('6');
			numbers.add('7');
			numbers.add('8');
			numbers.add('9');
			
			for (char c = 'a'; c <= 'z'; c++) {
				letters.put(index, c);
				index++;
			}
			index = 0;
			
			for (char c = 'z'; c >= 'a'; c--) {
				reverse.put(index, c);
				index++;
			}
			
			
			for (int i = 0; i < sentence.length; i++) {
				if (i % 5 == 0) {
					sentence2.add(' ');
				}
				for (int j = 0; j < letters.size(); j++) {
					
					// System.out.println(letters.get(j));
					if (sentence[i] == letters.get(j)) {
						sentence[i] = reverse.get(j);
						sentence2.add(sentence[i]);
						break;
					} 
				}
				
				for (int k = 0; k < numbers.size(); k++) {
				if (sentence[i] == numbers.get(k)) {
					sentence2.add(sentence[i]);
					break;
					}
				}
			}
			
			if (sentence2.get(0) == ' ') {
				sentence2.remove(sentence2.get(0));
			}
			if (sentence2.get(sentence2.size()-1) == ' ') {
				sentence2.remove(sentence2.size()-1);
			}
			
			String result3 = sentence2.stream().map(String :: valueOf).collect(Collectors.joining());
			
			System.out.println(result3);
			
			return result3;
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.toLowerCase();
			string = string.replaceAll(",", "");
			string = string.replaceAll("\\s", "");
			sentence = string.toCharArray();
			sentence2.clear();
			
			numbers.add('0');
			numbers.add('1');
			numbers.add('2');
			numbers.add('3');
			numbers.add('4');
			numbers.add('5');
			numbers.add('6');
			numbers.add('7');
			numbers.add('8');
			numbers.add('9');
			
			for (char c = 'a'; c <= 'z'; c++) {
				reverse.put(index, c);
				index++;
			}
			index = 0;
			
			for (char c = 'z'; c >= 'a'; c--) {
				letters.put(index, c);
				index++;
			}
			
			
			for (int i = 0; i < sentence.length; i++) {
				if (i % 5 == 0) {
					
				}
				for (int j = 0; j < letters.size(); j++) {
					
					// System.out.println(letters.get(j));
					if (sentence[i] == letters.get(j)) {
						sentence[i] = reverse.get(j);
						sentence2.add(sentence[i]);
						break;
					} 
				}
				
				for (int k = 0; k < numbers.size(); k++) {
				if (sentence[i] == numbers.get(k)) {
					sentence2.add(sentence[i]);
					break;
					}
				}
			}
			
			if (sentence2.get(0) == ' ') {
				sentence2.remove(sentence2.get(0));
			}
			if (sentence2.get(sentence2.size()-1) == ' ') {
				sentence2.remove(sentence2.size()-1);
			}
			
			String result3 = sentence2.stream().map(String :: valueOf).collect(Collectors.joining());
			
			System.out.println(result3);
			
			return result3;		
		}
	}

	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
