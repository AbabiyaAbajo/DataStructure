import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		Scanner input = new Scanner (System.in);
		String myValue = new String();
		String stripValue = new String();
		
		
		System.out.println("This program will determine if your inputs are a palindrome ");
		System.out.println("Please enter a string: ");
		myValue=input.nextLine().toLowerCase();
		
		for (int i = 0; i < myValue.length(); i++) {
			if (myValue.charAt(i) >= 'a' && myValue.charAt(i) <= 'z') {
				list.addAtHead(myValue.charAt(i));
				stripValue += myValue.charAt(i);
			}
		}
		
		String reversedValue = new String();
		while(!list.isEmpty()){
			reversedValue += list.deleteAtHead();
		}
		
		
		if (reversedValue.equals(stripValue)) System.out.println ("List is a palindrome");
	   else  System.out.println ("List isn't a palindrome");


	}

}
