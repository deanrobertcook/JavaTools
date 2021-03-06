package org.theronin.javatools.utility;

/**
 *
 * @author dean
 */
public class Util {

    public static void printArray(float[] A) {
        printArray(A, null);
    }

    public static void printArray(float[] A, String header) {
        Float[] B = toObject(A);
        printArray(B, header);
    }

    public static Float[] toObject(float[] A) {
        Float[] B = new Float[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        return B;
    }

	public static void printArray(int[] A) {
		printArray(A, null);
	}
	
	public static void printArray(int[] A, String header) {
		Integer[] B = toObject(A);
		printArray(B, header);
	}
	
	public static Integer[] toObject(int[] A) {
		Integer[] B = new Integer[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		return B;
	}
	
	public static void printArray(long[] A) {
		printArray(A, null);
	}
	
	public static void printArray(long[] A, String header) {
		Long[] B = toObject(A);
		printArray(B, header);
	}
	
	public static Long[] toObject(long[] A) {
		Long[] B = new Long[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		return B;
	}
	
	public static void printArray(boolean[] A) {
		printArray(A, null);
	}
	
	public static void printArray(boolean[] A, String header) {
		Boolean[] B = toObject(A);
		printArray(B, header);
	}
	
	public static Boolean[] toObject(boolean[] A) {
		Boolean[] B = new Boolean[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		return B;
	}
	
	public static <E> void printArray(E[] A) {
		printArray(A, null);
	}
	
	public static <E> void printArray(E[] A, String header) {
		int columnLength = 7;
		if (header != null) {
			System.out.println(header);
		}
		System.out.println("Array Size: " + A.length);
		System.out.printf("%-" + (columnLength + 2) + "s%s\n", "Index", "Value");
		for (int i = 0; i < A.length; i++) {
			if (A[i] instanceof String) {
				//include quotes for strings to make printed array copiable
				System.out.printf("%-" + columnLength + "s%s;\n", "A[" + i + "]", "= \"" + A[i] + "\"");
			} else {
				System.out.printf("%-" + columnLength + "s%s;\n", "A[" + i + "]", "= " + A[i]);
			}
		}
		System.out.println("------------------------------------");
	}
	
	public static void printMatrix(int[][] matrix) {
		int columnWidth = 8;
		int matrixWidth = matrix.length;
		int[] arrayLengths = new int[matrixWidth];
		for (int i = 0; i < arrayLengths.length; i++) {
			arrayLengths[i] = matrix[i].length;
		}
		int matrixHeight = arrayLengths[Util.findMaximumPos(arrayLengths)];
		
		System.out.println("Matrix size: " + matrixHeight + "x" + matrixWidth);
		System.out.printf("%-"+ columnWidth +"s", "");
		for (int x = 0; x < matrixWidth; x++) {
			System.out.printf("%-"+ columnWidth +"s", "[" + x + "][y]");
		}
		System.out.printf("\n");
		
		for (int y = 0; y < matrixHeight; y++) {
			System.out.printf("%-"+ columnWidth +"s", "[x][" + y + "]");
			for (int x = 0; x < matrixWidth; x++) {
				System.out.printf("%-"+ columnWidth +"d", matrix[x][y]);
			}
			System.out.printf("\n");
		}
		
	}

	public static int findMinimumPos(int[] A) {
		if (A.length > 0) {
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
		return -1;
	}

	public static int findMaximumPos(int[] A) {
		if (A.length > 0) {
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
		return -1;
	}

	public static int sumOfArray(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
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
		for (int i = 1; i <= integer; i++) {
			sum += i;
		}
		return sum;
	}

	public static double avgOfArray(int[] A) {
		int sum = 0;
		for (int d : A) {
			sum += d;
		}
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
	
	public static int sumOfAll(int n) {
		//what a nice function!
		return	n * (n + 1) / 2;
	}

}
