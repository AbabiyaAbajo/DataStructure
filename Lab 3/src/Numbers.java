/* Student Name: Ababiya Abajobir
 * Student Number  
 * Course:  18W CST8130 - Data Structures
 * 
 * This class contains the dynamically allocated array and it's processing
 */
import java.util.*;
import java.io.*;
public class Numbers {
	private Float [] numbers;

	public Numbers() {
		numbers = new Float[10];
		for (int i=0; i < numbers.length; i++)
			numbers[i] = new Float(0.0f);
	}

	public Numbers (int size) {
		if (size > 0) {
			numbers = new Float[size];
		} else {
			numbers = new Float[0];
		}
		for (int i=0; i < numbers.length; i++)
			numbers[i] = new Float(0.0f);
	}

	public void initValuesInArray() {
		Scanner keyboard = new Scanner (System.in);

		System.out.println ("Enter the float numbers as values in the array: ");

		for (int i=0; i < numbers.length; i++) {
			System.out.print ("Enter value: ");
			if (keyboard.hasNextFloat()) {
				numbers[i] = keyboard.nextFloat();
			} else {
				System.out.println ("Invalid entry...reenter a valid float");
				keyboard.next();
				i--;
			}
		}

	}

	public String toString() {
		String temp = "Values are: \n";
		for (int i=0; i < numbers.length; i++ )
			temp += numbers[i] + "\n";

		return temp;
	}

	public float calcAverage() {
		if (numbers.length == 0)
			return 0.0f;

		float total = 0;

		for (int i=0; i < numbers.length; i++ )
			total += numbers[i];

		return total/numbers.length;
	}

	public boolean initValuesFromFile(Scanner inFile) {
		int size;
		if (!inFile.hasNextInt()) {
			System.out.println ("Invalid first value for size...cannot process file");
			return false;
		}
		size =inFile.nextInt();
		numbers = new Float[size];
		for (int i=0; i < numbers.length; i++) {
			if (inFile.hasNextFloat())
				numbers[i]=inFile.nextFloat();
			else {
				System.out.println ("Error...invalid value in file");
				for (; i < numbers.length; i++)  // fill rest of array with 0s
					numbers[i] = 0.0f;
				return false;
			}
		}
		return true;

	}

	public boolean writeFile (FileWriter outFile) {
		try {
			outFile.append(numbers.length + " ");
			for (float num: numbers) {
				outFile.append (num + " ");
			}
			outFile.close();

		} 
		catch (IOException e) {
			System.out.println ("Error writing to file");
			return false;
		}
		return true;
	}


	public void sortArray(){

		float tempMem;
		for (int i = 1; i<numbers.length; i++) {
			//	float smallest = numbers[i];

			for (int a = i; a>0 ; a++) { // 

				if (numbers[i]<numbers[a]) {
					tempMem=numbers[i]; //store the previous value (this is my new smallest)

					numbers[i]= numbers[a]; //put the new value of smallest at this location (this is bigger than smallest)
					numbers[a]= tempMem;
				}
			}
		}
	}

	public int displayArrayCount () {
		Scanner keyboard = new Scanner (System.in);
		int count = 0; //this will provide me with the number of iterations between num1 and num2
		int bottom = 0; //this is my index floor. Ever changing based on the binary search. It starts at zero index but can become half plus one if num1 is greater than half
		int top = numbers.length-1; //this is my ceiling. Same as bottom, this can change depending on which half has the num1. If lower portion has the num1, this value changes to half minus 1. 
		boolean check = false;

		System.out.println("Please enter first number: ");
		while (!keyboard.hasNextFloat()) {
			System.out.println("Invalid character, please try again: ");
			keyboard.next();
		}
		float num1 = keyboard.nextFloat();
		
		
		System.out.println("Please enter second number: ");

		while (!keyboard.hasNextFloat()) {
			System.out.println("Invalid character or second entry is too low, please try again: ");
			keyboard.next();
		}
		float num2 = keyboard.nextFloat();


		do {


			int mid = (bottom + top) / 2; //My half way point. Used to quickly search information based on a comparison of num1 and half
		

			if (num1 == numbers[mid]) {

					for (int i = mid; i < numbers.length; i++ ) {
						if (num2>=numbers[i]) {
							count++;
						}
						else
							check = true;
					}

			}
			else if(num1 > numbers[mid] && num1 < numbers[mid+1]){
				for (int i = mid+1; i < numbers.length; i++ ) {
					if (num2>=numbers[i]) {
						count++;
					}
					else
						check = true;
				}
			}

			else if (num1 < numbers[mid]) {

				top = mid - 1;

			}


			
			else if (bottom > top) {
				check = true;
			}

			else {
				bottom = mid + 1;
			}

			
			if (2==bottom-top) {

				if (num1 < numbers[mid]) {

					for (int i = mid; i < numbers.length; i++ ) {
						if (num2>=numbers[i]) {
							count++;
						}
						else
							check = true;
					}
				}
				else{
					mid++;
					for (int i = mid; i < numbers.length; i++ ) {
						if (num2>=numbers[i]) {
							count++;
						}
						else
							check = true;
					}
				}

			}

		}while(!check);

		System.out.print("There is "+count+" indexes between my low and high input\n");
		return -bottom -1;

	}


}