import java.util.*;

public class BlockChain {
	private Block head = new Block (); // start the chain with the Genesis block
	private Block tail = head;
	private String courseName = "NotEntered";
	
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
	}
	
	public void printBlockChain() {
		
		// write code here to display the contents of the block chain
        //  (from the head – using the next reference)

		
		Block block = head;
		while (block != null) {
		
		System.out.println(block);
		block = block.next();
		}
	}
	
	public boolean verifyChain() {
		
		// write code here to verify the chain – (from the head – using
        // the next reference, checking that each block in the chain’s
        // previous hash is equal to the current hash in the previous
        //  block’s                  	      
        // Note:  if they all are all equal, you return true;  if any one
        // is not equal, they are false

		boolean check = false;

		Block temp = head;
		
		Block block = head.next();
		while (temp!=null) {

		
			if (block.isEqual(temp)) {
				block = block.next();
				temp = temp.next();
				check= true;
			}
		
		else {
			
		check= false;
		break;
		}
		}
		
		return check;
		}
	
		public Block deleteAtHead ( ) {
		Block removedOne = head;
		head = head.next();
		return removedOne;
		}

	
	public void deleteBadBlock () {
		Block remove = null;
		Block temp = head;
		Block prev = head;
		
		while (temp != null) {
			if (temp.next().isEqual(temp)){
			remove = temp;
			if (temp == head) 
				head = temp.next();
			else prev.updateNext(remove.next());
			break;
			}
			else {
				prev = temp;
				temp = temp.next();
			}
			
		}
	}
		
	
	
	/*public LLNode delete (char oneToDelete) {
		LLNode removedOne = null;
		LLNode temp = head;
		LLNode prev = head;
		
		while (temp != null) {
			if (temp.getData() == (oneToDelete)) {
				removedOne = temp;
				if (temp == head) 
					head = temp.getNext();
				else prev.updateNode(temp.getNext());
				break;
			}
			else 
			{   prev = temp;
			    temp = temp.getNext();
			}
		}
		return removedOne;
		
	}*/
		
	public void addBlock(Scanner keyboard) {
		
		// write code here to add a block to the BlockChain (at the tail)
		
		Block newOne = new Block();

		
		if (newOne.addInfoToBlock(keyboard,tail.getCurrentHash())){
 
			tail.updateNext(newOne);
			tail = newOne;	

		}
		
	}
	
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat())){
			// add to chain at tail
			tail.updateNext(newOne);
			tail = newOne;			
		}
		
	}
	
	

}
