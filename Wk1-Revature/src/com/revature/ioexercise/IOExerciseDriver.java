package com.revature.ioexercise;

public class IOExerciseDriver {
	
	public static final String DEFAULT_FILE = "count.txt";
	
	public static void main(String[] args) {
		IOCount count = new IOCount(DEFAULT_FILE);
		int countstate = count.countIn();
		if (countstate != Integer.MIN_VALUE)
		{
			count.countOut();
		}
	}

}
