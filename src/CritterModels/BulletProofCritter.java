package CritterModels;

import Utility.Constants;


/**
 * @author Jose
 *
 */
public class BulletProofCritter extends Critter {

    /**
     * Constructor of the BulletProofCritter class
     * 
     * @param level Level at which the critter is being spawned
     */
    public BulletProofCritter(int level) {
        super(level);

        this.speed = Constants.BULLET_PROOF_CRITTER_SPEED;
        this.bounty = Constants.BULLET_PROOF_CRITTER_BOUNTY;
        this.strength = Constants.BULLET_PROOF_CRITTER_STRENGTH;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 15 * level * level + 5 * level + 80;
    }

}
