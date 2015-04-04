package CritterGroup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CritterModels.Critter;
import CritterModels.CritterGroupGenerator;
import Map.Cell;
import OtherModels.Bank;
import OtherModels.Player;
import TowerModels.BomberTower;
import TowerModels.MultiTargetsTower;
import TowerModels.RegularTower;
import TowerModels.SingleTargetTower;
import Utility.Constants;

/**
 * Unit tests for CritterGroupGenerator class
 *
 * @author Jose
 *
 */
public class TestCritterGroupGenerator {

    CritterGroupGenerator critterGroup;
    List<Critter> critters;

    List<Cell> path;

    Cell entryCell;
    Cell pathCell2;
    Cell pathCell3;
    Cell pathCell4;
    Cell pathCell5;
    Cell exitCell;

    SingleTargetTower singleTargetTower;
    MultiTargetsTower multiTargetsTower;

    Bank bank;
    Player user;

    @Before
    public void setUp() throws Exception {

        path = new ArrayList<Cell>();

        entryCell = new Cell(2, 0);
        pathCell2 = new Cell(2, 1);
        pathCell3 = new Cell(3, 1);
        pathCell4 = new Cell(3, 2);
        pathCell5 = new Cell(3, 3);
        exitCell = new Cell(3, 4);

        path.add(entryCell);
        path.add(pathCell2);
        path.add(pathCell3);
        path.add(pathCell4);
        path.add(pathCell5);
        path.add(exitCell);

        critterGroup = new CritterGroupGenerator(1);
        critters = critterGroup.getCritterGroup();

        singleTargetTower = new RegularTower(5, 5, Constants.INITIAL_TOWER_LEVEL, null);

        multiTargetsTower = new BomberTower(5, 5, Constants.INITIAL_TOWER_LEVEL, null);

        bank = Bank.getUniqueInstance();
        user = Player.getUniqueInstance();

    }

    @Test
    public void testGenerateGroup() {

        for (int i = 0; i < critters.size(); i++) {
            Critter c = critters.get(i);
            assertEquals(4, (long) c.getBounty());
            assertEquals(80, (long) c.getHealth());
            assertEquals(1, (long) c.getLevel());
            assertEquals((long) 6, (long) c.getSpeed());
            assertEquals(2, (long) c.getStrength());
            assertEquals(0, (long) c.getxPos());
            assertEquals(0, (long) c.getyPos());
        }
    }
}
