/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingpractice.codility;

/**
 *
 * @author dean
 */
public class MinAvgTwoSlice {
	//int[] A = {4, 2, 2, 5, 1, 5, 8};
	public int solution(int[] A) {
		int lowestAvgIdx = -1;
		double lowestAvg = 10001.00;
		for (int i = 0; i < A.length; i++) {
			if (i < A.length - 1) {
				double avg = (double) (A[i] + A[i + 1]) / 2;
				if (avg < lowestAvg) {
					lowestAvgIdx = i;
					lowestAvg = avg;
					int j = 2;
					while (i + j < A.length && A[i + j] < avg){
						System.out.println("Slice length: " + j);
						double avgWithNext = (avg + A[i + j]) / 2;
						lowestAvg = avgWithNext;
						j++;	
					}
				}
			}
		}
		return lowestAvgIdx;
    }
}
