package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SpecializedListSimpleTest {
	
	// the provided test case does not represent all possible cases.
	// please write your own cases to test for all possible edge scenarios within the preconditions
	
	@Test
	void testSpecializedListThreeElem() {
		byte elem = 3;
		byte elem2 = 4;
		byte elem3 = 5;
		
		SpecializedList threeList = new SpecializedList();
		assertEquals(0, threeList.lengthIs());
		threeList.insertFront(elem);
		threeList.insertEnd(elem2);
		threeList.insertEnd(elem3);
		assertEquals(3, threeList.lengthIs());
		
		// test iterator methods.
		// To keep with the preconditions in interface, I reset to initialize the pointer, then iterate
		threeList.resetForward();
//		System.out.println(threeList.getNextItem());
		assertEquals(elem, threeList.getNextItem());
		threeList.resetBackward();
		assertEquals(elem3, threeList.getPriorItem());
		
		// where are the iterators now?
//		System.out.println(threeList.getNextItem()); 
//		threeList.printList();
		assertEquals(elem2, threeList.getNextItem());
		assertEquals(elem2, threeList.getPriorItem());
		
		// test reset methods
		threeList.resetForward();
		assertEquals(elem, threeList.getNextItem());
		threeList.resetBackward();
		assertEquals(elem3, threeList.getPriorItem());
	}
}
