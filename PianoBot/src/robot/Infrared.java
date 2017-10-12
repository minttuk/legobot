package robot;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;

public class Infrared extends Thread {

	Port portIP = LocalEV3.get().getPort("S2");
	EV3IRSensor infrap = new EV3IRSensor(portIP);
	private boolean remotePressed = false;

	/**
	 * runs while quit is pressed on remote controller
	 */

	public void run(){
		while(!remotePressed){
			//System.out.println("Infrapuna runnin sis�ll�");
			if(infrap.getRemoteCommand(0) == 1){
				remotePressed = true;
			}
		}
	}

	/**
	 * Checks if quit button is pressed on remote controller
	 * @return variable remotePressed, true or false
	 */

	public boolean remotePressed(){
		return remotePressed;
	}

}
