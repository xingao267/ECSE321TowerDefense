package CritterModels;

import java.util.LinkedList;
import java.util.List;

import OtherModels.Cell;
import OtherModels.Player;

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
    public CritterGroupGenerator(int level, int initXPos, int initYPos) {
        generateGroup(level, initXPos, initYPos);
    }

    /**
     * Generates a critter group for the constructor, based on the assigned level of the game
     * 
     * @param level level at which the game is currently at
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
                    critterGroup.add(new RegenerativeCritter(level, initXPos, initYPos));
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
                    critterGroup.add(new RegenerativeCritter(level, initXPos, initYPos));
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
                    critterGroup.add(new BulletProofCritter(level, initXPos, initYPos));
                }
                break;
            }
            case 10: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter(0.7, 150, 2500, initXPos, initYPos));
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
                    critterGroup.add(new RegenerativeCritter(level, initXPos, initYPos));
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
                    critterGroup.add(new BulletProofCritter(level, initXPos, initYPos));
                }
                break;
            }
            case 19: {
                numCritters = 20;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level, initXPos, initYPos));
                }
                break;
            }
            case 20: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter(1.0, 320, 10000, initXPos, initYPos));
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
                    critterGroup.add(new BossCritter(0.75, 1000, 50000, initXPos, initYPos));
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
    public void moveTo(Critter c, Cell nextCell, Player player) {
        if (nextCell.isExitPoint()) { // need a method in Cell or Map class,
                                      // boolean isExitPoint()
            move(c, nextCell.getXCoord(), nextCell.getYCoord(), c.getSpeed());
            critterGroup.remove(c); // remove critter from group
            player.setLifePoints(player.getLifePoints() - c.getStrength()); // reduce
                                                                            // Player's
                                                                            // lifePoints
            // by critters strength
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
