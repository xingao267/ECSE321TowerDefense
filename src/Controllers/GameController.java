package Controllers;

import java.util.ArrayList;
import java.util.List;

import CritterModels.Critter;
import CritterModels.CritterGroupGenerator;
import Exceptions.CritterDeadException;
import Exceptions.InvalidTowerTypeException;
import Exceptions.MaxLevelReachedException;
import Exceptions.NoEnoughMoneyException;
import OtherModels.Bank;
import Map.Cell;
import TowerModels.BomberTower;
import TowerModels.DeceleratorTower;
import TowerModels.LongRangeTower;
import TowerModels.MultiTargetsTower;
import TowerModels.RegularTower;
import TowerModels.SpeedTower;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;
import Window.CritterDisplay;
import Window.Screen;

/**
 * TowerController Class
 *
 * @author Xin
 *
 */
public class GameController implements IGameController {


    private int spawnTime = 1000, spawnFrame = 0;

    @Override
    public Tower purchaseTower(String towerType, int xPos, int yPos, int level, Bank bank)
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
        return towerToPurchase;
    }

    @Override
    public void moveTower(Tower tower, int newXPos, int newYPos) {

        tower.setxPos(newXPos);
        tower.setyPos(newYPos);
    }

    @Override
    public void upgradeTower(Tower tower, Bank bank) throws MaxLevelReachedException,
            NoEnoughMoneyException {

        if (tower.getLevel() < Constants.MAX_TOWER_LEVEL) {
            tower.upgrade();
            bank.removeFromBank(tower.getUpgradeCost());
        } else {
            throw new MaxLevelReachedException("Tower maximum level reached, cannot be upgraded");
        }
    }

    @Override
    public void sellTower(Tower tower, Bank bank) {

        bank.returnToBank(tower.getRefundValue());

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
    }

    @Override
    public void towerAttackTargets(Tower tower, List<Critter> critters, Bank bank)
            throws CritterDeadException {

        for (Critter critter : critters) {
            tower.attack(critter);
            bank.returnToBank(critter.getBounty());
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

    @Override
    public void spawnCritterGroup(Cell entryPoint, CritterGroupGenerator group) {
        List<Critter> critterGroup = group.getCritterGroup();

        if (spawnFrame >= spawnTime) {
            for (int i = 0; i < critterGroup.size(); i++) {
                if (!critterGroup.get(i).isInGame()) {
                    critterGroup.get(i).spawn(entryPoint);
                    Screen.critterGroupDisplay.add(new CritterDisplay(critterGroup.get(i)));
                    break;
                }
            }
            spawnFrame = 0;
        } else {
            spawnFrame++;
        }

        /*
         * for (int i = 0; i < critterGroup.size(); i++) { long lastExecutionTime = 0; if
         * (System.currentTimeMillis() - lastExecutionTime >= 1000) {
         * critterGroup.get(i).spawn(entryPoint); lastExecutionTime = System.currentTimeMillis(); }
         * }
         */}

}
