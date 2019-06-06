
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a due dates for assessments in a course
Author:  Linda Crane and Ababiya Abajobir
Course: CST8130
Lab Section: 300
Data members:  

Methods: 
DueDates() - default constructor. Initializes object array to 10 by default.

DueDates(int max) - parameterized constructor. Initializes object array to given value.

inputDueDates(Scanner in) - boolean method. Stores assessment dates in the object array.       

addOne () - void method. Increments the assessment dates in the object array.

toString() - String method. Displays the content of the object array.
 *************************************************************************************************************/

public class DueDates {
	private MyDate[] dueDates ;
	private int numDates;

	public DueDates() {
		//*****  write the code for this method here
		dueDates = new MyDate[10];
		numDates = 0;
	}

	public DueDates(int max) {
		//*****  write the code for this method here
		this.dueDates = new MyDate[max];
		numDates = 0;
	}

	public boolean inputDueDates(Scanner in, boolean check) {
		MyDate date = new MyDate();
		date.inputDate(in, check);
		dueDates[numDates] = date;
		numDates++;
		return true;
		//*****  write the code for this method here
	}

	public void addOne () {
		//*****  write the code for this method here
		for(int i = 0; i < dueDates.length;i++)
			dueDates[i].addOne();
	}

	public String toString() {
		String dates = "";
		for(int i = 0; i < dueDates.length;i++)
			System.out.println((i+1)+": "+ dueDates[i].toString());

		return dates;
		//*****  write the code for this method here
	}

	public void writeFile(FileWriter o){

		try {
			o.append(dueDates.length + "\n");
			for(int i = 0; i < dueDates.length; i++) {
				o.append(dueDates[i].toString().replaceAll("/", "\n"));
				if(((dueDates.length - i) > 1))
					o.append("\n");
			}
			o.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

