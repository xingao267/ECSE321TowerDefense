package CritterModels;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
        this.spawnRate = Constants.ARMORED_CRITTER_SPAWN_RATE;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 5 * level * level + 15*level + 60;
        this.maxHealth = health;
        
        this.critterType = Constants.ARMORED_CRITTER_TYPE;
        try {
			this.img= ImageIO.read(new File(Constants.TRUCK_IMAGE));
			this.slowImg= ImageIO.read(new File(Constants.SLOW_TRUCK_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
