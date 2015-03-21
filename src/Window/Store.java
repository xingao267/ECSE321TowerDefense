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
	private Rectangle mainMenuButton;
	private ArrayList<Tower> towerType;
	
	public Store() {
		init();
	}
	
	public void init() {
		for(int i = 0; i < towers.length; i++) {
			towers[i] = new Rectangle(Constants.STORE_OFFSET + (Constants.STORE_BUTTON_SIZE + Constants.STORE_SPACING)*i,
					storeYPos, Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);
		}
		
		mainMenuButton = new Rectangle(670, 3*storeYPos/5, 2*Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE/2);
		
		towerType = new ArrayList<Tower>();
		towerType.add(new RegularTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new BomberTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new SpeedTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new DeceleratorTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		towerType.add(new LongRangeTower(-1, -1, Constants.INITIAL_TOWER_LEVEL));
		
	}
	
	public void draw(Graphics g) {
		//Draw Buttons for each purchaseable tower
		for(int i = 0; i < towers.length; i++){
			//change to drawImage when tileset of tower images has been created
			g.setColor(new Color(0, 0, 0));
			g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
			
			//TODO: add stuff that happens when a tower is purchased on click
			if(towers[i].contains(Screen.mouseLocation)){
				//slightly light up the tower button
				g.setColor(new Color(255, 255, 255, 150));
				g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
				
				//Displays tower characteristics on right side of life and money icons
				g.setFont(new Font("Courier New", Font.BOLD, 15));
				g.drawString(towerType.get(i).getTowerType(), 400, 30);
				g.setFont(new Font("Courier New", Font.BOLD, 14));
				g.drawString("Cost: " + towerType.get(i).getInitialCost(), 575, 30);
				g.drawString("Power: " + towerType.get(i).getPower(), 400, 55);
				g.drawString("Range: " + towerType.get(i).getRange(), 500, 55);
				g.drawString("Fire Rate: " + towerType.get(i).getRateOfFire(), 400, 80);
				
				if(towerType.get(i).isMultiTargets()){
					g.drawString("MultiTarget: Yes", 525, 80);
				}
				else{
					g.drawString("MultiTarget: No", 525, 80);
				}
				
			}
		}
		
		//Draw Button to return to the main menu
		g.setColor(new Color(0, 0, 0));
		g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(new Color(255, 255, 255));
		g.drawString("Main Menu", mainMenuButton.x + Constants.STORE_BUTTON_SIZE/4 + 2, 
				mainMenuButton.y + Constants.STORE_BUTTON_SIZE/4 + 4);
		
		if(mainMenuButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
		}
		if(mainMenuButton.contains(Screen.mouseClicked)){
			Screen.inGameplay = false;
			Screen.displayMap1 = false;
			Screen.displayMap2 = false;
			Screen.displayMap3 = false;
			Screen.displayMainMenu = true;
			
			//stop everything to do with the game.
		}
	}
}
