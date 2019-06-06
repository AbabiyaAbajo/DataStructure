import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Lab8Main {
	
	
	public static void main (String []args) {
		
		Scanner input = new Scanner(System.in);
		HtableC hash = new HtableC();
		String options = "0";
		String temp;
		int index;
		
		while(options.charAt(0) != '3'){
			
			System.out.println("1 add to HashTable: ");
			System.out.println("2 search HashTable: ");
			System.out.println("3 end program: ");
			options = input.next();
			
			switch (options.charAt(0)) {
			
			case '1':	System.out.println("Enter String to be added: ");
						temp = input.next();
						hash.add(temp);
						
						break;
						
			case '2':	System.out.println("Enter String to search: ");
						temp = input.next();
						index = hash.hash(temp);
						if (hash.search(temp, index))
							System.out.println("String "+temp+" is in structure at index "+index);
						else
							System.out.println("String "+temp+" is not in structure.");
						break;
						
			
			case '3':	System.out.println("Have a nice day..");
						break;
			default: 	System.out.println("Invalid input, please try again.");			
			}
			
		}
			
	}

	}

