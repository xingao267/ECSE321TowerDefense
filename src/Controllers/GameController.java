package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import CritterModels.Critter;
import Exceptions.CritterDeadException;
import Exceptions.InvalidTowerTypeException;
import Exceptions.MaxLevelReachedException;
import Exceptions.NotEnoughMoneyException;
import Map.Cell;
import OtherModels.Bank;
import TowerModels.BomberTower;
import TowerModels.DeceleratorTower;
import TowerModels.LongRangeTower;
import TowerModels.MultiTargetsTower;
import TowerModels.RegularTower;
import TowerModels.RapidFireTower;
import TowerModels.Tower;
import Utility.Constants;
import Utility.SpringUtilities;
import Utility.Utils;
import Window.Screen;

/**
 * GameController Class
 *
 * @author Xin, Jose
 *
 */
public class GameController implements IGameController {

    private int spawnFrame = 0, spawnRate;

    /** The singleton GameController unique instance. */
    private static GameController uniqueInstance = null;

    private JFrame frame;

    /** The active tower list on the map. */
    private List<Tower> towers;

    /** The selected tower type String in the store. */
    private String selectedTowerTypeInStore;

    /** Is a tower selected in store. */
    private boolean isTowerSeletedInStore;

    /** Is a tower hovered in store. */
    private boolean isTowerHoveredInStore;

    /** Is a tower selected on map. */
    private boolean isTowerSelectedOnMap;

    /** Is a tower hovered on map. */
    private boolean isTowerCellHoveredOnMap;

    /** The hovered tower on map. */
    private Tower hoveredTowerOnMap;

    /** The selected tower to move on map. */
    private Tower selectedTowerToMove;

    /** Is NoMoneyException caught. */
    private boolean isNoMoneyCaught;

    /** Is MaxLevelException caught. */
    private boolean isMaxLevelReached;

    /** Is move tower in the right click menu clicked. */
    private boolean isTowerMoveClicked;

    /** Tower targeting strategy. */
    private ITowerTargetingStrategy towerTargetingStrategy;

    /** Constructor. */
    private GameController() {
        towers = new ArrayList<Tower>();
        isTowerSeletedInStore = false;
        isTowerSelectedOnMap = false;
        isTowerCellHoveredOnMap = false;
        isNoMoneyCaught = false;
        isMaxLevelReached = false;
        isTowerMoveClicked = false;

        setTowerTargetingStrategy(new NearestCritterToTowerStrategy());
    }

    public static synchronized GameController getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameController();
        }
        return uniqueInstance;
    }

    public static synchronized void resetUniqueInstance() {
        uniqueInstance = new GameController();
    }

    public void setTowerTargetingStrategy(ITowerTargetingStrategy strategy) {
        this.towerTargetingStrategy = strategy;
    }

    @Override
    public Tower purchaseTower(String towerType, int xPos, int yPos, int level, Cell cell)
            throws NotEnoughMoneyException, InvalidTowerTypeException {

        Tower towerToPurchase = null;

        if (towerType.equals(Constants.REGULAR_TOWER_TYPE)) {
            towerToPurchase = new RegularTower(xPos, yPos, level, cell);
        } else if (towerType.equals(Constants.BOMBER_TOWER_TYPE)) {
            towerToPurchase = new BomberTower(xPos, yPos, level, cell);
        } else if (towerType.equals(Constants.LONGRANGE_TOWER_TYPE)) {
            towerToPurchase = new LongRangeTower(xPos, yPos, level, cell);
        } else if (towerType.equals(Constants.RAPID_FIRE_TOWER_TYPE)) {
            towerToPurchase = new RapidFireTower(xPos, yPos, level, cell);
        } else if (towerType.equals(Constants.DECELERATOR_TOWER_TYPE)) {
            towerToPurchase = new DeceleratorTower(xPos, yPos, level, cell);
        } else {
            throw new InvalidTowerTypeException();
        }

        Bank.getUniqueInstance().removeFromBank(towerToPurchase.getInitialCost());
        towers.add(towerToPurchase);

        return towerToPurchase;
    }

    @Override
    public void moveTower(Tower tower, int newXPos, int newYPos) {

        tower.setxPos(newXPos);
        tower.setyPos(newYPos);
    }

    @Override
    public void upgradeTower(Tower tower) throws MaxLevelReachedException, NotEnoughMoneyException {

        if (tower.getLevel() < Constants.MAX_TOWER_LEVEL) {
            Bank.getUniqueInstance().removeFromBank(tower.getUpgradeCost());
            tower.upgrade();
        } else {
            throw new MaxLevelReachedException("Tower maximum level reached, cannot be upgraded");
        }
    }

    @Override
    public void sellTower(Tower tower) {

        if (tower != null) {
            tower.setInGame(false);
            towers.remove(tower);
            tower.getCell().setHasTower(false);
            tower.getCell().setTower(null);
            Bank.getUniqueInstance().returnToBank(tower.getRefundValue());
        }
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

        Critter targetCritter = towerTargetingStrategy.getTarget(tower, critters);

        if (targetCritter != null) {
            List<Critter> crittersSelected = new ArrayList<Critter>();

            if (tower.isMultiTargets()) {

                MultiTargetsTower multiTargetsTower = (MultiTargetsTower) tower;

                for (Critter critter : critters) {
                    double distance =
                            Utils.getDistance(targetCritter.getxPos(), targetCritter.getyPos(),
                                    critter.getxPos(), critter.getyPos());

                    // Add critters around the closest critter within the bomb
                    // effect range of the Tower
                    if (distance <= multiTargetsTower.getEffectRange()) {
                        crittersSelected.add(critter);
                    }
                }

            } else {
                crittersSelected.add(targetCritter);
            }
            return crittersSelected;
        } else {
            return null;
        }
    }

    @Override
    public synchronized void towerAttackTargets(Tower tower, List<Critter> critters)
            throws CritterDeadException {

        if (critters != null) {
            for (Critter critter : critters) {
                if (critter.isInGame()) {
                    tower.attack(critter);
                }
            }
        }
    }

    @Override
    public void spawnCritterGroup(Cell entryPoint, List<Critter> critterGroup) {

        if (critterGroup.size() != 0) {
            spawnRate = critterGroup.get(0).getSpawnRate();
        }

        if (spawnFrame >= spawnRate) {
            for (int i = 0; i < critterGroup.size(); i++) {
                if (!critterGroup.get(i).isInGame() && !critterGroup.get(i).hasReachedExit()) {
                    critterGroup.get(i).spawn(entryPoint);
                    break;
                }
            }
            spawnFrame = 0;
        } else {
            spawnFrame++;
        }
    }

    public void gameOver() {
        final String message = "GAME OVER!!!";
        JPanel userPanel = new JPanel(new SpringLayout());

        JLabel label = new JLabel(message, JLabel.CENTER);
        userPanel.add(label);
        JButton button = new JButton("Return to Main Menu");
        userPanel.add(new JLabel());
        userPanel.add(button);

        SpringUtilities.makeCompactGrid(userPanel, 3, 1, 100, 40, 7, 7);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                frame.setVisible(false);
                frame.dispose();
                Screen.displayCustomMap = false;
                Screen.displayEasyMap = false;
                Screen.displayHardMap = false;
                Screen.displayMapDesigner = false;
                Screen.displayMapSelectorPane = false;
                Screen.displayMediumMap = false;
                Screen.crittersGenerated = false;
                Screen.inGameplay = false;
                Screen.levelEnded = false;
                Screen.levelStarted = false;
                Screen.gameLevel = 0;
                Screen.count = 0;
                Screen.gameOver = false;
                Screen.gameRunning = true;
                Screen.displayMainMenu = true;
                Screen.mouseClickedReset();
            }
        });

        // Create and set up the window.
        frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        userPanel.setOpaque(true); // content panes must be opaque
        frame.setContentPane(userPanel);

        // Display the window.
        frame.pack();
        frame.setSize(350, 175);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void gameWon() {
        final String message = "Congratulations. You have won the game!!!";
        JPanel userPanel = new JPanel(new SpringLayout());

        JLabel label = new JLabel(message, JLabel.CENTER);
        userPanel.add(label);
        JButton button = new JButton("Return to Main Menu");
        userPanel.add(new JLabel());
        userPanel.add(button);

        SpringUtilities.makeCompactGrid(userPanel, 3, 1, 50, 40, 7, 7);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                frame.setVisible(false);
                frame.dispose();
                Screen.displayCustomMap = false;
                Screen.displayEasyMap = false;
                Screen.displayHardMap = false;
                Screen.displayMapDesigner = false;
                Screen.displayMapSelectorPane = false;
                Screen.displayMediumMap = false;
                Screen.crittersGenerated = false;
                Screen.inGameplay = false;
                Screen.levelEnded = false;
                Screen.levelStarted = false;
                Screen.gameLevel = 0;
                Screen.count = 0;
                Screen.gameWon = false;
                Screen.gameRunning = true;
                Screen.displayMainMenu = true;
                Screen.mouseClickedReset();
            }
        });

        // Create and set up the window.
        frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        userPanel.setOpaque(true); // content panes must be opaque
        frame.setContentPane(userPanel);

        // Display the window.
        frame.pack();
        frame.setSize(350, 175);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * @return the towers
     */
    public List<Tower> getTowers() {
        return towers;
    }

    /**
     * @param towers the towers to set
     */
    public void setTowers(List<Tower> towers) {
        this.towers = towers;
    }

    /**
     * @return the selectedTowerTypeInStore
     */
    public String getSelectedTowerTypeInStore() {
        return selectedTowerTypeInStore;
    }

    /**
     * @param selectedTowerTypeInStore the selectedTowerTypeInStore to set
     */
    public void setSelectedTowerTypeInStore(String selectedTowerTypeInStore) {
        this.selectedTowerTypeInStore = selectedTowerTypeInStore;
    }

    /**
     * @return the isTowerSeletedInStore
     */
    public boolean isTowerSeletedInStore() {
        return isTowerSeletedInStore;
    }

    /**
     * @param isTowerSeletedInStore the isTowerSeletedInStore to set
     */
    public void setTowerSeletedInStore(boolean isTowerSeletedInStore) {
        this.isTowerSeletedInStore = isTowerSeletedInStore;
    }

    /**
     * @return the isTowerSelectedOnMap
     */
    public boolean isTowerSelectedOnMap() {
        return isTowerSelectedOnMap;
    }

    /**
     * @param isTowerSelectedOnMap the isTowerSelectedOnMap to set
     */
    public void setTowerSelectedOnMap(boolean isTowerSelectedOnMap) {
        this.isTowerSelectedOnMap = isTowerSelectedOnMap;
    }

    /**
     * @return the isTowerCellHoveredOnMap
     */
    public boolean isTowerCellHoveredOnMap() {
        return isTowerCellHoveredOnMap;
    }

    /**
     * @param isTowerCellHoveredOnMap the isTowerCellHoveredOnMap to set
     */
    public void setTowerCellHoveredOnMap(boolean isTowerCellHoveredOnMap) {
        this.isTowerCellHoveredOnMap = isTowerCellHoveredOnMap;
    }

    /**
     * @return the hoveredTowerOnMap
     */
    public Tower getHoveredTowerOnMap() {
        return hoveredTowerOnMap;
    }

    /**
     * @param hoveredTowerOnMap the hoveredTowerOnMap to set
     */
    public void setHoveredTowerOnMap(Tower hoveredTowerOnMap) {
        this.hoveredTowerOnMap = hoveredTowerOnMap;
    }


    /**
     * @return the selectedTowerToMove
     */
    public Tower getSelectedTowerToMove() {
        return selectedTowerToMove;
    }

    /**
     * @param selectedTowerToMove the selectedTowerToMove to set
     */
    public void setSelectedTowerToMove(Tower selectedTowerToMove) {
        this.selectedTowerToMove = selectedTowerToMove;
    }

    /**
     * @return the isNoMoneyCaught
     */
    public boolean isNoMoneyCaught() {
        return isNoMoneyCaught;
    }

    /**
     * @param isNoMoneyCaught the isNoMoneyCaught to set
     */
    public void setNoMoneyCaught(boolean isNoMoneyCaught) {
        this.isNoMoneyCaught = isNoMoneyCaught;
    }

    /**
     * @return the isMaxLevelReached
     */
    public boolean isMaxLevelReached() {
        return isMaxLevelReached;
    }

    /**
     * @param isMaxLevelReached the isMaxLevelReached to set
     */
    public void setMaxLevelReached(boolean isMaxLevelReached) {
        this.isMaxLevelReached = isMaxLevelReached;
    }

    /**
     * @return the isTowerMoveClicked
     */
    public boolean isTowerMoveClicked() {
        return isTowerMoveClicked;
    }

    /**
     * @param isTowerMoveClicked the isTowerMoveClicked to set
     */
    public void setTowerMoveClicked(boolean isTowerMoveClicked) {
        this.isTowerMoveClicked = isTowerMoveClicked;
    }

    /**
     * @return the isTowerHoveredInStore
     */
    public boolean isTowerHoveredInStore() {
        return isTowerHoveredInStore;
    }

    /**
     * @param isTowerHoveredInStore the isTowerHoveredInStore to set
     */
    public void setTowerHoveredInStore(boolean isTowerHoveredInStore) {
        this.isTowerHoveredInStore = isTowerHoveredInStore;
    }

}
