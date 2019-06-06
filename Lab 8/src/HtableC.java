import java.util.*;


public class HtableC {
	private String dataItems[];



	public HtableC () {
		dataItems = new String [100];

		for (int i = 0; i < dataItems.length; i++)
			dataItems[i] = null;
		
	}

	public int hash(String temp) {
		int total = 0;
		for (int i = 0; i < temp.length(); i++) 
			total+= (int)temp.charAt(i) ;
		return total%100;
	}

	public boolean add ( String temp) {

		int index = hash(temp);

		do {
			
			if (isEmpty(index)) {
				dataItems[index] = temp;
				return true;
		}
			
			else if (!isEmpty(index) && dataItems[index]==temp){
				System.out.println(temp+" is already in the structure...");
				return false;
			}
			else
				index++;
				
			}while (index <100);


		return false;
	}
	
	public boolean isEmpty(int index) {
		
		if (dataItems[index] == null) 
			return true;
		
		else
			return false;
	}

	public boolean search (String temp, int index) {

		
		
		for ( int i = index; i < dataItems.length ; i++) {
			if (temp.equals(dataItems[i])) {
				return true;
			}
		}
		
		return false;
		
		 // you can use contains in the linked list equals makes more sense --- searching for A will also bring up AB, which is not correct
	
	}

	public void checkV () {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter String to search: ");
		String temp = input.next();

		int index = hash(temp);
		if (search (temp, index))
			System.out.println("String "+temp+"is in structure at index "+index);
		else
			System.out.println("String "+temp+"is not in structure at index "+index);
	}

	public void breakString(String temp) {
		// TODO Auto-generated method stub
		String store = "";


		if (temp.length()>=2) {

			store += String.valueOf(temp.charAt(0)) + String.valueOf(temp.charAt(1));
		}
		else 
			store += String.valueOf(temp.charAt(0));

		add(store);

	}




}

