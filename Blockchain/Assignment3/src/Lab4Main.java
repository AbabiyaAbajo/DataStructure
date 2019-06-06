/**************************************************
 * This program was originally written by Linda Crane for Lab 4-5.
 * I used this program and made some modifications. Menu has been updated in
 * the Main class and an object of College has been created. This object is
 * called to display information about the course.
 * My name is Ababiya Abajobir.
 * This program was completed for CST8130
 *************************************************/

import java.util.*;

public class Lab4Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		BlockChain myBlockChain = new BlockChain ("CST8130");
		College myCol = new College();
		String menuChoice = "a";

		while (menuChoice.charAt(0) != '6') {
			System.out.println ("\nEnter 1 to display the college courses: ");
			System.out.println ("2 to add a new course: ");
			System.out.println ("3 to add a new block: ");
			System.out.println ("4 to verify chains: ");
			System.out.println ("5 to fix a chain:");
			System.out.println ("6 to quit: ");
			menuChoice = keyboard.next();

			switch (menuChoice.charAt(0)) {
			case '1': 
				myCol.displayDeepInfo();

				break;
			case '2': myCol.addCourse(keyboard);
			break;	  
			case '3': 

				myBlockChain = myCol.displayCourse(keyboard);
				System.out.println("Add good block or bad?  (g for good, anything else for bad): ");
				if (keyboard.next().equalsIgnoreCase("g")){
					myBlockChain.addBlock(keyboard);
				}
				else
					myBlockChain.addBadBlock(keyboard);

				break;
			case '4':
				myBlockChain = myCol.displayCourse(keyboard);
				if (myBlockChain.verifyChain())
					System.out.println ("Chain is verified");
				else  System.out.println ("Chain is broken");
				break;

			case '5':
				myBlockChain = myCol.displayCourse(keyboard);
				myBlockChain.removeBadBlocks();
				System.out.println("Chain is fixed");

			case '6': 
				System.out.println ("Goodbye");
				break;
			default:  System.out.println ("Invalid choice...");
			}
		}


	}

}
