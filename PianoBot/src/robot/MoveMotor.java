package robot;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class MoveMotor {
	RegulatedMotor motorMove = new EV3LargeRegulatedMotor(MotorPort.D);
	private int moveValue = 52;

	public MoveMotor(){

	}

	/**
	 * Rotates motor that moves robot left and right
	 * @param vector gives the amount to rotate motor. A negative value moves to left and positive to right.
	 */

	//vector is between -2 and 2, negative to left, positive to right
	public void moveRobot(double vector) {
		motorMove.rotate((int)(vector * moveValue));
	}
	/**
	 * Sets the motor rotation speed
	 * @param speed the rotation speed
	 */

	public void setSpeed(int speed) {
		motorMove.setSpeed(speed);
	}

	/**
	 * Moves robot to starting point before closing the program
	 * @param position is the current position of the robot, either 1, 0 or -1.
	 */

	public void returnToStart(int position) {
		moveRobot(-1 * position);
	}

}
