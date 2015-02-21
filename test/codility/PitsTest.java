/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class PitsTest {
	
	@Test
	public void testSolution() {
		int[] A = {0, 1, 3, -2, 0, 1, 0, -3, 2, 3};
		assertEquals(4, new Pits().solution(A));
	}
	
}