package org.theronin.javatools.neuralnetworks;

import java.util.Random;

public class Perceptron {

    private static final float LEARNING_CONSTANT = 0.01f;

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

    public float[] getWeights() {
        return weights;
    }

    private int activate(float sum) {
        return sum > 0 ? 1 : -1;
    }

    public void train(float[] inputs, int desired) {
        int guess = feedForward(inputs);
        float error = desired - guess;

        for (int i = 0; i < inputs.length; i++) {
            weights[i] += LEARNING_CONSTANT * error * inputs[i];
        }
    }

    public static class FunctionTrainer {

        private final float BIAS = 1f;
        public float[][] inputs;
        public int[] answers;

        public FunctionTrainer(int numTrainingPoints, float min, float max) {
            this(numTrainingPoints, min, min, max, max);
        }

        public FunctionTrainer(int numTrainingPoints, float minX, float minY, float maxX, float maxY) {
            inputs = new float[numTrainingPoints][];
            answers = new int[numTrainingPoints];

            Random r = new Random();
            for (int i = 0; i < numTrainingPoints; i++) {
                float x = (maxX - minX) * r.nextFloat() + minX;
                float y = (maxY - minY) * r.nextFloat() + minY;
                int answer = answer(x, y);
                inputs[i] = new float[] {x, y, BIAS};
                answers[i] = answer;
            }
        }

        private int answer(float x, float y) {
            float yline = f(x);
            if (y >= yline) {
                return 1;
            } else {
                return -1;
            }
        }

        private float f(float x) {
            return (0.5f * x) + 2;
        }

        public void trainPerceptron(Perceptron perceptron) {
            for (int i = 0; i < inputs.length; i++) {
                perceptron.train(inputs[i], answers[i]);
            }
        }
    }
}
