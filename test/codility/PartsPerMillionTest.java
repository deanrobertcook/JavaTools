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
public class PartsPerMillionTest {

	@Test
	public void testSomeMethod() {
		int[] A = {0, 1, 2, 2, 3, 5};
		int[] B = {500000, 500000, 0, 0, 0, 20000};
		
		assertEquals(5, new PartsPerMillion().solution(A, B));
		
	}
	
}
