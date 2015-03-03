/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.datastructures;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tools.testutility.TestMethods;

/**
 *
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class BinarySearchTreeTest extends TestMethods {

	BinarySearchTree<String, String> searchTree;

	@Before
	public void before() {
		this.searchTree = new BinarySearchTree<>();
	}

	@Test
	public void testInsertAndSearch_Simple() {
		String key = "key";
		String value = "value";
		this.searchTree.insert(key, value);
		String returnedValue = this.searchTree.search(key);
		assertEquals(value, returnedValue);
	}

	@Test
	public void testInsertAndSearch_Medium() {
		int numStrings = 5000;
		int keyLength = 100;

		String[] keys = this.randomStrings(numStrings, keyLength);
		keys = this.removeDuplicates(keys);
		String[] values = this.randomStrings(numStrings, keys.length);

		for (int i = 0; i < keys.length; i++) {
			this.searchTree.insert(keys[i], values[i]);
		}

		for (int i = 0; i < keys.length; i++) {
			assertEquals("Failed on " + i + "th attempt", this.searchTree.search(keys[i]), values[i]);
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testDelete_Medium() {
		int numStrings = 5000;
		int keyLength = 10;

		String[] keys = new String[numStrings];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = this.randomStringContaining(keyLength, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		}
		keys = this.removeDuplicates(keys);
		String[] values = this.randomStrings(numStrings, keys.length);

		for (int i = 0; i < keys.length; i++) {
			this.searchTree.insert(keys[i], values[i]);
		}
		for (int i = 0; i < keys.length; i++) {
			this.searchTree.delete(keys[i]);
		}
		assertEquals(0, this.searchTree.size());
		
		String randomIndexCheck = keys[this.randomGenerator.nextInt(numStrings)];
		this.searchTree.search(randomIndexCheck);
	}
}
