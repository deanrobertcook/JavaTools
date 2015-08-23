package org.theronin.javatools.neuralnetworks;

import org.junit.Test;
import org.theronin.javatools.testutility.TestMethods;

/**
 * Created by deancook on 23/08/15.
 */
class PerceptronTest extends TestMethods {

    @Test
    public void perceptronPlayground() {
        Perceptron perceptron = new Perceptron(2);

        float[][] points = randomCartesianCoordinates(10, -10, 10);

        perceptron.feedForward(new float[]);
    }
}
