package TowerModels;

import CritterModels.Critter;
import Exceptions.MaxLevelReachedException;
import Utility.Constants;

/**
 *
 * @author Xin
 *
 */
public class LongRangeTower extends SingleTargetTower {

    public LongRangeTower(int xPos, int yPos, int level) {
        super(xPos, yPos, level, Constants.LONGRANGE_INITIAL_COST,
                Constants.LONGRANGE_UPGRADE_COST[Constants.INITIAL_TOWER_LEVEL + 1],
                Constants.LONGRANGE_REFUND_VALUE[Constants.INITIAL_TOWER_LEVEL],
                Constants.LONGRANGE_RANGE[Constants.INITIAL_TOWER_LEVEL],
                Constants.LONGRANGE_POWER[Constants.INITIAL_TOWER_LEVEL],
                Constants.LONGRANGE_RATE[Constants.INITIAL_TOWER_LEVEL]);

        towerType = Constants.LONGRANGE_TOWER_TYPE;
    }

    @Override
    public void upgrade() {

        super.upgrade();

        this.upgradeCost = Constants.LONGRANGE_UPGRADE_COST[this.level + 1];
        this.refundValue = Constants.LONGRANGE_REFUND_VALUE[this.level];
        this.range = Constants.LONGRANGE_RANGE[this.level];
        this.power = Constants.LONGRANGE_POWER[this.level];
        this.rateOfFire = Constants.LONGRANGE_RATE[this.level];

    }

    @Override
    public void applySpecialEffects(Critter critter) {
        // No special effect
    }

    @Override
    public double getNextLevelRange() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.LONGRANGE_RANGE[this.level + 1];
    }


    @Override
    public double getNextLevelPower() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.LONGRANGE_POWER[this.level + 1];
    }

    @Override
    public double getNextLevelRateOfFire() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.LONGRANGE_RATE[this.level + 1];
    }

    @Override
    public double getDamagePerHit() {
        return Constants.LONGRANGE_DAMAGE_PER_HIT[this.level];
    }


    @Override
    public double getNextLevelDamagePerHit() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.LONGRANGE_DAMAGE_PER_HIT[this.level + 1];
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LongRangeTower [xPos=" + xPos + ", yPos=" + yPos + ", initialCost=" + initialCost
                + ", level=" + level + ", upgradeCost=" + upgradeCost + ", refundValue="
                + refundValue + ", range=" + range + ", power=" + power + ", rateOfFire="
                + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }

}
