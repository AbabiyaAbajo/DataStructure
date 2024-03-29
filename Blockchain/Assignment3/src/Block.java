/**************************************************
 * This program was originally written by Linda Crane for Lab 4-5.
 * I used this program and made some modifications. I've removed
 * all references to 'nextOne' in this class.
 * My name is Ababiya Abajobir.
 * This program was completed for CST8130
 *************************************************/

import java.util.*;

public class Block {
	private int date;  // part of data - in month day year format  (eg) 2152018
	private int studentNumber; // part of data
	private int grade;  // part of data
	private float previousHash;
	private float currentHash;


	public Block() {
		// create the Genesis block
		date = 2152018;
		studentNumber = 0;
		grade = 100;
		previousHash = 0f;
		currentHash = calculateHash();


	}

	public float calculateHash() {
		return (date+studentNumber+grade)/88;
	}

	public String toString() {
		return "" + studentNumber + " " + grade + " " + date +  " current: " + currentHash + " previous: " + previousHash ;
	}

	public float getCurrentHash() {
		return currentHash;
	}

	public boolean isEqual (Block temp) {
		return (previousHash == temp.currentHash);
	}


	public void updatePreviousHash(float prevHash) {
		previousHash = prevHash;
	}

	public boolean addInfoToBlock(Scanner keyboard, float previousHash) {
		System.out.print ("Enter date: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for date: ");
			keyboard.next();
		}
		date = keyboard.nextInt();


		System.out.print ("Enter student number: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for student number: ");
			keyboard.next();
		}
		studentNumber = keyboard.nextInt();


		System.out.println ("Enter grade: ");
		while (!keyboard.hasNextInt())  {
			System.out.print ("Invalid...enter an int for grade: ");
			keyboard.next();
		}
		grade = keyboard.nextInt();

		currentHash = calculateHash();
		this.previousHash = previousHash;
		return true;
	}

}
