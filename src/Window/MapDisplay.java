package Window;

import java.awt.*;
import java.util.ArrayList;

import Map.*;
import Utility.Constants;
/**
 * This class displays the maps
 * @author Justin
 *
 */
public class MapDisplay {

	private static ArrayList<Rectangle> scenery;
	private static ArrayList<Rectangle> path;
	private Map m;
	private int mapWidth;
	private int mapHeight;
	public static ArrayList<Integer> offsets;
	
	/**
	 * Constructor
	 * @param m
	 */
	public MapDisplay(Map m){
		this.m = m;
		mapWidth = m.getWidth();
		mapHeight = m.getHeight();
		scenery = new ArrayList<Rectangle>();
		path = new ArrayList<Rectangle>();
		init();
	}
	
	/**
	 * Initialise the necessary rectangles
	 */
	public void init(){
		
		for(int i =0; i< mapWidth; i++){
			for(int j =0; j<mapHeight; j++){
			
				Rectangle r = new Rectangle(15+(Constants.STORE_BUTTON_SIZE*i), 100+Constants.STORE_BUTTON_SIZE*j,
								Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE);
				if (m.getCell(i, j).isScenery()){
					scenery.add(r);
				} else {
					path.add(r);
				}
				
			}
		}		
	}
	
	/**
	 * Draw the screen
	 * @param g
	 */
	public void draw(Graphics g) {
		//Draw the scenery
		for(Rectangle r : scenery){
			
			g.setColor(new Color(148, 204, 142)); //Green
			g.fillRect(r.x, r.y, r.width, r.height);
			
			
			if(r.contains(Screen.mouseLocation)){
				//slightly darken the scenery
				g.setColor(new Color(38, 59, 44, 150));
				g.fillRect(r.x, r.y, r.width, r.height);
			}	
		}
		//Draw the path
		for(Rectangle r : path){
			
			g.setColor(new Color(88, 38, 15)); //Brown
			g.fillRect(r.x, r.y, r.width, r.height);
			
			
			if(r.contains(Screen.mouseLocation)){
				//slightly darken the path
				g.setColor(new Color(73, 16, 9, 150));
				g.fillRect(r.x, r.y, r.width, r.height);
			}	
		}
	}
	
}