package utility;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class UtilityTest {
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
	
}
