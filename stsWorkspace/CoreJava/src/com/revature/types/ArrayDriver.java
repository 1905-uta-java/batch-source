package com.revature.types;

import javax.print.attribute.IntegerSyntax;

public class ArrayDriver {
	
	public static void main(String[] args) {
		
		int[] intArray1 = new int[5];
		int intArray2[] = new int[5];
		int[] intArray3 = {1, 2, 3, 4, 5};
		
		// accessing an index out of the alloted elements gives us an ArrayOutOfBoundsException
		System.out.println(intArray3[4]);
		
		//for loop
		int[][] twoDArray = new int[3][4];
		for(int y = 0; y < twoDArray.length; y++) {
			for(int x = 0; x < 4; x++) {
				System.out.println(twoDArray[y][x]);
			}
		}

		//foreach
		for(int e: intArray3) {
			System.out.println(e);
		}
		
		System.out.println(addVar(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
	}
	
	//varargs (variable arguments)
	//takes any amount of parameter values so long as it is of the same data type
	static int addVar(int...intArr) {
		int count = 0;
		for(int length: intArr) {
			count += 1;
			System.out.println(intArr[length-1]);
		}
		return count;
	}
	
	//You can have multiple parameters other than varargs but it must be placed last and you cannot have more than one varargs
	static String addStr(String op, int...intArr) {
		
		return "Hello";
	}
}
