package com.revature.stacks;

import java.util.ArrayList;
import java.util.Collections;

public class Stack<T> {
	
	private ArrayList<T> data;
	
	public Stack() {
		
		data = new ArrayList<T>();
	}
	
	public Stack(T... inputData) {
		
		this();
		
		for(T t : inputData)
			data.add(t);
	}
	
	public void push(T element) {
		
		data.add(element);
	}
	
	/**
	 * 
	 * @return 
	 */
	public T pop() {
		
		if(data.size() == 0)
			return null;
		
		return data.remove(data.size() - 1);
	}
	
	/**
	 * @return an array of type T, which represents the current state of the stack
	 */
	public T[] toArray() {
		
		ArrayList<T> cloneData = (ArrayList<T>) data.clone();
		
		Collections.reverse(cloneData);
		
		return (T[]) cloneData.toArray();
	}
}
