package com.revature.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		/*
		 * HashSet 
		 * - must contain unique values
		 * - use HashMap, but include a dummy value for the value in the key value pair
		 * - no particular ordering, and order can change over time
		 * 
		 */
		
		HashSet<Integer> hSet1 = new HashSet<Integer>();
		hSet1.add(2);
		hSet1.add(4);
		hSet1.add(5);
		hSet1.add(8);
		hSet1.add(12);
		hSet1.add(6);
		hSet1.add(2);
		hSet1.add(4);
		hSet1.add(2);
		hSet1.add(4);
//		System.out.println(hSet1);
		
		HashSet<String> hSet2 = new HashSet<String>();
		hSet2.add("alpha");
		hSet2.add("bravo");
		hSet2.add("charlie");
		hSet2.add("delta");
		hSet2.add("echo");
		hSet2.add("foxtrot");
//		System.out.println(hSet2);
		
		/*
		 * can use a LinkedHashSet to maintain insertion order 
		 * (there is a LinkedList running through the entries of the HashSet)
		 */
		
		/*
		 * TreeSet
		 * -sorted by natural ordering, using a binary search tree
		 */
		
		TreeSet<Integer> tSet1 = new TreeSet<Integer>();
		tSet1.add(2);
		tSet1.add(4);
		tSet1.add(5);
		tSet1.add(8);
		tSet1.add(12);
		tSet1.add(6);
//		System.out.println(tSet1);
		
		TreeSet<String> tSet2 = new TreeSet<String>();
		tSet2.add("alpha");
		tSet2.add("bravo");
		tSet2.add("charlie");
		tSet2.add("delta");
		tSet2.add("echo");
		tSet2.add("foxtrot");
//		System.out.println(tSet2);
		
		TreeSet<RaceHorse> horseSet = new TreeSet<RaceHorse>(new NameComparator());
		horseSet.add(new RaceHorse(100, 7, "Secretariat", 2));
		horseSet.add(new RaceHorse(40, 5, "Sea Biscuit", 1));
		horseSet.add(new RaceHorse(10, 12, "Lightning", 3));
//		System.out.println(horseSet);
//		for(RaceHorse r: horseSet) {
//			System.out.println(r);
//		}
		
		Iterator<RaceHorse> it = horseSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Comparator<RaceHorse> rankComparator = (RaceHorse rh1, RaceHorse rh2) -> {
			return rh1.getRank() - rh2.getRank();
		};
		
		TreeSet<RaceHorse> horseSet2 = new TreeSet<RaceHorse>(rankComparator);
		horseSet2.add(new RaceHorse(100, 7, "Secretariat", 2));
		horseSet2.add(new RaceHorse(40, 5, "Sea Biscuit", 1));
		horseSet2.add(new RaceHorse(10, 12, "Lightning", 3));
		
		for(RaceHorse r: horseSet2) {
			System.out.println(r);
		}

	}

}
