package tools.testutility;

import static org.junit.Assert.*;
import org.junit.Test;
import tools.utility.Util;

/**
 * A class to test the test methods!
 *
 * @author dean
 */
public class TestMethodsTest extends TestMethods {

	@Test
	public void testRandomIntegers() {
		for (int i = 0; i < 10000; i++) {
			int minLength = this.randomGenerator.nextInt(100);
			int maxLength = this.randomGenerator.nextInt(100) + minLength;

			int maxVal = this.randomGenerator.nextInt();
			int minVal = this.randomGenerator.nextInt();

			if (maxVal < minVal) {
				int temp = maxVal;
				maxVal = minVal;
				minVal = temp;
			}
			
			int[] A = this.randomIntegers(minLength, maxLength, minVal, maxVal);
			this.checkArrayIsinSpecifiedRanges(A, minLength, maxLength, minVal, maxVal);
		}
	}

	@Test
	public void testRandomIntegersRangeGreaterThanIntegerStorage() {
		int minLength = 33;
		int maxLength = 86;
		int minVal = -1163510201;
		int maxVal = 1816014807;
		int[] A = this.randomIntegers(minLength, maxLength, minVal, maxVal);
		this.checkArrayIsinSpecifiedRanges(A, minLength, maxLength, minVal, maxVal);
	}
	
	@Test
	public void testRandomIntegersFixedArrayLength() {
		int minLength = 50;
		int maxLength = 50;
		int minVal = 100;
		int maxVal = 100;
		int[] A = this.randomIntegers(minLength, maxLength, minVal, maxVal);
		this.checkArrayIsinSpecifiedRanges(A, minLength, maxLength, minVal, maxVal);
	}
	
	private void checkArrayIsinSpecifiedRanges(int[] A, int minLength, int maxLength, int minVal, int maxVal) {
		if (A.length < minLength || A.length > maxLength) {
				this.printRandomIntegersParameters(minLength, maxLength, minVal, maxVal);
				System.out.println("Array MaxLength: " + maxLength);
				System.out.println("Array Length: " + A.length);
				System.out.println("Array MinLength: " + minLength);
				fail("Array length outside of specified");
			}

			int arrayMinPos = Util.findMinimumPos(A);
			if (arrayMinPos > 0 && A[arrayMinPos] < minVal) {
				this.printRandomIntegersParameters(minLength, maxLength, minVal, maxVal);
				System.out.println("Array Defined Min: " + minVal);
				System.out.println("Array Min Value: " + A[arrayMinPos]);
				Util.printArray(A);
				fail("Minimum value falls below defined range");
			}
			int arrayMaxPos = Util.findMaximumPos(A);
			if (arrayMinPos > 0 && A[arrayMaxPos] > maxVal) {
				this.printRandomIntegersParameters(minLength, maxLength, minVal, maxVal);
				System.out.println("Array Defined Max: " + maxVal);
				System.out.println("Array Max Value: " + A[arrayMaxPos]);
				Util.printArray(A);
				fail("Maximum value falls above defined range");
			}
	}
	
	private void printRandomIntegersParameters(int minLength, int maxLength, int minVal, int maxVal) {
		System.out.println("int minLength = " + minLength + ";");
		System.out.println("int maxLength = " + maxLength + ";");
		System.out.println("int minVal = " + minVal + ";");
		System.out.println("int maxVal = " + maxVal + ";");
		System.out.println("------------------------------");
	}
	
	@Test
	public void testRemoveDuplicates() {
		String[] strings = {"a","b","c","a","b","d","e", "b"};
		String[] expected = {"c", "a", "d", "e", "b"};
		strings = this.removeDuplicates(strings);
		
		assertArrayEquals(expected, strings);
	}
}
