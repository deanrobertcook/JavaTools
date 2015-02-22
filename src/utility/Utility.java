package utility;

/**
 *
 * @author dean
 */
public class Utility {

	public static void printArray(int[] A) {
		System.out.println("Array Size: " + A.length);
		System.out.printf("%-10s%s\n", "Index", "Value");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%-10s %d;\n", "A[" + i + "] = ", A[i]);
		}
		System.out.println("------------------------------------");
	}

	public static void printArray(long[] A) {
		System.out.println("Array Size: " + A.length);
		System.out.printf("%-10s%s\n", "Index", "Value");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%-10s %d;\n", "A[" + i + "] = ", A[i]);
		}
		System.out.println("------------------------------------");
	}

	public static void printArray(String[] A) {
		System.out.println("Array Size: " + A.length);
		System.out.printf("%-10s%s\n", "Index", "Value");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%-10s %s;\n", "A[" + i + "] = ", A[i]);
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
		int matrixHeight = arrayLengths[Utility.findMaximumPos(arrayLengths)];
		
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

}
