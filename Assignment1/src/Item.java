/*This program was written by Ababiya Abajobir. 
 * My student number is 040873720.
 * Assignment 1 - CST8130 Data Structures
 * Completed on 02/09/2018
 * Approx. 6 hours spent
 * Biggest challenges: The purpose of each methods/data members and properly using 
 * polimorphism.
 * Data members: itemCode(int) stores the code; String itemName stores the item name;
 * int ItemQuanityInStock stores the quantity; float itemPrice stores the amount
 * Methods: constructor doesn't do much; adIttem has a Scanner parameter and requires input
 * from the user to store in the data members.
 * ToString returns the values in my data members
 * updateItem with an int parameters does the calculation of buying and selling
 * isEqual determines if my input itemCode matches with the one already stored
 * inputCode takes the user input for code and stores it into itemCode
 */



import java.util.*;

public class Item {

	private int itemCode;
	private String itemName;
	private int itemQuantityInStock;
	private float itemPrice;



	public Item () {




	}
	public boolean addItem(Scanner input) {

		boolean check = false;

		System.out.print("Enter the code for the item: ");
		inputCode(input);

		System.out.print("Enter the name for the item: ");
		itemName = input.next();

		System.out.print("Enter the quantity for the item: ");
		while (!check) {

			if(input.hasNextInt() && (itemQuantityInStock = input.nextInt()) >0) {

				break;

			}

			else {
				System.out.print("Invalid quantity...please enter integer greater than 0 ");


			}
		}

		System.out.print("Enter the price of the item: ");
		while (!check) {
			if(input.hasNextFloat() && (itemPrice = input.nextFloat())>0) {


				break;
			}

			else {
				System.out.print("Invalid price...please enter float greater than 0 ");

			}

		}
		return true;
	}

	public String toString() {

		return "Inventory: \n" + " Item: " +itemCode+" " + itemName+" "+ itemQuantityInStock+ " $"+itemPrice;

		//return String.format("Inventory: \nItem: %n %s %n $,.#f ", itemCode, itemName, itemQuantityInStock, itemPrice);
	}

	public boolean updateItem (int amount) {

		//if ((itemQuantityInStock+amount) <0 )

		if(itemQuantityInStock < (amount*=(-1))){
			System.out.print("Error... could not sell item \n");
			return false;
		}

		else {
			itemQuantityInStock+=amount;
		}

		return true;
	}

	public boolean isEqual (Item item) {

		if (itemCode == item.itemCode) {
			return false;

		}
		else {

			return true;
		}
	}

	public boolean inputCode (Scanner input) {

		boolean check = false;

		while (!check) {
			if(input.hasNextInt() &&  (itemCode = input.nextInt()) >0) {

				check = true;
			}
			else {

				System.out.print("Invalid code...please enter integer greater than 0");
				input.next();
			}
		}


		return true; 
	}
}


