package robot;


/**
 * This is the controller in a MCV architecture. The controller accepts input and converts it to commands for the model or view.
 * @author Minttu and Saini
 *
 */
public class PCController implements PCController_IF {

	PCModel_IF model;
	PCView_IF view;

	/**
	 * A constructor for the controller object.
	 * @param view The constructor takes the view object's interface through the parameter.
	 */
	public PCController(PCView_IF view) {
		model = new PCModel();
		this.view = view;
	}
	/**
	 * This method calls the connect method in the model class.
	 */
	public void startConnection() {
		model.connect();
	}

	/**
	 * This method calls the closeConnections method in the model class.
	 */
	public void closeConnection() {
		model.closeConnections();
	}


	/**
	 * This method calls the sendSong method in the model class.
	 */
	public void playSong() {
		model.sendSong();
	}

	/**
	 * This method calls the sendStop method in the model class.
	 */
	public void stopSong() {
		model.sendStop();
	}

	/**
	 * This method calls the setSong method in the model class and gives the index of the song through the parameter.
	 * @param songIndex is the index number (int) of the song.
	 */
	public void setSong(int songIndex) {
		model.setSong(songIndex);
	}
	/**
	 * This method calls the addToOwnSong method in the model class. It passes the note index and its length through the parameter.
	 * @param noteIndex is the index number(int) of the note.
	 * @param lengthIndex is the length of the note(int).
	 */
	public void setNote(int noteIndex, int lengthIndex){
		model.addToOwnSong(noteIndex, lengthIndex);
	}

	/**
	 * This method calls the quit method in the model class.
	 */
	public void quit() {
		model.quit();
	}

}
