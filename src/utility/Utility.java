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
		for(int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
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
	
}
