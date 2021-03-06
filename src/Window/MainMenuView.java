package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Jose
 *
 */
public class MainMenuView {

    private Rectangle startGameButton, createCustomMapButton;

    private static int buttonHeight = 55;
    private static int buttonWidth = 400;
    private static int buttonYOffset1 = 180;
    private static int buttonYOffset2 = 240;
    private static int wordXOffset1 = 200;
    private static int wordXOffset2 = 325;
    private static int wordYOffset = 10;

    public MainMenuView() {
        init();
    }

    public void init() {
        startGameButton =
                new Rectangle((Screen.screenWidth - buttonWidth) / 2,
                        (Screen.screenHeight - buttonHeight) / 2 + buttonYOffset1, buttonWidth,
                        buttonHeight);

        createCustomMapButton =
                new Rectangle((Screen.screenWidth - buttonWidth) / 2,
                        (Screen.screenHeight - buttonHeight) / 2 + buttonYOffset2, buttonWidth,
                        buttonHeight);
    }

    public void draw(Graphics g) {

        // add mouse click to change to Level Select or MapEditor Views
        g.setColor(new Color(0, 0, 0, 160));
        g.fillRect(startGameButton.x, startGameButton.y, startGameButton.width,
                startGameButton.height);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 32));
        g.drawString("Start Game", (Screen.screenWidth - wordXOffset1) / 2, (Screen.screenHeight
                - buttonHeight + startGameButton.height)
                / 2 + buttonYOffset1 + wordYOffset);

        if (startGameButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 100));
            g.fillRect(startGameButton.x, startGameButton.y, startGameButton.width,
                    startGameButton.height);
        }
        // transition to mapSelector pane
        if (startGameButton.contains(Screen.mouseClicked)) {
            Screen.mouseClickedReset();
            Screen.displayMainMenu = false;
            Screen.displayMapSelectorPane = true;
        }

        g.setColor(new Color(0, 0, 0, 160));
        g.fillRect(createCustomMapButton.x, createCustomMapButton.y, createCustomMapButton.width,
                createCustomMapButton.height);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 32));
        g.drawString("Create Custom Map", (Screen.screenWidth - wordXOffset2) / 2,
                (Screen.screenHeight - buttonHeight + createCustomMapButton.height) / 2
                        + buttonYOffset2 + wordYOffset);

        if (createCustomMapButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 100));
            g.fillRect(createCustomMapButton.x, createCustomMapButton.y,
                    createCustomMapButton.width, createCustomMapButton.height);
        }
        // transition to Map Editor window
        if (createCustomMapButton.contains(Screen.mouseClicked)) {
            Screen.mouseClickedReset();
            Screen.displayMainMenu = false;
            Screen.displayMapDesigner = true;
        }
    }

}
