/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

/**
 *
 * @author dean
 */
public class PartsPerMillion {
	public int solution(int[] A, int[] B) {
        int countLessThan2 = 0;
		int i = 0;
		while (A[i] < 2) {			
			countLessThan2++;
			i++;
		}
		int countMoreThan2 = A.length - countLessThan2;
			
		//number of pairs from all A >= 2
		long multiplicativePairs = 0;
		for (int j = 1; j < countMoreThan2; j++) {
			multiplicativePairs += j;
			if (multiplicativePairs > 1000000000) {
				return 1000000000;
			}
		}
		
		//check where A <=2
		for (int j = 0; j < countLessThan2; j++) {
			double C1 = (double) A[j] + ((double) B[j] / 1000000);
			for (int k = j + 1; k < A.length; k++) {
				if (k + j < A.length) {
					double C2 = (double) A[k + j] + ((double) B[k + j] / 1000000);
					if (C1 * C2 >= C1 + C2) {
						multiplicativePairs++;
					}
					if (multiplicativePairs > 1000000000) {
						return 1000000000;
					}
				}
			}
		}
		return (int)multiplicativePairs;
    }
}
