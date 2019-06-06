import java.io.*;
import java.util.*;

public class Lab7Main {

	public static void main (String []args) {

		Dictionary item = new Dictionary();
		Scanner input = new Scanner (System.in);
		String option = "0";

		while( option.charAt(0) !='6') {
			System.out.println("1 to clear dictionary ");
			System.out.println("2 to add text from keyboard: ");
			System.out.println("3 to add text from a file: ");
			System.out.println("4 to search for a word count: ");
			System.out.println("5 to display number of nodes: ");
			System.out.println("6 Exit! ");
			option = input.next();

			switch (option.charAt(0)) {

			case '1': 	item.resetTree();
						break;
			
			case '2':	item.readInput();
						break;
			
			case '3': 	Scanner inFile = openFile();
						if (inFile != null)  
							item.readFile(inFile);
						else System.out.println ("Could not find file");
						break;
			
			case '4': 	item.searchWord();
						break;
			
			case '5': 	item.display();
						break;
			
			case '6': 	System.out.println("End of program... Goodbye. ");
						break;
			
			default: 	System.out.println("Value not accepted, please try again..");
			}
		}
	}

	public static Scanner openFile () {
		Scanner input = new Scanner (System.in);
		Scanner inFile = null;
		String data = " ";

		System.out.println("Please enter the name of the file that will be processed: ");
		data = input.nextLine();
		File file = new File(data);

		try {
			if (file.exists()) {
				inFile = new Scanner(file);
			}
			return inFile;
		}
		catch(Exception e) {
			System.out.println("Could not locate "+data);
			return null;
		}



	}
}
