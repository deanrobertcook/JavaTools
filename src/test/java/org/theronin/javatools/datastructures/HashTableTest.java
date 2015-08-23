/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.theronin.javatools.datastructures;

import org.junit.Before;
import org.junit.Test;
import org.theronin.javatools.testutility.TestMethods;

import static org.junit.Assert.*;


/**
 *
 * @author dean
 */
public class HashTableTest extends TestMethods {
	
	HashTable<String, String> hashTable;
	
	@Before
	public void setUpHashTable() {
		this.hashTable = new HashTable<>();
	}
	
	@Test
	public void testSimpleInsertAndGet() {
		String index = "index";
		String value = "value";
		
		this.hashTable.insert(index, value);
		
		assertEquals(value, hashTable.get(index));
	}
	
	@Test
	public void testMultipleInsertsAndGets() {
		String[] keys = {
			"index1",
			"index2",
			"index3",
		};
		String[] values = {
			"value1",
			"value2",
			"value3",
		};
		
		for (int i = 0; i < keys.length; i++) {
			this.hashTable.insert(keys[i], values[i]);
		}
		for (int i = 0; i < keys.length; i++) {
			assertEquals(values[i], this.hashTable.get(keys[i]));
		}
	}
	
	@Test
	public void testMediumInsertsAndGets() {
		String[] keys = this.randomStrings(500, 10);
		String[] values = this.randomStrings(500, 50);
		
		for (int i = 0; i < keys.length; i++) {
			this.hashTable.insert(keys[i], values[i]);
		}
		for (int i = 0; i < keys.length; i++) {
			assertEquals(values[i], this.hashTable.get(keys[i]));
		}
	}
	
	@Test
	public void testDelete_Empty() {
		String key = "An index that doesn't exist";
		boolean deleted = this.hashTable.delete(key);
		assertFalse("Item should not have been deleted (doesn't exist!)", deleted);
	}
	
	@Test
	public void testDelete_SingleItem() {
		String key = "index";
		String value = "value";
		this.hashTable.insert(key, value);
		boolean deleted = this.hashTable.delete(key);
		assertTrue("Item should have been deleted", deleted);
		assertEquals(0, this.hashTable.size());
	}
	
	@Test
	public void testDelete_multipleItems() {
		String[] keys = this.randomStrings(500, 10);
		String[] values = this.randomStrings(500, 50);
		
		for (int i = 0; i < keys.length; i++) {
			this.hashTable.insert(keys[i], values[i]);
		}
		for (int i = 0; i < keys.length; i++) {
			assertTrue(this.hashTable.delete(keys[i]));
		}
		assertEquals(0, this.hashTable.size());
	}
	
	@Test
	public void testSize_AfterInsertions() {
		int expectedSize = 500;
		String[] keys = this.randomStrings(expectedSize, 10);
		String[] values = this.randomStrings(expectedSize, 50);
		
		for (int i = 0; i < keys.length; i++) {
			this.hashTable.insert(keys[i], values[i]);
		}
		
		assertEquals(expectedSize, this.hashTable.size());
	}
	
}
