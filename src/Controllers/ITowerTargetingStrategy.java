/**
 *
 */

package Controllers;

import java.util.List;

import CritterModels.Critter;
import TowerModels.Tower;

/**
 * Interface for different Tower targeting strategies
 * 
 * @author Xin
 *
 */
public interface ITowerTargetingStrategy {

    /**
     * Get the target with different tower targeting strategies
     *
     * @param tower
     * @param critters
     * @return
     */
    public Critter getTarget(Tower tower, List<Critter> critters);

}
