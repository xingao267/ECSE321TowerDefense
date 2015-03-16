package TowerModels;

import CritterModels.Critter;
import Utility.Constants;

/**
 * @author Xin
 *
 */
public class DeceleratorTower extends MultiTargetsTower {

    public DeceleratorTower(int xPos, int yPos, int level) {
        super(xPos, yPos, level, Constants.DECELERATOR_INITIAL_COST,
                Constants.DECELERATOR_UPGRADE_COST[Constants.INITIAL_TOWER_LEVEL + 1],
                Constants.DECELERATOR_REFUND_VALUE[Constants.INITIAL_TOWER_LEVEL],
                Constants.DECELERATOR_RANGE[Constants.INITIAL_TOWER_LEVEL],
                Constants.DECELERATOR_POWER[Constants.INITIAL_TOWER_LEVEL],
                Constants.DECELERATOR_RATE[Constants.INITIAL_TOWER_LEVEL],
                Constants.DECELERATOR_EFFECT_RANGE[Constants.INITIAL_TOWER_LEVEL]);
    }

    @Override
    public void upgrade() {

        super.upgrade();

        this.upgradeCost = Constants.DECELERATOR_UPGRADE_COST[this.level + 1];
        this.refundValue = Constants.DECELERATOR_REFUND_VALUE[this.level];
        this.range = Constants.DECELERATOR_RANGE[this.level];
        this.power = Constants.DECELERATOR_POWER[this.level];
        this.rateOfFire = Constants.DECELERATOR_RATE[this.level];
        this.effectRange = Constants.DECELERATOR_EFFECT_RANGE[this.level];

    }

    @Override
    public void applySpecialEffects(Critter critter) {

        if (!critter.isSlowed()) {
            critter.setSpeed(critter.getSpeed() * (0.9 - this.level * 0.1));
            critter.setSlowed(true);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DeceleratorTower [effectRange=" + effectRange + ", xPos=" + xPos + ", yPos=" + yPos
                + ", initialCost=" + initialCost + ", level=" + level + ", upgradeCost="
                + upgradeCost + ", refundValue=" + refundValue + ", range=" + range + ", power="
                + power + ", rateOfFire=" + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }

}