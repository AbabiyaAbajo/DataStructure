/*This program was written by Ababiya Abajobir. 
 * My student number is 040873720.
 * Assignment 1 - CST8130 Data Structures
 * Completed on 02/09/2018
 * Approx. 6 hours spent
 * Biggest challenges: The purpose of each methods/data members and properly using 
 * polimorphism.
 * My main class runs my program. I use int nums to store my menu selection and i have
 * instantiated Scanner and Inventory
 */

import java.util.Scanner;

public class Assign1Main {

	public static void main (String [] args) {

		int nums = 0;



		Scanner input = new Scanner(System.in);

		Inventory inv = new Inventory();


		do {
			System.out.println("Enter 1 to add an item to inventory");
			System.out.println("2 to display current inventory");
			System.out.println("3 buy some of an item");
			System.out.println("4 sell some of an item");
			System.out.println("5 to quit");

			boolean check = false;
			while (!check) {
				if(input.hasNextInt()){

					nums=input.nextInt();



					if (nums == 1){


						inv.addItem(input);
						check =true;

					}

					else if (nums == 2){


						System.out.println(inv.toString());
						check =true;
					}

					else if (nums == 3){

						inv.updateQuantity(input, true);
						check =true;
					}

					else if (nums == 4){

						inv.updateQuantity(input, false);
						check =true;

					}

					else if(nums == 5){
						check =true;
						break;

					}

					else {
						System.out.println("Invalid entry... Enter a valid input \n");

					}	
				}

				else{
					System.out.println("Entry "+input.next()+" is invalid. Please try again. \n");
				}	
			}


		}while (nums!=5);


	}

}
