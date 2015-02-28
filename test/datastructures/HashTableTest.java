/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import testutility.TestMethods;

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
		String[] keys = this.randomStrings(50, 10);
		String[] values = this.randomStrings(50, 50);
		
		for (int i = 0; i < keys.length; i++) {
			this.hashTable.insert(keys[i], values[i]);
		}
		for (int i = 0; i < keys.length; i++) {
			assertEquals(values[i], this.hashTable.get(keys[i]));
		}
	}
	
}
