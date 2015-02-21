package codility;
import java.lang.Math;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dean
 */
public class LeapFrog {
	public int solution(int X, int Y, int D) {
        double distanceToGo = (double)Y - (double)X;
		
        double hops = Math.ceil(distanceToGo / (double)D);
		return (int)hops;
    }
}
