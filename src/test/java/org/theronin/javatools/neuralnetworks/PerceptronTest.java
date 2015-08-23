package org.theronin.javatools.neuralnetworks;

import org.junit.Test;
import org.theronin.javatools.testutility.TestMethods;
import org.theronin.javatools.utility.Util;

public class PerceptronTest extends TestMethods {

    @Test
    public void perceptronPlayground() {
        Perceptron perceptron = new Perceptron(2);

        float[][] points = randomCartesianCoordinates(10, -10, 10);

        for (int i = 0; i < points.length; i++) {
            Util.printArray(points[i]);
            int result = perceptron.feedForward(points[i]);
            System.out.println("result: " + result);
        }


    }
}