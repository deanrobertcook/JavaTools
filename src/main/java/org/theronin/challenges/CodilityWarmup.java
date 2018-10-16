package org.theronin.challenges;

import static java.util.Arrays.sort;

/**
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class CodilityWarmup {

    /**
     * has O(n^2) performance worst case
     */
    public int naive(int[] A) {
        int smallest = 1;
        int i = 0;
        while (i < A.length) {
            if (A[i] == smallest) {
                smallest++;
                i = 0;
            } else {
                i++;
            }
        }
        return smallest;
    }

    public int attempt2(int[] A) {
        sort(A); //O(n log(n)) time sorting
        int smallest = 1;
        for (int a: A) {
            if (a == smallest) {
                smallest++;
            }
        }
        return smallest;
    }


}
