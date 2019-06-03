package com.revature.stacks;

public class StackDriver {
	
	public static void main(String[] args) {
		
		Stack<Integer> intStack = new Stack<Integer>();
		
		pushAndMessage(intStack, 3);
		pushAndMessage(intStack, 6);
		pushAndMessage(intStack, 5);
		pushAndMessage(intStack, 2);
		
		System.out.println();
		
		printStack(intStack);
		
		System.out.println();
		System.out.println();
		
		popAndMessage(intStack);
		popAndMessage(intStack);
		
		System.out.println();
		
		printStack(intStack);
		
		System.out.println();
		System.out.println();
		
		popAndMessage(intStack);
		pushAndMessage(intStack, 1);
		pushAndMessage(intStack, 2);
		pushAndMessage(intStack, 20);
		
		System.out.println();
		
		printStack(intStack);
	}
	
	static <T> void popAndMessage(Stack<T> stack) {
		
		T element = stack.pop();
		
		if(element == null)
			System.out.println("Stack empty: nothing popped");
		else
			System.out.println("Popping: " + element);
	}
	
	static <T> void pushAndMessage(Stack<T> stack, T element) {
		
		stack.push(element);
		
		System.out.println("Pushing: " + element);
	}
	
	static <T> void printStack(Stack<T> stack) {
		
		System.out.println("Stack: ");
		
		Object[] elements = stack.toArray();
		
		for(int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
		}
	}
}
