/*This program was written by Ababiya Abajobir. 
 * My student number is 040873720.
 * Assignment 1 - CST8130 Data Structures
 * Completed on 02/09/2018
 * Approx. 6 hours spent
 * Biggest challenges: The purpose of each methods/data members and properly using 
 * polimorphism.
 * * Data members: String supplierName stores supplier name
 * Methods: my constructor but i am not using it; addItem with a Scanner parameter. This calls 
 * on the super to prompt for the default information and than requests the user to input 
 * supplier name.
 * ToString returns the super and the supplier name
 */

import java.util.Scanner;

public class PurchasedItem extends Item {

	private String supplierName;

	public PurchasedItem() {
		//super();

		// TODO Auto-generated constructor stub
	}
	public boolean addItem (Scanner input) { //Scanner


		super.addItem(input);
		System.out.print("Enter the name of the supplier: ");

		supplierName = input.next();	
		return true;


	}

	public String toString () {

		//return String.format(super.toString()+" Supplier: %s", supplierName);
		return super.toString()+" Supplier: "+supplierName;

	}

}
