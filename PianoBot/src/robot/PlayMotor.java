package robot;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class PlayMotor {

	static RegulatedMotor motor1 = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor motor2 = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor motor3 = new EV3LargeRegulatedMotor(MotorPort.C);
	private double delayMultiplier = 0.8;
	private int playValue = 30;

	/**
	 * Constructor without parameters
	 */

	public PlayMotor() {

	}

	/**
	 * Moves robots finger motors.
	 * @param index determines which finger motor is rotated and into which direction.
	 * There are two indexes for each motor, first rotates to left, second to right
	 * @param delay the delay which will take place between rotating finger to key and rotating
	 * it back to its default position
	 */

	public void move(int index, int delay) {
		if (index == 0) {
			motor1.rotate(-playValue, false);
			Delay.msDelay((int)(delay / delayMultiplier));
			motor1.rotate(playValue, false);
		}
		if (index == 1){
			motor1.rotate(playValue, false);
			Delay.msDelay((int)(delay / delayMultiplier));
			motor1.rotate(-playValue, false);
		}
		if (index == 2){
			motor2.rotate(-playValue, false);
			Delay.msDelay((int)(delay / delayMultiplier));
			motor2.rotate(playValue, false);
		}
		if (index == 3){
			motor2.rotate(playValue, false);
			Delay.msDelay((int)(delay / delayMultiplier));
			motor2.rotate(-playValue, false);
		}
		if (index == 4) {
			motor3.rotate(-playValue, false);
			Delay.msDelay((int)(delay / delayMultiplier));
			motor3.rotate(playValue, false);
		}
		if (index == 5) {
			motor3.rotate(playValue, false);
			Delay.msDelay((int)(delay / delayMultiplier));
			motor3.rotate(-playValue, false);
		}
	}

	/**
	 * Sets a value that multiplies the delay time to fit the tempo
	 * @param delay delay value in milliseconds
	 */

	public void setDelay(int delay) {
		delayMultiplier = delay;
	}

}
