package CritterModels;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Utility.Constants;

/**
 * @author Jose
 *
 */
public class SpeedCritter extends Critter {

    /**
     * Constructor of the SpeedCritter class
     * 
     * @param level Level at which the critter is being spawned
     */
    public SpeedCritter(int level) {
        super(level);

        this.speed = Constants.SPEED_CRITTER_SPEED;
        this.bounty = Constants.SPEED_CRITTER_BOUNTY;
        this.strength = Constants.SPEED_CRITTER_STRENGTH;
        this.spawnRate = Constants.SPEED_CRITTER_SPAWN_RATE;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 15 * level * level + 5 * level + 80;
        this.maxHealth = health;
        try {
			this.img= ImageIO.read(new File(Constants.FASTCAR_IMAGE));
			this.slowImg = ImageIO.read(new File(Constants.SLOW_FASTCAR_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
