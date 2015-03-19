package CritterModels;

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
    public RegenerativeCritter(int level, int xPos, int yPos) {
        super(level, xPos, yPos);

        this.speed = Constants.REGENERATIVE_CRITTER_SPEED;
        this.bounty = Constants.REGENERATIVE_CRITTER_BOUNTY;
        this.strength = Constants.REGENERATIVE_CRITTER_STRENGTH;

        if (level > 5) {
            this.bounty += (level / 5) * this.bounty;
        }
        this.health = 15 * level * level + 5 * level + 80;
        this.maxHealthPoints = this.health;

        if (!isBeingHit) { // will need to be added into game loop
            regenerate(level);
        }
    }

    /**
     * Regenerates the a certain amount of health points every seconds that the critter is not being
     * hit, depending on the game level.
     * 
     * @param level Level at which the game is currently at.
     */
    public void regenerate(int level) { // regenerates a certain amount of
                                        // health every certain interval of time
        long lastExecutionTime = 0; // only begins regenerating after critter
                                    // has been spawned
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
