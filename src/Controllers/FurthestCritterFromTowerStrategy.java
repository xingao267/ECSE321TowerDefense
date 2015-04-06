/**
 *
 */
package Controllers;

import java.util.List;

import CritterModels.Critter;
import TowerModels.Tower;
import Utility.Utils;

/**
 * Detect the Critter furthest from the Tower
 *
 * @author Justin
 *
 */
public class FurthestCritterFromTowerStrategy implements ITowerTargetingStrategy {

    public FurthestCritterFromTowerStrategy() {
        super();
    }

    @Override
    public Critter getTarget(Tower tower, List<Critter> critters) {

        if (!critters.isEmpty()) {
            Critter furthestTarget = critters.get(0);
            double maxDistance =
                    Utils.getDistance(tower.getxPos(), tower.getyPos(), furthestTarget.getxPos(),
                            furthestTarget.getyPos());

            for (Critter critter : critters) {
                double distance =
                        Utils.getDistance(tower.getxPos(), tower.getyPos(), critter.getxPos(),
                                critter.getyPos());
                if (distance > maxDistance) {
                    furthestTarget = critter;
                }
            }
            return furthestTarget;
        }
        return null;
    }

}
