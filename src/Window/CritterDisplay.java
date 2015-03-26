package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import CritterModels.Critter;
import Utility.Constants;
import Utility.Utils;

public class CritterDisplay {

	public Rectangle critterDisplay, healthBar;
	public Point spawnPoint;
	public Critter critter;
	public int healthBarSpacing = 3, healthBarHeight = Constants.STORE_BUTTON_SIZE/10;
	public double maxCritterHealth;
	
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
			g.fillRect(critterDisplay.x,critterDisplay.y, critterDisplay.width, critterDisplay.height);
			
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
