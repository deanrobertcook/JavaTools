package tools.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.testutility.TestMethods;

public class QuickSortTest extends TestMethods{

	@Test
	public void test() {
		int[] A = this.randomIntegers(0, 20, 0, 50);
		
		Util.printArray(A);
		QuickSort.sort(A);
		Util.printArray(A);
	}

}
