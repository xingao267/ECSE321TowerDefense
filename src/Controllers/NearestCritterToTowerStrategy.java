/**
 *
 */
package Controllers;

import java.util.List;

import CritterModels.Critter;
import TowerModels.Tower;
import Utility.Utils;

/**
 * Detect the Critter closest to the Tower
 *
 * @author Xin
 *
 */
public class NearestCritterToTowerStrategy implements ITowerTargetingStrategy {

    public NearestCritterToTowerStrategy() {
        super();
    }

    @Override
    public Critter getTarget(Tower tower, List<Critter> critters) {

        if (!critters.isEmpty()) {
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
        return null;
    }

}
