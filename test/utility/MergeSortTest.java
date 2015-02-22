/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import testutility.TestMethods;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class MergeSortTest extends TestMethods {
	
	@Test
	public void testSimple() {
		int[][] arrays = this.randomIntegerArrays(50, 0, 100, -1000, 1000);
		for (int[] array : arrays) {
			MergeSort.sort(array);
			if (!this.isArrayInNumericalOrder(array)) {
				fail("Array not properly sorted");
			}
		}
	}
	
}
