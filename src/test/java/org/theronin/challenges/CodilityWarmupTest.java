package org.theronin.challenges;

import org.junit.Test;
import org.theronin.javatools.testutility.TestMethods;
import org.theronin.javatools.utility.Util;

public class CodilityWarmupTest extends TestMethods {

    @Test
    public void testImplementation() {

        CodilityWarmup cls = new CodilityWarmup();
        int[][] arrays = this.randomIntegerArrays(12, 0, 100000, -1000, 1000);
        for (int i = 0; i < arrays.length; i++) {
            this.startNewTimer(i);
            cls.attempt2(arrays[i]);
            this.stopTimer(i);
            this.printTime(i);
        }

        long[] times = this.getTimes(0, arrays.length - 1);
        Util.printArray(times);
    }

}