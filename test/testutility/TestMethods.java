package testutility;

import java.util.Random;

/**
 * Test Utility class containing methods for common test functionality that
 * other test classes can extend. I intend to build this class over time so I
 * can quickly use it for any projects.
 */
public class TestMethods {

	private long startTime;
	private long endTime;

	private final Random randomGenerator;

	public TestMethods() {
		this.randomGenerator = new Random();
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

	public boolean isArrayInNumericalOrder(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public int[][] randomIntegerArrays(int numArrays, int maxLength, int maxRange) {
		int[][] arrays = new int[numArrays][];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = this.randomIntegers(maxLength, maxRange);
		}
		return arrays;
	}

	public int[] randomIntegers(int maxLength, int maxRange) {
		return this.randomIntegers(0, maxLength, -maxRange, maxRange);
	}

	public int[] randomIntegers(int minLength, int maxLength, int minVal, int maxVal) {
		int arrayLength = this.randomGenerator.nextInt(maxLength + 1);
		
		arrayLength = arrayLength % minLength;
		arrayLength = arrayLength + minLength;

		int[] array = new int[arrayLength];

		for (int i = 0; i < array.length; i++) {
			int rand = this.randomGenerator.nextInt();
			int intRange = maxVal - minVal;
			rand = rand % ((intRange + 2) / 2);
			rand = rand + (intRange / 2) + minVal;
			array[i] = rand;
		}
		return array;
	}

	public String[] randomStrings(int numStrings, int maxStringLength) {
		String[] strings = new String[numStrings];
		for (int i = 0; i < strings.length; i++) {
			int stringLength = this.randomGenerator.nextInt(maxStringLength + 1);
			strings[i] = this.randomString(stringLength);
		}
		return strings;
	}

	public String randomString(int length) {
		char[] stringAsChars = new char[length];
		for (int i = 0; i < stringAsChars.length; i++) {
			//first ASCII = 32 (space), 256 - 32 = 224
			int asciiCode = this.randomGenerator.nextInt(224);
			asciiCode = asciiCode + 32;
			stringAsChars[i] = (char) asciiCode;
		}
		String randomString = String.copyValueOf(stringAsChars);
		return randomString;
	}

	public int[][] createScaledArrays() {
		return this.createScaledArrays(7, 10, -1);
	}

	//Creates numArrays each increasing by a factor of sizeMultiplier with random
	//values between -rangeOfRandomValues and rangeOfRandomValues
	public int[][] createScaledArrays(int numArrays, int sizeMultiplier, int rangeOfRandomValues) {
		int[][] arrays = new int[numArrays][];

		for (int i = 0; i < numArrays; i++) {
			if (i == 0) {
				arrays[i] = new int[0];
			} else {
				int arraySize = 1 * (int) Math.pow(sizeMultiplier, (double) (i - 1));
				arrays[i] = new int[arraySize];
				for (int j = 0; j < arraySize; j++) {
					if (rangeOfRandomValues == -1) {
						arrays[i][j] = this.randomGenerator.nextInt();
					} else {
						arrays[i][j] = this.randomGenerator.nextInt() % rangeOfRandomValues;
					}
				}
			}
		}
		return arrays;
	}
}
