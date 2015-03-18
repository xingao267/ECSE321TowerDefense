package CritterModels;

import Utility.Constants;


/**
 * @author Jose
 *
 */
public class BossCritter extends Critter {

	/**
	 * Constructor of the BossCritter class
	 * 
	 * @param level
	 *            Level at which the critter is being spawned
	 */
	public BossCritter(double speed, int bounty, int health, int xPos, int yPos) {
		super(Constants.MAX_CRITTER_LEVEL, xPos, yPos);

		this.strength = Constants.BOSS_CRITTER_STRENGTH;
		this.speed = speed;
		this.bounty = bounty;
		this.health = health;
	}

}