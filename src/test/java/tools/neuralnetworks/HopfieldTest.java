package tools.neuralnetworks;

import static org.junit.Assert.*;

import org.junit.Test;

public class HopfieldTest {

	@Test
	public void test() {
		float[] data [] = {
	        {1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
	        {-1, -1, -1, 1, -1, 1, -1, -1, -1, -1, -1, 1, -1},
	        {-1, -1, -1, -1, -1, -1, -1, -11, 1, 1, -1, 1, -1},
	        {1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1}
	    };

		Hopfield test = new Hopfield(13);
		test.addTrainingData(data[0]);
		test.addTrainingData(data[1]);
		test.addTrainingData(data[2]);
		test.train();
		
		helper(test, "pattern 0", data[0]);
        helper(test, "pattern 1", data[1]);
        helper(test, "pattern 2", data[2]);
	}

	private void helper(Hopfield test, String s, float[] test_data) {
		float[] dd = new float[13];
		for (int i = 0; i < 13; i++) {
			dd[i] = test_data[i];
		}
		// change this to flip 1 or 2 bits:
		int NUM_BITS_TO_FLIP = 1;
		for (int i_scramble = 0; i_scramble < NUM_BITS_TO_FLIP; i_scramble++) {
			int index = (int) (12.0f * (float) Math.random());
			dd[index] = -dd[index];
			// if (dd[index] < 0.0f)
			// dd[index] = 1.0f;
			// else
			// dd[index] = -1.0f;
		}
		float[] rr = test.recall(dd, 15);
		System.out.print(s + "\nOriginal data:      ");
		for (int i = 0; i < 13; i++)
			System.out.print(pp(test_data[i]) + " ");
		System.out.print("\nRandomized data:    ");
		for (int i = 0; i < 13; i++)
			System.out.print(pp(dd[i]) + " ");
		System.out.print("\nRecognized pattern: ");
		for (int i = 0; i < 13; i++)
			System.out.print(pp(rr[i]) + " ");
		System.out.println();
	}

	private int pp(float x) {
		if (x > 0.1f)
			return 1;
		return 0;
	}

}
