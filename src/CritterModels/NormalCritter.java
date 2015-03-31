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
        this.bounty = Constants.NORMAL_CRITTER_BOUNTY;
        this.strength = Constants.NORMAL_CRITTER_STRENGTH;
        this.spawnRate = Constants.NORMAL_CRITTER_SPAWN_RATE;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 15 * level * level + 5 * level + 80;
        this.maxHealth = health;
        
        this.critterType = Constants.NORMAL_CRITTER_TYPE;
        try {
			this.img= ImageIO.read(new File(Constants.CAR_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
