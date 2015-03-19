package TowerModels;

import CritterModels.ArmoredCritter;
import CritterModels.BulletProofCritter;
import CritterModels.Critter;
import Exceptions.CritterDeadException;

/**
 * The class is the generic base class Tower data model
 *
 * @author Xin
 *
 */
public abstract class Tower {

    /** x position. */
    protected int xPos;

    /** y position. */
    protected int yPos;

    /** The initial purchase cost for a tower. */
    protected int initialCost;

    /** The current level of the tower. */
    protected int level;

    /** The current upgradeCost of the tower. */
    protected int upgradeCost;

    /** The current refund value of the tower. */
    protected int refundValue;

    /** The current shooting range value of the tower. */
    protected double range;

    /** The current power/damage value of the tower per hit. */
    protected double power;

    /** The current rate of fire of the tower. */
    protected double rateOfFire;

    /** Tower can inflict damage to multiple targets at once or not. */
    protected boolean multiTargets;

    /**
     * @param xPos
     * @param yPos
     * @param level
     * @param initialCost
     * @param upgradeCost
     * @param refundValue
     * @param range
     * @param power
     * @param rateOfFire
     */
    public Tower(int xPos, int yPos, int level, int initialCost, int upgradeCost, int refundValue,
            double range, double power, double rateOfFire, boolean multiTargets) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.level = level;
        this.initialCost = initialCost;
        this.upgradeCost = upgradeCost;
        this.refundValue = refundValue;
        this.range = range;
        this.power = power;
        this.rateOfFire = rateOfFire;
        this.multiTargets = multiTargets;
    }

    /**
     * Tower specific attack
     *
     * @param critters
     * @throws CritterDeadException
     */
    public void attack(Critter critter) throws CritterDeadException {

        double newHealth = 0;

        if (critter instanceof ArmoredCritter) {
            newHealth = critter.getHealth() - this.power / 2;
        } else if (critter instanceof BulletProofCritter) {
            // Removed damage type for now
            // damageType
            // 0 implies regular attacks (bullets, explosions)
            // 1 implies special attacks (fire, electricity)
            newHealth = critter.getHealth() - this.power / 4;
        } else {
            newHealth = critter.getHealth() - this.power;
        }

        critter.setHealth(newHealth);

        if (!critter.isDead()) {
            applySpecialEffects(critter);
        } else {
            throw new CritterDeadException(critter);
        }

    }

    /**
     * Apply the Tower specific effects to Critter
     *
     * @param critter
     */
    public abstract void applySpecialEffects(Critter critter);

    /**
     * Upgrade tower to one level up
     *
     */
    public void upgrade() {

        this.level++;
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
     * @return the initialCost
     */
    public int getInitialCost() {
        return initialCost;
    }

    /**
     * @param initialCost the initialCost to set
     */
    public void setInitialCost(int initialCost) {
        this.initialCost = initialCost;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the upgradeCost
     */
    public int getUpgradeCost() {
        return upgradeCost;
    }

    /**
     * @param upgradeCost the upgradeCost to set
     */
    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    /**
     * @return the refundValue
     */
    public int getRefundValue() {
        return refundValue;
    }

    /**
     * @param refundValue the refundValue to set
     */
    public void setRefundValue(int refundValue) {
        this.refundValue = refundValue;
    }

    /**
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(double range) {
        this.range = range;
    }

    /**
     * @return the power
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * @return the rateOfFire
     */
    public double getRateOfFire() {
        return rateOfFire;
    }

    /**
     * @param rateOfFire the rateOfFire to set
     */
    public void setRateOfFire(double rateOfFire) {
        this.rateOfFire = rateOfFire;
    }

    /**
     * @return the multiTargets
     */
    public boolean isMultiTargets() {
        return multiTargets;
    }

    /**
     * @param multiTargets the multiTargets to set
     */
    public void setMultiTargets(boolean multiTargets) {
        this.multiTargets = multiTargets;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Tower [xPos=" + xPos + ", yPos=" + yPos + ", initialCost=" + initialCost
                + ", level=" + level + ", upgradeCost=" + upgradeCost + ", refundValue="
                + refundValue + ", range=" + range + ", power=" + power + ", rateOfFire="
                + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }

}
