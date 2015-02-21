package other;

/**
 * Class representing a Knapsack with various different implementations
 * of algorithms for filling it
 */
public class KnapSack {

	private int[] knapsack;
	private final int knapsackSize;
	private int knapsackItemsContained = 0;
	private int knapsackCurrentCapacity = 0;
	
	private int[][] solutionTable;

	public KnapSack(int knapsackSize) {
		this.knapsackSize = knapsackSize;
	}

	public int getKnapsackCapacity() {
		return this.knapsackCurrentCapacity;
	}

	public int getKnapsackItemCount() {
		return this.knapsackItemsContained;
	}

	public int[] getKnapsackContents() {
		return this.getFinalKnapsack();
	}

	public void fillKnapsackWithItems(int[] allItems) {
		this.knapsack = new int[allItems.length];
		this.dynamicAlgorithm(allItems);
		this.searchSolutionTable(allItems, knapsackSize,  allItems.length);
	}
	
	private void dynamicAlgorithm(int[] allItems) {
		this.solutionTable = new int[this.knapsackSize + 1][allItems.length + 1];
		for (int itemIndex = 0; itemIndex < allItems.length + 1; itemIndex++) {
			for (int knapsackFragment = 1; knapsackFragment < this.knapsackSize + 1; knapsackFragment++) {
				if (itemIndex == 0) { //case where no items in our inventory
					this.solutionTable[knapsackFragment][itemIndex] = 0;
				} else {
					
					int valueToAdd = 0;
					//note the quick jump back to 0 indexing for our original items array
					int itemWeight = allItems[itemIndex - 1];
					//the value from the cell above is our base comparison. Note this is 
					//not going back to 0 indexing, we are instead fetching the cell above
					int weightAbove = this.solutionTable[knapsackFragment][itemIndex - 1];
					
					if (itemWeight <= knapsackFragment) {
						//if item does fit, check it's value plus the value of remaining space
						int remainingKnapsackFragment = knapsackFragment - itemWeight;
						int maxValFromRemainder = 0;
						if (remainingKnapsackFragment > 0) {
							maxValFromRemainder = this.solutionTable[remainingKnapsackFragment][itemIndex - 1];
						}
						int potentialVal = itemWeight + maxValFromRemainder;
						//if new value greater than above, it's our value, 
						//else use weight above
						valueToAdd = potentialVal > weightAbove ? potentialVal : weightAbove;
					} else { //new weight doesn't even fit
						valueToAdd = weightAbove;
					}
					this.solutionTable[knapsackFragment][itemIndex] = valueToAdd;
				}
			}
		}
	}
	
	private void searchSolutionTable(int[] allItems, int knapsackFragment, int largestItemIndex) {
		if (knapsackFragment > 0) {
			int bestValue = this.solutionTable[knapsackFragment][largestItemIndex];
			int itemToCheck = largestItemIndex;
			while (this.solutionTable[knapsackFragment][itemToCheck] == bestValue) {			
				itemToCheck--;
			}
			if (itemToCheck != 0) { //we've not yet run out of items
				int itemWeight = allItems[itemToCheck];
				this.addItemToKnapsack(allItems[itemToCheck]);
				this.searchSolutionTable(allItems, knapsackFragment - itemWeight, itemToCheck);
			}
		}
	}

	private void addItemToKnapsack(int itemWeight) {
		if (itemWeight > 0) {
			if (this.knapsackCurrentCapacity + itemWeight <= this.knapsackSize) {
				this.knapsack[this.knapsackItemsContained] = itemWeight;
				this.knapsackCurrentCapacity += itemWeight;
				this.knapsackItemsContained++;
			}
		}
	}

	private int[] getFinalKnapsack() {
		int[] finalKnapsack = new int[this.knapsackItemsContained];
		System.arraycopy(this.knapsack, 0, finalKnapsack, 0, this.knapsackItemsContained);
		return finalKnapsack;
	}
}
