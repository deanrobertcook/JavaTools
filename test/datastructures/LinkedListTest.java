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
	public void testIsEmpty() {
		assertEquals(true, this.list.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty() {
		String string = this.randomString(10);
		list.insert(string);
		assertEquals(false, this.list.isEmpty());
	}
	
	@Test
	public void testDelete_SingleValue() {
		String string = this.randomString(10);
		list.insert(string);
		this.deleteAndAssert(string);
		assertTrue("List should be empty", list.isEmpty());
	}
	
	private void deleteAndAssert(String previouslyInsertedValue) {
		boolean deleted = list.delete(previouslyInsertedValue);
		assertTrue("Deletion should have found value", deleted);
		boolean deletedAgain = list.delete(previouslyInsertedValue);
		assertFalse("Deletion should not have found value again", deletedAgain);
	}
	
	@Test
	public void testDelete_deleteFirstOfMany() {
		int initialSize = 10;
		int stringLength = randomGenerator.nextInt(10);
		String[] strings = this.randomStrings(initialSize, stringLength);
			for (String string : strings) {
			list.insert(string);
		}
		
		// delete very first value
		list.delete(strings[0]); 
		
		//check size is correct
		assertEquals(initialSize - 1, list.size());
		
		//check order is maintained for rest of values
		for (int i = 1; i < strings.length; i++) {
			//list elements should now be off by one
			String returnedString = list.get(i - 1);
			String expectedString = strings[i];
			assertEquals(expectedString, returnedString);
		}		
	}
	
	@Test
	public void testDelete_repeatedValues() {
		String[] strings = {
			this.randomString(10),
			"repetative",
			this.randomString(10),
			"repetative",
			this.randomString(10),
			"repetative",
			this.randomString(10),
		};
		
		for (String string : strings) {
			list.insert(string);
		}
		
		int timesDeleted = 0;
		while (list.delete("repetative")) {			
			timesDeleted++;
		}
		assertEquals(3, timesDeleted);
	}
	
	@Test
	public void testDelete_nonExistentValue() {
		boolean deleted = list.delete("Non existent value");
		assertFalse("Deletion found a non existent value", deleted);
	}
	
	@Test
	public void testDelete_MultipleValues() {
		String[] strings = this.randomStrings(10000, 5000);
		
		for (String string : strings) {
			list.insert(string);
		}
		
		for (String string : strings) {
			this.deleteAndAssert(string);
		}
		
		assertTrue("List should be empty", list.isEmpty());
	}
	
	@Test
	public void testCorrectListLengthMedium() {
		int maxLength = 10000;
		int intendedLength = this.randomGenerator.nextInt(maxLength);
		String[] strings = this.randomStrings(intendedLength, 5000);
		
		for (String string : strings) {
			list.insert(string);
		}
		
		assertEquals(intendedLength, list.size());
	}
	
	@Test
	public void testConsecutiveStringInserts() {
		String[] strings = this.randomStrings(10000, 5000);
		
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
	public void testRandomStringInserts() {
		String[] strings = this.randomStrings(10000, 5000);
		for (String string : strings) {
			//int insertPosition = 
		}
		
	}
	
}
