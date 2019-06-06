/*********************************************************************************************
 * 
 * Student Name: Ababiya Abajobir
 * Student Number: 040873720
 * Course:  18W CST8130 - Data Structures
 * 
 * This class contains the dynamically allocated array and it's processing
 */
import java.util.*;

public class Numbers {

	private Float [] numbers;
	private int size;
	private int nums;
	Scanner input = new Scanner (System.in);



	public Numbers() {
		///  write code here to intialize a "default" array since this is the default constructor

		numbers = new Float[10];
		for (int i = 0; i< numbers.length; i++) {
			numbers[i] = 1.0f *0;
		}


	}

	public Numbers (int size) {
		///  write code here to initialize an "initial" array given the parameter size as this is an initial constructor
		this.size = size;

		numbers = new Float[size];

		for (int i = 0; i< numbers.length; i++) {
			numbers[i] = 1.0f *0;
		}

	}

	public void initValuesInArray() {
		/// write code here to intialize the values in the array

		for (int i = 0; i<numbers.length;i++) {

			System.out.print("Enter value: ");



			if (input.hasNextFloat()){
				numbers[i] = input.nextFloat();

			}

			else {
				System.out.println("Entry "+input.next()+" is invalid. Please try again. ");
				i--;


			}
		}
	}



	public String toString() {
		// write code to return the values in the array in a list format - one value per line


		for (int i = 0; i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}

		return " ";
	}

	public float calcAverage() {
		// write code to return the average of the values in the array
		int total = 0;

		for (int a = 0; a<numbers.length; a++){
			if(numbers[a] == null) {
				break;
			}
			total += numbers[a]; 
		}
		float average = 1.0f * total / numbers.length;; 


		return average;
	}


}
