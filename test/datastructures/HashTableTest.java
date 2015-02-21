/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.Test;
import static org.junit.Assert.*;
import utility.TestCase;
import utility.Utility;

/**
 *
 * @author dean
 */
public class HashTableTest extends TestCase {
	
	@Test
	public void testSimpleInsertAndGet() {
		HashTable hashTable = new HashTable();
		String index = "index";
		String value = "value";
		
		hashTable.insert(index, value);
		
		assertEquals(value, hashTable.get(index));
	}
	
	@Test
	public void testMultipleInsertsAndGets() {
		String[] indices = {
			"index1",
			"index2",
			"index3",
		};
		String[] values = {
			"value1",
			"value2",
			"value3",
		};
		
		HashTable hashTable = new HashTable();
		for (int i = 0; i < indices.length; i++) {
			hashTable.insert(indices[i], values[i]);
		}
		for (int i = 0; i < indices.length; i++) {
			assertEquals(values[i], hashTable.get(indices[i]));
		}
	}
	
	@Test
	public void testMediumInsertsAndGets() {
		String[] indices = this.generateRandomStrings(50, 10);
		String[] values = this.generateRandomStrings(50, 50);
		
		HashTable hashTable = new HashTable();
		for (int i = 0; i < indices.length; i++) {
			hashTable.insert(indices[i], values[i]);
		}
		for (int i = 0; i < indices.length; i++) {
			assertEquals(values[i], hashTable.get(indices[i]));
		}
	}
	
}
