package TempModels;

/**
 * The is a temporary Critter class to help implement Tower functions
 *
 * @author Xin
 *
 */
public class Critter {

    /** x position of critter. */
    private int xPos;

    /** y position of critter. */
    private int yPos;

    /** health of critter. */
    private double health;

    /** speed of critter. */
    private double speed;

    private boolean slowed;

    /**
     * @param xPos
     * @param yPos
     * @param health
     * @param speed
     */
    public Critter(int xPos, int yPos, double health, double speed) {
        super();
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.speed = speed;
    }

    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the slowed
     */
    public boolean isSlowed() {
        return slowed;
    }

    /**
     * @param slowed the slowed to set
     */
    public void setSlowed(boolean slowed) {
        this.slowed = slowed;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Critter [xPos=" + xPos + ", yPos=" + yPos + ", health=" + health + ", speed="
                + speed + ", slowed=" + slowed + "]";
    }

}
