package Models;

/**
 *
 * @author Xin
 *
 */
public abstract class SingleTargetTower extends Tower {

    public SingleTargetTower(int xPos, int yPos, int level, int initialCost, int upgradeCost,
            int refundValue, double range, double power, double rateOfFire) {

        super(xPos, yPos, level, initialCost, upgradeCost, refundValue, range, power, rateOfFire,
                false);

    }

}
