package robot;

import java.util.List;

public interface PCModel_IF {

	/**
	 * This method asks for the song notes.
	 * @param songIndex determines the song
	 * @return the notes of the song (songIndex)
	 */

	public abstract List<Note> getSongNotes(int songIndex);
	/**
	 * This method establishes an IO-connection to an EV3 computer.
	 */
	public abstract void connect();
	/**
	 * This method sets the song to be played.
	 * @param songIndex is the index number of the song.
	 */
	public abstract void setSong(int songIndex);
	/**
	 * This method sends the song to be played to the EV3 computer.
	 */
	public abstract void sendSong();
	/**
	 * This method sends the stop signal to the EV3 computer.
	 */
	public abstract void sendStop();
	/**
	 * This method closes the IO-connections.
	 */
	public abstract void closeConnections();
	/**
	 * This method sends the ending quit signal to the EV3 computer.
	 */
	public abstract void quit();
	/**
	 * This method adds a note to the list of own notes.
	 * @param noteIndex is the index number of a note.
	 * @param lengthIndex is the length of the note in milliseconds.
	 */
	public abstract void addToOwnSong(int noteIndex, int lengthIndex);


}
