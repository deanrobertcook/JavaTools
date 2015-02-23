package datastructures;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import testutility.TestMethods;

/**
 *
 * @author dean
 */
public class LinkedListTest extends TestMethods {
	private LinkedList<String> list;

	@Before
	public void setUpEmptyList() {
		 list = new LinkedList<>();
	}
	
	@Test
	public void testConsecutiveInserts() {
		String[] strings = this.randomStrings(10, 5);
		
		for (String string : strings) {
			list.insert(string);
		}
		
		//check that they have all been saved in order
		for (int i = 0; i < strings.length; i++) {
			String returnedString = list.get(i);
			String expectedString = strings[i];
			assertEquals(expectedString, returnedString);
		}
	}

	@Test
	public void testRandomInserts() {
		String[] strings = this.randomStrings(10, 5);
	}
	
}
