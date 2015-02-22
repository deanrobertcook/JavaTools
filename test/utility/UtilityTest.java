package utility;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class UtilityTest extends TestCase {
	@Test
	public void testFindPlaceValue() {
		System.out.println("findPlaceValue");
		int[] testInputs = {
			10000,	8964,	5,	717322,	0
		};
		int[] expectedOutputs = {
			5,		4,		1,	6,		0
		};
		
		for (int i = 0; i < testInputs.length; i++) {
			assertEquals(expectedOutputs[i], Utility.findSigFigs(testInputs[i]));
		}
	}
	
	@Test
	public void testFindIntValuesOfStringCharacters() {
		String testString = "abcdABCD1234!@#$%^&*()";
		int[] expectedVals = {
			97, 98, 99, 100, 
			65, 66, 67, 68, 
			49, 50, 51, 52,
			33, 64, 35, 36, 37, 94, 38, 42, 40, 41
		};
		int[] intVals = Utility.findIntValuesOfStringCharacters(testString);
		assertArrayEquals(expectedVals, intVals);
	}
	
	@Test
	public void testFindMinimumAndMax() {
		int[][] arrays = this.createRandomArrays(1000, 100, 10);		
		for (int[] array : arrays) {
			int testMin = Utility.findMinimum(array);
			int valueAtMin = array[testMin];
			int testMax = Utility.findMaximum(array);
			int valueAtMax = array[testMax];
			
			Arrays.sort(array);
			assertEquals(array[0], valueAtMin);
			assertEquals(array[array.length - 1], valueAtMax);
		}
		
	}
	
}
