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
public class BomberTower extends MultiTargetsTower {

    public BomberTower(int xPos, int yPos, int level, Cell cell) {
        super(xPos, yPos, level, Constants.BOMBER_INITIAL_COST,
                Constants.BOMBER_UPGRADE_COST[Constants.INITIAL_TOWER_LEVEL + 1],
                Constants.BOMBER_REFUND_VALUE[Constants.INITIAL_TOWER_LEVEL],
                Constants.BOMBER_RANGE[Constants.INITIAL_TOWER_LEVEL],
                Constants.BOMBER_POWER[Constants.INITIAL_TOWER_LEVEL],
                Constants.BOMBER_RATE[Constants.INITIAL_TOWER_LEVEL],
                Constants.BOMBER_EFFECT_RANGE[Constants.INITIAL_TOWER_LEVEL], cell);

        towerType = Constants.BOMBER_TOWER_TYPE;
    }


    @Override
    public void upgrade() {

        super.upgrade();

        this.upgradeCost = Constants.BOMBER_UPGRADE_COST[this.level + 1];
        this.refundValue = Constants.BOMBER_REFUND_VALUE[this.level];
        this.range = Constants.BOMBER_RANGE[this.level];
        this.power = Constants.BOMBER_POWER[this.level];
        this.rateOfFire = Constants.BOMBER_RATE[this.level];
        this.effectRange = Constants.BOMBER_EFFECT_RANGE[this.level];

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
        return Constants.BOMBER_RANGE[this.level + 1];
    }


    @Override
    public double getNextLevelPower() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.BOMBER_POWER[this.level + 1];
    }

    @Override
    public double getNextLevelRateOfFire() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.BOMBER_RATE[this.level + 1];
    }

    @Override
    public double getNextLevelEffectRange() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.BOMBER_EFFECT_RANGE[this.level + 1];
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BomberTower [effectRange=" + effectRange + ", xPos=" + xPos + ", yPos=" + yPos
                + ", initialCost=" + initialCost + ", level=" + level + ", upgradeCost="
                + upgradeCost + ", refundValue=" + refundValue + ", range=" + range + ", power="
                + power + ", rateOfFire=" + rateOfFire + ", multiTargets=" + multiTargets + "]";
    }


    @Override
    public double getDamagePerHit() {
        return Constants.BOMBER_DAMAGE_PER_HIT[this.level];
    }


    @Override
    public double getNextLevelDamagePerHit() throws MaxLevelReachedException {
        if (this.level == Constants.MAX_TOWER_LEVEL) {
            throw new MaxLevelReachedException();
        }
        return Constants.BOMBER_DAMAGE_PER_HIT[this.level + 1];
    }

}
