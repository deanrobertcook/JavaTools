/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.utility;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class PrimesTest {
	
	@Test
	public void testFindPrimesSingleInput() {
		int [] expectedPrimes = {
			0,	//0
			0,	//1
			0,	
			0,
			2,
			0,	//5
			2,
			0,
			2,
			3,
			2,	//10
			0,	
			2,
			0,
			2,
			3,	//15
			2,
			0,	//17
		};
		int upTo = 17;
		int[] primes = Primes.findPrimes(upTo);
		Util.printArray(primes);
		assertArrayEquals(expectedPrimes, primes);
	}
	
	@Test
	public void testFindFactors() {
		int testVal = 1;
		int[] expected = {2, 5, 10, 20};
		int[] returnedArray = Primes.findPrimeFactors(testVal);
		Util.printArray(returnedArray);
//		assertArrayEquals(expected, returnedArray);
	}
	
}
