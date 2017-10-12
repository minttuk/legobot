package robot;

/**
 *
 * @author sainipatala
 *
 */


public class Play {
	private Fingers fingers = new Fingers();
	private int[] fingerTable = new int[6];
	PlayMotor playMotor = new PlayMotor();
	MoveMotor moveMotor = new MoveMotor();
	//motorindex -1 niin kauan kuin oikeaa moottoria ei ole löydetty sormen painamiseen
	private int motorIndex = -1;
	//position is 0 when robot is in the middle, -1 when robot is one step to the left and 1 when one step to the right
	// mix -1 max 1, default 0
	private int position = 0;

	/**
	 * This method is used to get the current position of the robot.
	 * @return returns 1, 0 or -1 depending on robots position
	 */

	public int getPosition() {
		return position;
	}

	/**
	 * Constructor withouth parameters
	 */

	public Play() {
	}

	/*public void setFingers(Fingers fingers) {
		this.fingers = fingers;
	}*/

	/**
	 * Checks the position of the robot and calculates how the robot has to move to play
	 * the next note. Gives MoveMotor, PlayMotor and Fingers information accordingly.
	 * @param noteIndex the next note to play
	 * @param noteLenght the leght of the next note to play in milliseconds
	 */

	public void playNote(int noteIndex, int noteLenght) {
		motorIndex = -1;
		int fingerMoveIndex = 0;
		double moveMotorIndex = 0;
		//Multiplieres for each move because the motor acts a bit different depending on direction and lenght
		//backwards (negative) seems to move the motor more than the forward rotation and therefore
		//negative values are set smaller
		//and taking two one position steps does not equal to moving two steps at once
		double posMove1 = 1.1;  //1.4;
		double negMove1 = -1;  //-0.75;
		double posMove2 = 2.2;  //2.22;
		double negMove2 = -2; //-1.5;
		//System.out.println("Tultiin playnoteen");
		fingerTable = fingers.getFingers();
		//System.out.println("looppia ennen");
		//Check if some finger is above the note that will be played. Returns the motor index that is above
		for (int i = 0; i < 6; i++) {
			//System.out.println("Fingerin indexi on: " + fingerTable[i]);
			if (fingerTable[i] == noteIndex) {
				motorIndex = i;
				//System.out.println(motorIndex);
			}
		}
		if (motorIndex == -1) {
			if (position == 0) {
				for (int j = 0; j < 6; j++) {
					//Check if finger is on note when robot moves one step to right
					if ((fingerTable[j] + 1) == noteIndex) {
						moveMotorIndex = posMove1;
						fingerMoveIndex = 1;
						motorIndex = j;
						position = 1;
					}
				}
			}
			if (motorIndex == -1) {
				if (position == 0) {
					for (int k = 0; k < 6; k++) {
						//Check if finger is on note when robot moves one step to left
						if ((fingerTable[k] - 1) == noteIndex) {
							moveMotorIndex = negMove1;
							fingerMoveIndex = -1;
							motorIndex = k;
							position = -1;
						}
					}
				}
			}
			if (motorIndex == -1) {
				if (position == 1) {
					for (int f = 0; f < 6; f++) {
						//System.out.println("p��sty pos1 move-1 for loopin l�pi");
						//Check if finger is on note when robot moves one step to left
						if ((fingerTable[f] - 1) == noteIndex) {
							//System.out.println("Liikutettava moottori on: " +f);
							moveMotorIndex = negMove1;
							fingerMoveIndex = -1;
							motorIndex = f;
							position = 0;
						}
					}
				}
			}
			if (motorIndex == -1) {
				if (position == 1) {
					for (int g = 0; g < 6; g++) {
						//System.out.println("p��sty pos1 move-2 for loopin l�pi");
						//Check if finger is on note when robot moves two step to left
						if ((fingerTable[g] - 2) == noteIndex) {
							moveMotorIndex = negMove2;
							fingerMoveIndex = -2;
							motorIndex = g;
							position = -1;
						}
					}
				}
				if (motorIndex == -1) {
					if (position == -1) {
						for (int h = 0; h < 6; h++) {
							//Check if finger is on note when robot moves one step to right
							if ((fingerTable[h] + 1) == noteIndex) {
								moveMotorIndex = posMove1;
								fingerMoveIndex = 1;
								motorIndex = h;
								position = 0;
							}
						}
					}
				}
				if (motorIndex == -1) {
					if (position == -1) {
						for (int l = 0; l < 6; l++) {
							//Check if finger is on note when robot moves two step to right
							if ((fingerTable[l] + 2) == noteIndex) {
								moveMotorIndex = posMove2;
								fingerMoveIndex = 2;
								motorIndex = l;
								position = 1;
							}
						}
					}
				}
			}
		}
		moveMotor.moveRobot(moveMotorIndex);
		playMotor.move(motorIndex, noteLenght);
		fingers.moveFingers(fingerMoveIndex);
		//System.out.println("positio on: " + position);
	}

}
