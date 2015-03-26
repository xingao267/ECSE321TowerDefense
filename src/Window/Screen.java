package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JPanel;

import Controllers.GameController;
import CritterModels.Critter;
import CritterModels.CritterGroupGenerator;
import Exceptions.CritterDeadException;
import Exceptions.InvalidTowerTypeException;
import Exceptions.NoEnoughMoneyException;
import Map.Map;
import MapPresets.EasyMap;
import MapPresets.HardMap;
import MapPresets.MediumMap;
import OtherModels.Bank;
import OtherModels.Player;
import TowerModels.Tower;
import Utility.Constants;

/**
 * 
 * @author Jose,Justin
 *
 */
public class Screen extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;

    public Thread game = new Thread(this);

    // private int fps = 10000000 , fpsFrame = 0;

    public Frame frame;

    public static Point mouseLocation = new Point(0, 0), mouseClicked = new Point(0, 0);

    public MainMenu menu;

    public MapSelectPane mapSelectPane;

    public MapDesignerDisplay mapDesigner;

    private boolean isFirst = true;
    public static boolean gameRunning = true;
    private boolean suspended = false;
    private boolean designingMap = false; // added for while loop for map designer

    public static int clear = 0;

    public int gameLevel = 1;


    public static boolean displayMainMenu = true, displayMapSelectorPane = false,
            displayMapDesigner = false, inGameplay = false, displayMap1 = false,
            displayMap2 = false, displayMap3 = false, displayCustomMap = false,
            levelStarted = false, crittersGenerated = false;

    public static int screenWidth, screenHeight;

    public GameController gameController;
    public static Player player;
    public static Bank bank;

    public static Map map;
    private static Map CustomMap;
    private static MapDisplay mapDisplay;
    public static Store store;


    public ArrayList<Critter> critters;
    public static HashMap<Critter, CritterDisplay> critterGroupDisplays;
    public static CritterGroupGenerator group;

    public static HashMap<Tower, TowerDisplay> towerDisplays;

    public static IconDisplay icons;

    public Screen(Frame frame) {
        player = Player.getUniqueInstance();
        bank = Bank.getUniqueInstance();
        gameController = GameController.getUniqueInstance();

        this.frame = frame;
        frame.addMouseListener(new KeyHandler());
        frame.addMouseMotionListener(new KeyHandler());
        game.start();
    }

    public void init() {

        menu = new MainMenu();
        mapSelectPane = new MapSelectPane();
        mapDesigner = new MapDesignerDisplay();
        store = new Store();
        icons = new IconDisplay();
        towerDisplays = new HashMap<Tower, TowerDisplay>();

        // TODO: initialize all tilesets (images) here
    }


    public void paintComponent(Graphics g) {

        if (isFirst) {
            screenWidth = getWidth();
            screenHeight = getHeight();
            init();

            isFirst = false;
        }

        g.setColor(new Color(60, 60, 60));
        g.fillRect(0, 0, getWidth(), getHeight());

        if (displayMainMenu) {
            // display the main menu
            menu.draw(g);
        }

        if (displayMapSelectorPane) {
            // display map select pane
            mapSelectPane.draw(g);
        }

        if (displayMapDesigner) {
            mapDesigner.draw(g);
        }

        if (inGameplay) {
            store.draw(g);
            icons.draw(g);

            if (displayMap1) {
                EasyMap easyMap = new EasyMap();
                map = easyMap.getEasyMap();
                mapDisplay = new MapDisplay(map);
                mapDisplay.draw(g);
            }

            if (displayMap2) {
                MediumMap mediumMap = new MediumMap();
                map = mediumMap.getMediumMap();
                mapDisplay = new MapDisplay(map);
                mapDisplay.draw(g);
            }

            if (displayMap3) {
                HardMap hardMap = new HardMap();
                map = hardMap.getHardMap();
                mapDisplay = new MapDisplay(map);
                mapDisplay.draw(g);
            }

            if (displayCustomMap) {
                mapDisplay = new MapDisplay(map);
                mapDisplay.draw(g);
            }

            if (displayMap1 || displayMap2 || displayMap3 || displayCustomMap) {

                for (Tower tower : gameController.getTowers()) {
                    towerDisplays.put(tower, new TowerDisplay(tower));
                }
                for (Entry<Tower, TowerDisplay> entry : towerDisplays.entrySet()) {
                    entry.getValue().draw(g);
                }

            }

            if (levelStarted) {
                critterGroupDisplays = new HashMap<Critter, CritterDisplay>();
                if (!crittersGenerated) {
                    critters = new ArrayList<Critter>();
                    group = new CritterGroupGenerator(gameLevel);
                    critters = group.getCritterGroup();
                    crittersGenerated = true;
                } else {
//                    for (int i = 0; i < critters.size(); i++) {
                        
                        for (Critter c : critters) {
                            if (c.isInGame()) {
                                critterGroupDisplays.put(c, new CritterDisplay(c));
                                System.out.println(critterGroupDisplays.size());
                                critterGroupDisplays.get(c).draw(g);
                            }
                            if (c.hasReachedExit()) {
                                critters.remove(c);
                                critterGroupDisplays.remove(c);
                            }
                        }
                        
//                    }
                }
                for(Tower tower: gameController.getTowers()) {
                    List<Critter> detectedCritters = gameController.towerDetectTargets(tower, critters);
                    List<Critter> selectedCritters = gameController.towerSelectTargets(tower, detectedCritters);
                    try {
                        gameController.towerAttackTargets(tower, selectedCritters);
                    } catch (CritterDeadException e) {
                        critters.remove(e.getDeadCritter());
                        critterGroupDisplays.remove(e.getDeadCritter());
                       
                    }
                }
            }
        }
    }


    /**
     * Game Loop
     */
    public void run() {
        int j = 1;
        // Game Loop
        while (gameRunning) {
            if (levelStarted) {
                if (crittersGenerated) {
                    gameController.spawnCritterGroup(map.getStart(), critters);
                    for (int i = 0; i < critters.size(); i++) {
                        if (critters.get(i).isInGame() && !critters.get(i).hasReachedExit()) {
                            critters.get(i).moveAlongPath(critters.get(i).getSpeed(), player);
                        }
                    }
                }
            }

            // bank.setBalance(30 + j);
            repaint();
            j++;



            if (displayMapDesigner) {
                gameRunning = false;
            }


            try {
                game.sleep(10);
            } catch (Exception e) {
            }

        }

        if (displayMapDesigner) {
            // userInput.start();
            // mapDesigner.createUserDefinedMap();
            mapDesigner.run();
            while (displayMapDesigner) {

                repaint();


                try {
                    game.sleep(50);
                } catch (Exception e) {
                }
            }
        }
    }


    public boolean isGameRunning() {
        return gameRunning;
    }


    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public void setMapDesigning(boolean mapDesigning) { // you added this
        this.designingMap = mapDesigning;
    }

    public static void setCustomMap(Map m) {
        map = m;
    }

    public static void mouseClickedReset() {
        mouseClicked = new Point(0, 0);
    }

}
