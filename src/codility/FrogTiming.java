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
public class FrogTiming {
	//int X = 5;
	//int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
	public int solution(int X, int[] A) {
        int[] leavesFallen = new int[X + 1];
		int sumOfCrossableRiver = Utility.sumOfIntegers(X);
		int sumLeavesFallen = 0;
		
		for (int i = 0; i < A.length; i++) {
			int leafPos = A[i];
			if (leavesFallen[leafPos] == 0) { //no leaf fallen at leafPos yet
				leavesFallen[leafPos] = leafPos;
				sumLeavesFallen+= leafPos;
				if(sumLeavesFallen == sumOfCrossableRiver) {
					return i;
				}
			}
		}

		//the frog doesn't make it
		return -1;
    }
}