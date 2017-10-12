package robot;

import java.util.ArrayList;
import java.util.List;
import lejos.robotics.subsumption.Behavior;

public class BehaviorPlaySong implements Behavior {

	private volatile List<Note> notes = new ArrayList<Note>();
	private volatile boolean suppressed = false;
	private boolean start = false;
	Play play = new Play();


	 /**
	  * Makes a new list of Note objects clearing the old one
	  */

	public void clearSong() {
		notes = new ArrayList<Note>();
		start = false;
	}

	/**
	 * Sets new notes to a list of Note objects and changes the Behavior start variable into true.
	 * Behavior takeControl will return true
	 * @param notes that will be added to the list
	 */

	public void setNotes(List<Note> notes) {
		this.notes = notes;
		start = true;
	}

	/**
	 * This method returns true when new notes have been set to notes list
	 * @return returns true or false
	 */

	public boolean takeControl() {
		return start;
	}

	/**
	 * This method iterates through notes list and passes each note index and lenght to play class
	 */

	public void action() {
		suppressed = false;
		while (!suppressed){
			for (int i = 0; i < notes.size() && !suppressed; i++) {
				play.playNote(notes.get(i).getNoteIndex(), notes.get(i).getNoteLength());
				Thread.yield();
			}
		}
	}

	/**
	 * This method returns true when stop or quit is pressed on GUI or remote controller
	 */

	public void suppress() {
		suppressed = true;
	}

}
