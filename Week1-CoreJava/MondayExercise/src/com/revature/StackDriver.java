package com.revature;

import java.util.Arrays;

public class StackDriver {

	public static void main(String[] args) {
		MyStack<String> ms = new MyStack<>();
		ms.addValue("string");
		ms.addValue("another string");
		ms.addValue("string 3");
		System.out.println(Arrays.toString(ms.toArray()));
		System.out.println(ms.removeValue());
		System.out.println(Arrays.toString(ms.toArray()));
		System.out.println(ms.removeValue());
		System.out.println(Arrays.toString(ms.toArray()));
		System.out.println(ms.removeValue());
		System.out.println(Arrays.toString(ms.toArray()));
		System.out.println(ms.removeValue());
		System.out.println(Arrays.toString(ms.toArray()));

	}

}
