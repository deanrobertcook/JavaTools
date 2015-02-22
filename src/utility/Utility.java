/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author dean
 */
public class Utility {
	public static void printArray(int[] A) {
		System.out.println("Array Size: " + A.length);
		System.out.printf("%-10s%s\n", "Index", "Value");
		for(int i = 0; i < A.length; i++) {
			System.out.printf("%-10s %d;\n", "A[" + i + "] = ", A[i]);
		}
		System.out.println("------------------------------------");
	}
	
	public static void printArray(String[] A) {
		System.out.println("Array Size: " + A.length);
		System.out.printf("%-10s%s\n", "Index", "Value");
		for(int i = 0; i < A.length; i++) {
			System.out.printf("%-10s %s;\n", "A[" + i + "] = ", A[i]);
		}
		System.out.println("------------------------------------");
	}
	
	public static int findMinimum(int[] A) {
		int minPos = 0;
		int lowestVal = A[0];
		for (int i = 1; i < A.length; i++) {
			int valAtCurrent = A[i];
			if (valAtCurrent < lowestVal) {
				minPos = i;
				lowestVal = A[i];
			}
		}
		return minPos;
	}
	
	public static int findMaximum(int[] A) {
		int maxPos = 0;
		int highestVal = A[0];
		for (int i = 1; i < A.length; i++) {
			int valAtCurrent = A[i];
			if (valAtCurrent > highestVal) {
				maxPos = i;
				highestVal = A[i];
			}
		}
		return maxPos;
	}
	
	public static int sumOfArray(int[] A) {
		int sum = 0;
		for(int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}
	
	public static int sumOfArraySlice(int[] A, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += A[i];
		}
		return sum;
	}
	
	public static int sumOfIntegers(int integer) {
		int sum = 0;
		for(int i = 1; i <= integer; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static double avgOfArray(int[] A ) {
		int sum = 0;
		for (int d : A ) sum += d;
		double avg = (1.0d * sum) / A.length;
		return avg;
	}
	
	public static int findSigFigs(int n) {
		int placeValue = 0;
		
		if (n == 0) {
			return 0;
		}
		
		while (n / 10 >= 1) {
			placeValue++;
			n = n / 10;
		}
		placeValue++;
		return placeValue;
	}
	
	public static int[] findIntValuesOfStringCharacters(String string) {
		char[] indexAsArray = string.toCharArray();
		int[] asciiArray = new int[indexAsArray.length];
		for (int i = 0; i < indexAsArray.length; i++) {
			int asciiVal = (int) indexAsArray[i];
			asciiArray[i] = asciiVal;
		}
		return asciiArray;
	}
	
	/**
	 * Wrapper function for Math.pow() for working only with integers. Saves
	 * tedious casting.
	 * @param base
	 * @param exponent
	 * @return 
	 */
	public static int pow(int base, int exponent) {
		return (int) Math.pow((double) base, (double) exponent);
	}
	
}
