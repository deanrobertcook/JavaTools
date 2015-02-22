package utility;

import testutility.TestMethods;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class UtilityTest extends TestMethods {

	@Test
	public void scribbleTest() {
		System.out.println(11/2);
	}
	
	@Test
	public void testFindPlaceValue() {
		int[] testInputs = {
			10000, 8964, 5, 717322, 0
		};
		int[] expectedOutputs = {
			5, 4, 1, 6, 0
		};

		for (int i = 0; i < testInputs.length; i++) {
			assertEquals(expectedOutputs[i], Utility.findSigFigs(testInputs[i]));
		}
	}

	@Test
	public void testFindMinimumAndMax() {
		int numArrays = 1000;
		int minLengths = 0;
		int maxLengths = 100;
		int minVals = 100;
		int maxVals = 100;
		
		int[][] arrays = this.randomIntegerArrays(numArrays, minLengths, maxLengths, minVals, maxVals);
		for (int[] array : arrays) {
			if (array.length > 0) {
				int testMin = Utility.findMinimumPos(array);
				int valueAtMin = array[testMin];
				int testMax = Utility.findMaximumPos(array);
				int valueAtMax = array[testMax];

				Arrays.sort(array);
				assertEquals(array[0], valueAtMin);
				assertEquals(array[array.length - 1], valueAtMax);
			}			
		}
	}
	
	@Test
	public void testPrintMatrix() {
		int[][] matrix = this.randomIntegerArrays(6, 3, 3, -100, 100);
		Utility.printMatrix(matrix);
		System.out.println("Check [2][0]:" + matrix[2][0]);
	}
}
