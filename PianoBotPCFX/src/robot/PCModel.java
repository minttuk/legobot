package robot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**This class is the Model part of the MVC architecture. It directly manages the data of the played songs and the data send by an IO -connectio to an EV3 computer.
 *
 * @author Minttu and Saini
 *
 */
public class PCModel implements PCModel_IF{

	//F0, G0, A0, H0, C1, D1, E1, F1, G1, A1, H1, C2, D2, E2
	//0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13

	private Note note;
	private List<Note> ukkonooa = new ArrayList<Note>();
	private List<Note> jinglebells = new ArrayList<Note>();
	private List<Note> demo3 = new ArrayList<Note>();
	private List<Note> ownSong = new ArrayList<Note>();
	private List<Note> hamahakki = new ArrayList<Note>();
    private List<List<Note>> songs = new ArrayList<List<Note>>();
	Socket s;
	DataOutputStream out;
	ObjectOutputStream obOut;
	private int songToPlay;

	/**
	 * In the constructor, the precomposed songs and an empty list for own songs are called to be created.
	 */
	public PCModel() {
		createUkkonooa();
		createJingleBells();
		createHamahakki();
		songs.add(ownSong);
	}

	/**
	 * getSongNotes returns list of Note objects of the song wanted. @param songIndex determines which song's notes are returned
	 */

	public List<Note> getSongNotes(int songIndex) {
		return songs.get(songIndex);
	}

	/**
	 * This method sets the song to be played with the songIndex given in the parameter.
	 * @param songIndex is the index number of a song.
	 *
	 */
	public void setSong(int songIndex){
		songToPlay = songIndex;
	}

	/**
	 * Method connect() establishes a connection to an EV3 computer.
	 */
	public void connect() {

		try {
			s = new Socket("10.0.1.1", 1111);
			out = new DataOutputStream(s.getOutputStream());
			obOut = new ObjectOutputStream(out);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method sends the number of notes (int) and the notes (Note) through the IO-connection.
	 */
	public void sendSong(){
		try {
			out.writeInt(songs.get(songToPlay).size());
			out.flush();
			for(int i = 0; i < songs.get(songToPlay).size(); i++){
				obOut.writeObject(songs.get(songToPlay).get(i));
				obOut.flush();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method sends the stop signal through the IO-connection.
	 */
	public void sendStop(){
		try{
			out.writeInt(-1);
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method send the end signal through the IO-connection.
	 */
	public void quit() {
		try {
			out.writeInt(-2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Method closes the DataOutputStream, ObjecOutputStream and Socket connections.
	 */
	public void closeConnections(){
		try {
			out.close();
			obOut.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method creates the list of notes for the song Ukko Nooa, and adds the song to the list of songs.
	 */
	public void createUkkonooa() {
		note = new Note(4, 200);
		ukkonooa.add(note);
		note = new Note(4, 200);
		ukkonooa.add(note);
		note = new Note(4, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(7, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(4, 400);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(8, 600);
		ukkonooa.add(note);
		note = new Note(7, 600);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(7, 600);
		ukkonooa.add(note);
		note = new Note(6, 600);
		ukkonooa.add(note);
		note = new Note(4, 200);
		ukkonooa.add(note);
		note = new Note(4, 200);
		ukkonooa.add(note);
		note = new Note(4, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(7, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(6, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(5, 200);
		ukkonooa.add(note);
		note = new Note(4, 400);
		ukkonooa.add(note);

		songs.add(ukkonooa);

	}

	/**
	 * Method creates the list of notes for the song Jingle Bells, and adds the song to the list of songs.
	 */
	public void createJingleBells() {

		for (int i = 0; i < 2; i++) {
			//1. & 9.
			note = new Note(6, 100);
			jinglebells.add(note);
			note = new Note(6, 100);
			jinglebells.add(note);
			note = new Note(6, 600);
			jinglebells.add(note);
			//2. & 10.
			note = new Note(6, 100);
			jinglebells.add(note);
			note = new Note(6, 100);
			jinglebells.add(note);
			note = new Note(6, 600);
			jinglebells.add(note);
			//3. & 11.
			note = new Note(6, 100);
			jinglebells.add(note);
			note = new Note(8, 100);
			jinglebells.add(note);
			note = new Note(4, 550);
			jinglebells.add(note);
			note = new Note(5, 50);
			jinglebells.add(note);
			//4. & 12.
			note = new Note(6, 800);
			jinglebells.add(note);
			//5. & 13.
			note = new Note(7, 100);
			jinglebells.add(note);
			note = new Note(7, 100);
			jinglebells.add(note);
			note = new Note(7, 550);
			jinglebells.add(note);
			note = new Note(7, 50);
			jinglebells.add(note);
			//6. & 14.
			note = new Note(7, 100);
			jinglebells.add(note);
			note = new Note(6, 100);
			jinglebells.add(note);
			note = new Note(6, 500);
			jinglebells.add(note);
			note = new Note(6, 50);
			jinglebells.add(note);
			note = new Note(6, 50);
			jinglebells.add(note);
			if (i == 0) {
				//7.
				note = new Note(6, 100);
				jinglebells.add(note);
				note = new Note(5, 100);
				jinglebells.add(note);
				note = new Note(5, 100);
				jinglebells.add(note);
				note = new Note(6, 100);
				jinglebells.add(note);
				//8.
				note = new Note(5, 400);
				jinglebells.add(note);
				note = new Note(8, 400);
				jinglebells.add(note);
			}
			else {
				//15.
				note = new Note(8, 100);
				jinglebells.add(note);
				note = new Note(8, 100);
				jinglebells.add(note);
				note = new Note(7, 100);
				jinglebells.add(note);
				note = new Note(5, 100);
				jinglebells.add(note);
				//16.
				note = new Note(4, 800);
				jinglebells.add(note);
			}
		}

		songs.add(jinglebells);

	}

	/**
	 * Method creates the list of notes for the song Demo3, and adds the song to the list of songs.
	 */
	public void createDemo3() {
		note = new Note(0, 200);
		demo3.add(note);
		note = new Note(2, 200);
		demo3.add(note);
		note = new Note(11, 200);
		demo3.add(note);
		note = new Note(13, 200);
		demo3.add(note);
		songs.add(demo3);
	}

	/**
	 * Method creates the list of notes for the song Hamahakki, and adds the song to the list of songs.
	 */
	public void createHamahakki(){
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(5, 50);
		hamahakki.add(note);
		note = new Note(6, 200);
		hamahakki.add(note);
		note = new Note(6, 200);
		hamahakki.add(note);
		note = new Note(5, 50);
		hamahakki.add(note);
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(5, 50);
		hamahakki.add(note);
		note = new Note(6, 50);
		hamahakki.add(note);
		note = new Note(4, 400);
		hamahakki.add(note);

		note = new Note(6, 50);
		hamahakki.add(note);
		note = new Note(6, 50);
		hamahakki.add(note);
		note = new Note(6, 50);
		hamahakki.add(note);
		note = new Note(7, 50);
		hamahakki.add(note);
		note = new Note(8, 200);
		hamahakki.add(note);
		note = new Note(8, 200);
		hamahakki.add(note);
		note = new Note(7, 50);
		hamahakki.add(note);
		note = new Note(6, 50);
		hamahakki.add(note);
		note = new Note(7, 50);
		hamahakki.add(note);
		note = new Note(8, 50);
		hamahakki.add(note);
		note = new Note(6, 400);
		hamahakki.add(note);

		note = new Note(11, 200);
		hamahakki.add(note);
		note = new Note(11, 50);
		hamahakki.add(note);
		note = new Note(11, 50);
		hamahakki.add(note);
		note = new Note(10, 200);
		hamahakki.add(note);
		note = new Note(10, 200);
		hamahakki.add(note);
		note = new Note(9, 50);
		hamahakki.add(note);
		note = new Note(9, 50);
		hamahakki.add(note);
		note = new Note(9, 50);
		hamahakki.add(note);
		note = new Note(9, 50);
		hamahakki.add(note);
		note = new Note(8, 400);
		hamahakki.add(note);

		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(5, 50);
		hamahakki.add(note);
		note = new Note(6, 200);
		hamahakki.add(note);
		note = new Note(6, 200);
		hamahakki.add(note);
		note = new Note(5, 50);
		hamahakki.add(note);
		note = new Note(4, 50);
		hamahakki.add(note);
		note = new Note(5, 50);
		hamahakki.add(note);
		note = new Note(6, 50);
		hamahakki.add(note);
		note = new Note(4, 400);
		hamahakki.add(note);

		songs.add(hamahakki);

	}
	/**
	 * Method adds a note and its length to a list of own song notes.
	 * @param noteIndex is the index number of the note, where 0 is the note F0 and 13 is the note E2.
	 * @param lengthIndex is the length of the note in milliseconds.
	 */
	public void addToOwnSong(int noteIndex, int lengthIndex){
		note = new Note(noteIndex, lengthIndex);
		ownSong.add(note);

	}

}
