
public class LList {


	private LLNode head;
	
	public LList() {
		head = null;
	}
	public void addAtHead (char c) {
		LLNode newNode = new LLNode (c);
		newNode.updateNode(head);
		head = newNode;
	}
	
	public void display() {
		LLNode temp = head;
		while (temp != null) {
			System.out.println (temp);
			temp = temp.getNext();
		}
	}
	
	public char deleteAtHead ( ) {
		LLNode removedOne = head;
		head = head.getNext();
		return removedOne.getData();
	}
	
	public boolean isEmpty () {
		
		if (head != null) {
			return false;
		}
		
		return true;
	}
			
}
