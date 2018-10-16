package org.theronin.challenges;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaysafeGlobalHackathonTest {

    PaysafeGlobalHackathon inst = new PaysafeGlobalHackathon();

    @Test
    public void test1() {
        int[] A = {2, 5, 1};
        int[] B = {4, 7, 4};

        int[] expected = {5, 4, 3};

        int N = 7;
        int[] D = inst.solution(A, B, N);

        assertArrayEquals(expected, D);
    }

    @Test
    public void test2() {
        int[] A = {1, 1, 1};
        int[] B = {7, 4, 6};

        int[] expected = {1, 1, 1};

        int N = 7;
        int[] D = inst.solution(A, B, N);

        assertArrayEquals(expected, D);
    }

    @Test
    public void test3() {
        int[] A = {30, 50, 40};
        int[] B = {40, 60, 50};

        int[] expected = {90, 81, 72};

        int N = 100;
        int[] D = inst.solution(A, B, N);

        assertArrayEquals(expected, D);
    }

    @Test
    public void test4() {
        int[] A = {2, 4, 2, 2};
        int[] B = {4, 6, 8, 6};

        int[] expected = {6, 5, 2, 2};

        int N = 8;
        int[] D = inst.solution(A, B, N);

        assertArrayEquals(expected, D);
    }

}