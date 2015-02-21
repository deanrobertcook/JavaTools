package codility;

import java.util.Arrays;
import java.util.Random;

public class EquiLeader {
	private int leader;
	
	public int solution(int[] A) {
        int numEquiLeaders = 0;
		int splitPoint = A.length / 2;
		this.leader = this.findLeaderInRange(A, 0, A.length);
		while (splitPoint > 0 && splitPoint < A.length - 1) {			
			
		}
		return numEquiLeaders;
    }
	
	public int findLeaders(int[] A, int splitPoint, int leaders) {
		if (splitPoint <= 0 || splitPoint >= A.length - 1) {
			return leaders;
		}
		
		if (this.equiLeaderExistsAtSplit(A, splitPoint) && 
				this.leader == this.findLeaderInRange(A, 0, splitPoint)) {
			leaders++;
		}
		
		if (splitPoint == 1 || splitPoint == A.length - 1) {
			return leaders;
		} else {
			this.findLeaders(A, splitPoint / 2, leaders);
			this.findLeaders(A, splitPoint + splitPoint / 2, leaders);
		}
		return 0;
	}
	
	public boolean equiLeaderExistsAtSplit(int[] A, int splitPoint) {
		int leaderLeftHalf = this.findLeaderInRange(A, 0, splitPoint);
		int leaderRightHalf = this.findLeaderInRange(A, splitPoint, A.length - 1);
		if (leaderLeftHalf == leaderRightHalf) {
			return true;
		}
		return false;
	}
	
	public int bruteSolution(int[] A) {
		int numEquiLeaders = 0;
		for (int i = 0; i < A.length; i++) {
			if (i >= 1) {
				int leaderFirstHalf = this.findLeaderInRange(A, 0, i);
				int leaderSecondHalf = this.findLeaderInRange(A, i, A.length);
				if (leaderFirstHalf == leaderSecondHalf) {
					numEquiLeaders++;
				}
			}			
		}
		
		return numEquiLeaders;
	}
	
	//Finds leaders in part of an array from start (inclusive) to end (exclusive)
	//Note, slim chance the leader could be -1... how to solve?
	public int findLeaderInRange(int[] A, int start, int end) {
		int leader = -1;
		int sectionLength = end - start;
		int[] tempArray = new int[sectionLength];
		System.arraycopy(A, start, tempArray, 0, sectionLength);
		Arrays.sort(tempArray);
		
		int candidate = tempArray[tempArray.length / 2];
		int candidateAppearences = 0;
		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i] == candidate) {
				candidateAppearences++;
			}
		}
		
		if (candidateAppearences > tempArray.length / 2) {
			leader = candidate;
		} else {
			//return random number to reduce likelihood of false negative
			leader = new Random().nextInt();
		}
		
		return leader;
	}
}
