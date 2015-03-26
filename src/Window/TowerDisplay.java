/**
 * 
 */
package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import Exceptions.InvalidTowerTypeException;
import TowerModels.BomberTower;
import TowerModels.DeceleratorTower;
import TowerModels.ITowerObserver;
import TowerModels.LongRangeTower;
import TowerModels.RegularTower;
import TowerModels.SpeedTower;
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

            BufferedImage img;
            try {

                if (this.tower.getTowerType().equals(Constants.REGULAR_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.REGULAR_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.BOMBER_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.BOMBER_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.LONGRANGE_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.LONGRANGE_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.SPEED_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.SPEED_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.DECELERATOR_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.DECELERATOR_TOWER_IMAGE));
                } else {
                    throw new InvalidTowerTypeException();
                }

                g.drawImage(img, towerDisplay.x, towerDisplay.y, towerDisplay.width,
                        towerDisplay.height, null);

            } catch (IOException | InvalidTowerTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
