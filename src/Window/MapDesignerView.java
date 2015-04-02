package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Map.Cell;
import Map.Map;
import Map.MapDesigner;
import Map.MapLoader;
import Utility.Constants;
import Utility.SpringUtilities;

/**
 * 
 * @author Jose,Justin
 *
 */
public class MapDesignerView implements Runnable {

    private JFrame frame;
    public static Thread userInput = new Thread();

    private Rectangle mainMenuButton, saveMapButton;

    private Map map;
    private MapDesigner mapDesigner;

    private String mapName;
    private int customMapWidth;
    private int customMapHeight;

    public MapView display;

    private boolean ready = false;


    public MapDesignerView() {
        init();

    }

    public void init() {

        // map = new Map(mapName, customMapWidth, customMapHeight);
        map = null;

        mainMenuButton =
                new Rectangle(Constants.MAIN_MENU_XPOS, Constants.MAIN_MENU_YPOS,
                        2 * Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE / 2);

        saveMapButton =
                new Rectangle(Constants.MAIN_MENU_XPOS, Constants.SAVE_BUTTON_YPOS,
                        2 * Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE / 2);
    }


    public void createUserDefinedMap() {
        final String[] labels = {"Map Name: ", "Map Width: ", "Map Height: "};
        int labelsLength = labels.length;
        final List<JTextField> textFields = new ArrayList<JTextField>();
        JPanel userPanel = new JPanel(new SpringLayout());

        for (int i = 0; i < labelsLength; i++) {
            JLabel label = new JLabel(labels[i], JLabel.TRAILING);
            userPanel.add(label);
            JTextField textField = new JTextField(10);
            textFields.add(textField);
            label.setLabelFor(textField);
            userPanel.add(textField);
        }

        JButton button = new JButton("OK");
        userPanel.add(new JLabel());
        userPanel.add(button);

        SpringUtilities.makeCompactGrid(userPanel, labelsLength + 1, 2, 7, 7, 7, 7);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                try {
                    for (int i = 0; i < textFields.size(); i++) {
                        String s = textFields.get(i).getText();
                        switch (i) {
                            case 0:
                                mapName = s;
                                break;
                            case 1:
                                customMapWidth = Integer.parseInt(s);
                                break;
                            case 2:
                                customMapHeight = Integer.parseInt(s);
                        }
                    }


                    frame.setVisible(false);
                    frame.dispose();

                    if (customMapWidth > 15 || customMapHeight > 9) {
                        invalidMapParameterExceptionHandler();
                    } else {
                        map = new Map(mapName, customMapWidth, customMapHeight);
                        mapDesigner = new MapDesigner(map);
                        for (int i = 0; i < customMapHeight; i++) {
                            map.addIndicator(new Cell(0, i));
                        }
                        ready = true;

                    }

                } catch (NumberFormatException e1) {
                    frame.setVisible(false);
                    frame.dispose();
                    invalidMapParameterExceptionHandler();
                }
                // Screen.setMapDesigning(true);
            }
        });

        // Create and set up the window.
        frame = new JFrame("Input Custom Map Parameters");
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

    public void draw(Graphics g) {

        // display instruction string
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Click the orange cells to create a path.", 15, 25);

        // Draw Button to return to the main menu
        g.setColor(new Color(0, 0, 0));
        g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
        g.setFont(new Font("Courier New", Font.BOLD, 14));
        g.setColor(new Color(255, 255, 255));
        g.drawString("Main Menu", mainMenuButton.x + Constants.STORE_BUTTON_SIZE / 4 + 2,
                mainMenuButton.y + Constants.STORE_BUTTON_SIZE / 4 + 4);

        if (map != null) {
            display = new MapView(map);
            display.draw(g);
            if (!display.indicator.isEmpty()) {
                for (Rectangle r : display.indicator) {
                    if (r.contains(Screen.mouseClicked)) {
                        mapDesigner.addPathNodeFromClick(Screen.mouseClicked, false);
                        Screen.mouseClickedReset();
                    }
                }
            }
        }

        // transition to main menu window
        if (mainMenuButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width,
                    mainMenuButton.height);
        }
        if (mainMenuButton.contains(Screen.mouseClicked)) {
            // resume to main menu
            Screen.displayMapDesigner = false;
            Screen.inGameplay = false;
            Screen.displayEasyMap = false;
            Screen.displayMediumMap = false;
            Screen.displayHardMap = false;
            Screen.displayCustomMap = false;
            Screen.displayMapSelectorPane = false;
            Screen.crittersGenerated = false;
            Screen.levelStarted = false;
            Screen.displayMainMenu = true;
            Screen.gameRunning = true;
            Screen.mouseClickedReset();

        }

        // Draw button to save map
        g.setColor(new Color(0, 0, 0));
        g.fillRect(saveMapButton.x, saveMapButton.y, saveMapButton.width, saveMapButton.height);
        g.setFont(new Font("Courier New", Font.BOLD, 14));
        g.setColor(new Color(255, 255, 255));
        g.drawString("Save Map", saveMapButton.x + Constants.STORE_BUTTON_SIZE / 4 + 5,
                saveMapButton.y + Constants.STORE_BUTTON_SIZE / 4 + 4);

        // saves map and transitions to map selector window
        if (saveMapButton.contains(Screen.mouseLocation)) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(saveMapButton.x, saveMapButton.y, saveMapButton.width, saveMapButton.height);
        }
        if (saveMapButton.contains(Screen.mouseClicked)) {

            try {
                Screen.displayMapDesigner = false;
                Screen.displayMainMenu = true;

                MapLoader mapLoader = MapLoader.getUniqueInstance();

                mapDesigner.endMap();
                if (map.validPath()) {
                    map.clearIndicators();
                    mapLoader.saveMap(map, mapName);

                    Screen.displayMapDesigner = false;
                    Screen.inGameplay = false;
                    Screen.displayEasyMap = false;
                    Screen.displayMediumMap = false;
                    Screen.displayHardMap = false;
                    Screen.displayCustomMap = false;
                    Screen.displayMapSelectorPane = false;
                    Screen.crittersGenerated = false;
                    Screen.levelStarted = false;
                    Screen.displayMainMenu = true;
                    Screen.gameRunning = true;

                }

                Screen.mouseClickedReset();
                stop();

            } catch (Exception e) {
                // Create new map
                invalidMapConfigExceptionHandler();
                Screen.displayMapDesigner = false;
                Screen.inGameplay = false;
                Screen.displayEasyMap = false;
                Screen.displayMediumMap = false;
                Screen.displayHardMap = false;
                Screen.displayCustomMap = false;
                Screen.displayMapSelectorPane = false;
                Screen.crittersGenerated = false;
                Screen.levelStarted = false;
                Screen.displayMainMenu = true;
                Screen.gameRunning = true;

            }
        }
    }

    private void invalidMapConfigExceptionHandler() {
        final String message = "This is not a valid map. Please try again";
        JPanel userPanel = new JPanel(new SpringLayout());

        JLabel label = new JLabel(message, JLabel.TRAILING);
        userPanel.add(label);
        JButton button = new JButton("OK");
        userPanel.add(new JLabel());
        userPanel.add(button);

        SpringUtilities.makeCompactGrid(userPanel, 3, 1, 60, 40, 7, 7);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                frame.setVisible(false);
                frame.dispose();
            }
        });

        // Create and set up the window.
        frame = new JFrame("InvalidMapConfigError");
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

    private void invalidMapParameterExceptionHandler() {
        final String message = "The values you entered are invalid. Please try again";
        JPanel userPanel = new JPanel(new SpringLayout());


        JLabel label = new JLabel(message, JLabel.TRAILING);
        userPanel.add(label);
        JButton button = new JButton("OK");
        userPanel.add(new JLabel());
        userPanel.add(button);

        SpringUtilities.makeCompactGrid(userPanel, 3, 1, 20, 40, 7, 7);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                mapName = "error";
                customMapHeight = 3;
                customMapWidth = 3;
                frame.setVisible(false);
                frame.dispose();
                createUserDefinedMap();

            }
        });

        // Create and set up the window.
        frame = new JFrame("InvalidMapParameterError");
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

    @Override
    public void run() {
        createUserDefinedMap();
        while (!ready) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        userInput = null;
    }
}
