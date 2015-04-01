package CritterModels;

import java.util.ArrayList;

/**
 * Class which generates a group of Critters for each game level
 *
 * @author Jose
 *
 */
public class CritterGroupGenerator {

    private ArrayList<Critter> critterGroup;

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
        critterGroup = new ArrayList<Critter>();

        switch (level) {
            case 1: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 2: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 3: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 4: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 5: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter("Normal Critter", 6, 100, 2500));
                }
                break;
            }
            case 6: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 7: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 8: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level));
                }
                break;
            }
            case 9: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new ArmoredCritter(level));
                }
                break;
            }
            case 10: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter("Normal Critter", 5, 150, 20000));
                }
                break;
            }
            case 11: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 12: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 13: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level));
                }
                break;
            }
            case 14: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new RegenerativeCritter(level));
                }
                break;
            }
            case 15: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter("Speed Critter", 9, 200, 40000));
                }
                break;
            }
            case 16: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 17: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new SpeedCritter(level));
                }
                break;
            }
            case 18: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BulletProofCritter(level));
                }
                break;
            }
            case 19: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new ArmoredCritter(level));
                }
                break;
            }
            case 20: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter("BulletProof Critter", 5, 320, 100000));
                }
                break;
            }
            case 21: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 22: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 23: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 24: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 25: {
                numCritters = 1;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter("Regenerative Critter", 5, 750, 500000));
                }
                break;
            }
            case 26: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 27: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 28: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 29: {
                numCritters = 10;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new NormalCritter(level));
                }
                break;
            }
            case 30: {
                numCritters = 3;
                for (int i = 0; i < numCritters; i++) {
                    critterGroup.add(new BossCritter("Armored Critter", 5, 500, 1000000));
                }
                break;
            }
        }
    }

    /**
     * Getter for the critter group list
     * 
     * @return A list of critters spawned at the start of a level
     */
    public ArrayList<Critter> getCritterGroup() {
        return critterGroup;
    }

    /**
     * Allows user to set a list as the critter group
     * 
     * @param critterGroup
     */
    public void setCritterGroup(ArrayList<Critter> critterGroup) {
        this.critterGroup = critterGroup;
    }
}
