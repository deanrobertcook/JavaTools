package tools.utility;

import java.util.Random;

public class QuickSort {
	
	public static void sort(int[] A) {
		quicksort(A, 0, A.length - 1);
	}
	
	private static void quicksort(int[] A, int lo, int hi) {
		if (lo <= hi) {
			int p = partition(A, lo, hi);
			quicksort(A, lo, p-1);
			quicksort(A, p + 1, hi);
		}
	}
	
	private static int partition(int[]A, int lo, int hi) {
		int pivotIndex = choosePivot(A, lo, hi);
		int pivotValue = A[pivotIndex];
		
		swap(A, pivotIndex, hi);
		
		int storeIndex = lo;
		
		for (int i = lo; i < hi; i++) {
			if (A[i] <= pivotValue) {
				swap(A, storeIndex, i);
				storeIndex ++;
			}
		}
		
		swap(A, storeIndex, hi);
		return storeIndex;
	}

	private static int choosePivot(int[] A, int lo, int hi) {
		Random rand = new Random();
		int index = rand.nextInt(hi - lo + 1);
		return (lo + index);
	}
	
	private static void swap(int[] A, int ind1, int ind2) {
		int val1 = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = val1;
	}
}
