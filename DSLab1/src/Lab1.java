
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and Ababiya Abajobir
Course: CST8130
Lab Section: 300
                                             
         

*************************************************************************************************************/


public class Lab1 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		String choice = "";
		int numLoop;
		
		do{
		System.out.print("How many assessments in this course - must be greater than 0?");
		do{
		
		while(!keyboard.hasNextInt()){ //checking to make sure input is a number
			System.out.println("Please enter valid number.. ");
			keyboard.next();
		}
		numLoop = keyboard.nextInt();
		
		if(numLoop < 1) // error message if the number of assessments is lower than 1
			System.out.println("Please enter a number greater than 0.. ");
		
		}while(numLoop<1); // will continue to loop while number is lower than 1
		
		DueDates d = new DueDates(numLoop); //setting the size of the array using the parameterized constructor
		for(int i = 0; i<numLoop; i++){
			System.out.println(i+1+":");
			d.inputDueDates(keyboard);
		}
		
		System.out.println("The due dates are:");
		d.toString();
		
		System.out.println("\nDue Dates with one day added are ");
		d.addOne();
		d.toString();
		
		System.out.println("Do another (y/n)?");
		keyboard.nextLine(); //consuming \n due to the nextInt() used above 
		choice = keyboard.nextLine();
		while(!choice.toLowerCase().equals("y") && !choice.toLowerCase().equals("n")){
			System.out.println("Please enter valid choice.. ");
			choice = keyboard.nextLine();
		}
			
		}while(!choice.toLowerCase().equals("n"));
		
		System.out.println("Thank you for your assessments. Have a nice day.. ");
	}
}


