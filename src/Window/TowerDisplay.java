/**
 * 
 */
package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import TowerModels.ITowerObserver;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;



/**
 * @author Xin
 *
 */
public class TowerDisplay implements ITowerObserver {

    public Rectangle towerDisplay;

    public Tower tower;

    public TowerDisplay(Tower tower) {

        this.tower = tower;
        Point towerScreenCoord = Utils.convertMapCoordToScreen(tower.getxPos(), tower.getyPos());
        towerDisplay =
                new Rectangle(towerScreenCoord.x, towerScreenCoord.y, Constants.STORE_BUTTON_SIZE,
                        Constants.STORE_BUTTON_SIZE);

    }

    public void draw(Graphics g) {
        if (tower.isInGame()) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(towerDisplay.x, towerDisplay.y, towerDisplay.width, towerDisplay.height);
            System.out.println("Tower placed at: " + "(" + towerDisplay.x + "," + towerDisplay.y
                    + ")");
        }
    }

    @Override
    public void update() {

        Point towerScreenCoord = Utils.convertMapCoordToScreen(tower.getxPos(), tower.getyPos());
        towerDisplay =
                new Rectangle(towerScreenCoord.x, towerScreenCoord.y, Constants.STORE_BUTTON_SIZE,
                        Constants.STORE_BUTTON_SIZE);

    }

    /**
     * @return the tower
     */
    public Tower getTower() {
        return tower;
    }

    /**
     * @param tower the tower to set
     */
    public void setTower(Tower tower) {
        this.tower = tower;
    }

}
