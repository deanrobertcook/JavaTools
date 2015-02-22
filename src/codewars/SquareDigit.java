package codewars;

import utility.Util;

public class SquareDigit {

	public int squareDigits(int n) {
		int valueToReturn = 0;
		
		int sigFigs = Util.findSigFigs(n);
		int lastDigit = -1;
		int previousZeros = 0;
		for (int i = 0; i < sigFigs; i++) {
			int digit = n % 10;
			int digitSquared = (int) (Math.pow((double) digit, 2));
			
			int currentSigFigs = Util.findSigFigs(valueToReturn);
			if (lastDigit == 0) {
				previousZeros++;
				currentSigFigs = currentSigFigs + previousZeros;
			} else {
				previousZeros = 0;
			}
			int placeHolder = (int) Math.pow(10, (double) (currentSigFigs));
			valueToReturn = valueToReturn + (digitSquared * placeHolder);
			
			lastDigit = digit;
			n = n / 10;
		}
		return valueToReturn;
	}
}
