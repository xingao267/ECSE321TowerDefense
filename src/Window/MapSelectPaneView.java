package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Map.Map;
import Map.MapLoader;
import Utility.Constants;

/**
 * 
 * @author Jose,Justin
 *
 */
public class MapSelectPaneView {

    private Rectangle easyButton, mediumButton, hardButton, createCustomMap, mainMenuButton;
    private ArrayList<Rectangle> customMaps;
    private List<String> mapList;
    private MapLoader mapLoader;
    private static boolean isCustomMapHovered;
    private static String hoveredMap;

    private static int buttonHeight = 60;
    private static int buttonWidth = 275;
    private static int buttonYOffset1 = 40;
    private static int buttonYOffset2 = 120;
    private static int buttonYOffset3 = 200;
    private static int buttonXOffset = 50;
    private static int columnOffset1 = 400;
    private static int wordXOffset1 = 150;
    private static int wordXOffset2 = 75;
    private static int wordXOffset3 = 150;
    private static int wordYOffset = 10;
    private static int stringOffset = 450;
    private static int customMapOffset = -33;

    public MapSelectPaneView() {
        mapLoader = MapLoader.getUniqueInstance();
        mapList = mapLoader.getMapList();
        customMaps = new ArrayList<Rectangle>();
        isCustomMapHovered = false;
        init();
    }

    public void init() {

        mainMenuButton =
                new Rectangle(Constants.MAIN_MENU_XPOS + 10, Constants.MAIN_MENU_YPOS,
                        2 * Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE / 2);

        easyButton =
                new Rectangle((Screen.screenWidth - buttonWidth) / 4 - buttonXOffset,
                        (Screen.screenHeight - buttonHeight) / 2 + buttonYOffset1, buttonWidth,
                        buttonHeight);

        mediumButton =
                new Rectangle((Screen.screenWidth - buttonWidth) / 4 - buttonXOffset,
                        (Screen.screenHeight - buttonHeight) / 2 + buttonYOffset2, buttonWidth,
                        buttonHeight);

        hardButton =
                new Rectangle((Screen.screenWidth - buttonWidth) / 4 - buttonXOffset,
                        (Screen.screenHeight - buttonHeight) / 2 + buttonYOffset3, buttonWidth,
                        buttonHeight);

        createCustomMap =
                new Rectangle(3 * (Screen.screenWidth - buttonWidth / 2) / 4 - buttonXOffset / 2,
                        Screen.screenHeight / 2 - buttonHeight / 4 + buttonYOffset3,
                        3 * buttonWidth / 4, buttonHeight / 2);


        for (int i = 0; i < mapList.size(); i++) {

            Rectangle r =
                    new Rectangle(3 * (Screen.screenWidth - buttonWidth / 2) / 4 - buttonXOffset
                            / 2, (Screen.screenHeight / 2 - buttonHeight / 4 + buttonYOffset3)
                            + ((i + 1) * customMapOffset), 3 * buttonWidth / 4, buttonHeight / 2);
            customMaps.add(r);
        }

    }

    public void draw(Graphics g) {

        // Draw Button to return to the main menu
        g.setColor(new Color(0, 0, 0, 160));
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
            Screen.displayEasyMap = false;
            Screen.displayMediumMap = false;
            Screen.displayHardMap = false;
            Screen.displayCustomMap = false;
            Screen.displayMapSelectorPane = false;
            Screen.crittersGenerated = false;
            Screen.levelStarted = false;
            Screen.displayMainMenu = true;
            Screen.mouseClickedReset();
        }


        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 24));
        g.drawString("Please select map you wish to play.",
                (Screen.screenWidth - stringOffset) / 2, (Screen.screenHeight - buttonHeight) / 2
                        - 4 * buttonYOffset1 / 3);

        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Pre-Made Levels",
                (Screen.screenWidth - buttonWidth) / 4 + 50 - buttonXOffset,
                (Screen.screenHeight - buttonHeight) / 2 - buttonYOffset1 / 4 + 25);
        g.drawString("Custom Maps", 3 * (Screen.screenWidth - buttonWidth) / 4 + 115,
                (Screen.screenHeight - buttonHeight) / 2 - buttonYOffset1 / 4 + 25);



        // Easy Map Button
        g.setColor(new Color(0, 0, 0, 160));
        g.fillRect(easyButton.x, easyButton.y, easyButton.width, easyButton.height);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 28));
        g.drawString("Map 1 - Easy", (Screen.screenWidth - buttonWidth + wordXOffset1) / 4
                - buttonXOffset, (Screen.screenHeight - buttonHeight + easyButton.height) / 2
                + buttonYOffset1 + wordYOffset);

        if (easyButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(easyButton.x, easyButton.y, easyButton.width, easyButton.height);
        }
        // transition to gameplay window playing Map 1
        if (easyButton.contains(Screen.mouseClicked)) {
            Screen.mouseClickedReset();
            Screen.displayMapSelectorPane = false;
            Screen.inGameplay = true;
            Screen.displayEasyMap = true;
        }


        // Medium Map Button
        g.setColor(new Color(0, 0, 0, 160));
        g.fillRect(mediumButton.x, mediumButton.y, mediumButton.width, mediumButton.height);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 28));
        g.drawString("Map 2 - Medium", (Screen.screenWidth - buttonWidth + wordXOffset2) / 4
                - buttonXOffset, (Screen.screenHeight - buttonHeight + mediumButton.height) / 2
                + buttonYOffset2 + wordYOffset);

        if (mediumButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(mediumButton.x, mediumButton.y, mediumButton.width, mediumButton.height);
        }
        // transition to gameplay window playing Map 2
        if (mediumButton.contains(Screen.mouseClicked)) {
            Screen.mouseClickedReset();
            Screen.displayMapSelectorPane = false;
            Screen.inGameplay = true;
            Screen.displayMediumMap = true;
        }


        // Hard Map Button
        g.setColor(new Color(0, 0, 0, 160));
        g.fillRect(hardButton.x, hardButton.y, hardButton.width, hardButton.height);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 28));
        g.drawString("Map 3 - Hard", (Screen.screenWidth - buttonWidth + wordXOffset3) / 4
                - buttonXOffset, (Screen.screenHeight - buttonHeight + hardButton.height) / 2
                + buttonYOffset3 + wordYOffset);

        if (hardButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(hardButton.x, hardButton.y, hardButton.width, hardButton.height);
        }
        // transition to gameplay window playing Map 3
        if (hardButton.contains(Screen.mouseClicked)) {
            Screen.mouseClickedReset();
            Screen.displayMapSelectorPane = false;
            Screen.inGameplay = true;
            Screen.displayHardMap = true;
        }


        // Create Custom Map Button
        g.setColor(new Color(0, 0, 0, 160));
        g.fillRect(createCustomMap.x, createCustomMap.y, createCustomMap.width,
                createCustomMap.height);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 16));
        g.drawString("Create Custom Map", 3 * (Screen.screenWidth - buttonWidth / 2) / 4
                - buttonXOffset / 10, (Screen.screenHeight - buttonHeight + createCustomMap.height)
                / 2 + buttonYOffset3 + 2 * wordYOffset);

        if (createCustomMap.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(createCustomMap.x, createCustomMap.y, createCustomMap.width,
                    createCustomMap.height);

        }
        // transition to map editor window
        if (createCustomMap.contains(Screen.mouseClicked)) {
            Screen.mouseClickedReset();
            Screen.displayMapSelectorPane = false;
            Screen.displayMapDesigner = true;
        }

        // TODO: Add number of buttons based on how many saved maps there are.

        for (int i = 0; i < customMaps.size(); i++) {

            if (i > 5) {
                break;
            }

            g.setColor(new Color(0, 0, 0, 160));
            g.fillRect((3 * (Screen.screenWidth - buttonWidth / 2) / 4 - buttonXOffset / 2),
                    (Screen.screenHeight / 2 - buttonHeight / 4 + buttonYOffset3)
                            + ((i + 1) * customMapOffset), 3 * buttonWidth / 4, buttonHeight / 2);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Courier New", Font.BOLD, 16));
            g.drawString(
                    mapList.get(i),
                    3 * (Screen.screenWidth - buttonWidth / 2) / 4 - buttonXOffset / 10,
                    ((Screen.screenHeight - buttonHeight + createCustomMap.height) / 2 + buttonYOffset3)
                            + ((i + 1) * customMapOffset) + 2 * wordYOffset);

            if (customMaps.get(i).contains(Screen.mouseLocation)) {
                g.setColor(new Color(255, 255, 255, 150));
                g.fillRect((3 * (Screen.screenWidth - buttonWidth / 2) / 4 - buttonXOffset / 2),
                        (Screen.screenHeight / 2 - buttonHeight / 4 + buttonYOffset3)
                                + ((i + 1) * customMapOffset), 3 * buttonWidth / 4,
                        buttonHeight / 2);
                isCustomMapHovered = true;
                hoveredMap = mapList.get(i);
            }

            if (customMaps.get(i).contains(Screen.mouseClicked)) {

                Map m;
                try {
                    m = mapLoader.loadMap(mapList.get(i));
                    Screen.displayMapSelectorPane = false;
                    Screen.setCustomMap(m);
                    Screen.inGameplay = true;
                    Screen.displayCustomMap = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Screen.mouseClickedReset();
            }

        }
    }

    public static boolean isCustomMapHovered() {
        return isCustomMapHovered;
    }

    public static String getHoveredMap() {
        return hoveredMap;
    }
}
