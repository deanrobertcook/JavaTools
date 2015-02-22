/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.Test;
import static org.junit.Assert.*;
import testutility.TestMethods;

/**
 *
 * @author dean
 */
public class LinkedListTest extends TestMethods {
	
	public LinkedListTest() {
	}

	/**
	 * Test of insert method, of class LinkedList.
	 */
	@Test
	public void testConsecutiveInserts() {
		String[] strings = this.randomStrings(10, 5);
		LinkedList<String> list = new LinkedList<>();
		
		//fill list with 50 random strings
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

	/**
	 * Test of insert method, of class LinkedList.
	 */
	@Test
	public void testInsert_GenericType_int() {
	}

	/**
	 * Test of search method, of class LinkedList.
	 */
	@Test
	public void testSearch() {
	}

	/**
	 * Test of delete method, of class LinkedList.
	 */
	@Test
	public void testDelete() {
	}

	/**
	 * Test of sort method, of class LinkedList.
	 */
	@Test
	public void testSort() {
	}

	/**
	 * Test of insertList method, of class LinkedList.
	 */
	@Test
	public void testInsertList() {
	}

	/**
	 * Test of get method, of class LinkedList.
	 */
	@Test
	public void testGet() {
	}

	/**
	 * Test of toArray method, of class LinkedList.
	 */
	@Test
	public void testToArray() {
	}
	
}
