package Window;

import java.awt.*;
import java.io.IOException;

import Map.MapLoader;
import Map.Map;

import java.util.List;
import java.util.ArrayList;
/**
 * 
 * @author Jose,Justin
 *
 */
public class MapSelectPane {

	private Rectangle easyButton, mediumButton, hardButton, createCustomMap;
	private ArrayList<Rectangle> customMaps;
	private List<String> mapList;
	private MapLoader mapLoader;
	
	public static int buttonHeight = 60;
	public static int buttonWidth = 275;
	public static int buttonYOffset1 = 40;
	public static int buttonYOffset2 = 120;
	public static int buttonYOffset3 = 200;
	public static int buttonXOffset = 50;
	public static int columnOffset1 = 400;
	public static int wordXOffset1 = 150;
	public static int wordXOffset2 = 75;
	public static int wordXOffset3 = 150;
	public static int wordYOffset = 10;
	public static int stringOffset = 450;
	public static int customMapOffset = -30;
			
	public MapSelectPane() {
		mapLoader = MapLoader.getUniqueInstance();
		mapList = mapLoader.getMapList();
		customMaps = new ArrayList<Rectangle>();
		init();
	}
	
	public void init() {
		easyButton = new Rectangle((Screen.screenWidth - buttonWidth)/4 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset1, buttonWidth, buttonHeight);
		
		mediumButton = new Rectangle((Screen.screenWidth - buttonWidth)/4 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset2, buttonWidth, buttonHeight);
		
		hardButton = new Rectangle((Screen.screenWidth - buttonWidth)/4 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset3, buttonWidth, buttonHeight);
		
		createCustomMap = new Rectangle(3*(Screen.screenWidth - buttonWidth/2)/4 - buttonXOffset/2,
				Screen.screenHeight/2 - buttonHeight/4 + buttonYOffset3, 3*buttonWidth/4, buttonHeight/2);
		
		
		for(int i =0; i <mapList.size(); i++){
			
			Rectangle r = new Rectangle(3*(Screen.screenWidth - buttonWidth/2)/4 - buttonXOffset/2,
					(Screen.screenHeight/2 - buttonHeight/4 + buttonYOffset3)+((i+1)*customMapOffset), 3*buttonWidth/4, buttonHeight/2);
			customMaps.add(r);
		}
		
	}
	
	public void draw(Graphics g) {

		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 24));
		g.drawString("Please select map you wish to play.", (Screen.screenWidth - stringOffset)/2, 
				(Screen.screenHeight - buttonHeight)/2 - 4*buttonYOffset1/3);
		
		g.setFont(new Font("Courier New", Font.BOLD, 20));
		g.drawString("Pre-Made Levels", (Screen.screenWidth - buttonWidth)/4 + 50 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight)/2 - buttonYOffset1/4 + 25);
		g.drawString("Custom Maps", 3*(Screen.screenWidth - buttonWidth)/4 + 115, 
				(Screen.screenHeight - buttonHeight)/2 - buttonYOffset1/4 + 25);
		
		
		
		//Easy Map Button
		g.setColor(new Color(0, 0, 0));
		g.fillRect(easyButton.x, easyButton.y, 
				easyButton.width, easyButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 28));
		g.drawString("Map 1 - Easy", (Screen.screenWidth - buttonWidth + wordXOffset1)/4 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight + easyButton.height)/2 + buttonYOffset1 + wordYOffset);
		
		if(easyButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(easyButton.x, easyButton.y, 
					easyButton.width, easyButton.height);
		}
		//transition to gameplay window playing Map 1
		if(easyButton.contains(Screen.mouseClicked)){
			Screen.displayMapSelectorPane = false;
			Screen.inGameplay = true;
			Screen.displayMap1 = true;
		}
		
		
		//Medium Map Button
		g.setColor(new Color(0, 0, 0));
		g.fillRect(mediumButton.x, mediumButton.y, 
				mediumButton.width, mediumButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 28));
		g.drawString("Map 2 - Medium", (Screen.screenWidth - buttonWidth + wordXOffset2)/4 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight + mediumButton.height)/2 + buttonYOffset2 + wordYOffset);
		
		if(mediumButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(mediumButton.x, mediumButton.y, 
					mediumButton.width, mediumButton.height);
		}
		//transition to gameplay window playing Map 2
		if(mediumButton.contains(Screen.mouseClicked)){
			Screen.displayMapSelectorPane = false;
			Screen.inGameplay = true;
			Screen.displayMap2 = true;
		}
		
		
		//Hard Map Button
		g.setColor(new Color(0, 0, 0));
		g.fillRect(hardButton.x, hardButton.y, 
				hardButton.width, hardButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 28));
		g.drawString("Map 3 - Hard", (Screen.screenWidth - buttonWidth + wordXOffset3)/4 - buttonXOffset, 
				(Screen.screenHeight - buttonHeight + hardButton.height)/2 + buttonYOffset3 + wordYOffset);
		
		if(hardButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(hardButton.x, hardButton.y, 
					hardButton.width, hardButton.height);
		}
		//transition to gameplay window playing Map 3
		if(hardButton.contains(Screen.mouseClicked)){
			Screen.displayMapSelectorPane = false;
			Screen.inGameplay = true;
			Screen.displayMap3 = true;
		}
		
		
		//Create Custom Map Button
		g.setColor(new Color(0, 0, 0));
		g.fillRect(createCustomMap.x, createCustomMap.y, 
				createCustomMap.width, createCustomMap.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 16));
		g.drawString("Create Custom Map", 3*(Screen.screenWidth - buttonWidth/2)/4 - buttonXOffset/10, 
				(Screen.screenHeight - buttonHeight + createCustomMap.height)/2 + buttonYOffset3 + 2*wordYOffset);
				
		if(createCustomMap.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(createCustomMap.x, createCustomMap.y, 
					createCustomMap.width, createCustomMap.height);
		}
		//transition to map editor window
		if(createCustomMap.contains(Screen.mouseClicked)){
			Screen.displayMapSelectorPane = false;
			Screen.displayMapDesigner = true;
		}
		
		//TODO: Add number of buttons based on how many saved maps there are.
		
		
			for(int i =0; i < 8; i++){
				g.setColor(new Color(0, 0, 0));
				g.fillRect((3*(Screen.screenWidth - buttonWidth/2)/4 - buttonXOffset/2),
						(Screen.screenHeight/2 - buttonHeight/4 + buttonYOffset3)+((i+1)*customMapOffset), 3*buttonWidth/4, buttonHeight/2);
				g.setColor(new Color(255, 255, 255));
				g.setFont(new Font("Courier New", Font.BOLD, 16));
				g.drawString(mapList.get(i), 3*(Screen.screenWidth - buttonWidth/2)/4 - buttonXOffset/10, 
						((Screen.screenHeight - buttonHeight + createCustomMap.height)/2 + buttonYOffset3)+((i+1)*customMapOffset) + 2*wordYOffset);
						
				if(customMaps.get(i).contains(Screen.mouseLocation)){
					g.setColor(new Color(255, 255, 255, 150));
					g.fillRect((3*(Screen.screenWidth - buttonWidth/2)/4 - buttonXOffset/2),
							(Screen.screenHeight/2 - buttonHeight/4 + buttonYOffset3)+((i+1)*customMapOffset), 3*buttonWidth/4, buttonHeight/2);
				}
				if(customMaps.get(i).contains(Screen.mouseClicked)){
					
					Map m;
					try {
						m = mapLoader.loadMap(mapList.get(i));
						Screen.displayMapSelectorPane = false;
						Screen.setCustomMap(m);
						Screen.inGameplay = true;
						Screen.displayCustomMap = true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}
