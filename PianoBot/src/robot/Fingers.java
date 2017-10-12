package robot;

import java.util.Arrays;

public class Fingers {

	//F0, G0, A0, H0, C1, D1, E1, F1, G1, A1, H1, C2, D2, E2
	//0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13

	private int[] fingers;

	public Fingers() {
		fingers = new int[6];
		fingers[0] = 1;
		fingers[1] = 4;
		fingers[2] = 5;
		fingers[3] = 8;
		fingers[4] = 9;
		fingers[5] = 12;
	}

	/**
	 * Is used to check the position of robots fingers.
	 * Zero index key represents first finger and its value represents the keyboard key index it is above.
	 * @return An int table.
	 */

	public int[] getFingers() {
		return fingers;
	}

	/**
	 * Moves robots fingers, sums the present key index the finger is on and the parameter.
	 * Each finger position is moved by the same value.
	 * @param n the amounth to move finger position, is either 2, 1, -1 or -2
	 */

	public void moveFingers(int n) {
		for (int i = 0; i < 6; i++) {
			fingers[i] = fingers[i] + n;
		}
	}

}
