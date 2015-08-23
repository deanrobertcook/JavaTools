package org.theronin.javatools.neuralnetworks;

import java.util.Random;

public class Perceptron {
    private float[] weights;

    public Perceptron(int numInputs) {
        weights = new float[numInputs];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = 2 * (new Random().nextFloat()) - 1; //(-1, 1)
        }
    }

    public int feedForward(float[] inputs) {
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("The number of inputs does not match the number this Perceptron" +
                    "was contstructed for");
        }

        float sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }

        return activate(sum);
    }

    private int activate(float sum) {
        return sum > 0 ? 1 : -1;
    }
}
