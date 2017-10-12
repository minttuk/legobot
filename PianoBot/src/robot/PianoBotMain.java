package robot;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class PianoBotMain {

	/**
	 * In this meethod all Behaviors are created. Arbitrator is created and behaviors are given to it. Connection thread is also created and started.
	 * Arbitrator is started.
	 * @param args args
	 */

	public static void main (String[] args) {

		Infrared infrared = new Infrared();
		Behavior playSong = new BehaviorPlaySong();
		Behavior stopSong = new BehaviorStopSong();
		Behavior quit = new BehaviorQuit(infrared, playSong);
		Behavior[] behaviors = {playSong, stopSong, quit};
		Arbitrator arby = new Arbitrator(behaviors);
		ConnectionT connection = new ConnectionT(playSong, stopSong, quit);
		connection.start();
		infrared.start();
		arby.go();

		//F0, G0, A0, H0, C1, D1, E1, F1, G1, A1, H1, C2, D2, E2
		//0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13

	}
}
