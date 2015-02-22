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
public class DivisorsTest {
	@Test
	public void testValidated() {
		int[] A = {3, 1, 2, 3, 6};
		int[] expected = {2, 4, 3, 2, 0};
		assertArrayEquals(expected, new Divisors().solution(A));
	}
	
}
