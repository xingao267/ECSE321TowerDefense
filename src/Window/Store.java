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

	public static int storeYPos = 25;
		
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
		
		towerType = new ArrayList<Tower>();
		towerType.add(new RegularTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new SpeedTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new BomberTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new DeceleratorTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new LongRangeTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < towers.length; i++){
			//change to drawImage when tileset of tower images has been created
			g.setColor(new Color(0, 0, 0));
			g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
			
			//actions when mouse is over tile
			if(towers[i].contains(Screen.mouseLocation)){
				//slightly light up the tower button
				g.setColor(new Color(255, 255, 255, 150));
				g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
				
				//add method which displays tower charateristics(toString method) on right side life display
				g.setFont(new Font("Courier New", Font.PLAIN, 13));
				g.drawString(towerType.get(i).toString(), 400, storeYPos);
			}
		}
	}
}
