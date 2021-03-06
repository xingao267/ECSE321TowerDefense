package Controllers;

import java.util.List;

import CritterModels.Critter;
import Exceptions.CritterDeadException;
import Exceptions.InvalidTowerTypeException;
import Exceptions.MaxLevelReachedException;
import Exceptions.NotEnoughMoneyException;
import Map.Cell;
import TowerModels.Tower;

/**
 * Interface for TowerController
 *
 * @author Xin
 *
 */
public interface IGameController {


    /**
     * Purchase the Tower
     * 
     * @param towerType
     * @param xPos
     * @param yPos
     * @param level
     * 
     * @return the tower object
     * @throws NotEnoughMoneyException
     * @throws InvalidTowerTypeException
     */
    public Tower purchaseTower(String towerType, int xPos, int yPos, int level, Cell cell)
            throws NotEnoughMoneyException, InvalidTowerTypeException;

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
     * @throws NotEnoughMoneyException
     */
    public void upgradeTower(Tower tower) throws MaxLevelReachedException, NotEnoughMoneyException;

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
     * @throws CritterDeadException
     */
    public void towerAttackTargets(Tower tower, List<Critter> critters) throws CritterDeadException;

    /**
     * Spawns critter group one by one every second at the entry point of the path
     * 
     * @param critterGroup Group of critters to be spawned
     * @param entryPoint First cell on path where critters will be spawned
     */
    public void spawnCritterGroup(Cell entryPoint, List<Critter> critterGroup);

}
