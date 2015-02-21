/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import codility.TriangularArray;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class TriangularArrayTest {
	
	@Test
	public void testSimple() {
		int[] testA = {10, 2, 5, 1, 8, 20};
		int expectedA = 1; //triangular triplet exists
		assertEquals(expectedA, (new TriangularArray()).solution(testA));
		
		int[] testB = {10, 50, 5, 1};
		int expectedB = 0; //doesn't exist
		assertEquals(expectedB, (new TriangularArray()).solution(testB));
	}
}