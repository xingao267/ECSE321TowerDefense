package CritterModels;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import Map.Cell;
import OtherModels.Player;
import Utility.Utils;

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
     * @param level level at which the game is currently at
     */
    public CritterGroupGenerator(int level) {
        generateGroup(level);
    }

    /**
     * Generates a critter group for the constructor, based on the assigned level of the game
     * 
     * @param level level at which the game is currently at
     */
    public void generateGroup(int level) {
        int numCritters;
        critterGroup = new LinkedList<Critter>();

        switch (level) {
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
     * Determines action of based on the next cell location
     * 
     * @param c Critter that is to be moved
     * @param nextCell Cell which critter will move to next
     */
/*    public void moveTo(Critter c, Cell nextCell, Player player) {
        if (nextCell.isExitPoint()) {
            move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed());
            critterGroup.remove(c);
            player.setLifePoints(player.getLifePoints() - c.getStrength());
        } else {
            // move critter to next cell at its speed
            move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed());
        }
    }

    /**
     * Moves a critter at a certain speed to the next cell location
     * 
     * @param nextXPos X position of the next cell
     * @param nextYPos Y position of the next cell
     * @param speed Speed at which critter will move to the next cell
     */
 /*   private void move(Critter c, Cell nextCell, double speed) {
        // physics of critter movement
    	
    	Point nextScreenPoint = Utils.convertMapCoordToScreen(nextCell.getXCoordinate(), 
        		nextCell.getYCoordinate());
    	
        c.setxPos(nextCell.getXCoordinate());
        c.setyPos(nextCell.getYCoordinate());
        
        c.setScreenXPos((int) nextScreenPoint.getX());
        c.setScreenYPos((int) nextScreenPoint.getY());
    }
*/
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
