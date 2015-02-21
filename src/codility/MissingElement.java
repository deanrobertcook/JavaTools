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
public class MissingElement {
	//int[] A = {2, 3, 1, 5}; 
	public int solution(int[] A) {
        int actualSum = this.sum(A);
		
		int completeSum = 0;
		for(int i = 1; i < A.length + 2; i++) {
			completeSum += i;
		}
		
		int missingValue = completeSum - actualSum;
		return missingValue;
	}
	
	private int sum(int[] A) {
		int sum = 0;
		for(int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;
	}
}
