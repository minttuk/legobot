package robot;

public interface PCController_IF {

	/**
	 * This method calls the sendSong method in the model class.
	 */
	public abstract void playSong();
	/**
	 * This method calls the sendStop method in the model class.
	 */
	public abstract void stopSong();
	/**
	 * This method calls the connect method in the model class.
	 */
	public abstract void startConnection();
	/**
	 * This method calls the closeConnections method in the model class.
	 */
	public abstract void closeConnection();
	/**
	 * This method calls the setSong method in the model class and gives the index of the song through the parameter.
	 * @param n is the index number (int) of the song.
	 */
	public abstract void setSong(int n);
	/**
	 * This method calls the quit method in the model class.
	 */
	public abstract void quit();
	/**
	 * This method calls the addToOwnSong method in the model class. It passes the note index and its length through the parameter.
	 * @param noteIndex is the index number(int) of the note.
	 * @param lengthIndex is the length of the note(int).
	 */
	public abstract void setNote(int noteIndex, int lengthIndex);

}
