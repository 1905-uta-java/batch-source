package com.revature.filecount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class IncrementCount {
	public static void main(String[] args) {
		String path = "count.txt";
		int count = 0;
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw;
		
		try {
			
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String s = br.readLine();
			
			fw = new FileWriter(path, false);
			bw = new BufferedWriter(fw);
			if(s != null) {
				try {
					count = Integer.parseInt(s);
					count += 1;
					bw.write(""+count+"\n");
					System.out.println("Count: " + count);
				}
				catch(NumberFormatException e) {
					bw.write("0\n");
					System.out.println("Wrote 0, number failed to be parsed.");
				}
			}
			else {
				bw.write("0\n");
				System.out.println("Wrote 0, failed to readline.");
			}
			bw.close();
			br.close();
			fw.close();
			fr.close();
		}
		catch(FileNotFoundException e) {
			
		}
		catch(IOException e) {
			
		}
		finally {
			
		}
	}
}
