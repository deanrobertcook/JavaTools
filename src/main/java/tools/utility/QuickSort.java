package tools.utility;

import java.util.Random;

public class QuickSort {
	
	public static <T extends Comparable<T>> void sort(T[] A) {
		quicksort(A, 0, A.length - 1);
	}
	
	private static <T extends Comparable<T>> void quicksort(T[] A, int lo, int hi) {
		if (lo <= hi) {
			int p = partition(A, lo, hi);
			quicksort(A, lo, p-1);
			quicksort(A, p + 1, hi);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[]A, int lo, int hi) {
		int pivotIndex = choosePivot(lo, hi);
		T pivotValue = A[pivotIndex];
		
		swap(A, pivotIndex, hi);
		
		int storeIndex = lo;
		
		for (int i = lo; i < hi; i++) {
			if (A[i].compareTo(pivotValue) <= 0) {
				swap(A, storeIndex, i);
				storeIndex ++;
			}
		}
		
		swap(A, storeIndex, hi);
		return storeIndex;
	}

	private static int choosePivot(int lo, int hi) {
		Random rand = new Random();
		int index = rand.nextInt(hi - lo + 1);
		return (lo + index);
	}
	
	private static <T extends Comparable<T>> void swap(T[] A, int ind1, int ind2) {
		T val1 = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = val1;
	}
}
