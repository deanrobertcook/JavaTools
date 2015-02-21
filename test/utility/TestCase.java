package utility;

import java.util.Random;

/**
 * Test Utility class containing methods for common test functionality that
 * other test classes can extend. I intend to build this class over time so I
 * can quickly use it for any projects.
 */
public class TestCase {

	private long startTime;
	private long endTime;

	//Creates 7 random arrays of sizes from 0 to 100000 with largest random
	//value range
	public int[][] createScaledArrays() {
		return this.createScaledArrays(7, 10, -1);
	}

	//Creates numArrays each increasing by a factor of sizeMultiplier with random
	//values between -rangeOfRandomValues and rangeOfRandomValues
	public int[][] createScaledArrays(int numArrays, int sizeMultiplier, int rangeOfRandomValues) {
		int[][] arrays = new int[numArrays][];

		Random randomGenerator = new Random();

		for (int i = 0; i < numArrays; i++) {
			if (i == 0) {
				arrays[i] = new int[0];
			} else {
				int arraySize = 1 * (int) Math.pow(sizeMultiplier, (double) (i - 1));
				arrays[i] = new int[arraySize];
				for (int j = 0; j < arraySize; j++) {
					if (rangeOfRandomValues == -1) {
						arrays[i][j] = randomGenerator.nextInt();
					} else {
						arrays[i][j] = randomGenerator.nextInt() % rangeOfRandomValues;
					}
				}
			}
		}
		return arrays;
	}
	
	public int[] createRandomArray(int minLength, int maxLength, int minVal, int maxVal) {
		Random randomGenerator = new Random();
		int arrayLength = randomGenerator.nextInt(maxLength + 1);
		arrayLength = arrayLength + minLength;
		arrayLength = arrayLength % maxLength + 1;
		
		int[] array = new int[arrayLength];
		
		for (int i = 0; i < array.length; i++) {
			int rand = randomGenerator.nextInt();
			int intRange = maxVal - minVal;
			rand = rand % ((intRange + 2) / 2);
			rand = rand + (intRange / 2) + minVal;
			array[i] = rand;
		}
		return array;
	}

	public void startTimer() {
		this.startTime = System.currentTimeMillis();
	}

	public void stopTimer() {
		this.endTime = System.currentTimeMillis();
	}

	public void printTime() {
		long time = this.endTime - this.startTime;
		System.out.println("Time taken: " + time + "ms");
	}

	public long getTime() {
		return this.endTime - this.startTime;
	}

	public boolean arrayInNumericalOrder(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
