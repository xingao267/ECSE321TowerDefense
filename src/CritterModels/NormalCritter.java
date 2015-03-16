package CritterModels;

import Utility.Constants;


/**
 * @author José
 *
 */
public class NormalCritter extends Critter {

	/**
	 * Constructor of the NormalCritter class
	 * 
	 * @param level
	 *            Level at which the critter is being spawned
	 */
	public NormalCritter(int level, int xPos, int yPos) {
		super(level, xPos, yPos);

		this.speed = Constants.NORMAL_CRITTER_SPEED;
		this.bounty = Constants.NORMAL_CRITTER_BOUNTY;
		this.strength = Constants.NORMAL_CRITTER_STRENGTH;

		if (level > 5) {
			this.bounty += (level / 5) * this.bounty;
		}
		this.health = 15 * level * level + 5 * level + 80;
	}

}
