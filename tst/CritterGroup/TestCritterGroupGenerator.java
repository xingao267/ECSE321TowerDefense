package CritterGroup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CritterModels.Critter;
import CritterModels.CritterGroupGenerator;
import OtherModels.Bank;
import OtherModels.Cell;
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

		critterGroup = new CritterGroupGenerator(1, 0, 0);
		critters = critterGroup.getCritterGroup();

		singleTargetTower = new RegularTower(5, 5,
				Constants.INITIAL_TOWER_LEVEL);

		multiTargetsTower = new BomberTower(5, 5, Constants.INITIAL_TOWER_LEVEL);

		bank = Bank.getUniqueInstance();
		user = Player.getUniqueInstance();

	}

	@Test
	public void testGenerateGroup() {

		for (int i = 0; i < critters.size(); i++) {
			Critter c = critters.get(i);
			assertEquals(2, (long) c.getBounty());
			assertEquals(100, (long) c.getHealth());
			assertEquals(1, (long) c.getLevel());
			assertEquals((long) 0.5, (long) c.getSpeed());
			assertEquals(1, (long) c.getStrength());
			assertEquals(0, (long) c.getxPos());
			assertEquals(0, (long) c.getyPos());
		}
	}

	@Test
	public void testSpawnGroup() {

		critterGroup.spawnGroup(entryCell);
		for (int i = 0; i < critters.size(); i++) {
			assertEquals(2, (long) entryCell.getXCoord());
			assertEquals(0, (long) entryCell.getYCoord());
		}
	}

	@Test
	public void testReceiveDamage() {

		singleTargetTower.setPower(10);
		Critter critter1 = critters.get(0);
		critterGroup.receiveDamage(critter1, singleTargetTower.getPower(), 0,
				bank);
		assertEquals(90, (long) critter1.getHealth());

		critterGroup.receiveDamage(critter1, 100, 0, bank);
		assertEquals(32, (long) bank.getBalance());
	}

	@Test
	public void testMoveTo() {

		Critter critter1 = critters.get(0);

		critterGroup.moveTo(critter1, pathCell2, user);
		assertEquals(2, pathCell2.getXCoord());
		assertEquals(1, pathCell2.getYCoord());

		critterGroup.moveTo(critter1, pathCell3, user);
		assertEquals(3, pathCell3.getXCoord());
		assertEquals(1, pathCell3.getYCoord());

		critterGroup.moveTo(critter1, pathCell4, user);
		assertEquals(3, pathCell4.getXCoord());
		assertEquals(2, pathCell4.getYCoord());

		critterGroup.moveTo(critter1, pathCell5, user);
		assertEquals(3, pathCell5.getXCoord());
		assertEquals(3, pathCell5.getYCoord());

		critterGroup.moveTo(critter1, exitCell, user);
		assertEquals(3, exitCell.getXCoord());
		assertEquals(4, exitCell.getYCoord());
		assertEquals(99, (long) user.getLifePoints());
	}
}
