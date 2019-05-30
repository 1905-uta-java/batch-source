package com.revature.strings;

public class StringDriver {

	public static void main(String[] args) {
		StringBuffer sbfr = new StringBuffer();
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		System.out.println("== " + (string1 == string2));
		System.out.println(".equals = " + string1.equals(string2));
		
		String alsoString1 = string1;
		//this does not modify the actual value but rather creates a new string in the string pool
		//which it is not referencing
		string1 = string1 + "1";
		
		System.out.println(alsoString1);
		System.out.println(string1);
		
		System.out.println("== " + (string1 == alsoString1));
		System.out.println(".equals = " + string1.equals(alsoString1));
		
		//StringBuilders
		StringBuilder sbldr1 = new StringBuilder("I'm a StringBuilder Object.");
		StringBuilder sbldr2 = new StringBuilder("I'm a StringBuilder Object.");
		
		System.out.println();
		System.out.println("StringBuilders: ");
		System.out.println("== " + (sbldr1 == sbldr2));
		System.out.println(".equals = " + sbldr1.equals(sbldr2));
		
		System.out.println();
		
		//Same value same references
		StringBuilder alsoSbldr1 = sbldr1;
		sbldr1.append("!!!");
		System.out.println(sbldr1);
		System.out.println(alsoSbldr1);
		System.out.println(sbldr1 == alsoSbldr1);
		
		System.out.println();
		System.out.println();
		String str1 = "Hello World";
		String str2 = "Hello World";
		String str3 = new String("Hello World");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		str3 = str3.intern();
		System.out.println(str1 == str3);
	}

}
