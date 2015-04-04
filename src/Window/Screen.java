package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controllers.GameController;
import CritterModels.Critter;
import CritterModels.CritterGroupGenerator;
import Exceptions.CritterDeadException;
import Map.Map;
import MapPresets.EasyMap;
import MapPresets.HardMap;
import MapPresets.MediumMap;
import OtherModels.Bank;
import OtherModels.Player;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;

/**
 * 
 * @author Jose, Justin, Xin, Eric
 *
 */
public class Screen extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;

    public Thread game = new Thread(this);

    public Frame frame;
    public MainMenuView menu;
    public MapSelectPaneView mapSelectPane;
    public MapDesignerView mapDesigner;
    public KeyHandler keyHandle;

    public static TowerRightClickMenu towerRightClickMenu;
    public static CustomMapRightClickMenu customMapRightClickMenu;
    public static IconView icons;

    public static int gameLevel;

    private static boolean isFirst = true;
    public static boolean displayMainMenu = true;
    public static boolean displayMapSelectorPane = false;
    public static boolean displayMapDesigner = false;
    public static boolean inGameplay = false;
    public static boolean displayEasyMap = false;
    public static boolean displayMediumMap = false;
    public static boolean displayHardMap = false;
    public static boolean displayCustomMap = false;
    public static boolean levelStarted = false;
    public static boolean levelEnded = false;
    public static boolean crittersGenerated = false;
    public static boolean gameRunning = true;
    public static boolean gameOver = false;
    public static boolean gameWon = false;

    public static Point mouseLocation = new Point(0, 0);
    public static Point mouseClicked = new Point(0, 0);

    public static int screenWidth;
    public static int screenHeight;
    public static long count = 0;

    public static Map map;
    private static MapView mapDisplay;
    public static ControlPanelView store;


    public ArrayList<Critter> critters;
    public static HashMap<Critter, CritterView> critterGroupDisplays;
    public static CritterGroupGenerator group;

    public static HashMap<Tower, TowerView> towerDisplays;

    private EasyMap easyMap;
    private MediumMap mediumMap;
    private HardMap hardMap;


    public Screen(Frame frame) {

        this.frame = frame;
        keyHandle = new KeyHandler();
        frame.addMouseListener(keyHandle);
        frame.addMouseMotionListener(keyHandle);
        game.start();
    }

    public void init() {

        Bank.resetUniqueInstance();
        GameController.resetUniqueInstance();
        Player.resetUniqueInstance();

        gameLevel = 0;
        menu = new MainMenuView();
        mapSelectPane = new MapSelectPaneView();
        mapDesigner = new MapDesignerView();
        store = new ControlPanelView();
        icons = new IconView();
        towerDisplays = new HashMap<Tower, TowerView>();
        critterGroupDisplays = new HashMap<Critter, CritterView>();
        easyMap = new EasyMap();
        mediumMap = new MediumMap();
        hardMap = new HardMap();

    }


    public void paintComponent(Graphics g) {

        if (isFirst) {
            screenWidth = getWidth();
            screenHeight = getHeight();
            init();
            isFirst = false;
        }

        if (displayMainMenu) {
            init();
            Image mainMenu = null;
            try {
                mainMenu = (ImageIO.read(new File(Constants.MAIN_MENU_IMAGE)));
            } catch (IOException e1) {
            }
            g.drawImage(mainMenu, -2, -2, getWidth(), getHeight(), null);
            menu.draw(g);

        } else if (displayMapSelectorPane) {
        	 Image mainMenu = null;
             try {
                 mainMenu = (ImageIO.read(new File(Constants.MAIN_MENU_IMAGE)));
             } catch (IOException e1) {
             }
             g.drawImage(mainMenu, -2, -2, getWidth(), getHeight(), null);
             mapSelectPane.draw(g);

        } else if (displayMapDesigner) {
            g.setColor(new Color(60, 60, 60));
            g.fillRect(0, 0, getWidth(), getHeight());
            mapDesigner.draw(g);

        } else if (inGameplay) {
            g.setColor(new Color(60, 60, 60));
            g.fillRect(0, 0, getWidth(), getHeight());
            store.draw(g);
            icons.draw(g);

            if (displayEasyMap) {
                map = easyMap.getEasyMap();
                mapDisplay = new MapView(map);
                mapDisplay.draw(g);
            } else if (displayMediumMap) {
                map = mediumMap.getMediumMap();
                mapDisplay = new MapView(map);
                mapDisplay.draw(g);
            } else if (displayHardMap) {
                map = hardMap.getHardMap();
                mapDisplay = new MapView(map);
                mapDisplay.draw(g);
            } else if (displayCustomMap) {
                mapDisplay = new MapView(map);
                mapDisplay.draw(g);
            }

            if (displayEasyMap || displayMediumMap || displayHardMap || displayCustomMap) {

                for (Tower tower : GameController.getUniqueInstance().getTowers()) {
                    towerDisplays.put(tower, new TowerView(tower));
                }
                for (Entry<Tower, TowerView> entry : towerDisplays.entrySet()) {
                    entry.getValue().draw(g);
                }
            }

            if (levelStarted) {
                if (!crittersGenerated) {
                    critters = new ArrayList<Critter>();
                    group = new CritterGroupGenerator(gameLevel);
                    critters = group.getCritterGroup();
                    crittersGenerated = true;
                } else {
                    // Use iterator to avoid concurrent modification exception occurred when remove
                    // element from ArrayList
                    Iterator<Critter> iterator = critters.iterator();
                    while (iterator.hasNext()) {
                        Critter critter = iterator.next();
                        if (critter.isInGame()) {
                            critterGroupDisplays.put(critter, new CritterView(critter));
                            critterGroupDisplays.get(critter).draw(g);
                        }
                        if (critter.hasReachedExit()) {
                            critterGroupDisplays.remove(critter);
                            iterator.remove(); // remove the current critter
                        }
                    }
                    if (critters.size() == 0) {
                        levelStarted = false;
                        crittersGenerated = false;
                        levelEnded = true;
                        if(gameLevel >= Constants.MAX_GAME_LEVEL){
                        	gameWon = true;
                        	gameRunning = false;
                        }
                    }
                    if(Player.getUniqueInstance().getLifePoints() <= 0){
                    	gameOver = true;
                    	gameRunning = false;
                    }
                }

                for (Tower tower : GameController.getUniqueInstance().getTowers()) {
                    List<Critter> detectedCritters =
                            GameController.getUniqueInstance().towerDetectTargets(tower, critters);
                    List<Critter> selectedCritters =
                            GameController.getUniqueInstance().towerSelectTargets(tower,
                                    detectedCritters);
                    try {
                        GameController.getUniqueInstance().towerAttackTargets(tower,
                                selectedCritters);
                    } catch (CritterDeadException e) {
                        critters.remove(e.getDeadCritter());
                        critterGroupDisplays.remove(e.getDeadCritter());
                        Bank.getUniqueInstance().returnToBank(e.getDeadCritter().getBounty());
                    }
                }
            }
        }
    }

    /** Game Loop */
    public void run() {

        Utils.playSound(Constants.GAME_START, Integer.MAX_VALUE);

        while (true) {
            while (gameRunning) {
                if (levelStarted) {
                    if (crittersGenerated) {
                        GameController.getUniqueInstance().spawnCritterGroup(map.getStart(),
                                critters);
                        for (int i = 0; i < critters.size(); i++) {
                            if (critters.get(i).isInGame() && !critters.get(i).hasReachedExit()) {
                                critters.get(i).moveAlongPath(critters.get(i).getSpeed(),
                                        Player.getUniqueInstance());
                            }
                        }
                    }
                }

                repaint();

                if (displayMapDesigner || gameOver || gameWon) {
                    gameRunning = false;
                }

                try {
                    Thread.sleep(Constants.GAME_THREAD_SLEEP_TIME);
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
                        Thread.sleep(50);
                    } catch (Exception e) {
                    }
                }
            }
            
            if(gameOver && count == 0){
            	GameController.getUniqueInstance().gameOver();
            }
            if(gameWon && count == 0){
            	GameController.getUniqueInstance().gameWon();
            }
            count++;
        }
    }

    public static void mouseClickedReset() {
        mouseClicked = new Point(0, 0);
    }
    
    public static void setCustomMap(Map m) {
        map = m;
    }
}
