package codingpractice.codility;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class EquiLeaderTest {

	@Test
	public void simpleTest() {
		
	}
	
	@Test
	public void bruteTest() {
		int[][] tests = {
			{4, 3, 4, 4, 4, 2},
			{4, 4, 4, 2, 4, 4, 7},
			{4, 3},
			{0},
			{-1, -1, -1, 2, 3, -1, -1},
		};
		
		int[] expectedResults = {
			2,
			3,
			0,
			0,
			5
		};
		EquiLeader testObject = new EquiLeader();
		for (int i = 0; i < expectedResults.length; i++) {
//			System.out.println("bruteTest iteration: " + i);
			assertEquals(expectedResults[i], testObject.bruteSolution(tests[i]));
		}
	}
	
	@Test
	public void bruteTimeTest() {
		int[] randomValues = new int[10];
		for (int i = 0; i < randomValues.length; i++) {
			randomValues[i] = new Random().nextInt();
		}
		
		long start = System.currentTimeMillis();
		int result = new EquiLeader().bruteSolution(randomValues);
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println("Brute Solution executed in: " + time + " milliseconds");
		System.out.println("Brute Solution found: " + result + " leaders");
	}
	
	@Test
	public void testFindLeader() {
		int[] testA = {4, 3, 4, 4, 4, 2};
		int expectedA = 4;
		assertEquals(expectedA, new EquiLeader().findLeaderInRange(testA, 0, testA.length));
	}
}
