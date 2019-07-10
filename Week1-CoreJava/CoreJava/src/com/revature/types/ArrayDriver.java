package com.revature.types;

public class ArrayDriver {
	
	
	public static void main(String[] args) {
		
		int[] intArray1 = new int[5]; // preferred way
		int intArray2[] = new int[5];
		int[] intArray3 = {2,6,4,8,2};
		
//		for(int i = 0; i<intArray3.length; i++) {
//			System.out.println(intArray3[i]);
//		}
//		
//		for(int e : intArray3) {
//			System.out.println(e);
//		}
		
		// accessing an index  out of the alloted elements gives us an ArrayIndexOutOfBoundsException
		System.out.println(intArray3[2]);
		
		int[][] int2DArray = new int[3][4];
		
		
		printAll("Hello","World","Carolyn");
	}
	
	static void printAll(String...strArr) {
		for(String s : strArr) {
			System.out.println(s);
		}
	}

}
