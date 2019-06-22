package com.revature.string;

public class StringDriver {

	public static void main(String[] args) {
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		System.out.println("== "+ (string1 == string2));
		System.out.println(".equals "+ string1.equals(string2));
		
		String alsoString1 = string1;
		// this does not modify the actual value of string value but rather creates a new string in the string pool which it is now referencing
		string1 = string1 + "!";
		
		System.out.println(string1);
		System.out.println(alsoString1);
		
		System.out.println("== "+ (string1 == alsoString1));
		System.out.println(".equals "+ string1.equals(alsoString1));
		System.out.println();
		
		// using StringBuilder to create a mutable character sequence
		StringBuilder sb1 = new StringBuilder("I'm a StringBuilder Object");
		StringBuilder sb2 = new StringBuilder("I'm a StringBuilder Object");
		
		System.out.println("StringBuilders: ");
		System.out.println("== "+ (sb1 == sb2));
		System.out.println("equals "+ (sb1.equals(sb2)));

		StringBuilder alsoSb1 = sb1;
		sb1.append("!!!");
		System.out.println(sb1);
		System.out.println(alsoSb1);
		System.out.println(sb1 == alsoSb1);
		
		System.out.println();
		System.out.println();
		
		String str1 = "hello world";
		String str2 = "hello world";
		String str3 = new String("hello world");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		str3 = str3.intern();
		System.out.println(str1 == str3);

		
		
	}

}
