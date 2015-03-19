package Window;

import java.awt.*;

/**
 * 
 * @author Jose
 *
 */
public class MapSelectPane {

	private Rectangle easyButton, mediumButton, hardButton, createCustomMap;
	
	public static int buttonHeight = 75;
	public static int buttonWidth = 400;
	public static int buttonYOffset1 = 30;
	public static int buttonYOffset2 = 130;
	public static int buttonYOffset3 = 230;
	public static int columnOffset1 = 400;
	public static int wordXOffset1 = 200;
	public static int wordXOffset2 = 125;
	public static int wordXOffset3 = 200;
	public static int wordYOffset = 10;
	public static int stringOffset = 450;
			
	public MapSelectPane() {
		init();
	}
	
	public void init() {
		easyButton = new Rectangle((Screen.screenWidth - buttonWidth)/4, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset1, buttonWidth, buttonHeight);
		
		mediumButton = new Rectangle((Screen.screenWidth - buttonWidth)/4, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset2, buttonWidth, buttonHeight);
		
		hardButton = new Rectangle((Screen.screenWidth - buttonWidth)/4, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset3, buttonWidth, buttonHeight);
		
		createCustomMap = new Rectangle(3*(Screen.screenWidth)/4,
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset3, buttonWidth/2, buttonHeight/2);
	}
	
	public void draw(Graphics g) {

		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 24));
		g.drawString("Please select map you wish to play.", (Screen.screenWidth - stringOffset)/2, 
				(Screen.screenHeight - buttonHeight)/2 - 2*buttonYOffset1);
		
		g.setFont(new Font("Courier New", Font.BOLD, 20));
		g.drawString("Pre-Made Levels", (Screen.screenWidth - buttonWidth)/4 + 100, 
				(Screen.screenHeight - buttonHeight)/2 - buttonYOffset1/4 + 25);
//		g.drawString("Custom Levels", (Screen.screenWidth - stringOffset)/2, 
//				(Screen.screenHeight - buttonHeight)/2 - 2*buttonYOffset1);
		
		//add mouse click to change to Level Select or MapEditor Views
		g.setColor(new Color(0, 0, 0));
		g.fillRect(easyButton.x, easyButton.y, 
				easyButton.width, easyButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.drawString("Map 1 - Easy", (Screen.screenWidth - buttonWidth + wordXOffset1)/4, 
				(Screen.screenHeight - buttonHeight + easyButton.height)/2 + buttonYOffset1 + wordYOffset);
		
		g.setColor(new Color(0, 0, 0));
		g.fillRect(mediumButton.x, mediumButton.y, 
				mediumButton.width, mediumButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.drawString("Map 2 - Medium", (Screen.screenWidth - buttonWidth + wordXOffset2)/4, 
				(Screen.screenHeight - buttonHeight + mediumButton.height)/2 + buttonYOffset2 + wordYOffset);
		
		g.setColor(new Color(0, 0, 0));
		g.fillRect(hardButton.x, hardButton.y, 
				hardButton.width, hardButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.drawString("Map 3 - Hard", (Screen.screenWidth - buttonWidth + wordXOffset3)/4, 
				(Screen.screenHeight - buttonHeight + hardButton.height)/2 + buttonYOffset3 + wordYOffset);
		
		g.setColor(new Color(0, 0, 0));
		g.fillRect(createCustomMap.x, createCustomMap.y, 
				createCustomMap.width, createCustomMap.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 16));
		g.drawString("Create Custom Map", 3*(Screen.screenWidth - buttonWidth)/4, 
				(Screen.screenHeight - buttonHeight + createCustomMap.height)/2 + buttonYOffset3 + wordYOffset);
	}
}
