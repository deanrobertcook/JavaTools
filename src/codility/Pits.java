/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import utility.Utility;

/**
 *
 * @author dean
 */
public class Pits {
	public int solution(int[] A) {
        int[] gradArray = this.findGradientArray(A);
		
		long deepestDepth = Long.MIN_VALUE;
		
		int firstHill = this.findNextHill(gradArray, 0);
		int currentPos = firstHill;
		
		while (currentPos < A.length - 1) {			
//			System.out.println("firstHill: " + firstHill);
			
			int nextPit = this.findNextPit(gradArray, currentPos);
//			System.out.println("nextPit: " + nextPit);
			currentPos = nextPit;
			
			int secondHill = this.findNextHill(gradArray, currentPos);
//			System.out.println("secondHill: " + secondHill);
			currentPos = secondHill;
			
			int depthFirstHalf = A[firstHill] - A[nextPit];
			int depthSecondHalf = A[secondHill] - A[nextPit];
			
			int depth = (int) Math.min((double) depthFirstHalf, (double) depthSecondHalf);
			if (depth > deepestDepth) {
				deepestDepth = (long)depth;
			}
			
			firstHill = secondHill;
		}
		return (int) deepestDepth;
    }
	
	private int findNextHill(int[] gradArray, int currentPos) {
		for (int i = currentPos; i < gradArray.length - 1; i++) {
			if (gradArray[i] < 0) {
				return i;
			}
		}
		return gradArray.length - 1;
	}
	
	private int findNextPit(int[] gradArray, int currentPos) {
		for (int i = currentPos; i < gradArray.length - 1; i++) {
			if (gradArray[i] > 0) {
				return i;
			}
		}
		return gradArray.length - 1;
	}
	
	private int[] findGradientArray(int[] A) {
		int[] gradientArray = new int[A.length];
		for (int i = 0; i < A.length - 1; i++) {
			int currentHeight = A[i];
			int nextHeight = A[i + 1];
			gradientArray[i] = nextHeight - currentHeight;
		}
		return gradientArray;
	}
}
