package com.revature;

public class MyStack<E> {
	
	private Object[] values = new Object[10];
	private int currentIndex = 0;
	
	public void addValue(E element) {
		// resize our array if it cannot accommodate our new value 
		if(currentIndex+1>values.length-1) {
			Object[] newValues = new Object[values.length+10];
			for(int i=0; i<values.length;i++) {
				newValues[i] = values[i];
			}
			values = newValues;
		} 
		// add our value to the next index
		values[currentIndex++] = element;
	}
	
	@SuppressWarnings("unchecked")
	public E removeValue() {
		if(currentIndex == 0 ) {
			return null;
		}
		E currentVal = (E) values[--currentIndex];
		values[currentIndex] = null;
		return currentVal;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		Object[] returnArr = new Object[currentIndex];
		for(int i = 0; i<returnArr.length; i++) {
			returnArr[i] = values[i];
		}
		return (E[]) returnArr;
	}
	

}
