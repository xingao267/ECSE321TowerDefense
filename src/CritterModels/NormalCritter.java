package CritterModels;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Utility.Constants;


/**
 * @author Jose
 *
 */
public class NormalCritter extends Critter {

    /**
     * Constructor of the NormalCritter class
     * 
     * @param level Level at which the critter is being spawned
     */
    public NormalCritter(int level) {
        super(level);

        this.speed = Constants.NORMAL_CRITTER_SPEED;
        this.initialSpeed = speed;
        this.bounty = Constants.NORMAL_CRITTER_BOUNTY;
        this.strength = Constants.NORMAL_CRITTER_STRENGTH;
        this.spawnRate = Constants.NORMAL_CRITTER_SPAWN_RATE;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 5 * level * level + 15*level + 60;
        this.maxHealth = health;
        
        this.critterType = Constants.NORMAL_CRITTER_TYPE;
        try {
			this.img= ImageIO.read(new File(Constants.CAR_IMAGE));
			this.slowImg= ImageIO.read(new File(Constants.SLOW_CAR_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
