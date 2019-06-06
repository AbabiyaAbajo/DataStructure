import java.util.*;

public class BlockChain {
	private Block head = new Block (); // start the chain with the Genesis block
	private Block tail = head;
	private String courseName = "NotEntered";
	
	public BlockChain ( String courseName) {
		this.courseName = new String (courseName);
	}
	
	public void printBlockChain() {
		
		
		
		
	}
	
	public boolean verifyChain() {
			
		
		return true;
	}
	
	public void addBlock(Scanner keyboard) {
		
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
