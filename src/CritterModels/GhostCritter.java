package CritterModels;

import Utility.Constants;

//will probably not use in final game
public class GhostCritter extends Critter {

	private boolean isVanished;

	/**
	 * Constructor of the GhostCritter class
	 * 
	 * @param level
	 *            Level at which the critter is being spawned
	 */
	public GhostCritter(int level, int xPos, int yPos) {
		super(level, xPos, yPos);

		this.isVanished = false;

		this.speed = Constants.GHOST_CRITTER_SPEED;
		this.bounty = Constants.GHOST_CRITTER_BOUNTY;
		this.strength = Constants.GHOST_CRITTER_STRENGTH;

		if (level > 5) {
			this.bounty += (level / 5) * this.bounty;
		}
		this.health = 15 * level * level + 5 * level + 80;
	}

	public void vanish() { // add some changes to graphics
		isVanished = true;
	}

	/**
	 * @return the isVanished
	 */
	public boolean isVanished() {
		return isVanished;
	}

	/**
	 * @param isVanished
	 *            the isVanished to set
	 */
	public void setVanished(boolean isVanished) {
		this.isVanished = isVanished;
	}

}
