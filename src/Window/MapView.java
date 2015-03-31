package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
public class MapView {

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
    private BufferedImage sceneryCell;

    /**
     * Constructor
     * 
     * @param m
     */
    public MapView(Map m) {

        this.m = m;
        mapWidth = m.getWidth();
        mapHeight = m.getHeight();
        scenery = new ArrayList<Rectangle>();
        path = new ArrayList<Rectangle>();
        indicator = new ArrayList<Rectangle>();
        cells = new ArrayList<Rectangle>();
        try {
            this.sceneryCell = ImageIO.read(new File(Constants.SCENERY_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                        new Rectangle(Constants.MAP_INITIAL_XPOS
                                + (Constants.STORE_BUTTON_SIZE * i), Constants.MAP_INITIAL_YPOS
                                + Constants.STORE_BUTTON_SIZE * j, Constants.STORE_BUTTON_SIZE,
                                Constants.STORE_BUTTON_SIZE);
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

            g.drawImage(sceneryCell, r.x, r.y, r.width, r.height, null);
            // g.setColor(new Color(148, 204, 142)); // Green
            // g.fillRect(r.x, r.y, r.width, r.height);

            if (r.contains(Screen.mouseLocation)) {
                // slightly darken the scenery
                g.setColor(new Color(38, 59, 44, 150));
                g.fillRect(r.x, r.y, r.width, r.height);

                if (cell.hasTower()) {
                    GameController.getUniqueInstance().setTowerCellHoveredOnMap(true);
                    GameController.getUniqueInstance().setHoveredTowerOnMap(cell.getTower());
                } else {
                    GameController.getUniqueInstance().setTowerCellHoveredOnMap(false);
                    GameController.getUniqueInstance().setMaxLevelReached(false);
                    GameController.getUniqueInstance().setNoMoneyCaught(false);
                }
            }

            if (r.contains(Screen.mouseClicked)) {

                if (cell.hasTower()) {
                    GameController.getUniqueInstance().setTowerSelectedOnMap(true);

                } else if (GameController.getUniqueInstance().isTowerSeletedInStore()) {

                    String towerType =
                            GameController.getUniqueInstance().getSelectedTowerTypeInStore();
                    try {
                        Tower tower =
                                GameController.getUniqueInstance().purchaseTower(towerType,
                                        mapPosition.x, mapPosition.y,
                                        Constants.INITIAL_TOWER_LEVEL, cell);
                        cell.setTower(tower);
                        cell.setHasTower(true);
                        Utils.playSound(Constants.CONSTRUCTION, 0);
                    } catch (NoEnoughMoneyException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvalidTowerTypeException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    GameController.getUniqueInstance().setTowerSeletedInStore(false);

                } else if (GameController.getUniqueInstance().isTowerMoveClicked()) {
                    Tower towerToMove = GameController.getUniqueInstance().getSelectedTowerToMove();

                    Cell oldCell = towerToMove.getCell();
                    oldCell.setTower(null);
                    oldCell.setHasTower(false);

                    GameController.getUniqueInstance().moveTower(towerToMove, mapPosition.x,
                            mapPosition.y);
                    cell.setTower(towerToMove);
                    cell.setHasTower(true);
                    towerToMove.setCell(cell);
                    GameController.getUniqueInstance().setTowerMoveClicked(false);

                    Utils.playSound(Constants.CONSTRUCTION, 0);
                }
                Screen.mouseClickedReset();
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

                GameController.getUniqueInstance().setTowerCellHoveredOnMap(false);
            }
            if (r.contains(Screen.mouseClicked)) {
                if (GameController.getUniqueInstance().isTowerSeletedInStore()) {
                    GameController.getUniqueInstance().setTowerSeletedInStore(false);
                }
                Screen.mouseClickedReset();
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
