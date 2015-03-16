package CritterModels;

import java.util.LinkedList;
import java.util.List;

import TempModels.Bank;
import TempModels.Cell;
import TempModels.Player;


/**
 * Class which generates a group of Critters for each game level
 *
 * @author Jose
 *
 */
public class CritterGroupGenerator {

	private List<Critter> critterGroup;

	/**
	 * Constructor of the CritterGroupGenerator class
	 * 
	 * @param level
	 *            level at which the game is currently at
	 */
	public CritterGroupGenerator(int level, int initXPos, int initYPos) {
		generateGroup(level, initXPos, initYPos);
	}

	/**
	 * Generates a critter group for the constructor, based on the assigned
	 * level of the game
	 * 
	 * @param level
	 *            level at which the game is currently at
	 */
	public void generateGroup(int level, int initXPos, int initYPos) {
		int numCritters;
		critterGroup = new LinkedList<Critter>();

		switch (level) {
		case 1: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new NormalCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 2: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new NormalCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 3: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new SpeedCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 4: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new SpeedCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 5: {
			numCritters = 1;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new RegenerativeCritter(level, initXPos,
						initYPos));
			}
			break;
		}
		case 6: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new SpeedCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 7: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new RegenerativeCritter(level, initXPos,
						initYPos));
			}
			break;
		}
		case 8: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new ArmoredCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 9: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new BulletProofCritter(level, initXPos,
						initYPos));
			}
			break;
		}
		case 10: {
			numCritters = 1;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new BossCritter(0.7, 150, 2500, initXPos,
						initYPos));
			}
			break;
		}
		case 11: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new NormalCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 12: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new NormalCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 13: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new SpeedCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 14: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new SpeedCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 15: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new RegenerativeCritter(level, initXPos,
						initYPos));
			}
			break;
		}
		case 16: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new ArmoredCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 17: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new SpeedCritter(level, initXPos, initYPos));
			}
			break;
		}
		case 18: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new BulletProofCritter(level, initXPos,
						initYPos));
			}
			break;
		}
		case 19: {
			numCritters = 20;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new BulletProofCritter(level, initXPos,
						initYPos));
			}
			break;
		}
		case 20: {
			numCritters = 1;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new BossCritter(1.0, 320, 10000, initXPos,
						initYPos));
			}
			break;
		}
		case 21: {
			numCritters = 1;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new NormalCritter(level, initXPos, initYPos));
			}
			break;
		}

		case 50: {
			numCritters = 5;
			for (int i = 0; i < numCritters; i++) {
				critterGroup.add(new BossCritter(0.75, 1000, 50000, initXPos,
						initYPos));
			}
			break;
		}
		}
	}

	/**
	 * Spawns critter group one by one every second at the entry point of the
	 * path
	 * 
	 * @param entryPoint
	 *            First cell on path where critters will be spawned
	 */
	public void spawnGroup(Cell entryPoint) {
		for (int i = 0; i < critterGroup.size(); i++) {
			long lastExecutionTime = 0;
			if (System.currentTimeMillis() - lastExecutionTime >= 1000) {
				critterGroup.get(i).spawn(entryPoint);
				lastExecutionTime = System.currentTimeMillis();
			}
		}
	}

	/**
	 * When a critter is hit by a tower it will receive damage
	 * 
	 * @param c
	 *            Critter that is to receive damage
	 * @param damage
	 *            Amount of damage being inflicted on the critter
	 * @param damageType
	 *            Type of damage that critter is hit with. 0 implies regular
	 *            attacks (bullets, explosions), 1 implies special attacks
	 *            (fire, electricity)
	 */
	public void receiveDamage(Critter c, double damage, int damageType) {

		if (c instanceof ArmoredCritter)
			c.setHealth(c.getHealth() - (damage / 2));
		else if (c instanceof BulletProofCritter) {
			// each tower should have a field damageType (could be both as in
			// tesla case)
			if (damageType == 0)
				c.setHealth(c.getHealth() - (damage / 4));
			else
				c.setHealth(c.getHealth() - damage);
		} // tower cannot target GhostCritter if isVanished = true!!!
		else
			c.setHealth(c.getHealth() - damage);

		if (c.isDead()) { // critter killed
			critterGroup.remove(critterGroup.indexOf(c)); // remove critter from
															// group
			// critterGroup.remove(index); //need method that returns index of
			// critter that is being hit
			Bank.returnToBank(c.getBounty()); // returns bounty to Player's Bank
												// balance
		}
	}

	/**
	 * Determines action of based on the next cell location
	 * 
	 * @param c
	 *            Critter that is to be moved
	 * @param nextCell
	 *            Cell which critter will move to next
	 */
	public void moveTo(Critter c, Cell nextCell) {
		if (nextCell.isExitPoint()) { // need a method in Cell or Map class,
										// boolean isExitPoint()
			move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed());
			critterGroup.remove(c); // remove critter from group
			Player.lifePoints -= c.getStrength(); // reduce Player's lifePoints
													// by critters strength
		} else {
			// move critter to next cell at its speed
			move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed());
		}
	}

	/**
	 * Moves a critter at a certain speed to the next cell location
	 * 
	 * @param nextXPos
	 *            X position of the next cell
	 * @param nextYPos
	 *            Y position of the next cell
	 * @param speed
	 *            Speed at which critter will move to the next cell
	 */
	private void move(Critter c, int nextXPos, int nextYPos, double speed) {
		// physics of critter movement
		c.setxPos(nextXPos);
		c.setyPos(nextYPos);
	}

	/**
	 * Getter for the critter group list
	 * 
	 * @return A list of critters spawned at the start of a level
	 */
	public List<Critter> getCritterGroup() {
		return critterGroup;
	}

	/**
	 * Allows user to set a list as the critter group
	 * 
	 * @param critterGroup
	 */
	public void setCritterGroup(List<Critter> critterGroup) {
		this.critterGroup = critterGroup;
	}
}
