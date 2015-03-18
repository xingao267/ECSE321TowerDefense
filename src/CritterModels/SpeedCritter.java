package CritterModels;

import Utility.Constants;

/**
 * @author Jose
 *
 */
public class SpeedCritter extends Critter {

	/**
	 * Constructor of the SpeedCritter class
	 * 
	 * @param level
	 *            Level at which the critter is being spawned
	 */
	public SpeedCritter(int level, int xPos, int yPos) {
		super(level, xPos, yPos);

		this.speed = Constants.SPEED_CRITTER_SPEED;
		this.bounty = Constants.SPEED_CRITTER_BOUNTY;
		this.strength = Constants.SPEED_CRITTER_STRENGTH;

		if (level > 5) {
			this.bounty += (level / 5) * this.bounty;
		}
		this.health = 15 * level * level + 5 * level + 80;
	}

}
