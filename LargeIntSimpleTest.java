package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LargeIntSimpleTest {
	
	// the provided test cases do not represent all possible cases.
	// please write your own cases to test for all possible edge scenarios within the assignment requirements
	
	@Test
	void testLargeIntNeg20120() {
		String value = "-20120";
		LargeInt me = new LargeInt("-20120");
		// we'll use String.replace, to ensure that we can catch outputs with extraneous + or , characters when grading
		assertEquals(value, me.toString().replace("+","").replace(",", ""));
	}
	
	@Test
	void testLargeInt20120() {
		String value = "20120";
		LargeInt me = new LargeInt(value);
		assertEquals(value, me.toString().replace("+","").replace(",", ""));
	}
	
	@Test
	void testLargeIntSum() {
		String meValue = "102112";
		String me2Value = "104231";
		LargeInt me = new LargeInt(meValue); // i have an integer me
		LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
		System.out.println(me);
		System.out.println(me2);
		LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
		assertEquals("206343", me3.toString().replace("+","").replace(",", ""));
		// ensure original LargeInts state didn't change
		assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
		assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
	}
	
	@Test
	void test1() {
		String meValue = "20";
		String me2Value = "5";
		LargeInt me = new LargeInt(meValue); // i have an integer me
		LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
		System.out.println(me);
		System.out.println(me2);
		LargeIntInterface me3 = me.subtract(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
		assertEquals("15", me3.toString().replace("+","").replace(",", ""));
		// ensure original LargeInts state didn't change
		assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
		assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
	}
	
	
	@Test
	void testLargeIntDiff() { 
		String meValue = "9642";
		String me2Value = "4230";
		LargeInt me = new LargeInt(meValue); // i have an integer me
		LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
		LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
		assertEquals("5412", me3.toString().replace("+","").replace(",", ""));
		// ensure original LargeInts state didn't change
		assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
		assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
	}
	
	
	
}
