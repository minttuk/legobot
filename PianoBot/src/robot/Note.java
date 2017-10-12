package robot;
import java.io.Serializable;

/**
 *
 * @author sainipatala
 *
 */

public class Note implements Serializable {

	//F0, G0, A0, H0, C1, D1, E1, F1, G1, A1, H1, C2, D2, E2
	//0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13

	private static final long serialVersionUID = 1L;
	private int noteIndex;
	private int noteLength;  //milliseconds

	/**
	 * This class has two instance variables, that are given as parameters.
	 * 	F0 = 0, G0 = 1, A0 = 2, H0 = 3, C1 = 4, D1 = 5, E1 = 6, F1 = 7, G1 = 8,
	 * A1 = 9, H1 = 10, C2 = 11, D2 = 12, E2 = 13
	 * @param noteIndex is an int between 0-13 and represents the key on a keyboard
	 * @param noteLength is an int that represents note lenght in milliseconds
	 */

	public Note(int noteIndex, int noteLength){
		this.noteIndex = noteIndex;
		this.noteLength = noteLength;
	}

	/**
	 * getNoteIndex() method is used to get the index of the note
	 * @return index of the note on keyboard (0-13)
	 */

	public int getNoteIndex() {
		return noteIndex;
	}

	/**
	 * Sets the index of a note
	 * @param noteIndex is an int between 0 and 13
	 */

	public void setNoteIndex(int noteIndex) {
		this.noteIndex = noteIndex;
	}

	/**
	 * Is used to get the lenght of the note in milliseconds
	 * @return int lenght
	 */

	public int getNoteLength() {
		return noteLength;
	}

	/**
	 * Is used to set the lenght of the note in milliseconds
	 * @param noteLength int lenght
	 */

	public void setNoteLength(int noteLength) {
		this.noteLength = noteLength;
	}
}
