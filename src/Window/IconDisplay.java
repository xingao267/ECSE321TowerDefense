package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import OtherModels.Bank;
import OtherModels.Player;
import Utility.Constants;

/**
 * 
 * @author Jose
 *
 */
public class IconDisplay {

	private Bank bank;
	private Player player;
	
	private Rectangle moneyIcon;
    private Rectangle lifeIcon;
    
    private int iconXPos = 315;
	private int moneyIconYPos = 8;
	private int lifeIconYPos = 45;
          
    
	public IconDisplay(){
		bank = Bank.getUniqueInstance();
		player = Player.getUniqueInstance();
		
		moneyIcon =
                new Rectangle(iconXPos, moneyIconYPos
                        + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE) / 2,
                        Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);
		
		lifeIcon =
                new Rectangle(iconXPos, lifeIconYPos
                        + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE) / 2,
                        Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);		
	}
	
	public void draw(Graphics g){
		
		g.setColor(new Color(255, 215, 0));
	    g.fillRect(moneyIcon.x, moneyIcon.y, moneyIcon.width, moneyIcon.height);
	    g.setFont(new Font("Courier New", Font.BOLD, 20));
	    g.setColor(new Color(255, 215, 0));
	    g.drawString("" + bank.getBalance(), iconXPos + moneyIcon.width + Constants.SPACING, moneyIconYPos
	    		+ Constants.STORE_BUTTON_SIZE / 2 + Constants.DISPLAY_SIZE / 4 - 1);
	        
	    g.setColor(new Color(255, 0, 0));
        g.fillRect(lifeIcon.x, lifeIcon.y, lifeIcon.width, lifeIcon.height);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.setColor(new Color(255, 0, 0));
        g.drawString("" + player.getLifePoints(), iconXPos + lifeIcon.width + Constants.SPACING, lifeIconYPos
                + Constants.STORE_BUTTON_SIZE / 2 + Constants.DISPLAY_SIZE / 4 - 1);
	}
}
