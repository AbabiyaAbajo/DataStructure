/*This program was written by Ababiya Abajobir. 
 * My student number is 040873720.
 * Assignment 1 - CST8130 Data Structures
 * Completed on 02/09/2018
 * Approx. 6 hours spent
 * Biggest challenges: The purpose of each methods/data members and properly using 
 * polimorphism.
 * Data members: An Item inventory array used to store all of the items 
 * numItems(int) stores the number of items are in the inventory
 * Methods: constructor instantiates the inventory length to 1000
 * boolean addItem with a Scanner parameter requires a user input to choose between purchased
 * or manufactured item. This is than stored in the inventory array.
 * ToString returns the values in my inventory array
 * already exists checks if the item code already exists
 * updateQuanity will update the quantity based on the buying or selling
 */

import java.util.Scanner;

public class Inventory {

	private Item [] inventory;
	private int numItems = 0;


	public Inventory () {

		inventory = new Item[1000];

	}

	public boolean addItem(Scanner input) {

		Item item; 

		System.out.println("Do you wish to add a purchased item (enter P/p) or manudactured (enter anything else)? ");

		String select = input.next();

		if (select.equalsIgnoreCase("p")) {

			item = new PurchasedItem();

		}

		else {

			item = new ManufacturedItem();

		}
		item.addItem(input);

		//   already in array???
		int index = alreadyExists(item);

		if (index == -1) {

			inventory[numItems++] = item;

			return true; //Scanner
		}
		else {

			System.out.print("This code is not in the inventory ");
			return false;
		}
	}

	public String toString() {

		String value = " "; //String builder

		for (int i = 0; i<numItems;i++) {

			value = inventory[i].toString() + "\n";

		}
		return value;

	}

	public int alreadyExists(Item item) {

		for (int i = 0; i < numItems; i++) {

			if(item.isEqual(inventory[i])) {

				return i;

			}
		}

		return -1;		
	}

	public boolean updateQuantity (Scanner input, boolean check) { //Scanner, boolean
		Item item = new Item();

		System.out.println("Enter valid item code: ");

		item.inputCode(input);

		//if (!inventory[i].isEqual(item)) {
		int index = alreadyExists(item);

		if (index == -1) {

			System.out.println("This code is not in the inventory \n");
			return false;

		}
		else {

			System.out.println("Enter valid quantity : ");

			int amt = input.nextInt();

			if (check){

				inventory[index].updateItem(amt);

			}
			else if (!check){

				inventory[index].updateItem(amt*=(-1));

			}
			return true;
		}

	}

}
