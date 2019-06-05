package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return backStr
	 */
	public String reverse(String string) {
		int indx = string.length() - 1; //otherwise we have an OutOfBounds error
		char backChar;
		String backStr = "";

		while(indx > -1) {
			backChar = string.charAt(indx); 
			backStr = backStr + backChar;
			
			indx--;
		}
		
		return backStr;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return acr
	 */
	public String acronym(String phrase) {
		phrase = phrase.replaceAll(", |-|//W", " ");
		String[] strArr = phrase.split(" ");
		String acr = "";
		char chr;
		
		for(int i = 0; i < strArr.length; i++) {
			chr = strArr[i].charAt(0);
			acr = acr + chr;
		}
		acr = acr.toUpperCase();
		
		return acr;
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
			
			if((getSideOne() == getSideTwo()) &&
					(getSideOne() == getSideThree()) &&
					(getSideTwo() == getSideThree())){
				return true;
			} else {
				return false;				
			}
		}

		public boolean isIsosceles() {
			if((getSideOne() == getSideTwo()) && getSideOne() != getSideThree() ||
					(getSideOne() == getSideThree()) && getSideOne() != getSideTwo()||
					(getSideTwo() == getSideThree()) && getSideTwo() != getSideOne()) {
				return true;
			} else {
				return false;				
			}
		}

		public boolean isScalene() {
			
			if(getSideOne() != getSideTwo() &&
					getSideOne() != getSideThree() &&
					getSideTwo() != getSideThree()) {
				return true;
			} else {
				return false;				
			}
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
	 * @return totalPoints
	 */
	public int getScrabbleScore(String string) {
		string = string.toUpperCase();
		String scannedChars = "";
		char chr;
		int score = 0;
		int totalPoints = 0;
		int multiplier = 0;
		
		
		for(int i = 0; i < string.length(); i++) {
			chr = string.charAt(i);
			
			if(scannedChars.indexOf(chr) == -1) { //check to make sure char hasn't already been scanned
				scannedChars = scannedChars + chr; // add character to scannedChars so we don't scan it twice
				for (int j = 0; j < string.length(); j++) {
					if (string.charAt(j) == chr) {
						multiplier++;
					}
				}
				
				//check, do some math
				if(chr == 'A'||chr == 'E' || chr == 'I' || chr == 'O' || 
						chr == 'U' || chr == 'L' || chr == 'N' || 
						chr == 'R' || chr == 'S' || chr == 'T') {
					score = 1 * multiplier;
				} else if(chr == 'D' || chr == 'G') {
					score = 2 * multiplier;
				} else if(chr == 'B' || chr == 'C' || chr == 'M' || chr == 'P') {
					score = 3 * multiplier;
				} else if(chr == 'F' || chr == 'H' || chr == 'V' || chr == 'W' || 
						chr == 'Y') {
					score = 4 * multiplier;
				} else if (chr == 'K') {
					score = 5 * multiplier;
				} else if (chr == 'J' || chr == 'X') {
					score = 8 * multiplier;
				} else if (chr == 'Q' || chr == 'Z') {
					score = 10 * multiplier;
				} else {
					System.out.println(chr + " is an invalid character.");
				}
				
				totalPoints = totalPoints + score; //add to score. 
				multiplier = 0; // reset multiplier
			}
		}		 
			return totalPoints;
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
		int n = 0;
		char chr;
		boolean illegalNum = false;
		String newStr = "";
		String legalChars = " +().-0123456789";
		
		for(int j = 0; j < string.length(); j++) {
			chr = string.charAt(j);
			if(legalChars.indexOf(chr) == -1) //bad characters present in string
				illegalNum = true;
			
		}
		
		if (!illegalNum) {
			//pull out only numbers, put into string. 
			for(int i = 0; i < string.length(); i++) {
				chr = string.charAt(i);
				if(chr == '1' || chr == '2' || chr == '3' || chr == '4' ||
						chr == '5' ||chr == '6' || chr == '7' || chr == '8' ||
						chr == '9' ||chr == '0'){
					newStr = newStr + chr;
 				}
			}
		
			//remove 1 from beginning & check next num is >=2
			if(newStr.length() <= 11) {
				if(newStr.length() == 11) {
					if(newStr.charAt(0) == '1') // so far so legal
						newStr = newStr.substring(1); // remove 1 from beginning
					else // NANP code is bad 
						illegalNum = true;
					
				}
				
				n = Character.getNumericValue(newStr.charAt(0));
				if(n == 1) 
					illegalNum = true;	
			} else //phone length is too long
				illegalNum = true;
		}
		
		if(illegalNum) 
			throw new IllegalArgumentException();
		else
			return newStr;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return wordHashMap
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> wordHashMap = new HashMap<>();
		string = string.replaceAll("\n", "");
		string = string.replaceAll("[,|, ]", " ");
		String[] strArr = string.split("\\s"); // some regex, this will split at either space or comma
		int key = 0;
		
		for (int i = 0; i < strArr.length; i++) {
			key = 0;
			if(wordHashMap.containsKey(strArr[i])) {
				key = wordHashMap.get(strArr[i]) + 1;
				wordHashMap.put(strArr[i], key);
			} else {
				wordHashMap.put(strArr[i], 1);
			}
		}
		return wordHashMap;
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
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int upper = 0;
			int middle = sortedList.size()/2;
			int lower = sortedList.size();
			boolean found = false;
			
			while(!found) {
				if(t.compareTo(sortedList.get(middle)) == -1){
					lower = middle;
				} else if (t.compareTo(sortedList.get(middle)) == 1) {
					upper = middle;
				} else if (t.compareTo(sortedList.get(middle)) == 0) {
					found = true;
				}
				
				middle = (upper + lower)/2; // reset middle
				
				if(middle == 0) {
					if(sortedList.get(upper).equals(t)) {
						found = true;
						break;
					} else if (sortedList.get(lower - 1).equals(t)) {
						found = true;
					}
					break;
				}
			}
			return middle;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
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
	 * @return boolean
	 */
	public boolean isArmstrongNumber(int input) {
		String intStrVal = String.valueOf(input);
		int exp = intStrVal.length();
		int singleNum = 0;
		int num = 0;
		
		for(int i = 0; i < exp; i++) {
			singleNum = Character.getNumericValue(intStrVal.charAt(i));			
			singleNum = (int) Math.pow(singleNum, exp);
			num = num + singleNum;
		}
		if(num == input)
			return true;
		else
			return false;
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
	 * @return boolean
	 */
	public boolean isPangram(String string) {
		String strDownString = string.toLowerCase();
		String scannedChars = "";
		char chr;
		
		strDownString = strDownString.replaceAll("\\s", ""); //remove all spaces from phrase
		
		for(int i = 0; i < strDownString.length(); i++) {
			chr = strDownString.charAt(i);
			
			if(scannedChars.indexOf(chr) == -1) 
				scannedChars = scannedChars + chr;
			else // don't count it, keep going
				continue;
		}
		
		if(scannedChars.length() == 26)
			return true;
		else
			return false;
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

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			Character[] alphL = new Character[26];
			Character[] alphU = new Character[26];
			int charKey;
			int indx;
			char beginChr = 'a';
			char newChr;
			char chr;
			String newStr = "";
			
			// load the alph char array with lowercase alphabet characters
			 for(int i = 0; i < 26; i++) { 
				 alphL[i] = beginChr;
				 beginChr++; 
			 }
			 beginChr = 'A'; 
			 // load the alph char array with uppercase characters
			 for(int i = 0; i < 26; i++) { 
				 alphU[i] = beginChr;
				 beginChr++; 
			 }
			 for (int i = 0; i < string.length(); i++) {
				 chr = string.charAt(i);
				 indx = -1;
				
				//check lowercase first 
				for(int j = 0; j < alphL.length; j++) {
					if(alphL[j] == chr)
						indx = j;
					
				}
				if(indx != -1) {
					charKey = (indx + key) % 26; // add (rotate) char and mod by 26
					chr = alphL[charKey];
				}
				indx = -1;
				//check uppercase next
				for(int k = 0; k < alphL.length; k++) {
					if(alphU[k] == chr)
						indx = k; 		
					} 
				if(indx != -1) {
					charKey = (indx + key) % 26; // add (rotate) char and mod by 26
					chr = alphU[charKey];
				}
				
				newStr = newStr + chr; //this is for anything not in alphabet
				
			}
			
 			return newStr;
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
		 * @return newStr
		 */
		public static String encode(String string) {
			Character alph[] = new Character [26];
			int index = 0; 
			char chr;
			char startChar = 'a';
			String newStr = "";
			
			string = string.toLowerCase().replaceAll("\\s|[^a-z0-9]", "");
			//string = string.toLowerCase().replaceAll("[^a-z0-9]", "");
			
			for(int i = 0; i < 26; i++) { // initialize alphabet array 
				alph[i] = startChar;
				startChar++;
			}
			
			for(int j = 0; j < string.length(); j++) {
				chr = string.charAt(j);
				for(int k = 0; k < alph.length; k++) { // check array for letter
					if(alph[k] == chr) {
						index = k;
						break;
					} else 
						index = -1;
				}
				
				if(j % 5 == 0 && j != 0) { // add space every 5 characters
					newStr = newStr + " ";
				}
				
				
				if (index!= -1) {
					index = (index - 26) * (-1);
					chr = alph[index-1];
				} 
				newStr = newStr + chr;
				
				
			}
			
			return newStr;
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return newStr
		 */
		public static String decode(String string) {
			Character alph[] = new Character [26];
			int index = 0; 
			char chr;
			char startChar = 'a';
			String newStr = "";
			
			string = string.replaceAll(" ", "");
			//string = string.toLowerCase().replaceAll("[^a-z0-9]", "");
			
			for(int i = 0; i < 26; i++) { // initialize alphabet array 
				alph[i] = startChar;
				startChar++;
			}
			
			for(int j = 0; j < string.length(); j++) {
				chr = string.charAt(j);
				for(int k = 0; k < alph.length; k++) { // check array for letter
					if(alph[k] == chr) {
						index = k;
						break;
					} else 
						index = -1;
				}
				if (index!= -1) {
					index = (index - 26) * (-1);
					chr = alph[index-1];
				} 
				newStr = newStr + chr;
				
			}
			
			return newStr;
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
