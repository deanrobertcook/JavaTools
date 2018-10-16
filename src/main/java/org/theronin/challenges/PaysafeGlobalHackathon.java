package org.theronin.challenges;

import java.util.LinkedList;


public class PaysafeGlobalHackathon {

    public int[] solution(int[] A, int[] B, int N) {

        int M = A.length; //number of roads to be built

        //keeping track of stops allows us to decide if a new road will shorten our travel time or not.
        //A linked list lends itself nicely to the task, auto resizing will help us a lot!
        LinkedList<Integer> stops = new LinkedList<>();

        //before we've built any new roads, we need to go through every city, these are
        //our worst case stops
        for (int i = 1; i <= N; i ++) {
            stops.add(i);
        }

        int[] D = new int[M];

        for(int road = 0; road < M; road++) {
            //A new road is built! Does it shorten our travel distance?
            int startCity = A[road];
            int endCity   = B[road];

            //we can now avoid all roads between startCity and newCity (not inclusive), remove them from our stops
            stops.removeIf(stop -> stop > startCity && stop < endCity);
            //the best distance is now easy!
            int best = stops.size() - 1;
            D[road] = best;
        }

        return D;
    }
}
