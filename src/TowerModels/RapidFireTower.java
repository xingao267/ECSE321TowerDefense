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
public class RapidFireTower extends SingleTargetTower {

    public RapidFireTower(int xPos, int yPos, int level, Cell cell) {
        super(xPos, yPos, level, Constants.RAPID_FIRE_INITIAL_COST,
                Constants.RAPID_FIRE_UPGRADE_COST[Constants.INITIAL_TOWER_LEVEL + 1],
                Constants.RAPID_FIRE_REFUND_VALUE[Constants.INITIAL_TOWER_LEVEL],
                Constants.RAPID_FIRE_RANGE[Constants.INITIAL_TOWER_LEVEL],
                Constants.RAPID_FIRE_POWER[Constants.INITIAL_TOWER_LEVEL],
                Constants.RAPID_FIRE_RATE[Constants.INITIAL_TOWER_LEVEL], cell);

        towerType = Constants.RAPID_FIRE_TOWER_TYPE;
    }


    @Override
    public void upgrade() {

        super.upgrade();

        this.upgradeCost = Constants.RAPID_FIRE_UPGRADE_COST[this.level + 1];
        this.refundValue = Constants.RAPID_FIRE_REFUND_VALUE[this.level];
        this.range = Constants.RAPID_FIRE_RANGE[this.level];
        this.power = Constants.RAPID_FIRE_POWER[this.level];
        this.rateOfFire = Constants.RAPID_FIRE_RATE[this.level];

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
        return Constants.RAPID_FIRE_RANGE[this.level + 1];
    }


    @Override
    public double getNextLevelPower() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.RAPID_FIRE_POWER[this.level + 1];
    }

    @Override
    public double getNextLevelRateOfFire() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.RAPID_FIRE_RATE[this.level + 1];
    }

    @Override
    public double getDamagePerHit() {
        return Constants.RAPID_FIRE_DAMAGE_PER_HIT[this.level];
    }


    @Override
    public double getNextLevelDamagePerHit() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.RAPID_FIRE_DAMAGE_PER_HIT[this.level + 1];
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RapidFireTower [xPos=" + xPos + ", yPos=" + yPos + ", initialCost=" + initialCost
                + ", level=" + level + ", upgradeCost=" + upgradeCost + ", refundValue="
                + refundValue + ", range=" + range + ", power=" + power + ", rateOfFire="
                + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }

}
