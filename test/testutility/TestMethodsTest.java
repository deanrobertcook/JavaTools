package testutility;

import org.junit.Assert;
import org.junit.Test;
import utility.Utility;

/**
 * A class to test the test methods!
 *
 * @author dean
 */
public class TestMethodsTest extends TestMethods {

//	@Test
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

			System.out.println("int minLength = " + minLength + ";");
			System.out.println("int maxLength = " + maxLength + ";");
			System.out.println("int minVal = " + minVal + ";");
			System.out.println("int maxVal = " + maxVal + ";");
			System.out.println("------------------------------");

			int[] A = this.randomIntegers(minLength, maxLength, minVal, maxVal);
			if (A.length < minLength || A.length > maxLength) {
				System.out.println("Array MaxLength: " + maxLength);
				System.out.println("Array Length: " + A.length);
				System.out.println("Array MinLength: " + minLength);
				Assert.fail("Array length outside of specified");
			}

			int arrayMinPos = Utility.findMinimum(A);
			if (arrayMinPos > 0 && A[arrayMinPos] < minVal) {
				System.out.println("Array Defined Min: " + minVal);
				System.out.println("Array Min Value: " + A[arrayMinPos]);
				Utility.printArray(A);
				Assert.fail("Minimum value falls below defined range");
			}
			int arrayMaxPos = Utility.findMaximum(A);
			if (arrayMinPos > 0 && A[arrayMaxPos] > maxVal) {
				System.out.println("Array Defined Max: " + maxVal);
				System.out.println("Array Max Value: " + A[arrayMaxPos]);
				Utility.printArray(A);
				Assert.fail("Maximum value falls above defined range");
			}
		}
	}

	@Test
	public void testTroublesome() {
		int minLength = 33;
		int maxLength = 86;
		int minVal = -1163510201;
		int maxVal = 1816014807;
		int[] A = this.randomIntegers(minLength, maxLength, minVal, maxVal);
		if (A.length < minLength || A.length > maxLength) {
			System.out.println("Array MaxLength: " + maxLength);
			System.out.println("Array Length: " + A.length);
			System.out.println("Array MinLength: " + minLength);
			Assert.fail("Array length outside of specified");
		}

		int arrayMinPos = Utility.findMinimum(A);
		if (arrayMinPos > 0 && A[arrayMinPos] < minVal) {
			System.out.println("Array Defined Min: " + minVal);
			System.out.println("Array Min Value: " + A[arrayMinPos]);
			Utility.printArray(A);
			Assert.fail("Minimum value falls below defined range");
		}
		int arrayMaxPos = Utility.findMaximum(A);
		if (arrayMinPos > 0 && A[arrayMaxPos] > maxVal) {
			System.out.println("Array Defined Max: " + maxVal);
			System.out.println("Array Max Value: " + A[arrayMaxPos]);
			Utility.printArray(A);
			Assert.fail("Maximum value falls above defined range");
		}
	}

//	@Test
	public void testRandomIntegersZeroRange() {

	}
}
