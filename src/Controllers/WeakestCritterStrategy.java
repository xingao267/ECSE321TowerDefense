/**
 *
 */
package Controllers;

import java.util.List;

import CritterModels.Critter;
import TowerModels.Tower;
import Utility.Utils;

/**
 * Detect the weakest critter in range
 *
 * @author Justin
 *
 */
public class WeakestCritterStrategy implements ITowerTargetingStrategy {

    public WeakestCritterStrategy() {
        super();
    }

    @Override
    public Critter getTarget(Tower tower, List<Critter> critters) {

        if (!critters.isEmpty()) {
            Critter weakestTarget = critters.get(0);
            double lowestHealth = weakestTarget.getHealth();

            for (Critter critter : critters) {
                double health =  weakestTarget.getHealth();
                if (health < lowestHealth) {
                    weakestTarget = critter;
                }
            }
            return weakestTarget;
        }
        return null;
    }

}
