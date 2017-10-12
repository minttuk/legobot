package robot;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lejos.robotics.subsumption.Behavior;

public class DataHandlerT extends Thread {

	//Instance variables
	Socket s;
	private List<Note> notes;
	private int dataRead = 0;
	private BehaviorPlaySong playSong;
	private BehaviorStopSong stopSong;
	private BehaviorQuit quit;
	//stopSong is 1 if song is stopped from the GUI. When 0 song can continue playing
	private int stopPlaying = -1;
	private boolean quitProgram = false;

	/**
	 * Constructor
	 * @param socket connection socket object
	 * @param playSong object that plays songs
	 * @param stopSong object that stops songs
	 * @param quit object that quits the whole program
	 */

	//Constructor with socket and behaviors as parameters.
	public DataHandlerT(Socket socket, Behavior playSong, Behavior stopSong, Behavior quit) {
		s = socket;
		this.playSong = (BehaviorPlaySong)playSong;
		this.stopSong = (BehaviorStopSong)stopSong;
		this.quit = (BehaviorQuit)quit;
	}

	/**
	 * This method runs untill the whole program is quit. It receives notes and play, stop and quit commands and then gives them to other classes
	 */

	public void run() {
		System.out.println("paasty handleriin");
		DataInputStream in = null;
		ObjectInputStream inObject = null;
		try {
			in = new DataInputStream(s.getInputStream());
			inObject = new ObjectInputStream(s.getInputStream());
			while(!quitProgram) {
				notes = new ArrayList<Note>();
				stopSong.setStop(false);
				dataRead = in.readInt();
				if (dataRead > 0) {
					System.out.println(dataRead);
					for (int i = 0; i < dataRead; i++) {
						notes.add((Note)inObject.readObject());
					}
					playSong.setNotes(notes);
				}
				if (dataRead == -1) {
					stopSong.setStop(true);
					playSong.clearSong();
				}
				if (dataRead == -2) {
					quit.programClosed();
				}
			}

			inObject.close();
			in.close();
			s.close();
		}
		catch (EOFException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
