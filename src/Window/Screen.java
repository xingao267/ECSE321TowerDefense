package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import OtherModels.Bank;
import OtherModels.Player;
import MapPresets.*;
import Map.*;
/**
 * 
 * @author Jose,Justin
 *
 */
public class Screen extends JPanel implements Runnable{

	public Thread game = new Thread(this);
	
//	private int fps = 10000000 , fpsFrame = 0;
	
	public Frame frame;
	
	public static Point mouseLocation = new Point(0, 0), 
			mouseClicked = new Point(0,0);
	
	public MainMenu menu;
	
	public MapSelectPane mapSelectPane;
	
	public MapDesignerDisplay mapDesigner;
	private Thread userInput = new Thread(mapDesigner);
	
	private boolean isFirst = true;
	private boolean gameRunning = true;
	private boolean suspended = false;
	private boolean designingMap=false; //added for while loop for map designer
	
	public static boolean displayMainMenu = true, displayMapSelectorPane = false, 
			displayMapDesigner = false, inGameplay = false, displayMap1 = false,
			displayMap2 = false, displayMap3 = false;
	
	public static int screenWidth, screenHeight;
	
//	public static Map map;
	public static Store store;
	
	public static IconDisplay icons;
	
	public Screen(Frame frame){
		this.frame = frame;
		frame.addMouseListener(new KeyHandler());
		frame.addMouseMotionListener(new KeyHandler());
		game.start();
	}
	
	
	public void paintComponent(Graphics g){
		
		if(isFirst) {
			screenWidth = getWidth();
			screenHeight = getHeight();
			isFirst = false;
			
			menu = new MainMenu();
			mapSelectPane = new MapSelectPane();
			mapDesigner = new MapDesignerDisplay();
			store = new Store();
			icons = new IconDisplay();
		}
			
		g.setColor(new Color(60, 60, 60));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(displayMainMenu){
			//display the main menu
			menu.draw(g);
		}
		
		if(displayMapSelectorPane){
			//display map select pane
			mapSelectPane.draw(g);
		}
		
		if(displayMapDesigner){
			mapDesigner.draw(g);
		}
		
		if(inGameplay){		
			store.draw(g);
			icons.draw(g);
			
			if(displayMap1){
				EasyMap em = new EasyMap();
				Map m = em.getEasyMap();
				MapDisplay display = new MapDisplay(m);
				display.draw(g);
			}
			if(displayMap2){
				
			}
			
			if(displayMap3){
				
			}
		}
	}
	
	
	/**
	 * Game Loop
	 */
	public void run(){

		//Game Loop
		while(gameRunning){
			
			repaint();
			
			if(displayMapDesigner){
				gameRunning = false;
			}
			
			try{
				game.sleep(1);
			} catch(Exception e){}	
			
		}
		
		
		
		if(displayMapDesigner){
//			userInput.start();
			mapDesigner.createUserDefinedMap(); //you added this
			while(displayMapDesigner){
				repaint();
			}
		}
	}


	public boolean isGameRunning() {
		return gameRunning;
	}


	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}
	
	public void setMapDesigning(boolean mapDesigning){ //you added this
		this.designingMap=mapDesigning;
	}
	
}
