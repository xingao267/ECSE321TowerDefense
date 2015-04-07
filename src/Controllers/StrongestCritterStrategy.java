/**
 *
 */
package Controllers;

import java.util.List;

import CritterModels.Critter;
import TowerModels.Tower;

/**
 * Detect the strongest critter in range
 *
 * @author Justin
 *
 */
public class StrongestCritterStrategy implements ITowerTargetingStrategy {

    public StrongestCritterStrategy() {
        super();
    }

    @Override
    public Critter getTarget(Tower tower, List<Critter> critters) {

        if (!critters.isEmpty()) {
            Critter strongestTarget = critters.get(0);
            double greatestHealth = strongestTarget.getHealth();

            for (Critter critter : critters) {
                double health =  strongestTarget.getHealth();
                if (health > greatestHealth) {
                    strongestTarget = critter;
                }
            }
            return strongestTarget;
        }
        return null;
    }

}