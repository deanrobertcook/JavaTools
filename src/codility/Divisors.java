package codility;

import utility.Primes;
import utility.Util;

public class Divisors {
	public int[] solution(int[] A) {
		int[] nonDivisors = new int[A.length];
		int maxVal = A[Util.findMaximumPos(A)]; //runs in N time
		int[] occurences = new int[maxVal + 1];
		for (int i = 0; i < A.length; i++) {
			occurences[A[i]] ++;
		}
		
		for (int i = 0; i < A.length; i++) {
			int number = A[i];
			int divisors = 0;
			int[] factors = Primes.findPrimeFactors(number);
			for (int factor : factors) {
				int numOccurences = occurences[factor];
				divisors+= numOccurences;
			}
			nonDivisors[i] = A.length - divisors;
		}
		
		return nonDivisors;
	}
}
