package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import CritterModels.Critter;
import Map.Map;
import Utility.Constants;
import Utility.Utils;

public class CritterDisplay {

	public Rectangle critterDisplay;
	public Point spawnPoint;
	public Critter critter;
	
	public CritterDisplay(Critter critter){
		
		this.critter = critter;
		
//		spawnPoint = Utils.convertMapCoordToScreen(map.getStart().getXCoordinate(),
//				map.getStart().getYCoordinate());
		
		critterDisplay = new Rectangle(critter.getScreenXPos(), critter.getScreenYPos(),
				Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);
		//in critter spawn method convert the coordinated to screen coordinates.
	}
	
	public void draw(Graphics g){
		if(critter.isInGame()){
			g.setColor(new Color(0, 0, 0));
			g.fillRect(critterDisplay.x,critterDisplay.y, critterDisplay.width, critterDisplay.height);
			System.out.println("Critter display at: " + "("+ critterDisplay.x + "," + critterDisplay.y);
		}
	}
}
