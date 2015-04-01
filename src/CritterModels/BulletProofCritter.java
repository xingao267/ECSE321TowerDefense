package CritterModels;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
        this.spawnRate = Constants.BULLET_PROOF_CRITTER_SPAWN_RATE;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 5 * level * level + 15*level + 60;
        this.maxHealth = health;
        
        this.critterType = Constants.BULLET_PROOF_CRITTER_TYPE;
        try {
			this.img= ImageIO.read(new File(Constants.VAN_IMAGE));
			this.slowImg = ImageIO.read(new File(Constants.SLOW_VAN_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
