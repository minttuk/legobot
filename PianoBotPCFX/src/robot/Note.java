package robot;

import java.io.Serializable;

/**
 *
 * @author minttu and saini
 *
 */
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	private int noteIndex;
	private int noteLength;

	/**
	 * The constructor of the object Note.
	 * @param noteIndex is the index number of a note. The number is in the range from 0 to 13.
	 * @param noteLength is the length of the note in milliseconds. The number is from 100 to 1400.
	 */
	public Note(int noteIndex, int noteLength){
		this.noteIndex = noteIndex;
		this.noteLength = noteLength;
	}
	/**
	 * This method is to get the index number of the note, which is returned.
	 * @return the index number of the note.
	 */
	public int getNoteIndex() {
		return noteIndex;
	}

	/**
	 * This method sets the index number of a note.
	 * @param noteIndex is the index number of a note.
	 */
	public void setNoteIndex(int noteIndex) {
		this.noteIndex = noteIndex;
	}
	/**
	 * This method is to get the length of a note, which is given in the return statement.
	 * @return the length of the note in milliseconds.
	 */
	public int getNoteLength() {
		return noteLength;
	}
	/**
	 * This method sets the length of a note.
	 * @param noteLength is the length of a note in milliseconds.
	 */
	public void setNoteLength(int noteLength) {
		this.noteLength = noteLength;
	}



}
