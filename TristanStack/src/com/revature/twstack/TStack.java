package com.revature.twstack;

import java.util.LinkedList;

public class TStack<T> {
	private LinkedList<T> stack;
	
	public void push(T pu) {
		stack.add(pu);
	}
	
	public T pop() {
		T ret = stack.getLast();
		stack.removeLast();
		return ret;
	}
	
	public Object[] toArray() {
		return stack.toArray();
	}
}
