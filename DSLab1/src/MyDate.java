
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a simple date by keeping day, month and year information.   Leap years are NOT
               accommodated in this class.
Author:  Linda Crane and Ababiya Abajobir
Course: CST8130
Lab Section: 300
Data members:  day : int - value between 1 and 31 inclusive (depending on value in month)
               month: int - value between 1 and 12 inclusive
               year: int - positive value
Methods: default constructor - sets date to Jan 1, 2018
         toString (): String - prints date in year/moht/day format
         inputDate(Scanner): boolean - reads a valid date from the Scanner parameter and returns through
                                       boolean success or not
         addOne(): void - adds one to the day field and then adjusts month and year as needed.                                              
         

*************************************************************************************************************/
public class MyDate {
		private int day = 1;
		private int month = 1;
		private int year = 2018;
		
		public MyDate() {
		}
		
		public String toString() {   return new String ("" + year + "/" + month + "/" + day);
		}
		
		public boolean inputDate(Scanner in) {
			month = 0;
			day = 0; 
			year = 0;
			do {
				System.out.print ("Enter year: ");
				if (in.hasNextInt())
					this.year = in.nextInt();
				else {
					System.out.println ("Invalid day input");
					in.next();
				}
			} while (this.year <= 0);
			
			do {
					
				System.out.print ("Enter month - between 1 and 12: ");
				if (in.hasNextInt())
					this.month = in.nextInt();
				else {
					System.out.println ("Invalid month input");
					in.next();
				}
			} while (this.month <= 0 || this.month > 12);
			
			do {
				
				if(month == 2){
					if (((year%4==0) && (year%100!=0)) || (year%400==0))//it's a leap year
						System.out.print ("Enter day - between 1 and 29: ");
					else
						System.out.print ("Enter day - between 1 and 28: ");
				}
				else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
					System.out.print ("Enter day - between 1 and 30: ");

				else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
					System.out.print ("Enter day - between 1 and 31: ");
				
				if (in.hasNextInt())
					this.day = in.nextInt();
				else {
					System.out.println ("Invalid day input");
					in.next();
				}
			} while (this.day <= 0 || this.day > 31 || (this.month == 2 && (((year%4==0) && (year%100!=0)) || (year%400==0))  && this.day > 29) || (this.month == 2 &! (((year%4==0) && (year%100!=0)) || (year%400==0))  && this.day > 28) || (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) ) );
				
			return true;		
		}
		
		public void addOne (){
			// *********    write the code for this method here  **************
			
			//incrementing day in order to make changes to month and year, as required
			day++; 
			if (day > 28){
				if(month == 2){
					if ((((year%4==0) && (year%100!=0)) || (year%400==0)) && day == 29){
						//no action, it's a leap year
					}
					else
					{
						month++;
						day = 1;
					}
				}
				//there are 4 months in a year that go up to 30. We reset day to 1 and increment month.
				else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) && day > 30){ 
					month++;
					day = 1;
				}
				else if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) && day > 31){
					if(month == 12){ // new year - we now have to increment year as well
						month = 1;
						day = 1;
						year++;
					}
					else{
						month++;
						day = 1;
					}
				}		
			}			
		}
}


