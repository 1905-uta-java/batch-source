package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {


	
	public static void main(String[] args) {
		
		String path = "src/com/revature/io/write_data.txt";
		// second parameter in the FileWriter constructor represents appending
		try (FileWriter fw = new FileWriter(path, true); BufferedWriter bw = new BufferedWriter(fw);) {
			
			bw.append("Hello world again\n");
			System.out.println("Our file has been written");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
