package TowerModels;

import Exceptions.MaxLevelReachedException;

/**
 *
 * @author Xin
 *
 */
public abstract class MultiTargetsTower extends Tower {

    /** The range of effect for the multiple targets attack. */
    protected double effectRange;

    public MultiTargetsTower(int xPos, int yPos, int level, int initialCost, int upgradeCost,
            int refundValue, double range, double power, double rateOfFire, double effectRange) {

        super(xPos, yPos, level, initialCost, upgradeCost, refundValue, range, power, rateOfFire,
                true);
        this.effectRange = effectRange;
    }

    /**
     * @return the effectRange
     */
    public double getEffectRange() {
        return effectRange;
    }

    /**
     * @param effectRange the effectRange to set
     */
    public void setEffectRange(double effectRange) {
        this.effectRange = effectRange;
    }

    public abstract double getNextLevelEffectRange() throws MaxLevelReachedException;

}
