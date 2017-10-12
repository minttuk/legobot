package robot;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lejos.robotics.subsumption.Behavior;

public class ConnectionT extends Thread {
	private Behavior playSong;
	private Behavior stopSong;
	private Behavior quit;

	/**
	 * Constructor
	 * @param playSong object that plays songs
	 * @param stopSong object that stops songs
	 * @param quit object that quits the whole program
	 */

	public ConnectionT(Behavior playSong, Behavior stopSong, Behavior quit) {
		this.playSong = playSong;
		this.stopSong = stopSong;
		this.quit = quit;
	}

	/**
	 * This method runs until connection is created with computer and dataHandler is created
	 */

	public void run() {
		System.out.println("päästy connectioniin");
		ServerSocket server = null;
		try {
			server = new ServerSocket(1111);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Socket s = null;
		DataHandlerT dataHandler;

		while (true) {
			try {
				System.out.println("odottaa konetta");
				s = server.accept();
				dataHandler = new DataHandlerT(s, playSong, stopSong, quit);
				dataHandler.start();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
