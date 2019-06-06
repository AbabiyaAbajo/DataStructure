
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and Ababiya Abajobir
Course: CST8130
Lab Section: 300



 *************************************************************************************************************/


public class Lab2 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);
		String choice = new String();
		String fileName = new String();
		DueDates d = new DueDates();
		int numLoop;
		boolean flag = false; //this flag will be used to prompt to save file when the user enters null
		boolean flag2 = false;
		
		do{

			System.out.println("Enter name of file to import or the word null to bypass: ");
			fileName = keyboard.nextLine();

			if(fileName.toLowerCase().equals("null")){

				System.out.println("You chose to bypass this step....continuing");
				flag = true;

				System.out.print("How many assessments in this course - must be greater than 0?");
				do{

					while(!keyboard.hasNextInt()){ //checking to make sure input is a number
						System.out.println("Please enter valid number.. ");
						keyboard.next();
					}
					numLoop = keyboard.nextInt();
					flag2 = true;
					if(numLoop < 1) // error message if the number of assessments is lower than 1
						System.out.println("Please enter a number greater than 0.. ");

				}while(numLoop<1); // will continue to loop while number is lower than 1
				d = new DueDates(numLoop); //setting the size of the array using the parameterized constructor
				for(int i = 0; i<numLoop; i++){
					System.out.println(i+1+":");
					d.inputDueDates(keyboard, false);
				}
			} else {
				Scanner f = readFile(fileName);
				int i = 0;
				if(f != null){
					numLoop = Integer.parseInt(f.nextLine());
					d = new DueDates(numLoop);
					while(i < numLoop && d.inputDueDates(f, true)){i++;}
				}
				
			}

			
			System.out.println("The due dates are:");
			d.toString();

			System.out.println("\nDue Dates with one day added are ");
			d.addOne();
			d.toString();
			
			if(flag2)
				keyboard.nextLine(); //consuming \n due to the nextInt() used above 
			
			if(flag){				
				System.out.print("Enter name of file to write to null to bypass: ");
				fileName = keyboard.nextLine();
				FileWriter o = writeFile(fileName);
				if(o != null)
					d.writeFile(o);
			}

			System.out.println("Do another (y/n)?");
				
			choice = keyboard.nextLine();
			while(!choice.toLowerCase().equals("y") && !choice.toLowerCase().equals("n")){
				System.out.println("Please enter valid choice.. ");
				choice = keyboard.nextLine();
			}
			flag = false; flag2 = false;
		}while(!choice.toLowerCase().equals("n"));

		System.out.println("Thank you for your assessments. Have a nice day.. ");
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static Scanner readFile(String fileName){
		Scanner rFile = null;
		File file = new File(fileName);
		
		try {
			
			rFile = new Scanner(file);
			return rFile;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static FileWriter writeFile(String fileName){
		FileWriter wFile = null;

		try {
			wFile = new FileWriter(fileName);
			return wFile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
}


