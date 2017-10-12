package robot;

import lejos.robotics.subsumption.Behavior;

public class BehaviorStopSong implements Behavior{
	private volatile boolean suppressed = false;
	private boolean stop = false;

	/**
	 * Sets variable stop into true or false
	 * @param n is either true or false
	 */

	public void setStop(boolean n) {
		stop = n;
	}

	/**
	 * This method returns true when stop is pressed on GUI
	 * @return returns the boolean value of stop
	 */

	public boolean takeControl() {
		return stop;
	}

	/**
	 * This method waits for another Bheavior to take control and stays activated until it's supressed
	 */

	public void action() {
		suppressed = false;
		while (!suppressed) {
		}
	}

	/**
	 * This method returns true when play is pressed on GUI or quit is activated on GUI or remote controller
	 */

	public void suppress() {
		suppressed = true;
	}
}
