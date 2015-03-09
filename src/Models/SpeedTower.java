package Models;

import TempModels.Critter;
import Utility.Constants;

/**
 *
 * @author Xin
 *
 */
public class SpeedTower extends SingleTargetTower {

    public SpeedTower(int xPos, int yPos, int level) {
        super(xPos, yPos, level, Constants.SPEED_INITIAL_COST,
                Constants.SPEED_UPGRADE_COST[Constants.INITIAL_TOWER_LEVEL + 1],
                Constants.SPEED_REFUND_VALUE[Constants.INITIAL_TOWER_LEVEL],
                Constants.SPEED_RANGE[Constants.INITIAL_TOWER_LEVEL],
                Constants.SPEED_POWER[Constants.INITIAL_TOWER_LEVEL],
                Constants.SPEED_RATE[Constants.INITIAL_TOWER_LEVEL]);
    }


    @Override
    public void upgrade() {

        super.upgrade();

        this.upgradeCost = Constants.SPEED_UPGRADE_COST[this.level + 1];
        this.refundValue = Constants.SPEED_REFUND_VALUE[this.level];
        this.range = Constants.SPEED_RANGE[this.level];
        this.power = Constants.SPEED_POWER[this.level];
        this.rateOfFire = Constants.SPEED_RATE[this.level];

    }

    @Override
    public void applySpecialEffects(Critter critter) {
        // No special effect
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SpeedTower [xPos=" + xPos + ", yPos=" + yPos + ", initialCost=" + initialCost
                + ", level=" + level + ", upgradeCost=" + upgradeCost + ", refundValue="
                + refundValue + ", range=" + range + ", power=" + power + ", rateOfFire="
                + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }

}
