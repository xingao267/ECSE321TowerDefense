package CritterModels;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Utility.Constants;


/**
 * @author Jose
 *
 */
public class RegenerativeCritter extends Critter {

    private double maxHealthPoints;

    /**
     * Constructor of the RegenerativeCritter class
     * 
     * @param level Level at which the critter is being spawned
     */
    public RegenerativeCritter(int level) {
        super(level);

        this.speed = Constants.REGENERATIVE_CRITTER_SPEED;
        this.initialSpeed = speed;
        this.bounty = Constants.REGENERATIVE_CRITTER_BOUNTY;
        this.strength = Constants.REGENERATIVE_CRITTER_STRENGTH;
        this.spawnRate = Constants.REGENERATIVE_CRITTER_SPAWN_RATE;

        if (level > 5) {
            this.bounty += (level / 5) * 2*this.bounty;
        }
        this.health = 5 * level * level + 10*level + 55;
        this.maxHealth = health;

//        if (!isBeingHit) { // will need to be added into game loop
//           regenerate(level);
//        }
        
        this.critterType = Constants.REGENERATIVE_CRITTER_TYPE;
        try {
			this.img= ImageIO.read(new File(Constants.PICKUP_IMAGE));
			this.slowImg= ImageIO.read(new File(Constants.SLOW_PICKUP_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Regenerates the a certain amount of health points every seconds that the critter is not being
     * hit, depending on the game level.
     * 
     * @param level Level at which the game is currently at.
     */
    public void regenerate(int level) {
 
        long lastExecutionTime = 0;
        int regenerativeAmount = 40 + 8 * level + 2 * level * level;
        if (System.currentTimeMillis() - lastExecutionTime >= 0) {
            if (health + regenerativeAmount > maxHealthPoints)
                health = maxHealthPoints;
            else
                health += regenerativeAmount;

            lastExecutionTime = System.currentTimeMillis();
        }
    }

    /**
     * @return the maxHealthPoints
     */
    public double getMaxHealthPoints() {
        return maxHealthPoints;
    }

    /**
     * @param maxHealthPoints the maxHealthPoints to set
     */
    public void setMaxHealthPoints(double maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

}
