package com.revature.mdo.GenericStack;

public class GenericStack<T> {
	private T[] data;
	private int top;
	private int size;

	public GenericStack( )
	{  top = -1;
	   size = 100;
	   data = (T[]) new Object[100];
	}
	
	public GenericStack(int n)
	{  top = -1;
	   size = n;
	   data = (T[]) new Object[n];
	}
	
	public boolean push(T newNode)
	{ 
		if(top == size-1)
			return false;  // ** overflow error **
	    else
	    {  top = top +1;
	       data[top] = (T) newNode;
	       return true;  // push operation successful
	    }
	}
	
	public T pop()
	{
		int topLocation;
	    if(top == -1)
	        return null;  // ** underflow error **
	    else
	    {  topLocation = top;
	        top = top -1;
	        return data[topLocation];
	    }
	}
	
	public T peek() {
		if(top == -1)
			return null;
		else {
			return data[top];
		}
	}
	
	public T[] toArray() {
		T[] newArray = (T[]) new Object[data.length];
		for(int x = 0; x < data.length; x++)
			newArray[x] = data[x]; //will need to implement a deep copy method...
		return newArray;
	}
	
	public void showAll()
	{
		for(int i = top; i >= 0; i--) {
	      System.out.println(data[i].toString());
		}
	}
}
