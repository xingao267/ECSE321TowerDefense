package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import Controllers.GameController;
import Exceptions.InvalidTowerTypeException;
import Exceptions.NoEnoughMoneyException;
import Map.Cell;
import Map.Map;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;

/**
 * This class displays the maps
 * 
 * @author Justin
 *
 */
public class MapDisplay {

    private static ArrayList<Rectangle> scenery;
    private static ArrayList<Rectangle> path;
    public ArrayList<Rectangle> indicator;
    private ArrayList<Rectangle> cells;
    private Map m;
    private int mapWidth;
    private int mapHeight;
    public static ArrayList<Integer> offsets;
    public static int initialMapXPos = Constants.MAP_INITIAL_XPOS,
            initialMapYPos = Constants.MAP_INITIAL_YPOS;

    private GameController gameController;

    /**
     * Constructor
     * 
     * @param m
     */
    public MapDisplay(Map m) {

        gameController = GameController.getUniqueInstance();
        this.m = m;
        mapWidth = m.getWidth();
        mapHeight = m.getHeight();
        scenery = new ArrayList<Rectangle>();
        path = new ArrayList<Rectangle>();
        indicator = new ArrayList<Rectangle>();
        cells = new ArrayList<Rectangle>();
        init();
    }

    /**
     * Initialise the necessary rectangles
     */
    public void init() {

        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {

                boolean foundInd = false;
                Rectangle r =
                        new Rectangle(Constants.MAP_INITIAL_XPOS + (Constants.STORE_BUTTON_SIZE * i), 
                        		Constants.MAP_INITIAL_YPOS + Constants.STORE_BUTTON_SIZE * j,
                        		Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);
                if (m.noIndicators()) {
                    if (m.getCell(i, j).isScenery()) {
                        scenery.add(r);
                    } else {
                        path.add(r);
                    }
                } else {
                    for (int k = 0; k < m.numIndicators(); k++) {
                        if (m.getIndicator(k).getXCoordinate() == i
                                && m.getIndicator(k).getYCoordinate() == j) {
                            indicator.add(r);
                            foundInd = true;
                            break;
                        }
                    }
                    if (!foundInd) {
                        if (m.getCell(i, j).isScenery()) {
                            scenery.add(r);
                        } else {
                            path.add(r);
                        }
                    }
                }
                cells.add(r);
            }
        }
    }

    /**
     * Draw the screen
     * 
     * @param g
     */
    public void draw(Graphics g) {

        // Draw the scenery
        for (Rectangle r : scenery) {

            Point mapPosition = Utils.convertScreenToMapCoord(r.getLocation());
            Cell cell = m.getCell(mapPosition.x, mapPosition.y);

            g.setColor(new Color(148, 204, 142)); // Green
            g.fillRect(r.x, r.y, r.width, r.height);

            if (r.contains(Screen.mouseLocation)) {
                // slightly darken the scenery
                g.setColor(new Color(38, 59, 44, 150));
                g.fillRect(r.x, r.y, r.width, r.height);

                if (cell.hasTower()) {
                    gameController.setTowerCellHoveredOnMap(true);
                    gameController.setHoveredTowerOnMap(cell.getTower());
                    gameController.setHoveredCellOnMap(cell);
                } else {
                    gameController.setTowerCellHoveredOnMap(false);

                    gameController.setMaxLevelReached(false);
                    gameController.setNoMoneyCaught(false);
                }
            }

            if (r.contains(Screen.mouseClicked)) {

                if (cell.hasTower()) {
                    gameController.setTowerSelectedOnMap(true);
                    gameController.setSelectedTowerOnMap(cell.getTower());

                } else if (gameController.isTowerSeletedInStore()) {

                    String towerType = gameController.getSelectedTowerTypeInStore();
                    try {
                        Tower tower =
                                gameController.purchaseTower(towerType, mapPosition.x,
                                        mapPosition.y, Constants.INITIAL_TOWER_LEVEL);
                        cell.setTower(tower);
                        cell.setHasTower(true);
                    } catch (NoEnoughMoneyException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvalidTowerTypeException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    gameController.setTowerSeletedInStore(false);

                }
            }
        }

        // Draw the path
        for (Rectangle r : path) {

            g.setColor(new Color(88, 38, 15)); // Brown
            g.fillRect(r.x, r.y, r.width, r.height);

            if (r.contains(Screen.mouseLocation)) {
                // slightly darken the path
                g.setColor(new Color(73, 16, 9, 150));
                g.fillRect(r.x, r.y, r.width, r.height);

                gameController.setTowerCellHoveredOnMap(false);
            }
            if (r.contains(Screen.mouseClicked)) {
                if (gameController.isTowerSeletedInStore()) {
                    gameController.setTowerSeletedInStore(false);
                }
            }

        }
        // Draw Indicators
        for (Rectangle r : indicator) {

            g.setColor(new Color(255, 153, 51)); // Orange
            g.fillRect(r.x, r.y, r.width, r.height);

            if (r.contains(Screen.mouseLocation)) {
                // slightly darken the orange
                g.setColor(new Color(255, 128, 0, 150));
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }
    }
}
