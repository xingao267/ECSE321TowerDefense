package Window;

import java.awt.*;
import java.util.ArrayList;

import TowerModels.*;
import Utility.Constants;

/**
 * 
 * @author Jose
 *
 */
public class Store {

	public static int storeYPos = 35;
		
	private Rectangle[] towers = new Rectangle[Constants.NUM_TOWERS];
	private ArrayList<Tower> towerType;
	
	public Store() {
		init();
	}
	
	public void init() {
		for(int i = 0; i < towers.length; i++) {
			towers[i] = new Rectangle(Constants.STORE_OFFSET + (Constants.STORE_BUTTON_SIZE + Constants.STORE_SPACING)*i,
					storeYPos, Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);
		}
		
//		towerType.add(new RegularTower(-1, -1, 1));
//		towerType.add(new BomberTower(-1, -1, 1));
//		towerType.add(new SpeedTower(-1, -1, 1));
//		towerType.add(new LongRangeTower(-1, -1, 1));
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < towers.length; i++){
			//actions when mouse is over tile
			if(towers[i].contains(Screen.mouseLocation)){
				//slightly light up the tile
				g.setColor(new Color(255, 255, 255, 100));
				g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
				//add method which displays tower charateristics(toString method) on right side life display
				//g.drawString(towerType.get(i).toString(), arg1, arg2);
			}
			
			//change to drawImage when tileset of tower images has been created
			g.setColor(new Color(0, 0, 0));
			g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
		}
	}
}
