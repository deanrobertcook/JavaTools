package org.theronin.javatools.sort;

import org.junit.Test;
import org.theronin.javatools.testutility.TestMethods;
import org.theronin.javatools.utility.Util;

public class QuickSortTest extends TestMethods {

	@Test
	public void testIntegers() {
		Integer[] A = this.randomIntegers(0, 20, 0, 50);
		
		Util.printArray(A);
		new QuickSorter<Integer>().sort(A);
		Util.printArray(A);
	}
	
	@Test
	public void testStrings() {
		String[] A = randomStrings(20, 10);
		
		Util.printArray(A);
		new QuickSorter<String>().sort(A);
		Util.printArray(A);
	}
	
	@Test
	public void largeTest() {
		int[][] arrays = this.increasingArrays();
		
	}

}
