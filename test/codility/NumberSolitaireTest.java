/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import codility.NumberSolitaire;
import org.junit.Test;
import static org.junit.Assert.*;
import utility.TestCase;
import utility.Utility;

/**
 *
 * @author dean
 */
public class NumberSolitaireTest extends TestCase {
	
	/**
	 * Test of solution method, of class PebbleSquare.
	 */
//	@Test
	public void testSimple() {
		Utility.printArray(this.createScaledArrays(3, 18, 10)[2]);
		int[] A = {1, -2, 0, 9, -1, -2};
		int expected = 8;
		assertEquals(expected, new NumberSolitaire().solution(A));
	}
	
//	@Test
	public void testValidated() {
		int[] A = {1, -2, 0, 9, -1, -2};
		int expected = 8;
		assertEquals(expected, new NumberSolitaire().solution(A));
	}
	
//	@Test
	public void testHandVersion() {
		int[] A = {0, -1, -2, -3, -7, -7, 10, -12, 10, 3, 0};
		int expected = 20;
		assertEquals(expected, new NumberSolitaire().solution(A, 3));
	}
	
	@Test
	public void testLarge() {
		int[] A = this.createRandomArray(2, 100000, -10000, 10000);
		new NumberSolitaire().solution(A);
	}
	
}
