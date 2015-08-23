package org.theronin.javatools.testutility;

import java.util.Random;

/**
 * Test Utility class containing methods for common test functionality that
 * other test classes can extend. I intend to build this class over time so I
 * can quickly use it for any projects.
 */
public class TestMethods {

	private long[] startTimes;
	private long[] endTimes;

	protected final Random randomGenerator;

	public TestMethods() {
		this.randomGenerator = new Random();
		this.startTimes = new long[10];
		this.endTimes = new long[10];
	}

	public void startNewTimer(int timer) {
		if (timer == this.startTimes.length) {
			this.increaseTimers();
		}
		this.startTimes[timer] = System.currentTimeMillis();
	}
	
	private void increaseTimers() {
		int oldLenth = this.startTimes.length;
		long[] newStartTimes = new long[oldLenth * 2];
		System.arraycopy(this.startTimes, 0, newStartTimes, 0, oldLenth);
		
		long[] newEndTimes = new long[oldLenth * 2];
		System.arraycopy(this.endTimes, 0, newEndTimes, 0, oldLenth);
		
		this.startTimes = newStartTimes;
		this.endTimes = newEndTimes;
	}

	public void stopTimer(int timer) {
		this.endTimes[timer] = System.currentTimeMillis();
	}

	public void printTime(int timer) {
		long time = this.endTimes[timer] - this.startTimes[timer];
		System.out.println("Time taken: " + time + "ms");
	}
	
	public long[] getTimes(int firstTimer, int lastTimer) {
		int numTimers = lastTimer - firstTimer + 1;
		long[] times = new long[numTimers];
		for (int i = 0; i < numTimers; i++) {
			long time = this.getTime(i + firstTimer);
			times[i] = time;
		}
		return times;
	}

	public long getTime(int timer) {
		return this.endTimes[timer] - this.startTimes[timer];
	}

	public boolean isArrayInNumericalOrder(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public int[][] increasingArrays() {
		int numArrays = 6; //of sizes 1, 10, 100, 1000, 10000, 100000
		int[][] arrays = new int[numArrays][];
		for (int i = 0; i < numArrays; i++) {
			int arraySize = 1 * (int) Math.pow((double) 10, (double) (i));
			int[] array = this.randomInts(arraySize, arraySize, Integer.MIN_VALUE, Integer.MAX_VALUE);
			arrays[i] = array;
		}
		return arrays;
	}

	public int[][] randomIntegerArrays(int numArrays, int minLength,
			int maxLength, int minVal, int maxVal) {
		int[][] arrays = new int[numArrays][];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = this.randomInts(minLength, maxLength,  minVal, maxVal);
		}
		return arrays;
	}

	public int[] randomInts(int minLength, int maxLength, int minVal, int maxVal) {
		int arrayLength = this.randomGenerator.nextInt(maxLength + 1);
		if (minLength > 0) {
			int lengthRange = maxLength - minLength + 1;
			arrayLength = arrayLength % lengthRange;
			arrayLength = arrayLength + minLength;
		}

		int[] array = new int[arrayLength];

		long intRange = (long) maxVal - (long) minVal;
		for (int i = 0; i < array.length; i++) {
			long rand = this.randomGenerator.nextInt();
			rand = rand % ((intRange + 2) / 2);
			rand = rand + (intRange / 2) + minVal;
			array[i] = (int) rand;
		}
		return array;
	}
	
	public Integer[] randomIntegers (int minLength, int maxLength, int minVal, int maxVal) {
		int[] intArray = randomInts(minLength, maxLength, minVal, maxVal);
		Integer[] integerArray = new Integer[intArray.length];
		
		for (int i = 0; i < intArray.length; i++) {
			integerArray[i] = intArray[i];
		}
		return integerArray;
	}

	public String[] randomStrings(int numStrings, int maxStringLength) {
		String[] strings = new String[numStrings];
		for (int i = 0; i < strings.length; i++) {
			int stringLength = this.randomGenerator.nextInt(maxStringLength + 1);
			strings[i] = this.randomString(stringLength);
		}
		return strings;
	}
	
	public String[] removeDuplicates(String[] strings) {
		int duplicates = 0;
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i] != null && strings[i].equals(strings[j])) {
					duplicates++;
					strings[i] = null;
				}
			}
		}
		
		String[] uniqueStrings = new String[strings.length - duplicates];
		int uniqueIndex = 0;
		for (String string : strings) {
			if (string != null) {
				uniqueStrings[uniqueIndex] = string;
				uniqueIndex++;
			}
		}
		
		return uniqueStrings;
	}
	
	public String randomStringContaining(int length, String chars) {
		char[] charsArray = chars.toCharArray();
		String returnString = "";
		for (int i = 0; i < length; i++) {
			int randomIndex = this.randomGenerator.nextInt(charsArray.length);
			char nextChar = charsArray[randomIndex];
			returnString += nextChar;
		}
		return returnString;
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

    public float[][] randomCartesianCoordinates(int numCoordinates, float min, float max) {
        return randomCartesianCoordinates(numCoordinates, min, min, max, max);
    }

    public float[][] randomCartesianCoordinates(int numCoordinates, float minX, float minY, float maxX, float maxY) {
        float[][] results = new float[numCoordinates][];
        Random r = new Random();
        for (int i = 0; i < numCoordinates; i++) {
            float x = r.nextFloat() * (maxX - minX) + minX;
            float y = r.nextFloat() * (maxY - minY) + minY;
            results[i] = new float[] {x, y};
        }

        return results;
    }
}
