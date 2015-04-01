package Controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CritterModels.ArmoredCritter;
import CritterModels.Critter;
import Exceptions.CritterDeadException;
import Exceptions.MaxLevelReachedException;
import Map.Cell;
import OtherModels.Bank;
import OtherModels.Player;
import TowerModels.DeceleratorTower;
import TowerModels.MultiTargetsTower;
import TowerModels.RegularTower;
import TowerModels.SingleTargetTower;
import Utility.Constants;

/**
 * Unit tests for TowerController class
 *
 * @author Xin
 *
 */
public class TestGameController {

    GameController controller;

    SingleTargetTower singleTargetTower;
    MultiTargetsTower multiTargetsTower;

    List<Critter> critterGroup;
    Critter critter1;
    Critter critter2;
    Critter critter3;
    Critter critter4;
    Critter critter5;

    Cell entryCell;

    Bank bank;
    Player user;

    @Before
    public void setup() {

        controller = GameController.getUniqueInstance();
        bank = Bank.getUniqueInstance();
        user = Player.getUniqueInstance();

        singleTargetTower = new RegularTower(5, 5, Constants.INITIAL_TOWER_LEVEL, null);

        multiTargetsTower = new DeceleratorTower(5, 5, Constants.INITIAL_TOWER_LEVEL, null);

        critter1 = new ArmoredCritter(5);
        critter2 = new ArmoredCritter(5);
        critter3 = new ArmoredCritter(5);
        critter4 = new ArmoredCritter(5);
        critter5 = new ArmoredCritter(5);

        critterGroup = new ArrayList<Critter>();

        critterGroup.add(critter1);
        critterGroup.add(critter2);
        critterGroup.add(critter3);
        critterGroup.add(critter4);
        critterGroup.add(critter5);

        entryCell = new Cell(false, 0, 0);

    }

    @Test
    public void testDetectTargets() throws Exception {

        singleTargetTower.setRange(8);

        critter1.spawn(entryCell);
        critter2.spawn(entryCell);
        critter3.spawn(entryCell);
        critter4.spawn(entryCell);
        critter4.spawn(entryCell);

        List<Critter> detectedTargets1 =
                controller.towerDetectTargets(singleTargetTower, critterGroup);
        assertEquals(5, detectedTargets1.size());

        singleTargetTower.setRange(5);
        List<Critter> detectedTargets2 =
                controller.towerDetectTargets(singleTargetTower, critterGroup);
        assertEquals(0, detectedTargets2.size());

    }

    @Test
    public void testSelectTargets() throws Exception {

        singleTargetTower.setRange(8);
        List<Critter> detectedTargets1 =
                controller.towerDetectTargets(singleTargetTower, critterGroup);
        List<Critter> selectedTargets1 =
                controller.towerSelectTargets(singleTargetTower, detectedTargets1);

        assertEquals(1, selectedTargets1.size());
        assertEquals(0, selectedTargets1.get(0).getxPos());
        assertEquals(0, selectedTargets1.get(0).getyPos());

        multiTargetsTower.setRange(10);
        multiTargetsTower.setEffectRange(1);
        List<Critter> detectedTargets2 =
                controller.towerDetectTargets(multiTargetsTower, critterGroup);
        List<Critter> selectedTargets2 =
                controller.towerSelectTargets(multiTargetsTower, detectedTargets2);

        assertEquals(5, selectedTargets2.size());

    }

    @Test
    public void testAttackTargets() throws Exception {

        List<Critter> targets = new ArrayList<Critter>();
        critter1.setInGame(true);
        targets.add(critter1);

        assertEquals(480, (long) critter1.getHealth());

        singleTargetTower.setPower(10);
        controller.towerAttackTargets(singleTargetTower, targets);
        assertEquals(475, (long) critter1.getHealth());

        multiTargetsTower.setPower(5);
        assertEquals(false, critter1.isSlowed());

        controller.towerAttackTargets(multiTargetsTower, targets);
        assertEquals(472, (long) critter1.getHealth());

        assertTrue(critter1.getSpeed() - 2.6 < 0.0000001);
        assertEquals(true, critter1.isSlowed());

        controller.towerAttackTargets(multiTargetsTower, targets);
        assertEquals(470, (long) critter1.getHealth());
        assertTrue(critter1.getSpeed() - 2.6 < 0.0000001);
        assertEquals(true, critter1.isSlowed());

    }

    @Test(expected = CritterDeadException.class)
    public void testCritterDead() throws Exception {

        List<Critter> targets = new ArrayList<Critter>();
        critter1.setInGame(true);
        targets.add(critter1);

        assertEquals(480, (long) critter1.getHealth());

        singleTargetTower.setPower(1000);
        controller.towerAttackTargets(singleTargetTower, targets);
    }

    public void testMoveTower() throws Exception {

        controller.moveTower(singleTargetTower, 30, 20);
        assertEquals(30, singleTargetTower.getxPos());
        assertEquals(20, singleTargetTower.getyPos());

    }

    @Test
    public void testUpgradeTowerWithoutReachingMaximumLevel() throws Exception {

        bank.setBalance(10000);

        assertEquals(1, multiTargetsTower.getLevel());
        assertEquals(Constants.DECELERATOR_UPGRADE_COST[2], multiTargetsTower.getUpgradeCost());
        assertEquals((long) Constants.DECELERATOR_REFUND_VALUE[1],
                (long) multiTargetsTower.getRefundValue());
        assertEquals((long) Constants.DECELERATOR_RANGE[1], (long) multiTargetsTower.getRange());
        assertEquals((long) Constants.DECELERATOR_POWER[1], (long) multiTargetsTower.getPower());
        assertEquals((long) Constants.DECELERATOR_RATE[1], (long) multiTargetsTower.getRateOfFire());
        assertEquals((long) Constants.DECELERATOR_EFFECT_RANGE[1],
                (long) multiTargetsTower.getEffectRange());

        controller.upgradeTower(multiTargetsTower);

        assertEquals(2, multiTargetsTower.getLevel());
        assertEquals(Constants.DECELERATOR_UPGRADE_COST[3], multiTargetsTower.getUpgradeCost());
        assertEquals((long) Constants.DECELERATOR_REFUND_VALUE[2],
                (long) multiTargetsTower.getRefundValue());
        assertEquals((long) Constants.DECELERATOR_RANGE[2], (long) multiTargetsTower.getRange());
        assertEquals((long) Constants.DECELERATOR_POWER[2], (long) multiTargetsTower.getPower());
        assertEquals((long) Constants.DECELERATOR_RATE[2], (long) multiTargetsTower.getRateOfFire());
        assertEquals((long) Constants.DECELERATOR_EFFECT_RANGE[2],
                (long) multiTargetsTower.getEffectRange());

        controller.upgradeTower(multiTargetsTower);

        assertEquals(3, multiTargetsTower.getLevel());
        assertEquals(Constants.DECELERATOR_UPGRADE_COST[4], multiTargetsTower.getUpgradeCost());
        assertEquals((long) Constants.DECELERATOR_REFUND_VALUE[3],
                (long) multiTargetsTower.getRefundValue());
        assertEquals((long) Constants.DECELERATOR_RANGE[3], (long) multiTargetsTower.getRange());
        assertEquals((long) Constants.DECELERATOR_POWER[3], (long) multiTargetsTower.getPower());
        assertEquals((long) Constants.DECELERATOR_RATE[3], (long) multiTargetsTower.getRateOfFire());
        assertEquals((long) Constants.DECELERATOR_EFFECT_RANGE[3],
                (long) multiTargetsTower.getEffectRange());

        controller.upgradeTower(multiTargetsTower);

        assertEquals(4, multiTargetsTower.getLevel());
        assertEquals(Constants.DECELERATOR_UPGRADE_COST[5], multiTargetsTower.getUpgradeCost());
        assertEquals((long) Constants.DECELERATOR_REFUND_VALUE[4],
                (long) multiTargetsTower.getRefundValue());
        assertEquals((long) Constants.DECELERATOR_RANGE[4], (long) multiTargetsTower.getRange());
        assertEquals((long) Constants.DECELERATOR_POWER[4], (long) multiTargetsTower.getPower());
        assertEquals((long) Constants.DECELERATOR_RATE[4], (long) multiTargetsTower.getRateOfFire());
        assertEquals((long) Constants.DECELERATOR_EFFECT_RANGE[4],
                (long) multiTargetsTower.getEffectRange());

        controller.upgradeTower(multiTargetsTower);

        assertEquals(5, multiTargetsTower.getLevel());
        assertEquals(Constants.DECELERATOR_UPGRADE_COST[6], multiTargetsTower.getUpgradeCost());
        assertEquals((long) Constants.DECELERATOR_REFUND_VALUE[5],
                (long) multiTargetsTower.getRefundValue());
        assertEquals((long) Constants.DECELERATOR_RANGE[5], (long) multiTargetsTower.getRange());
        assertEquals((long) Constants.DECELERATOR_POWER[5], (long) multiTargetsTower.getPower());
        assertEquals((long) Constants.DECELERATOR_RATE[5], (long) multiTargetsTower.getRateOfFire());
        assertEquals((long) Constants.DECELERATOR_EFFECT_RANGE[5],
                (long) multiTargetsTower.getEffectRange());

    }

    @Test(expected = MaxLevelReachedException.class)
    public void testUpgradeTowerButExceedingMaximumLevel() throws Exception {

        singleTargetTower.setLevel(Constants.MAX_TOWER_LEVEL);
        controller.upgradeTower(singleTargetTower);

    }

    @Test
    public void testSpawnGroup() {

        controller.spawnCritterGroup(entryCell, critterGroup);
        for (int i = 0; i < critterGroup.size(); i++) {
            assertEquals(0, (long) entryCell.getXCoordinate());
            assertEquals(0, (long) entryCell.getYCoordinate());
        }
    }

}
