package Window;

import java.awt.*;

import Utility.Constants;

/**
 * 
 * @author Jose
 *
 */
public class Store {

	public static int storeYPos = 35;
		
	public Rectangle[] towers = new Rectangle[Constants.NUM_TOWERS];
	
	
	public Store() {
		init();
	}
	
	public void init() {
		for(int i = 0; i < towers.length; i++) {
			towers[i] = new Rectangle(Constants.STORE_OFFSET + (Constants.STORE_BUTTON_SIZE + Constants.STORE_SPACING)*i,
					storeYPos, Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < towers.length; i++){
			//lights up when mouse is over tile
			if(towers[i].contains(Screen.mouseLocation)){
				g.setColor(new Color(255, 255, 255, 100));
				g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
			}
			
			//change to drawImage when tileset of tower images has been created
			g.setColor(new Color(0, 0, 0));
			g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
		}
	}
}
