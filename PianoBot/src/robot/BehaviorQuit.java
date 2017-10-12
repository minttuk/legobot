package robot;
import lejos.robotics.subsumption.Behavior;

public class BehaviorQuit implements Behavior {

	public boolean suppressed = false;
	private Infrared infrared;
	private boolean programClosed = false;
	private BehaviorPlaySong playSong;

	/**
	 * Constructor
	 * @param infrared Infrared object
	 * @param playSong Behavior BehaviorPlaySong object
	 */

	public BehaviorQuit(Infrared infrared, Behavior playSong){
		this.infrared = infrared;
		this.playSong = (BehaviorPlaySong)(playSong);
	}

	/**
	 * Changes variable programClosed into true if PC GUI is closed
	 */

	public void programClosed() {
		programClosed = true;
	}

	/**
	 * This method returns true when quit is pressed on remote contoller or GUI is closed
	 * @return true if remote control quit button is pressed
	 */

	public boolean takeControl() {
		return infrared.remotePressed() || programClosed;
	}

	/**
	 * This method moves motor to default position and quits program
	 */

	public void action() {
		playSong.play.moveMotor.returnToStart(playSong.play.getPosition());
		System.exit(0);
	}

	/**
	 * This method is never called because the program quits when BehaviorQuit takes control
	 */

	public void suppress() {
		suppressed = true;
	}
}
