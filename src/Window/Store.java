package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Controllers.GameController;
import Exceptions.InvalidTowerTypeException;
import Exceptions.MaxLevelReachedException;
import OtherModels.Bank;
import TowerModels.BomberTower;
import TowerModels.DeceleratorTower;
import TowerModels.LongRangeTower;
import TowerModels.MultiTargetsTower;
import TowerModels.RegularTower;
import TowerModels.SpeedTower;
import TowerModels.Tower;
import Utility.Constants;

/**
 * 
 * @author Jose
 *
 */
public class Store {

    private static final String UP_ARROW = "\u2191";

    private Rectangle[] towers = new Rectangle[Constants.NUM_TOWERS];
    private Rectangle mainMenuButton, sendNextWaveButton;
    private ArrayList<Tower> towerType;
    private Bank bank;

    private GameController gameController;
    private HashMap<Integer, String> towerStorePosToName;

    private boolean[] towerClickable;

    public Store() {

        gameController = GameController.getUniqueInstance();
        towerStorePosToName = new HashMap<Integer, String>();

        towerStorePosToName.put(0, Constants.REGULAR_TOWER_TYPE);
        towerStorePosToName.put(1, Constants.BOMBER_TOWER_TYPE);
        towerStorePosToName.put(2, Constants.SPEED_TOWER_TYPE);
        towerStorePosToName.put(3, Constants.DECELERATOR_TOWER_TYPE);
        towerStorePosToName.put(4, Constants.LONGRANGE_TOWER_TYPE);

        towerClickable = new boolean[5];

        init();
    }

    public void init() {

        bank = Bank.getUniqueInstance();
        gameController = GameController.getUniqueInstance();

        for (int i = 0; i < towers.length; i++) {
            towers[i] =
                    new Rectangle(Constants.STORE_OFFSET
                            + (Constants.STORE_BUTTON_SIZE + Constants.STORE_SPACING) * i,
                            Constants.STORE_YPOS, Constants.STORE_BUTTON_SIZE,
                            Constants.STORE_BUTTON_SIZE);
        }

        mainMenuButton =
                new Rectangle(Constants.MAIN_MENU_XPOS, Constants.MAIN_MENU_YPOS,
                        2 * Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE / 2);

        sendNextWaveButton =
                new Rectangle(Constants.MAIN_MENU_XPOS, Constants.SEND_NEXT_WANVE_YPOS,
                        7 * Constants.STORE_BUTTON_SIZE / 3, Constants.STORE_BUTTON_SIZE / 2);

        towerType = new ArrayList<Tower>();
        towerType.add(new RegularTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
        towerType.add(new BomberTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
        towerType.add(new SpeedTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
        towerType.add(new DeceleratorTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
        towerType.add(new LongRangeTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));

    }

    public void draw(Graphics g) {

        // Draw Buttons for each purchaseable tower
        for (int i = 0; i < towers.length; i++) {

            BufferedImage img;
            try {

                img = ImageIO.read(new File(Constants.TOWER_IMAGE_SET[i]));
                g.drawImage(img, towers[i].x, towers[i].y, towers[i].width, towers[i].height, null);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // TODO: add stuff that happens when a tower is purchased on click
            if (towers[i].contains(Screen.mouseLocation)) {
                // display that player does not have enough money
                if (towerType.get(i).getInitialCost() > bank.getBalance()) {
                    g.setColor(new Color(255, 255, 255));
                    g.setFont(new Font("Courier New", Font.BOLD, 15));
                    g.drawString("You don't have enough money", 400, 30);
                    g.drawString("to buy this tower.", 400, 55);

                    g.setColor(new Color(0, 0, 0, 75));
                    g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);

                    towerClickable[i] = false;
                } else {
                    // player has enough money
                    // slightly light up the tower buttons that can be bought
                    g.setColor(new Color(255, 255, 255, 150));
                    g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);

                    // Displays tower characteristics on right side of life and money icons
                    g.setColor(new Color(255, 255, 255));
                    g.setFont(new Font("Courier New", Font.BOLD, 15));
                    g.drawString(towerType.get(i).getTowerType(), 400, 30);
                    g.setFont(new Font("Courier New", Font.BOLD, 14));
                    g.drawString("Cost: " + towerType.get(i).getInitialCost(), 575, 30);

                    g.drawString("Power: " + towerType.get(i).getDamagePerHit(), 400, 55);
                    g.drawString("Range: " + towerType.get(i).getRange(), 500, 55);
                    g.drawString("Fire Rate: " + towerType.get(i).getRateOfFire(), 400, 80);

                    if (towerType.get(i).isMultiTargets()) {
                        g.drawString("MultiTarget: Yes", 525, 80);
                    } else {
                        g.drawString("MultiTarget: No", 525, 80);
                    }

                    towerClickable[i] = true;
                }
            }

            // darkens towers when player doesn't have enough money
            if (towerType.get(i).getInitialCost() > bank.getBalance()) {
                g.setColor(new Color(0, 0, 0, 75));
                g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
            }

            if (towers[i].contains(Screen.mouseClicked)) {
                if (towerClickable[i]) {
                    gameController.setTowerSeletedInStore(true);
                    String towerTypeName = towerStorePosToName.get(i);
                    gameController.setSelectedTowerTypeInStore(towerTypeName);
                }
            }
        }

        if (gameController.isTowerSeletedInStore()) {
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Courier New", Font.BOLD, 14));
            g.drawString("Place tower on a scenery cell", 15, 85);
        }

        if (!gameController.isTowerSeletedInStore()) {
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Courier New", Font.BOLD, 14));
            g.drawString("Click tower button to buy tower.", 15, 85);
        }

        if (gameController.isTowerCellHoveredOnMap()) {

            Tower tower = gameController.getHoveredTowerOnMap();

            try {

                g.drawString(
                        "Power: " + tower.getDamagePerHit() + UP_ARROW
                                + tower.getNextLevelDamagePerHit(), 400, 55);
                g.drawString("Range: " + tower.getRange() + UP_ARROW + tower.getNextLevelRange(),
                        530, 55);

                g.drawString(
                        "Fire Rate: " + tower.getRateOfFire() + UP_ARROW
                                + tower.getNextLevelRateOfFire(), 400, 82);

                if (tower.isMultiTargets()) {
                    MultiTargetsTower multiTargettower = (MultiTargetsTower) tower;
                    g.drawString("Effect Range: " + multiTargettower.getEffectRange() + UP_ARROW
                            + multiTargettower.getNextLevelEffectRange(), 550, 82);
                }

                g.setColor(new Color(255, 255, 255));
                g.setFont(new Font("Courier New", Font.BOLD, 13));
                g.drawString(
                        tower.getTowerType() + " lv" + tower.getLevel() + UP_ARROW
                                + (tower.getLevel() + 1), 400, 30);

                g.setFont(new Font("Courier New", Font.BOLD, 13));
                g.drawString("Cost: " + tower.getUpgradeCost(), 575, 30);

            } catch (MaxLevelReachedException e) {
                g.setColor(new Color(255, 255, 255));
                g.setFont(new Font("Courier New", Font.BOLD, 13));
                g.drawString(tower.getTowerType() + " lv" + tower.getLevel(), 400, 30);

                g.drawString("Power: " + tower.getDamagePerHit(), 400, 55);
                g.drawString("Range: " + tower.getRange(), 500, 55);
                g.drawString("Fire Rate: " + tower.getRateOfFire(), 400, 80);

                if (tower.isMultiTargets()) {
                    MultiTargetsTower multiTargettower = (MultiTargetsTower) tower;
                    g.drawString("Effect Range: " + multiTargettower.getEffectRange(), 530, 80);
                }
            }
        }

        // Draw Button to return to the main menu
        g.setColor(new Color(0, 0, 0));
        g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
        g.setFont(new Font("Courier New", Font.BOLD, 14));
        g.setColor(new Color(255, 255, 255));
        g.drawString("Main Menu", mainMenuButton.x + Constants.STORE_BUTTON_SIZE / 4 + 2,
                mainMenuButton.y + Constants.STORE_BUTTON_SIZE / 4 + 4);

        if (mainMenuButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width,
                    mainMenuButton.height);
        }
        if (mainMenuButton.contains(Screen.mouseClicked)) {
            Screen.inGameplay = false;
            Screen.displayMap1 = false;
            Screen.displayMap2 = false;
            Screen.displayMap3 = false;
            Screen.displayCustomMap = false;
            Screen.displayMapSelectorPane = false;
            Screen.crittersGenerated = false;
            Screen.levelStarted = false;
            Screen.displayMainMenu = true;

            // stop everything to do with the game.
        }

        // Draw Button to send the next wave
        g.setColor(new Color(0, 0, 0));
        g.fillRect(sendNextWaveButton.x, sendNextWaveButton.y, sendNextWaveButton.width,
                sendNextWaveButton.height);
        g.setFont(new Font("Courier New", Font.BOLD, 14));
        g.setColor(new Color(255, 255, 255));
        g.drawString("Send Next Wave", sendNextWaveButton.x + Constants.STORE_BUTTON_SIZE / 4 - 10,
                sendNextWaveButton.y + Constants.STORE_BUTTON_SIZE / 4 + 5);

        // can't click send next wave button while level is in progress
        if (!Screen.levelStarted) {
            if (sendNextWaveButton.contains(Screen.mouseLocation)) {
                g.setColor(new Color(255, 255, 255, 150));
                g.fillRect(sendNextWaveButton.x, sendNextWaveButton.y, sendNextWaveButton.width,
                        sendNextWaveButton.height);
            }
            if (sendNextWaveButton.contains(Screen.mouseClicked)) {
                Screen.levelStarted = true;
                Screen.gameLevel++;
                // TODO: start movement of critter group
            }
        }
        if(Screen.gameLevel >=1){
        	g.setFont(new Font("Courier New", Font.BOLD, 20));
        	g.setColor(new Color(255, 255, 255));
        	g.drawString("Level " + Screen.gameLevel, mainMenuButton.x, sendNextWaveButton.y + 47);
        }
        
    }
}
