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
public class MinAbsSlice {
	public int solution(int[] A) {
        long lowestSum = Long.MAX_VALUE;
		
		for (int i = 0; i < A.length; i++) {
			int currentSum = 0;
			for (int j = i; j < A.length; j++) {
				currentSum += A[j];
				int currentAbs = (int) Math.abs((double) currentSum);
				if (currentAbs < lowestSum) {
					lowestSum = currentAbs;
				}
			}
		}
		
		
		return (int) lowestSum;
    }
}
