/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class MergeSortTest extends TestCase {
	
	@Test
	public void testSimple() {
		int[][] arrays = this.createScaledArrays();
		for (int[] array : arrays) {
			this.startTimer();
			MergeSort.sort(array);
			this.stopTimer();
			System.out.println("Sorted array of length: " + array.length + " in: " + this.getTime() + "ms");
			if (!this.arrayInNumericalOrder(array)) {
				fail("Array not properly sorted");
			}
		}
	}
	
}
