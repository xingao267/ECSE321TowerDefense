/**
 * 
 */
package Window;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import CritterModels.Critter;
import Exceptions.InvalidTowerTypeException;
import TowerModels.ITowerObserver;
import TowerModels.Tower;
import Utility.Constants;
import Utility.Utils;

/**
 * @author Xin, Justin
 *
 */
public class TowerView implements ITowerObserver {

    private Rectangle towerDisplay;

    private Tower tower;

    public TowerView(Tower tower) {

        this.tower = tower;
        Point towerScreenCoord = Utils.convertMapCoordToScreen(tower.getxPos(), tower.getyPos());
        towerDisplay =
                new Rectangle(towerScreenCoord.x, towerScreenCoord.y, Constants.STORE_BUTTON_SIZE,
                        Constants.STORE_BUTTON_SIZE);

    }

    public void draw(Graphics g) {
        if (tower.isInGame()) {

            BufferedImage img = null;
            BufferedImage sheetImg = null;
            try {

                if (this.tower.getTowerType().equals(Constants.REGULAR_TOWER_TYPE)) {
                    
                	
                    sheetImg = ImageIO.read(new File(Constants.REGULAR_TOWER_SHEET));
                   	img = sheetImg.getSubimage(100*0+20,100*0+20,60,60);
                    
                    if(this.tower.isAttacking()){
                    	Critter critter = this.tower.getAttackedCritter();
                    	double angle =  Utils.getAngle(this.tower.getxPos(), this.tower.getyPos(),
                    									critter.getScreenXPos(), critter.getScreenYPos());  
                    	
                    if( angle >= 0 && angle < 10){
                    	img = sheetImg.getSubimage(100*0+20,100*0+20,60,60);
                    }else if( angle >= 10 && angle < 20){
                    	img = sheetImg.getSubimage(100*0+20,100*2+20,60,60);
                    }
                    else if( angle >= 20 && angle < 30){
                    	img = sheetImg.getSubimage(100*5+20,100*3+20,60,60);
                    }
                    else if( angle >= 30 && angle < 40){
                    	img = sheetImg.getSubimage(100*0+20,100*5+20,60,60);
                    }
                    else if( angle >= 40 && angle < 50){
                    	img = sheetImg.getSubimage(100*1+20,100*5+20,60,60);
                    }
                    else if( angle >= 50 && angle < 60){
                    	img = sheetImg.getSubimage(100*2+20,100*5+20,60,60);
                    }
                    else if( angle >= 60 && angle < 70){
                    	img = sheetImg.getSubimage(100*3+20,100*5+20,60,60);
                    }
                    else if( angle >= 70 && angle < 80){
                    	img = sheetImg.getSubimage(100*4+20,100*5+20,60,60);
                    }
                    else if( angle >= 80 && angle < 90){
                    	img = sheetImg.getSubimage(100*5+20,100*5+20,60,60);
                    }
                    else if( angle >= 90 && angle < 100){
                    	img = sheetImg.getSubimage(100*2+20,100*0+20,60,60);
                    }
                    else if( angle >= 100 && angle < 120){
                    	img = sheetImg.getSubimage(100*3+20,100*0+20,60,60);
                    }
                    else if( angle >= 120 && angle < 130){
                    	img = sheetImg.getSubimage(100*4+20,100*0+20,60,60);
                    }
                    else if( angle >= 130 && angle < 140){
                    	img = sheetImg.getSubimage(100*5+20,100*0+20,60,60);
                    }
                    else if( angle >= 140 && angle < 150){
                    	img = sheetImg.getSubimage(100*0+20,100*1+20,60,60);
                    }
                    else if( angle >= 150 && angle < 160){
                    	img = sheetImg.getSubimage(100*1+20,100*1+20,60,60);
                    }
                    else if( angle >= 160 && angle < 170){
                    	img = sheetImg.getSubimage(100*2+20,100*1+20,60,60);
                    }
                    else if( angle >= 170 && angle < 180){
                    	img = sheetImg.getSubimage(100*3+20,100*1+20,60,60);
                    }
                    else if( angle >= 180 && angle < 190){
                    	img = sheetImg.getSubimage(100*4+20,100*1+20,60,60);
                    }
                    else if( angle >= 190 && angle < 200){
                    	img = sheetImg.getSubimage(100*5+20,100*1+20,60,60);
                    }
                    else if( angle >= 200 && angle < 210){
                    	img = sheetImg.getSubimage(100*1+20,100*2+20,60,60);
                    }
                    else if( angle >= 210 && angle < 220){
                    	img = sheetImg.getSubimage(100*2+20,100*2+20,60,60);
                    }
                    else if( angle >= 220 && angle < 230){
                    	img = sheetImg.getSubimage(100*3+20,100*2+20,60,60);
                    }
                    else if( angle >= 230 && angle < 240){
                    	img = sheetImg.getSubimage(100*4+20,100*2+20,60,60);
                    }
                    else if( angle >= 240 && angle < 250){
                    	img = sheetImg.getSubimage(100*5+20,100*2+20,60,60);
                    }
                    else if( angle >= 250 && angle < 260){
                    	img = sheetImg.getSubimage(100*0+20,100*3+20,60,60);
                    }
                    else if( angle >= 260 && angle < 270){
                    	img = sheetImg.getSubimage(100*1+20,100*3+20,60,60);
                    }
                    else if( angle >= 270 && angle < 280){
                    	img = sheetImg.getSubimage(100*2+20,100*3+20,60,60);
                    }
                    else if( angle >= 280 && angle < 290){
                    	img = sheetImg.getSubimage(100*3+20,100*3+20,60,60);
                    }
                    else if( angle >= 290 && angle < 300){
                    	img = sheetImg.getSubimage(100*4+20,100*3+20,60,60);
                    }
                    else if( angle >= 300 && angle < 310){
                    	img = sheetImg.getSubimage(100*0+20,100*4+20,60,60);
                    }
                    else if( angle >= 310 && angle < 320){
                    	img = sheetImg.getSubimage(100*1+20,100*4+20,60,60);
                    }
                    else if( angle >= 320 && angle < 330){
                    	img = sheetImg.getSubimage(100*2+20,100*4+20,60,60);
                    }
                    else if( angle >= 330 && angle < 340){
                    	img = sheetImg.getSubimage(100*3+20,100*4+20,60,60);
                    }
                    else if( angle >= 340 && angle < 350){
                    	img = sheetImg.getSubimage(100*4+20,100*4+20,60,60);
                    }
                    else{
                    	img = sheetImg.getSubimage(100*5+20,100*4+20,60,60);
                    }
                    	
                }
                    
                } else if (this.tower.getTowerType().equals(Constants.BOMBER_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.BOMBER_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.LONGRANGE_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.LONGRANGE_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.RAPID_FIRE_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.RAPID_FIRE_TOWER_IMAGE));
                } else if (this.tower.getTowerType().equals(Constants.DECELERATOR_TOWER_TYPE)) {
                    img = ImageIO.read(new File(Constants.DECELERATOR_TOWER_IMAGE));
                } else {
                    throw new InvalidTowerTypeException();
                }

                g.drawImage(img, towerDisplay.x, towerDisplay.y, towerDisplay.width,
                        towerDisplay.height, null);

            } catch (IOException | InvalidTowerTypeException e) {
                // shouldn't be hit
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
