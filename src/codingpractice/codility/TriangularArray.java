package codingpractice.codility;

import utility.MergeSort;
import java.util.Arrays;

/**
 *
 * @author dean
 */
public class TriangularArray {
	public int solution(int[] A) {
		Arrays.sort(A);
//		MergeSort.sort(A);
		
		for (int i = A.length - 1; i >= 0; i--) {
			if (i - 2 >= 0) {
				int point1 = A[i];
				int point2 = A[i-1];
				int point3 = A[i-2];
				
				if (
					point1 < point2 + point3 &&
					point2 < point3 + point1 &&
					point3 < point1 + point2
				) {
					return 1;
				}
			}
		}
		
		return 0;
    }
}
