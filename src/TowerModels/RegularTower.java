package TowerModels;

import CritterModels.Critter;
import Exceptions.MaxLevelReachedException;
import Map.Cell;
import Utility.Constants;

/**
 *
 * @author Xin
 *
 */
public class RegularTower extends SingleTargetTower {

    public RegularTower(int xPos, int yPos, int level, Cell cell) {
        super(xPos, yPos, level, Constants.REGULAR_INITIAL_COST,
                Constants.REGULAR_UPGRADE_COST[Constants.INITIAL_TOWER_LEVEL + 1],
                Constants.REGULAR_REFUND_VALUE[Constants.INITIAL_TOWER_LEVEL],
                Constants.REGULAR_RANGE[Constants.INITIAL_TOWER_LEVEL],
                Constants.REGULAR_POWER[Constants.INITIAL_TOWER_LEVEL],
                Constants.REGULAR_RATE[Constants.INITIAL_TOWER_LEVEL], cell);

        towerType = Constants.REGULAR_TOWER_TYPE;
    }

    @Override
    public void upgrade() {

        super.upgrade();

        this.upgradeCost = Constants.REGULAR_UPGRADE_COST[this.level + 1];
        this.refundValue = Constants.REGULAR_REFUND_VALUE[this.level];
        this.range = Constants.REGULAR_RANGE[this.level];
        this.power = Constants.REGULAR_POWER[this.level];
        this.rateOfFire = Constants.REGULAR_RATE[this.level];

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
        return Constants.REGULAR_RANGE[this.level + 1];
    }


    @Override
    public double getNextLevelPower() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.REGULAR_POWER[this.level + 1];
    }

    @Override
    public double getNextLevelRateOfFire() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.REGULAR_RATE[this.level + 1];
    }

    @Override
    public double getDamagePerHit() {
        return Constants.REGULAR_DAMAGE_PER_HIT[this.level];
    }


    @Override
    public double getNextLevelDamagePerHit() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.REGULAR_DAMAGE_PER_HIT[this.level + 1];
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegularTower [xPos=" + xPos + ", yPos=" + yPos + ", initialCost=" + initialCost
                + ", level=" + level + ", upgradeCost=" + upgradeCost + ", refundValue="
                + refundValue + ", range=" + range + ", power=" + power + ", rateOfFire="
                + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }

}
