package codingpractice;

import utility.Utility;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dean
 */
public class KnapSackTest {

//	@Test
	public void testSimple() {
		int knapsackSize = 10;
		KnapSack knapsack = new KnapSack(knapsackSize);
		
		int[] items = {3, 4, 5, 6, 7, 8, 9};
		knapsack.fillKnapsackWithItems(items);
		
		int expectedBestCapacity = 10;
		assertEquals(expectedBestCapacity, knapsack.getKnapsackCapacity());
	}
	
	
	/**
	 * A verified solution to a simple problem instance
	 */
	@Test
	public void testVerified() {
		int knapsackSize = 163;
		KnapSack knapsack = new KnapSack(knapsackSize);
		
		int[] items = {4, 9, 15, 19, 27, 44, 54, 68, 73, 101};
		knapsack.fillKnapsackWithItems(items);
		
		System.out.println("Items in knapsack:");
		Utility.printArray(knapsack.getKnapsackContents());
		
		int expectedBestCapacity = 163;
		assertEquals(expectedBestCapacity, knapsack.getKnapsackCapacity());
	}
	
//	@Test
	public void testSeries() {
		int knapsackSize = 30;
		int[][] itemLists = {
			{5, 8, 9}, //test trivial example where all items fit
			{31, 50, 70}, //test trivial example where no items fit
		};
		
		int[] expectedFinalCapacities = {
			22,
			0
		};
		
		for (int i = 0; i < expectedFinalCapacities.length; i++) {
			KnapSack knapsack = new KnapSack(knapsackSize);
			knapsack.fillKnapsackWithItems(itemLists[i]);
			assertEquals(expectedFinalCapacities[i], knapsack.getKnapsackCapacity());
		}
	}
	
//	@Test
	public void testAddingZeroWeightedItems() {
		int[] items = {0, -1}; //neither should be added
		KnapSack knapsack = new KnapSack(10);
		knapsack.fillKnapsackWithItems(items);
		
		//If we add an item of less than 0 weight, 
		//I'll assume that the item doesn't exist and ignore it
		int expectedCount = 0; 
		assertEquals(expectedCount, knapsack.getKnapsackItemCount());
	}
	
}
