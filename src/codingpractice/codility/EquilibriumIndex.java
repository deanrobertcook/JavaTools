/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingpractice.codility;

import utility.Utility;

/**
 *
 * @author dean
 */
public class EquilibriumIndex {
	public int solution(int[] A) {
       int[] nextToCheck = new int[A.length];
		nextToCheck[0] = A.length/2;
		
		for (int i = 0; i < nextToCheck.length; i++) {
			int split = nextToCheck[i];
			if (split > 0 && split < A.length - 1) {
				System.out.println("Split: " + split);
				int sumLeft = Utility.sumOfArraySlice(A, 0, split);
				int sumRight = Utility.sumOfArraySlice(A, split + 1, A.length);
				System.out.println(sumLeft);
				System.out.println(sumRight);
				if (sumLeft == sumRight) {
					return split;
				}
				if (i < nextToCheck.length - 1) {
					nextToCheck[i + 1] = split / 2;
				}
				if (i < nextToCheck.length - 2) {
					nextToCheck[i + 2] = split + split / 2;
				}
			}
			
		}
		
		return -1;
    }
}
