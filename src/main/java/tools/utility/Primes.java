package tools.utility;


public class Primes {
	public static int[] findPrimes(int upToInteger) {
		upToInteger++;
		//the smalles primes that divide the number i,
		int[] smallestPrimes = new int[upToInteger];
		
		for (int i = 0; i < smallestPrimes.length; i++) {
			smallestPrimes[i] = 0; //we want to add all primes, so set to not prime
		}
		
		int i = 2;
		while (i * i < upToInteger) {			
			int j = i * i;
			while (j < upToInteger) {				
				if (smallestPrimes[j] == 0) {
					smallestPrimes[j] = i; //composite,
					//i is smallest divisor
				}
				j = j + i;
			}
			i++;
		}
		
		return smallestPrimes;
	}
	
	public static int[] findPrimeFactors(int number) {
		if (number == 1) {
			int[] factors = {1};
			return factors;
		} else {
			int[] smallestPrimes = findPrimes(number);
			int[] primeFactors = new int[number];
			int primeCount = 0;
			int current = number;
			while (smallestPrimes[current] > 0) {			
				primeFactors[primeCount] = current;
				primeCount++;
				primeFactors[primeCount] = number / current;
				primeCount++;
				current = current / smallestPrimes[current];
			}
			primeFactors[primeCount] = current;
			primeCount++;
			primeFactors[primeCount] = number / current;

			int[] returnFactors = new int[primeCount + 1];
			System.arraycopy(primeFactors, 0, returnFactors, 0, primeCount + 1);

			return returnFactors;
		}
	}
}
