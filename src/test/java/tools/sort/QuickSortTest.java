package tools.sort;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.testutility.TestMethods;
import tools.utility.Util;

public class QuickSortTest extends TestMethods{

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
