package org.theronin.javatools.sort;

/**
 *
 * @author dean
 */
public class MergeSort {
	
	public static void sort(int[] A) {
		int splitSize = 2;
		while (splitSize < A.length) {
			for (int i = 0; i < A.length; i = i + splitSize) {
				mergeSplits(A, i, splitSize / 2);
			}
			splitSize = splitSize * 2;
		}
		mergeSplits(A, 0, splitSize/2);
	}
	
	private static void mergeSplits(int[] A, int pos1, int size1) {
		int pos2 = pos1 + size1;
		int size2 = pos2 + size1 < A.length ? size1 : A.length - pos2;
		
		while (size1 > 0 && size2 > 0) {			
			if (A[pos1] <= A[pos2]) {
				pos1++;
				size1--;
			} else {
				int temp = A[pos2];
				for (int empty = pos2; empty > pos1; empty--) {
					A[empty] = A[empty - 1];					
				}
				A[pos1] = temp;
				pos1++;
				pos2++;
				size2--;
			}
		}
	}
}
