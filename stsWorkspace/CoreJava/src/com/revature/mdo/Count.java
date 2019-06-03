package com.revature.mdo;
/**
 * Description - This program opens a txt file called count.txt and reads for an integer that represents the number of times this program has opened the file. If the file has an existing count then it will increment.
 * @author mattd
 */
//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.mdo.util.Input;

public class Count {//Class header
	//Variable that holds the path to text file which will be worked on
	static final String PATH = "src/com/revature/mdo/count.txt";
	/**
	 * Description - opens a txt file called count.txt and reads for an integer that represents the number of times this program has opened the file. If the file has an existing count then it will increment.
	 * @param args - String array of commandline arguments
	 * @return - Nothing
	 */
	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader(PATH);
				BufferedReader br = new BufferedReader(fr)) {
			String input = br.readLine();
			br.close();
			if(input == null || input == "") {
				writeToFile("0");
				System.out.println("File contains no count. New count started at 0.");
			} else {
				if(Input.isInputInt(input)) {
					int count = Integer.parseInt(input);
					count++;
					writeToFile(Integer.toString(count));
					System.out.println("Count has been incremented.");
				} else {
					System.out.println("Unable to read integer. Count has been reset to 0.");
					writeToFile("0");
				}
					
			}
		} catch (FileNotFoundException e) {
			writeToFile("0");
			System.out.println("File did not exist. File has been created and written to with a count of 0.");
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	/**
	 * Description - this method will open up a file and attempt to write to a file.
	 * @param str - String value that will be written to file
	 * @return - Nothing
	 */
	public static void writeToFile(String str) {
		try (FileWriter fw = new FileWriter(PATH);
				BufferedWriter bw = new BufferedWriter(fw)){
			bw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}//end of class
