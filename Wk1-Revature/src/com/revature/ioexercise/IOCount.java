package com.revature.ioexercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOCount {

	private String filename;
	private int count;
	
	public IOCount(String countFile) 
	{
		this.filename = countFile;
	}

	public int countIn()
	{
		try (FileReader fr = new FileReader(filename))
		{
			char[] data = new char[32];
			fr.read(data);
			String sdata = new String(data).trim();
			Integer idata = Integer.decode(sdata);
			count = idata.intValue();
			System.out.println("Read successful, read value of "+ Integer.toString(count));
			count++;
			fr.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("File Not Found. Count = 0.");
			count = 0;
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Read error. Count going to unrecoverable error state.");
			count = Integer.MIN_VALUE;
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number. Count = 0.");
			count = 0;
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countOut()
	{
		try (FileWriter fw = new FileWriter(filename))
		{
			String sdata = Integer.toString(count);
			fw.write(sdata);
			System.out.println("Write Successful, wrote value of "+ count);
			fw.close();
		} catch (IOException e) {
			System.out.println("Write failed.");
			e.printStackTrace();
		}
		
		return count;
	}
}
