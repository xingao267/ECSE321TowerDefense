package Window;

import java.awt.*;

/**
 * 
 * @author Jose
 *
 */
public class MainMenu {

	private Rectangle startGameButton, createCustomMapButton;
	
	public static int buttonHeight = 100;
	public static int buttonWidth = 500;
	public static int buttonYOffset1 = 100;
	public static int buttonYOffset2 = 225;
	public static int wordXOffset1 = 250;
	public static int wordXOffset2 = 400;
	public static int wordYOffset = 10;
			
	public MainMenu() {
		init();
	}
	
	public void init() {
		startGameButton = new Rectangle((Screen.screenWidth - buttonWidth)/2, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset1, buttonWidth, buttonHeight);
		
		createCustomMapButton = new Rectangle((Screen.screenWidth - buttonWidth)/2, 
				(Screen.screenHeight - buttonHeight)/2 + buttonYOffset2, buttonWidth, buttonHeight);
	}
	
	public void draw(Graphics g) {

		//add mouse click to change to Level Select or MapEditor Views
		g.setColor(new Color(0, 0, 0));
		g.fillRect(startGameButton.x, startGameButton.y, 
				startGameButton.width, startGameButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.drawString("Start Game", (Screen.screenWidth - wordXOffset1)/2, 
				(Screen.screenHeight - buttonHeight + startGameButton.height)/2 + buttonYOffset1 + wordYOffset);
		
		g.setColor(new Color(0, 0, 0));
		g.fillRect(createCustomMapButton.x, createCustomMapButton.y, 
				createCustomMapButton.width, createCustomMapButton.height);
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.drawString("Create Custom Map", (Screen.screenWidth - wordXOffset2)/2, 
				(Screen.screenHeight - buttonHeight + createCustomMapButton.height)/2 + buttonYOffset2 + wordYOffset);
		
		
	}

}
