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
public class PermExists {
//	int[] A = {4, 1, 3, 2};
//	int[] B = {4, 1, 3};
	public int solution(int[] A) {
		int[] elementsSoFar = new int[A.length];
		for(int i = 0; i < A.length; i++) {
			if (A[i] <= 0) { //falls outside spec of permutation
			    return 0;
			}
			
			int k = (A[i] - 1);
			if(k < elementsSoFar.length) {
				if (elementsSoFar[k] == 0) {
					elementsSoFar[k] = A[i];
				} else { //already an element there (double element)
					return 0;
				}
			} else { //element greater than bounds of what it should be for perm size
				return 0;
			}
			
		}
		if (this.sum(A) == this.sum(elementsSoFar)) { //all elements filled
			return 1;
		}
		
		return 0;
	}
	
	private void printArray(int[] A) {
		for(int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	
	private int sum(int[] A) {
		int sum = 0;
		for(int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}
}
