/*This program was written by Ababiya Abajobir. 
 * My student number is 040873720.
 * Assignment 1 - CST8130 Data Structures
 * Completed on 02/09/2018
 * Approx. 6 hours spent
 * Biggest challenges: The purpose of each methods/data members and properly using 
 * polimorphism.
 * Data members: int array of itemsUsed with a lenght of 10. Used to store 10 codes;
 * int numItemsUsed this determines the number of codes used
 * Methods: my constructor but i am not using it; addItem with a Scanner parameter. This calls 
 * on the super to prompt for the default information and than requests the user to input 10 codes.
 * ToString returns the super and the number in numItemsUsed
 */

import java.util.Scanner;

public class ManufacturedItem extends Item {

	private int[] itemsUsed = new int [10];
	private int numItemsUsed;


	public ManufacturedItem() {
		//super();

		// TODO Auto-generated constructor stub
	}

	public boolean addItem (Scanner input) { //Scanner

		int num;

		super.addItem(input);

		System.out.println("Enter up to 10 codes used in this item (-1 to quit) :");
		for(int i = 0; i < 10; i++) {
			num = input.nextInt();
			if(num == -1) {
				i=11;
			}
			else if (input.hasNextInt() && num < -1){
				itemsUsed[numItemsUsed++] = num;

			}
			else {
				System.out.println("Invalid code. Enter a number greater than 0 or enter '-1' to exit ");
				i--;
			}
		}

		return true;

	}

	public String toString() {


		return super.toString() + " Number of item Used: "+ numItemsUsed;

	}

}
