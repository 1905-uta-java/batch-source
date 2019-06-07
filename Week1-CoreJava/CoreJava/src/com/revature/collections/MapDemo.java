package com.revature.collections;

import java.util.HashMap;
import java.util.Set;

public class MapDemo {
	
	public static void main(String[] args) {
		
		
		/*
		 * HashMap
		 * - stores key value pairs
		 * - uses linked lists stored in an array
		 * - uses hashcode to determine location in array
		 * - no determined order
		 * 
		 */
		
		HashMap<String, Integer> map = new HashMap<>();
//		map.put("hello", 54);
//		Integer str = map.get("hello");
//		System.out.println(str);
		map.put("Lisa", 234);
		map.put("Paul", 356);
		map.put("George", 200);
		map.put("Lola", 500);
	
		Set<String> mapKeySet = map.keySet();
		for(String key: mapKeySet) {
			System.out.println(key+": "+map.get(key));
		}
		
		
		
		
	}

}
