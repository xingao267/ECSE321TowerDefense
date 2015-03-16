package Controllers;

import java.util.ArrayList;
import java.util.List;

import CritterModels.Critter;
import Exceptions.MaxLevelReachedException;
import TowerModels.MultiTargetsTower;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;


/**
 * TowerController Class
 *
 * @author Xin
 *
 */
public class TowerController implements ITowerController {

    @Override
    public void moveTower(Tower tower, int newXPos, int newYPos) {

        tower.setxPos(newXPos);
        tower.setyPos(newYPos);
    }

    @Override
    public void upgradeTower(Tower tower) throws MaxLevelReachedException {

        if (tower.getLevel() < Constants.MAX_TOWER_LEVEL) {
            tower.upgrade();
        } else {
            throw new MaxLevelReachedException("Tower maximum level reached, cannot be upgraded");
        }

    }

    @Override
    public void sellTower(Tower tower) {

        // Remove tower

        // Money should be deducted on the Bank side

    }

    @Override
    public List<Critter> detectTargets(Tower tower, List<Critter> critters) {

        List<Critter> crittersInRange = new ArrayList<Critter>();

        for (Critter critter : critters) {

            double distance =
                    Utils.getDistance(tower.getxPos(), tower.getyPos(), critter.getxPos(),
                            critter.getyPos());

            if (distance <= tower.getRange()) {
                crittersInRange.add(critter);
            }
        }
        return crittersInRange;
    }

    @Override
    public List<Critter> selectTargets(Tower tower, List<Critter> critters) {

        Critter closestCritter = detectClosestTarget(tower, critters);

        List<Critter> crittersSelected = new ArrayList<Critter>();

        if (tower.isMultiTargets()) {

            MultiTargetsTower multiTargetsTower = (MultiTargetsTower) tower;

            for (Critter critter : critters) {
                double distance =
                        Utils.getDistance(closestCritter.getxPos(), closestCritter.getyPos(),
                                critter.getxPos(), critter.getyPos());

                // Add critters around the closest critter within the bomb effect range of the Tower
                if (distance <= multiTargetsTower.getEffectRange()) {
                    crittersSelected.add(critter);
                }
            }

        } else {
            crittersSelected.add(closestCritter);
        }
        return crittersSelected;
    }

    @Override
    public void attackTargets(Tower tower, List<Critter> critters) {

        tower.attack(critters);
    }

    /**
     * Detect the Critter closest to the Tower
     *
     * @param tower
     * @param critters
     * @return
     */
    private Critter detectClosestTarget(Tower tower, List<Critter> critters) {

        Critter closestTarget = critters.get(0);
        double minDistance =
                Utils.getDistance(tower.getxPos(), tower.getyPos(), closestTarget.getxPos(),
                        closestTarget.getyPos());

        for (Critter critter : critters) {
            double distance =
                    Utils.getDistance(tower.getxPos(), tower.getyPos(), critter.getxPos(),
                            critter.getyPos());
            if (distance < minDistance) {
                closestTarget = critter;
            }
        }
        return closestTarget;
    }

}
