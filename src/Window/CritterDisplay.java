package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import CritterModels.Critter;
import Utility.Constants;
import Utility.Utils;

public class CritterDisplay {

	private Rectangle critterDisplay, healthBar;
	private Critter critter;
	private int healthBarSpacing = 3, healthBarHeight = Constants.STORE_BUTTON_SIZE/10;
	private double maxCritterHealth;
	
	public CritterDisplay(Critter critter){
		
		this.critter = critter;
		
		maxCritterHealth = critter.getMaxHealth();
		
		critterDisplay = new Rectangle(critter.getScreenXPos(), critter.getScreenYPos(),
				Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);

		healthBar = new Rectangle(critter.getScreenXPos(), critter.getScreenYPos() - healthBarSpacing, 
				Constants.STORE_BUTTON_SIZE, healthBarHeight);
	}
	
	public void draw(Graphics g){
		if(critter.isInGame()){
			g.setColor(new Color(0, 0, 0));
			//drawImage() using tileset of specific critter
			BufferedImage img=critter.getImage();
			BufferedImage clippedImg=null;
			
			//determine direction of travel
			if(critter.getDirection()==2){
				clippedImg= img.getSubimage(0,0,Constants.STORE_BUTTON_SIZE,Constants.STORE_BUTTON_SIZE);
			}
			if(critter.getDirection()==1){
				clippedImg= img.getSubimage(50,0,Constants.STORE_BUTTON_SIZE,Constants.STORE_BUTTON_SIZE);
			}
			if(critter.getDirection()==3){
				clippedImg= img.getSubimage(50,50,Constants.STORE_BUTTON_SIZE,Constants.STORE_BUTTON_SIZE);
			}
			if(critter.getDirection()==0){
				clippedImg= img.getSubimage(0,50,Constants.STORE_BUTTON_SIZE,Constants.STORE_BUTTON_SIZE);
			}
			
			
			
			g.drawImage(clippedImg, critterDisplay.x,critterDisplay.y, critterDisplay.width, critterDisplay.height, null);
			
			//g.fillRect(critterDisplay.x,critterDisplay.y, critterDisplay.width, critterDisplay.height);
			
			//draw health bar
			g.setColor(new Color(180, 50, 50));
			g.fillRect(healthBar.x, healthBar.y, healthBar.width, healthBar.height);
			
			g.setColor(new Color(50, 180, 50));
			g.fillRect(healthBar.x, healthBar.y, (int)
					Utils.convertCritterHealthToDisplayWidth(critter.getHealth(), maxCritterHealth), healthBar.height);
			
			g.setColor(new Color(0, 0, 0));
			g.drawRect(healthBar.x, healthBar.y, healthBar.width - 1, healthBar.height - 1);
		}
	}
}
