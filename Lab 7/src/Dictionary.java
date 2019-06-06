import java.util.*;



public class Dictionary {

	TreeMap<String, Integer> tree = new TreeMap<String, Integer>();


	public Dictionary () {

	}

	public void resetTree() {
		// TODO Auto-generated method stub
		tree.clear();
	}

	public void readInput() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String word = " ";

		System.out.println("Enter word to be added to the dictionary: ");
		word = input.next().toLowerCase().replaceAll("[^a-z]","");
	 
		addValues(word);

	}

	public void readFile(Scanner inFile) {
		// TODO Auto-generated method stub
		while(inFile.hasNext()){
			String word = inFile.next().toLowerCase().replaceAll("[^a-z]","");
			if(word.length() < 1)
			{
				continue;
			}
			//String word = inFile.next().toLowerCase().replaceAll("[^!#$%^&*()_+=-{}:;'<>.,?`]+","");
			//System.out.println(word);
			addValues(word);
		}		
	} 

	public void searchWord() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.println("Enter word to search for: ");
		String data = input.nextLine().toLowerCase();
		if(tree.containsKey(data)){
			System.out.println(data+" occures "+tree.get(data)+" times.");
		}
		else {
			System.out.println(data+" is not in the Tree Map.");
		}

	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("There are "+tree.size()+" nodes.");
	}

	public void addValues (String data) {

		if(!tree.containsKey(data)){

			tree.put(data, 1);

		}
		else {
			tree.put(data, tree.get(data) + 1);
		}

	}



}
