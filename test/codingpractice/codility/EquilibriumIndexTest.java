/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingpractice.codility;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class EquilibriumIndexTest {
	
	@Test
	public void simpleTest() {
		int[][] tests = {
			{-1, 3, -4, 5, 1, -6, 2, 1},
			{0, 0},
		};
		
		int[] expectedResults = {
			1,
			-1,
		};
		EquilibriumIndex testObject = new EquilibriumIndex();
		for (int i = 0; i < expectedResults.length; i++) {
//			System.out.println("bruteTest iteration: " + i);
			assertEquals(expectedResults[i], testObject.solution(tests[i]));
		} 
	}
	
}
