/**************************************************
 * This program was originally written by Linda Crane for Lab 4-5.
 * This class was created by me. It's purpose is to store the info
 * about the school/course
 * My name is Ababiya Abajobir.
 * This program was completed for CST8130
 *************************************************/

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class College {

	private ArrayList<BlockChain> college;
	private String collegeName;

	public College () {
		college = new ArrayList<BlockChain>();
		collegeName = "Algonquin";
	}

	public void addCourse(Scanner keyboard) {

		System.out.println("Enter name of course to add: ");
		String cName = keyboard.next();

		BlockChain cN = new BlockChain(cName);
		college.add(cN);
	}

	public void displayCol (){
		System.out.println("For College: "+collegeName+"\n");
	}

	public BlockChain displayCourse (Scanner keyboard) {
		int i = 0;

		ListIterator<BlockChain> dis = college.listIterator();
		Integer menu = 0;
		while(dis.hasNext()) {

			System.out.println("[ "+i+" "+dis.next().getCourseName()+" ]");
			i++;
			while(!keyboard.hasNextInt()){
				keyboard.next();
			}
			menu = keyboard.nextInt();
			while((menu > i) || (menu < 0))
			{
				System.out.println("Invalid Choice");
				while(!keyboard.hasNextInt()){
					keyboard.next();
				}
				menu = keyboard.nextInt();
			}
		}


		return college.get(menu);
	}

	public void displayDeepInfo()
	{
		ListIterator<BlockChain> dis = college.listIterator();
		displayCol();
		while(dis.hasNext()) {
			BlockChain temp = dis.next();
			System.out.println(temp.getCourseName()+"\n");
			temp.printBlockChain();
		}
	}

}
