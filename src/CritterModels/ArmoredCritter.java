package CritterModels;

import Utility.Constants;


/**
 * @author Jose
 *
 */
public class ArmoredCritter extends Critter {

    /**
     * Constructor of the ArmoredCritter class
     * 
     * @param level Level at which the critter is being spawned
     */
    public ArmoredCritter(int level) {
        super(level);

        this.speed = Constants.ARMORED_CRITTER_SPEED;
        this.bounty = Constants.ARMORED_CRITTER_BOUNTY;
        this.strength = Constants.ARMORED_CRITTER_STRENGTH;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 15 * level * level + 5 * level + 80;
        this.maxHealth = health;
    }

}
