package CritterModels;

import java.util.LinkedList;
import java.util.List;

import TempModels.Bank;
import TempModels.Cell;
import TempModels.Player;

public class CritterGroupGenerator {

    private static List<Critter> critterGroup;

    /**
     * Constructor of the CritterGroupGenerator class
     * 
     * @param level level at which the game is currently at
     */
    public CritterGroupGenerator(int level) {
        generateGroup(level);
    }

    /**
     * Generates a critter group for the constructor, based on the assigned level of the game
     * @param level level at which the game is currently at
     */
    public void generateGroup(int level) {
        int numCritters;
        critterGroup = new LinkedList<Critter>();

        switch(level) {
	        case 1: {
	            numCritters = 20;
	            for (int i = 0; i < numCritters; i++) {
	                critterGroup.add(new NormalCritter(level));
	            }
	            break;
	        }
	        case 2: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
	        case 3: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
	        case 4: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
	        case 5: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new RegenerativeCritter(level));
                }
                break;
            }
	        case 6: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
	        case 7: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new RegenerativeCritter(level));
                }
                break;
            }
	        case 8: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new ArmoredCritter(level));
                }
                break;
            }
	        case 9: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level));
                }
                break;
            }
	        case 10: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter(0.7, 150, 2500));
                }
                break;
            }
	        case 11: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
	        case 12: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
	        case 13: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
	        case 14: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 15: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new RegenerativeCritter(level));
                }
                break;
            }
            case 16: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new ArmoredCritter(level));
                }
                break;
            }
            case 17: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 18: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level));
                }
                break;
            }
            case 19: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level));
                }
                break;
            }
            case 20: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter(1.0, 320, 10000));
                }
                break;
            }
            case 21: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            
            
            case 50: {
                numCritters = 5;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter(0.75, 1000, 50000));
                }
                break;
            }
        }
    }

    
    /**
     * Spawns critter group one by one every second at the entry point of the path
     * @param entryPoint	First cell on path where critters will be spawned
     */
    public void spawnGroup(Cell entryPoint){
    	for(int i = 0; i < critterGroup.size(); i++){
    		long lastExecutionTime = 0;
    		if(System.currentTimeMillis() - lastExecutionTime >= 1000){
    			critterGroup.get(i).spawn(entryPoint);
    			lastExecutionTime = System.currentTimeMillis();
    		}
    	}
    }
    
    
    /**
     * When a critter is hit by a tower it will receive damage
     * @param c 			Critter that is to receive damage
     * @param damage 		Amount of damage being inflicted on the critter
     * @param damageType 	Type of damage that critter is hit with. 0 implies regular attacks
     *        				(bullets, explosions), 1 implies special attacks (fire, electricity)
     */
    public void receiveDamage(Critter c, int damage, int damageType) { 			// damageType: 0 = regular, 1 = special
        if (c.getType().equals("Armored Critter"))
            c.setHealthPoints(c.getHealthPoints() - (damage / 2));
        else if (c.getType().equals("BulletProof Critter")) { 					// each tower should have a field damageType (could be both as in tesla case)
            if (damageType == 0)
                c.setHealthPoints(c.getHealthPoints() - (damage / 4));
            else
                c.setHealthPoints(c.getHealthPoints() - damage);
        } 																		// tower cannot target GhostCritter if isVanished = true!!!
        else
            c.setHealthPoints(c.getHealthPoints() - damage);

        if (c.isDead()) { 														// critter killed
            critterGroup.remove(critterGroup.indexOf(c)); 						// remove critter from group
            // critterGroup.remove(index); 										//need method that returns index of critter that is being hit
            Bank.returnToBank(c.getBounty()); 									// returns bounty to Player's Bank balance
        }
    }
    
    
    /**
     * Determines action of based on the next cell location 
     * @param c			Critter that is to be moved
     * @param nextCell	Cell which critter will move to next
     */
    public void moveTo(Critter c, Cell nextCell) {								
        if (nextCell.isExitPoint()) { 											// need a method in Cell or Map class, boolean isExitPoint()
            move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed());
            critterGroup.remove(c); 											// remove critter from group
            Player.lifePoints -= c.getStrength(); 								// reduce Player's lifePoints by critters strength
        } else {
            move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed()); 	// move critter to next cell at speed
        }
    }

    
    /**
     * Moves a critter at a certain speed to the next cell location
     * @param nextXPos	X position of the next cell 
     * @param nextYPos	Y position of the next cell
     * @param speed		Speed at which critter will move to the next cell
     */
    public void move(Critter c, int nextXPos, int nextYPos, double speed) { 				// physics of movement of critter
    	c.setXPos(nextXPos);
    	c.setYPos(nextYPos);
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
