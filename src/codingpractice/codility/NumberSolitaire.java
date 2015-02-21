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
public class NumberSolitaire {
	public int solution(int[] A) {
		return this.solution(A, 6);
	}
			
	public int solution(int[] A, int K) {
		int[] bestScores = new int[A.length];
		for (int i = 0; i < bestScores.length; i++) {
			if (i == 0) {
				bestScores[i] = A[i];
			} else {
				bestScores[i] = -100001;
			}
		}
		for (int i = 0; i < A.length; i++) {
			int searchAhead = A.length - i - 1 < K ? A.length - i - 1 : K;
			for (int k = 1; k <= searchAhead; k++) {
				int currentSquare = i;
				int targetSquare = i + k;
				int candidateBest = bestScores[currentSquare] + A[targetSquare];
				if (candidateBest > bestScores[targetSquare]) {
					bestScores[targetSquare] = candidateBest;
				}
			}
		}
		return bestScores[A.length - 1];
	}
}
