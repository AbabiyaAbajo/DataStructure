/*********************************************************************************************
 * 
 * Student Name:Ababiya Abajobir
 * Student Number  040873720
 * Course:  18W CST8130 - Data Structures
 * 
 * 
 */
import java.util.*;
public class Lab1Main {


	public static void main (String [] args) {

		// write the code here to implement the menu as specified in Lab 1
		Numbers numb = new Numbers();
		Scanner input = new Scanner (System.in);

		int nums;
		do {
			System.out.println("Enter 1 to initialize a default array,");
			System.out.println("2 to initialize an array of input size,");
			System.out.println("3 fill array with values,");
			System.out.println("4 display values in array,");
			System.out.println("5 to display average of the values in the array, ");
			System.out.println("6 to quit ");

			nums = input.nextInt();


			if (nums == 1){

				numb = new Numbers();
			}

			else if (nums == 2){

				boolean check = false;
				System.out.print("Enter new size of array: ");
				int size = input.nextInt();

				while(check == false){
					if (size > 0) {
						numb = new Numbers(size);
						check = true;
					}
					else {
						System.out.println("Invalid entry...");
						size = input.nextInt();
					}

				}
			}

			else if (nums == 3){


				System.out.println("Enter the float numbers as values in the array: ");

				numb.initValuesInArray();
				System.out.println();

			}

			else if (nums == 4){

				System.out.println("Values are: ");
				numb.toString();

			}

			else if (nums == 5){

				System.out.println("The average is "+numb.calcAverage());
				System.out.println();
			}

			else if (nums == 6){
				break;
			}
			else {
				System.out.println("Invalid entry...");

			}


		}while (nums != 6);

	}

}
