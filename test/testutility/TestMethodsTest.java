package testutility;

import org.junit.Assert;
import org.junit.Test;
import utility.Utility;

/**
 * A class to test the test methods!
 * @author dean
 */
public class TestMethodsTest extends TestMethods {
	
	@Test
	public void testRandomArray() {
		for (int i = 0; i < 10000; i++) {
			int[] A = this.randomIntegers(10, 20, -5, 50);
			if (A.length < 10 || A.length > 20) {
				System.out.println("Array Length: " + A.length);
				Assert.fail("Array length outside of specified");
			}
			int arrayMinPos = Utility.findMinimum(A);
			if (A[arrayMinPos] < -5) {
				System.out.println("Array Min Value: " + A[arrayMinPos]);
				Assert.fail("Minimum value falls outside of defined range");
			}
			int arrayMaxPos = Utility.findMaximum(A);
			if (A[arrayMaxPos] > 50) {
				System.out.println("Array Max Value: " + A[arrayMaxPos]);
				Assert.fail("Maximum value falls outside of defined range");
			}
		}
	}
}
