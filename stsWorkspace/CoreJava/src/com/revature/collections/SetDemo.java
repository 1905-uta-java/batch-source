package com.revature.collections;

import java.util.HashSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		/*
		 * HashSet
		 *  - values have to be unique
		 *  - uses HashMap, but include a dummy value for the value in the key value pair
		 *  - no intuitive ordering, can change over time nullifying the key
		 */
		
		HashSet<Integer> hSet1 = new HashSet<Integer>();
		hSet1.add(1);
		hSet1.add(4);
		hSet1.add(61);
		hSet1.add(8);
		hSet1.add(0);
		
		
		System.out.println(hSet1);
		
		System.out.println();
		
		HashSet<String> hSet2 = new HashSet<String>();
		hSet2.add("1");
		hSet2.add("2");
		hSet2.add("3");
		hSet2.add("4");
		hSet2.add("01");
		System.out.println(hSet2);
		System.out.println();
		
		/*
		 * Can use a LinkedHashSet to maintain insertion order
		 * (there is a LinkedList running through the entries of the HashSet)
		 */
		
		/*
		 * TreeSet
		 * - sorted by natural ordering, uses a binary search tree
		 */
		TreeSet<Integer> tSet1 = new TreeSet<Integer>();
		tSet1.add(11);
		tSet1.add(4);
		tSet1.add(61);
		tSet1.add(1);
		tSet1.add(99);
		
		System.out.println(tSet1);
		System.out.println();
		
		TreeSet<String> tSet2 = new TreeSet<String>();
		tSet2.add("11");
		tSet2.add("rr");
		tSet2.add("o9q");
		tSet2.add("qs#");
		tSet2.add("!@#$%");
		
		System.out.println(tSet2);
		System.out.println();
	}

}
