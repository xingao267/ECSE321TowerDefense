package Application;

import java.util.ArrayList;
import java.util.List;

import Controllers.TowerController;
import Exceptions.MaxLevelReachedException;
import Models.BomberTower;
import Models.DeceleratorTower;
import Models.LongRangeTower;
import Models.RegularTower;
import Models.SpeedTower;
import Models.Tower;
import TempModels.Critter;

/**
 * This is a driver class that test all the functionalities of the Tower models and functions
 *
 * @author Xin
 *
 */
public class Driver {

    /**
     * Runnable
     *
     * @param args
     */
    public static void main(String[] args) {

        TowerController controller = new TowerController();

        List<Tower> activeTowers = new ArrayList<Tower>();

        // Create new towers
        RegularTower regularTower = new RegularTower(0, 0, 1);
        LongRangeTower longRangeTower = new LongRangeTower(1, 1, 1);
        SpeedTower speedTower = new SpeedTower(2, 2, 1);
        BomberTower bomberTower = new BomberTower(3, 3, 1);
        DeceleratorTower deceleratorTower = new DeceleratorTower(3, 0, 1);

        // Add towers to active tower list
        activeTowers.add(regularTower);
        activeTowers.add(longRangeTower);
        activeTowers.add(speedTower);
        activeTowers.add(bomberTower);
        activeTowers.add(deceleratorTower);

        System.out.println("Creating Towers ...");
        System.out.println(regularTower.toString());
        System.out.println(longRangeTower.toString());
        System.out.println(speedTower.toString());
        System.out.println(bomberTower.toString());
        System.out.println(deceleratorTower.toString());

        System.out.println("\n-----------------------------------------------------------------------------------------");

        // Sell Tower
        System.out.println("Sell SpeedTower ...");
        int speedTowerRefund = speedTower.getRefundValue();
        // Remove the tower from the active tower list
        activeTowers.remove(speedTower);
        System.out.println("SpeedTower is sold for " + speedTowerRefund + " dollars.");

        // Bank should deduct the same amount of money

        System.out.println("\n-----------------------------------------------------------------------------------------");

        // Upgrade Tower
        for (int i = 0; i < 5; i++) {

            System.out.println("Attempt to upgrade Regular Tower ...");
            try {
                controller.upgradeTower(regularTower);
                System.out.println("Successfully upgraded tower-RegularTower to level "
                        + regularTower.getLevel() + ".");
                System.out.println(regularTower.toString());
            } catch (MaxLevelReachedException e) {
                System.out.println("Tower maximum level reached, cannot be upgraded any more.");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        // Move Tower
        System.out.println("Attempt to move Long Range Tower ...");
        int oldX = longRangeTower.getxPos();
        int oldY = longRangeTower.getyPos();
        controller.moveTower(longRangeTower, 5, 5);
        System.out.println("Long Range Tower moved from (" + oldX + "," + oldY + ") to ("
                + longRangeTower.getxPos() + "," + longRangeTower.getyPos() + ").");

        System.out.println();

        System.out.println("Attempt to move Bomber Tower ...");
        int oldX2 = bomberTower.getxPos();
        int oldY2 = bomberTower.getyPos();
        controller.moveTower(bomberTower, 2, 0);
        System.out.println("Bomber Tower moved from (" + oldX2 + "," + oldY2 + ") to ("
                + bomberTower.getxPos() + "," + bomberTower.getyPos() + ").");

        System.out.println("\n-----------------------------------------------------------------------------------------");

        // Generate critters
        List<Critter> critters = generateCritters();
        System.out.println("Critters generated...");
        printCritterGroupInfo(critters);

        System.out.println("\n-----------------------------------------------------------------------------------------");
        // Regular Tower detects critters in fire range
        System.out.println("Regular Tower detecting critters in fire range...current RegularTower fire range is: " + regularTower.getRange());
        List<Critter> detectedCritters = controller.detectTargets(regularTower, critters);
        System.out.println("Number of Critters detected: " + detectedCritters.size());

        System.out.println();

        // Regular Tower determines critters that will be inflicted damage
        System.out.println("Regular Tower determining critters that will be inflicted damage...");
        List<Critter> selectedCritters = controller.selectTargets(regularTower, detectedCritters);
        System.out.println("Number of Critters will be inflicted damage: "
                + selectedCritters.size());

        System.out.println();

        // Bomber Tower inflicts damage on critters
        System.out.println("Regular Tower  inflicts damage on closest Critter...");
        controller.attackTargets(regularTower, selectedCritters);

        printCritterGroupInfo(critters);

        System.out.println();

        // Bomber Tower detects critters in fire range
        System.out.println("Bomber Tower detecting critters in fire range...");
        detectedCritters = controller.detectTargets(bomberTower, critters);
        System.out.println("Number of Critters detected: " + detectedCritters.size());

        printCritterGroupInfo(detectedCritters);

        System.out.println();

        // Bomber Tower determines critters that will be inflicted damage
        System.out.println("Bomber Tower determining critters that will be inflicted damage...");
        selectedCritters = controller.selectTargets(bomberTower, detectedCritters);
        System.out.println("Number of Critters will be inflicted damage: "
                + selectedCritters.size());
        printCritterGroupInfo(selectedCritters);

        System.out.println();

        // Bomber Tower inflicts damage on critters
        System.out.println("Bomber Tower  inflicts damage on critters within the effect range of bomb...");
        controller.attackTargets(bomberTower, selectedCritters);

        printCritterGroupInfo(critters);

        System.out.println();

        // Decelerator Tower detects critters in fire range
        System.out.println("Decelerator Tower detecting critters in fire range...");
        detectedCritters = controller.detectTargets(deceleratorTower, critters);
        System.out.println("Number of Critters detected: " + detectedCritters.size());

        printCritterGroupInfo(detectedCritters);

        System.out.println();

        // Decelerator Tower determines critters that will be inflicted damage
        System.out.println("Decelerator Tower determining critters that will be inflicted damage...");
        selectedCritters = controller.selectTargets(deceleratorTower, detectedCritters);
        System.out.println("Number of Critters will be inflicted damage: "
                + selectedCritters.size());

        printCritterGroupInfo(selectedCritters);

        System.out.println();

        // Decelerator Tower inflicts damage on critters
        System.out.println("Decelerator Tower  inflicts damage on critters within the effect range of decelerating bomb...");
        controller.attackTargets(deceleratorTower, selectedCritters);

        printCritterGroupInfo(critters);

        System.out.println();
        // Decelerator Tower inflicts damage on critters, and doesn't slow down the critters again
        System.out.println("Decelerator Tower  inflicts damage on critters within the effect range of decelerating bomb...");
        controller.attackTargets(deceleratorTower, selectedCritters);

        printCritterGroupInfo(critters);

    }

    /**
     * Generate a group of critters
     *
     * @return
     */
    private static List<Critter> generateCritters() {

        List<Critter> critters = new ArrayList<Critter>();
        critters.add(new Critter(0, 0, 100, 50));
        critters.add(new Critter(1, 0, 100, 50));
        critters.add(new Critter(2, 0, 100, 50));
        critters.add(new Critter(3, 0, 100, 50));
        critters.add(new Critter(4, 0, 100, 50));
        critters.add(new Critter(5, 0, 100, 50));

        return critters;
    }

    /**
     * Print the Critter information in the critter group
     *
     * @param critters
     */
    private static void printCritterGroupInfo(List<Critter> critters) {

        for (Critter critter : critters) {
            System.out.println(critter.toString());
        }

    }

}
