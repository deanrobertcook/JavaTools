/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.theronin.javatools.sort;

import org.junit.Test;
import org.theronin.javatools.testutility.TestMethods;
import org.theronin.javatools.utility.Util;

import static org.junit.Assert.fail;

/**
 *
 * @author dean
 */
public class MergeSortTest extends TestMethods {
	
	@Test
	public void testRandom() {
		int[][] arrays = this.randomIntegerArrays(12, 0, 100000, -1000, 1000);
		for (int i = 0; i < arrays.length; i++) {
			this.startNewTimer(i);
			MergeSort.sort(arrays[i]);
			this.stopTimer(i);
			this.printTime(i);
			if (!this.isArrayInNumericalOrder(arrays[i])) {
				fail("Array not properly sorted");
			}
		}
		
		long[] times = this.getTimes(0, arrays.length - 1);
		Util.printArray(times);
	}
	
	@Test
	public void testIncreasingInputs() {
		int[][] arrays = this.increasingArrays();
		for (int i = 0; i < arrays.length; i++) {
			this.startNewTimer(i);
			MergeSort.sort(arrays[i]);
			this.stopTimer(i);
			if (!this.isArrayInNumericalOrder(arrays[i])) {
				fail("Array not properly sorted");
			}
		}
		
		long[] times = this.getTimes(0, arrays.length - 1);
		Util.printArray(times);
	}
	
}
