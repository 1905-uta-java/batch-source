package com.revature.counter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCounter {
	
	public void count() {
		
		String path = "src/com/revature/counter/count.txt";
		
		int count = 0;
		
		try(FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);) {
			
			String fileContents = "";
			String line = br.readLine();
			
			// read the contents of the file, line by line, into a String
			while(line != null) {
				
				fileContents = fileContents + line;
				line = br.readLine();
			}
			
			// parse the contents into an int, if this throws a NumberFormatException,
			// then write "0" to the file
			try {
				
				count = Integer.parseInt(fileContents);
				
				count++;
				
			} catch(NumberFormatException e) {}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileWriter fw = new FileWriter(path);
				BufferedWriter bw = new BufferedWriter(fw)) {
			
			bw.append(count + "");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count has been updated to: " + count);
	}
}
