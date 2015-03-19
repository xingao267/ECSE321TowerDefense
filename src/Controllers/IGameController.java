package Controllers;

import java.util.List;

import CritterModels.Critter;
import Exceptions.CritterDeadException;
import Exceptions.MaxLevelReachedException;
import OtherModels.Bank;
import OtherModels.Cell;
import TowerModels.Tower;

/**
 * Interface for TowerController
 *
 * @author Xin
 *
 */
public interface IGameController {

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
     * @param bank
     * @throws MaxLevelReachedException
     */
    public void upgradeTower(Tower tower, Bank bank) throws MaxLevelReachedException;

    /**
     * Sell the Tower
     *
     * @param tower
     * @param bank
     */
    public void sellTower(Tower tower, Bank bank);

    /**
     * Detect targets in the fire range of the tower
     *
     * @param tower
     * @param critters
     * @return list of critters in the fire range
     */
    public List<Critter> towerDetectTargets(Tower tower, List<Critter> critters);

    /**
     * Select the target critter(s) that will be attacked
     *
     * @param tower
     * @param critters
     * @return list of critters selected
     */
    public List<Critter> towerSelectTargets(Tower tower, List<Critter> critters);

    /**
     * Tower attacks critter group
     * 
     * @param tower
     * @param critters
     * @param bank
     * @throws CritterDeadException
     */
    public void towerAttackTargets(Tower tower, List<Critter> critters, Bank bank)
            throws CritterDeadException;

    /**
     * Spawns critter group one by one every second at the entry point of the path
     * 
     * @param critterGroup Group of critters to be spawned
     * @param entryPoint First cell on path where critters will be spawned
     */
    public void spawnCritterGroup(Cell entryPoint, List<Critter> critterGroup);

}
