package Controllers;

import java.util.List;

import CritterModels.Critter;
import Exceptions.MaxLevelReachedException;
import TowerModels.Tower;

/**
 * Interface for TowerController
 *
 * @author Xin
 *
 */
public interface ITowerController {

    /**
     * Move the tower to new position
     *
     * @param tower
     * @param newXPos
     * @param newYPos
     */
    public void moveTower(Tower tower, int newXPos, int newYPos);

    /**
     * Upgrade the tower to one level up
     *
     * @param tower
     * @throws MaxLevelReachedException
     */
    public void upgradeTower(Tower tower) throws MaxLevelReachedException;

    /**
     * Sell the Tower
     *
     * @param tower
     */
    public void sellTower(Tower tower);

    /**
     * Detect targets in the fire range of the tower
     *
     * @param tower
     * @param critters
     * @return list of critters in the fire range
     */
    public List<Critter> detectTargets(Tower tower, List<Critter> critters);

    /**
     * Select the target critter(s) that will be attacked
     *
     * @param tower
     * @param critters
     * @return list of critters selected
     */
    public List<Critter> selectTargets(Tower tower, List<Critter> critters);

    /**
     * Attack the targets
     *
     * @param tower
     * @param critters
     */
    public void attackTargets(Tower tower, List<Critter> critters);

}
