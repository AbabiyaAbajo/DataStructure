/**************************************************
 * This program was originally written by Linda Crane for Lab 4-5.
 * I used this program and made some modifications. I've removed the head and the tail. 
 * Added LinkedList. Made my methods use the java LinkedList class.
 * Created a getCourseName method.
 * My name is Ababiya Abajobir.
 * This program was completed for CST8130
 *************************************************/

import java.util.*;

public class BlockChain {


	private String courseName = "NotEntered";
	private LinkedList<Block> blockChain;


	public BlockChain ( String courseName) {
		blockChain = new LinkedList<Block>();
		blockChain.add(new Block());
		this.courseName = new String (courseName);
	}

	public void printBlockChain() {

		if (blockChain==null){
			return;
		}
		else {
			ListIterator<Block> listPrint = blockChain.listIterator();
			while( listPrint.hasNext()) {
				System.out.println(listPrint.next());
			}
		}
	}

	public boolean verifyChain() {		

		ListIterator<Block> verify = blockChain.listIterator();
		Block prev = verify.next();

		while (verify.hasNext()) {

			Block temp = verify.next();

			if(temp.isEqual(prev)){
				prev = temp;
			}
			else{

				return false;
			}
		}
		return true;
	}

	public void addBlock(Scanner keyboard) {
		Block nextOne = new Block();

		if(blockChain.size() > 0)
		{
			nextOne.addInfoToBlock(keyboard, blockChain.getLast().getCurrentHash());
		}
		blockChain.add(nextOne);

	}

	public void addBadBlock(Scanner keyboard) {

		Random random = new Random();
		Block wrongOne = new Block();
		wrongOne.addInfoToBlock(keyboard, random.nextFloat());
		blockChain.add(wrongOne);

	}

	public void removeBadBlocks() {

		ListIterator<Block> remBad = blockChain.listIterator(); 

		Block prev = remBad.next();

		while (remBad.hasNext()) {
			Block curr = remBad.next();

			if (!curr.isEqual(prev)) {
				remBad.remove();

				if(remBad.nextIndex() > (blockChain.size() - 1))
				{
					break;
				}
				blockChain.get(remBad.nextIndex()).updatePreviousHash(prev.getCurrentHash());
			}

			else {
				prev = curr;				
			}
		}
	}

	public String getCourseName () {
		return courseName;
	}



}
