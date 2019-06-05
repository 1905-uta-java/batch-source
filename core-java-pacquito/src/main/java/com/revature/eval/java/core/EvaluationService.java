package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		char[] reverse = new char[string.length()];
		for(int i = 0; i<=string.length()-1; i++) {
			reverse[i] = string.charAt((string.length()-1) - i);
		}
		String reverseString = new String(reverse);
		return reverseString;
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
		// TODO Write an implementation for this method declaration
		
		String[] split = phrase.split(" |-");
		String acro = "";
		for(String s : split) {
			acro = acro+s.charAt(0);
			acro = acro.toUpperCase();
		}
		//System.out.println(acro);
		return acro;
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
			// TODO Write an implementation for this method declaration
			boolean result = getSideOne() == getSideTwo() && getSideTwo() == getSideThree() && getSideOne() == getSideThree();
			return result;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			boolean result = getSideOne() == getSideTwo() || getSideTwo() == getSideThree() || getSideOne() == getSideThree();
			return result;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			boolean result = getSideOne() != getSideTwo() && getSideTwo() != getSideThree() && getSideOne() != getSideThree();
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
		// TODO Write an implementation for this method declaration
		char[] onept = {'a','e','i','o','u','l','n','r','s','t'};
		ArrayList<Character> onePoint = new ArrayList<Character>();
		for(char c : onept) {
			onePoint.add(c);
		}
		char[] twopt = {'d','g'};
		ArrayList<Character> twoPoint = new ArrayList<Character>();
		for(char c : twopt) {
			twoPoint.add(c);
		}
		char[] threept = {'b','c','m','p'};
		ArrayList<Character> threePoint = new ArrayList<Character>();
		for(char c : threept) {
			threePoint.add(c);
		}
		char[] fourpt = {'f','h','v','w','y'};
		ArrayList<Character> fourPoint = new ArrayList<Character>();
		for(char c : fourpt) {
			fourPoint.add(c);
		}
		char[] fivept = {'k'};
		ArrayList<Character> fivePoint = new ArrayList<Character>();
		for(char c : fivept) {
			fivePoint.add(c);
		}
		char[] eightpt = {'j','x'};
		ArrayList<Character> eightPoint = new ArrayList<Character>();
		for(char c : eightpt) {
			eightPoint.add(c);
		}
		char[] tenpt = {'q','z'};
		ArrayList<Character> tenPoint = new ArrayList<Character>();
		for(char c : tenpt) {
			tenPoint.add(c);
		}
		int score = 0;
		
		char[] charArr = string.toLowerCase().toCharArray();
		for(char c : charArr) {
			if (onePoint.contains(c)) {
			 score = score +1;
			} else if (twoPoint.contains(c)) {
				score = score + 2;
			} else if (threePoint.contains(c)) {
				score = score + 3;
			} else if (fourPoint.contains(c)) {
				score = score + 4;
			} else if (fivePoint.contains(c)) {
				score = score + 5;
			} else if (eightPoint.contains(c)) {
				score =  score + 8;
			} else if (tenPoint.contains(c)) {
				score = score + 10;
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
		// TODO Write an implementation for this method declaration
		char[] charArr = string.toCharArray();
		String cleaned = new String();
		ArrayList<Character> numbers = new ArrayList<Character>();
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

		for(char c: charArr) {
			if(numbers.contains(c)) {
				cleaned = cleaned +c;
			}
		}
		
		if(cleaned.length() > 10 || cleaned.length() < 10) {
			throw new IllegalArgumentException();
			}
		if(cleaned.charAt(0) == '1') {
			cleaned = cleaned.substring(1);
			}
		return cleaned;
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
		// TODO Write an implementation for this method declaration
		Map<String, Integer> count = new HashMap<String, Integer>();
		String[] subStrings = string.trim().split("\\W");
		for(String s : subStrings) {
			if(s.isEmpty()) {
				continue;
			}
			if(count.containsKey(s)) {
				count.put(s, count.get(s)+1);
			} else {
			count.put(s, 1);}
		}
		return count;
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
	static class BinarySearch<T extends Comparable<T>>{
		private List<T> sortedList;

		public int indexOf(T t) {

		int lower = 0, up = sortedList.size(), index =0, half = 0;
		while(lower<=up) {
			half = (lower + (up-1)) /2;
		if(t.compareTo(sortedList.get(half)) ==0) {
			index = half;
			lower = sortedList.size()+1;
		} else if(sortedList.get(half).compareTo(t) > 0) {
			up = half - 1;
		} else if(sortedList.get(half).compareTo(t) < 0) {
			lower = half + 1;
		}
		}
		
			
			return index;
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
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String num = String.valueOf(input);
		char[] digitidus = num.toCharArray();
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		for(char c : digitidus) {
			//System.out.println(c);
			intArr.add(Character.digit(c, 10));
		}
		double check =0;
		for(int i : intArr) {
			//System.out.println(Math.pow(i, intArr.size()));
			check = check + Math.pow(i, intArr.size());
		}
		//System.out.println(Math.round(check) == input);
		return Math.round(check) == input;
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
		// TODO Write an implementation for this method declaration
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Map<Character, Integer> charCount = new HashMap<Character,Integer>();
		String[] strArr = string.toLowerCase().split(" ");
		for(String s : strArr) {
			char[] charArr = s.toCharArray();
			for(char c : charArr) {
				charCount.put(c, 0);
			}
		}
		
		boolean result = false;
		if(charCount.size() == 26) {
			result = true;
		} else {result = false;}
		return result;
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
			// TODO Write an implementation for this method declaration
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			Map<Character, Character> rotated = new HashMap<Character, Character>();
			int i = this.key;
			for(char c : alphabet) {
				if (i<alphabet.length) { rotated.put(c, alphabet[i]);}
				i++;
			}
			
			//at this point rotated has the letters from the key index to the end of the alphabet.
			i = 0;
			for(int j = alphabet.length - this.key; j<alphabet.length;j++) {
				if(!rotated.containsKey(alphabet[j])) {
				rotated.put(alphabet[j], alphabet[i]);}
				i++;
			}
//			Set<Character> keys = rotated.keySet();
//			for(char c : keys) {
//				System.out.println(c +" : " +rotated.get(c));
//			}
			String result = "";
			//String[] input = string.split(" ");
			//for(String s : input) {
				char[] charArr = string.toCharArray();
				for(char c : charArr) {
					if(Character.isLetter(c)) {
					if(Character.isUpperCase(c)) {
						char upCased = Character.toUpperCase(rotated.get(Character.toLowerCase(c)));
						result= result+upCased;
					} else { result = result+rotated.get(c); }
					} else { result = result + c; }
				}
			//}
			
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
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			Map<Character, Character> reversed = new HashMap<Character, Character>();
			int i = 25;
			for(char c : alphabet) {
				reversed.put(c, alphabet[i]);
				i--;
			}
//			Set<Character> keys = reversed.keySet();
//			for(char c : keys) {
//				System.out.println(c +" : " +reversed.get(c));
//			}
			char[] input = string.toLowerCase().toCharArray();
			String result = "";
			for(char c: input) {
				//should check for uppercase and invlalid characters when encoding string
				if(Character.isLetter(c)) {
				result = result + reversed.get(c);
				} else if(Character.isWhitespace(c)) {
					//do nothing with whitespace
				} else if(Character.isDigit(c)) {
					result = result + c;
				}
			}
			String finalString = "";
			if(string.length() >5) {
			int offset = 1;
			finalString = finalString + result.substring(0, 5*offset);
			offset++;
			while(5*offset <= result.length()) {
				finalString = finalString + " "+result.substring(5*(offset-1), 5*offset);
				offset++;
			}
			finalString = finalString + " " + result.substring(5*(offset-1), result.length());
			} else { finalString = result; }
			
			//System.out.println(finalString.trim());

			return finalString.trim();
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			Map<Character, Character> decoded = new HashMap<Character, Character>();
			int i = 25;
			for(char c : alphabet) {
				decoded.put(alphabet[i], c);
				i--;
			}
			
			char[] input = string.toCharArray();
			String result = "";
			for(char c: input) {
				if(Character.isLetter(c)) {
				result = result + decoded.get(c);
				} else if(Character.isDigit(c)) {
					result = result + c;
				} else if(Character.isWhitespace(c)) {
					//no whitespaces
				}
			}
			return result;
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
