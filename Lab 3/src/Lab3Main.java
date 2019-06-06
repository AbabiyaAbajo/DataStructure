/*********************************************************************************************
 * 
 * Student Name: Ababiya Abajobir
 * Student Number: 040873720 
 * Course:  18W CST8130 - Data Structures
 * 
 * 
 */
import java.util.*;
import java.io.*;
public class Lab3Main {
	
	public static void main (String [] args) {
		
		String menuChoice = "0";
		Scanner keyboard = new Scanner (System.in);
		Numbers numbers = new Numbers();
		
		while (menuChoice.charAt(0) !=  '*') {
			System.out.println ("\nEnter 1 to initialize a default array, \n2 to initialize an array of input size,");
			System.out.println ("3 fill array with values, \n4 display values in array,");
			System.out.println ("5 to display average of the values in the array, \n6 to read from file, ");
			System.out.println ("7 to put results to file, \n8 Sort the array:");
			System.out.println ("9 to provides number of indexes between low input and high input, \n* to quit:");
			menuChoice = keyboard.next();
			
			switch (menuChoice.charAt(0)) {
				case '1':   numbers = new Numbers(); 
							break;
				case '2':	int size = 0;
							System.out.print("Enter new size of array: ");
							while (!keyboard.hasNextInt()) {
								System.out.println ("Enter correct value as integer");
								keyboard.next();
							}
							size = keyboard.nextInt();
							numbers = new Numbers(size);
							break;
				case '3':   numbers.initValuesInArray();
							break;
				case '4':	System.out.println (numbers);
							break;
				case '5':	System.out.println ("The average is " + numbers.calcAverage());
							break;
				case '6':	Scanner inFile = openInputFile();
						    if (inFile != null)  
						    	numbers.initValuesFromFile(inFile);
						    else System.out.println ("Could not find file");
							break;
				case '7':	FileWriter outFile = openOutputFile();
							if (outFile!= null)
								numbers.writeFile(outFile);
							else System.out.println ("Could not find file");
							break;		
				case '8':	numbers.sortArray();
							break;
							
				case '9':	numbers.sortArray(); numbers.displayArrayCount();
							break;
				case '*':	System.out.println ("goodbye");
				break;
							
	
				
				default: System.out.println ("Invalid entry...");
			}
		}
		
		
	}
	
	public static Scanner openInputFile() {

		Scanner keyboard = new Scanner(System.in);
		String fileName = new String();
		Scanner inFile = null;

		System.out.print("\n\nEnter name of file to process: ");
		fileName = keyboard.next();

		File file = new File(fileName);
		try {
			if (file.exists()) {
				inFile = new Scanner(file);
			}
			return inFile;
		} catch (IOException e) {
			System.out
					.println("Could not open file...." + fileName + "exiting");
			return null;
		}
	}// end openOutputFile method
	public static FileWriter openOutputFile() {

		Scanner keyboard = new Scanner(System.in);
		String fileName = new String();
		FileWriter outFile = null;

		System.out.print("\n\nEnter name of file to write to: ");
		fileName = keyboard.next();

		try {
			outFile = new FileWriter(fileName);
		}
		catch (IOException e) {
			System.out .println("Could not open file...." + fileName + "exiting");
		}
		return outFile;
		
	}// end openFile method

}


