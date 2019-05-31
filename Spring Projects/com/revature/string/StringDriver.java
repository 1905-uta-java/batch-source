package com.revature.string;
public class StringDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		System.out.println("==" + (string1 == string2));
		System.out.println(".equals" + string1.equals(string2));
		
		
		String alsoString1 = string1;
		//this des not modify the actual value of the string, it creates a new string
		//in the string pool which it now references
		string1 += string1 + "1";
		System.out.println(string1);
		System.out.println(alsoString1);
		
		System.out.println("==" + (string1 == alsoString1));
		System.out.println(".equals" + string1.equals(alsoString1));
	}

}
