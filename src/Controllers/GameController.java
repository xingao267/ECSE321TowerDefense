package Controllers;

import java.util.ArrayList;
import java.util.List;

import CritterModels.Critter;
import Exceptions.CritterDeadException;
import Exceptions.InvalidTowerTypeException;
import Exceptions.MaxLevelReachedException;
import Exceptions.NoEnoughMoneyException;
import Map.Cell;
import OtherModels.Bank;
import TowerModels.BomberTower;
import TowerModels.DeceleratorTower;
import TowerModels.LongRangeTower;
import TowerModels.MultiTargetsTower;
import TowerModels.RegularTower;
import TowerModels.SpeedTower;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;

/**
 * TowerController Class
 *
 * @author Xin
 *
 */
public class GameController implements IGameController {

    private static GameController uniqueInstance = null;

    private Bank bank;

    private List<Tower> towers;

    private String selectedTowerTypeInStore;

    private boolean isTowerSeletedInStore;

    private boolean isTowerSelectedOnMap;

    private boolean isTowerCellHoveredOnMap;

    private Tower hoveredTowerOnMap;

    private Cell hoveredCellOnMap;

    private Tower selectedTowerOnMap;

    private boolean isNoMoneyCaught;

    private boolean isMaxLevelReached;

    private GameController() {
        bank = Bank.getUniqueInstance();
        towers = new ArrayList<Tower>();
        isTowerSeletedInStore = false;
        isTowerSelectedOnMap = false;
        isTowerCellHoveredOnMap = false;
    }

    public static synchronized GameController getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameController();
        }
        return uniqueInstance;
    }

    private int spawnTime = 100, spawnFrame = 0;

    @Override
    public Tower purchaseTower(String towerType, int xPos, int yPos, int level)
            throws NoEnoughMoneyException, InvalidTowerTypeException {

        Tower towerToPurchase = null;

        if (towerType.equals(Constants.REGULAR_TOWER_TYPE)) {
            towerToPurchase = new RegularTower(xPos, yPos, level);
        } else if (towerType.equals(Constants.BOMBER_TOWER_TYPE)) {
            towerToPurchase = new BomberTower(xPos, yPos, level);
        } else if (towerType.equals(Constants.LONGRANGE_TOWER_TYPE)) {
            towerToPurchase = new LongRangeTower(xPos, yPos, level);
        } else if (towerType.equals(Constants.SPEED_TOWER_TYPE)) {
            towerToPurchase = new SpeedTower(xPos, yPos, level);
        } else if (towerType.equals(Constants.DECELERATOR_TOWER_TYPE)) {
            towerToPurchase = new DeceleratorTower(xPos, yPos, level);
        } else {
            throw new InvalidTowerTypeException();
        }

        bank.removeFromBank(towerToPurchase.getInitialCost());
        towers.add(towerToPurchase);

        return towerToPurchase;
    }

    @Override
    public void moveTower(Tower tower, int newXPos, int newYPos) {

        tower.setxPos(newXPos);
        tower.setyPos(newYPos);
    }

    @Override
    public void upgradeTower(Tower tower) throws MaxLevelReachedException, NoEnoughMoneyException {

        if (tower.getLevel() < Constants.MAX_TOWER_LEVEL) {
            bank.removeFromBank(tower.getUpgradeCost());
            tower.upgrade();
        } else {
            throw new MaxLevelReachedException("Tower maximum level reached, cannot be upgraded");
        }
    }

    @Override
    public void sellTower(Tower tower) {

        if (tower != null) {
            tower.setInGame(false);
            towers.remove(tower);
            this.hoveredCellOnMap.setTower(null);
            this.hoveredCellOnMap.setHasTower(false);
            bank.returnToBank(tower.getRefundValue());
        }
    }

    @Override
    public List<Critter> towerDetectTargets(Tower tower, List<Critter> critters) {

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
    public List<Critter> towerSelectTargets(Tower tower, List<Critter> critters) {

        Critter closestCritter = detectClosestTarget(tower, critters);

        if (closestCritter != null) {
            List<Critter> crittersSelected = new ArrayList<Critter>();

            if (tower.isMultiTargets()) {

                MultiTargetsTower multiTargetsTower = (MultiTargetsTower) tower;

                for (Critter critter : critters) {
                    double distance =
                            Utils.getDistance(closestCritter.getxPos(), closestCritter.getyPos(),
                                    critter.getxPos(), critter.getyPos());

                    // Add critters around the closest critter within the bomb
                    // effect range of the Tower
                    if (distance <= multiTargetsTower.getEffectRange()) {
                        crittersSelected.add(critter);
                    }
                }

            } else {
                crittersSelected.add(closestCritter);
            }
            return crittersSelected;
        } else {
            return null;
        }
    }

    @Override
    public void towerAttackTargets(Tower tower, List<Critter> critters) throws CritterDeadException {

        if (critters != null) {
            for (Critter critter : critters) {
                tower.attack(critter);
                if (critter.isDead()) {
                    bank.returnToBank(critter.getBounty());
                }
            }
        }
    }

    /**
     * Detect the Critter closest to the Tower
     *
     * @param tower
     * @param critters
     * @return
     */
    private Critter detectClosestTarget(Tower tower, List<Critter> critters) {

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

    @Override
    public void spawnCritterGroup(Cell entryPoint, List<Critter> critterGroup) {
        // List<Critter> critterGroup = group.getCritterGroup();

        if (spawnFrame >= spawnTime) {
            for (int i = 0; i < critterGroup.size(); i++) {
                if (!critterGroup.get(i).isInGame() && !critterGroup.get(i).hasReachedExit()) {
                    critterGroup.get(i).spawn(entryPoint);
                    break;
                }
            }
            spawnFrame = 0;
        } else {
            spawnFrame++;
        }
    }

    /**
     * @return the towers
     */
    public List<Tower> getTowers() {
        return towers;
    }

    /**
     * @param towers the towers to set
     */
    public void setTowers(List<Tower> towers) {
        this.towers = towers;
    }

    /**
     * @return the selectedTowerTypeInStore
     */
    public String getSelectedTowerTypeInStore() {
        return selectedTowerTypeInStore;
    }

    /**
     * @param selectedTowerTypeInStore the selectedTowerTypeInStore to set
     */
    public void setSelectedTowerTypeInStore(String selectedTowerTypeInStore) {
        this.selectedTowerTypeInStore = selectedTowerTypeInStore;
    }

    /**
     * @return the isTowerSeletedInStore
     */
    public boolean isTowerSeletedInStore() {
        return isTowerSeletedInStore;
    }

    /**
     * @param isTowerSeletedInStore the isTowerSeletedInStore to set
     */
    public void setTowerSeletedInStore(boolean isTowerSeletedInStore) {
        this.isTowerSeletedInStore = isTowerSeletedInStore;
    }

    /**
     * @return the isTowerSelectedOnMap
     */
    public boolean isTowerSelectedOnMap() {
        return isTowerSelectedOnMap;
    }

    /**
     * @param isTowerSelectedOnMap the isTowerSelectedOnMap to set
     */
    public void setTowerSelectedOnMap(boolean isTowerSelectedOnMap) {
        this.isTowerSelectedOnMap = isTowerSelectedOnMap;
    }

    /**
     * @return the isTowerCellHoveredOnMap
     */
    public boolean isTowerCellHoveredOnMap() {
        return isTowerCellHoveredOnMap;
    }

    /**
     * @param isTowerCellHoveredOnMap the isTowerCellHoveredOnMap to set
     */
    public void setTowerCellHoveredOnMap(boolean isTowerCellHoveredOnMap) {
        this.isTowerCellHoveredOnMap = isTowerCellHoveredOnMap;
    }

    /**
     * @return the hoveredTowerOnMap
     */
    public Tower getHoveredTowerOnMap() {
        return hoveredTowerOnMap;
    }

    /**
     * @param hoveredTowerOnMap the hoveredTowerOnMap to set
     */
    public void setHoveredTowerOnMap(Tower hoveredTowerOnMap) {
        this.hoveredTowerOnMap = hoveredTowerOnMap;
    }

    /**
     * @return the selectedTowerOnMap
     */
    public Tower getSelectedTowerOnMap() {
        return selectedTowerOnMap;
    }

    /**
     * @param selectedTowerOnMap the selectedTowerOnMap to set
     */
    public void setSelectedTowerOnMap(Tower selectedTowerOnMap) {
        this.selectedTowerOnMap = selectedTowerOnMap;
    }

    /**
     * @return the isNoMoneyCaught
     */
    public boolean isNoMoneyCaught() {
        return isNoMoneyCaught;
    }

    /**
     * @param isNoMoneyCaught the isNoMoneyCaught to set
     */
    public void setNoMoneyCaught(boolean isNoMoneyCaught) {
        this.isNoMoneyCaught = isNoMoneyCaught;
    }

    /**
     * @return the isMaxLevelReached
     */
    public boolean isMaxLevelReached() {
        return isMaxLevelReached;
    }

    /**
     * @param isMaxLevelReached the isMaxLevelReached to set
     */
    public void setMaxLevelReached(boolean isMaxLevelReached) {
        this.isMaxLevelReached = isMaxLevelReached;
    }

    /**
     * @return the hoveredCellOnMap
     */
    public Cell getHoveredCellOnMap() {
        return hoveredCellOnMap;
    }

    /**
     * @param hoveredCellOnMap the hoveredCellOnMap to set
     */
    public void setHoveredCellOnMap(Cell hoveredCellOnMap) {
        this.hoveredCellOnMap = hoveredCellOnMap;
    }

}
