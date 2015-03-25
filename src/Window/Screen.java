package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import OtherModels.Bank;
import OtherModels.Player;
import Controllers.GameController;
import CritterModels.Critter;
import CritterModels.CritterGroupGenerator;
import CritterModels.NormalCritter;
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
	
	private boolean isFirst = true;
	private boolean gameRunning = true;
	private boolean suspended = false;
	private boolean designingMap=false; //added for while loop for map designer
	
	public static int clear=0;

	public int gameLevel = 1;

	
	public static boolean displayMainMenu = true, displayMapSelectorPane = false, 
			displayMapDesigner = false, inGameplay = false, displayMap1 = false,
			displayMap2 = false, displayMap3 = false, displayCustomMap = false,
			levelStarted = false, crittersGenerated = false;
	
	public static int screenWidth, screenHeight;
	
	public GameController gameController;
	public static Player player;
	
	public static Map map;
	private static Map CustomMap;
	private static MapDisplay mapDisplay;
	public static Store store;
	
	public static CritterDisplay critterDisplay;
	public List<Critter> critters;
	public static List<CritterDisplay> critterGroupDisplay;
	public static CritterGroupGenerator group;
	public static Critter critter;
	
	List<Cell> path = new ArrayList<Cell>();
	
	public static IconDisplay icons;
	
	public Screen(Frame frame){
		this.frame = frame;
		frame.addMouseListener(new KeyHandler());
		frame.addMouseMotionListener(new KeyHandler());
		game.start();
	}
	
	public void init(){
		menu = new MainMenu();
		mapSelectPane = new MapSelectPane();
		mapDesigner = new MapDesignerDisplay();
		store = new Store();
		icons = new IconDisplay();
		player = Player.getUniqueInstance();
		
		path.add(new Cell(0, 8));
		path.add(new Cell(1, 8));
		path.add(new Cell(1,7));
		
		//TODO: initialize all tilesets (images) here
	}
	
	
	public void paintComponent(Graphics g){
		
		if(isFirst){
			screenWidth = getWidth();
			screenHeight = getHeight();
			init();
			
			isFirst = false;
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
				EasyMap easyMap = new EasyMap();
				map = easyMap.getEasyMap();
				mapDisplay = new MapDisplay(map);
				mapDisplay.draw(g);
//				critterGroupDisplay = new ArrayList<CritterDisplay>();
				
//				critter.move(40);
				if(levelStarted){
					if(!crittersGenerated){
						critter = new NormalCritter(gameLevel);
						
//						group = new CritterGroupGenerator(gameLevel);
						crittersGenerated = true;
					}

//					critter.move(path.get(1), 40);
//					critterDisplay = new CritterDisplay(critter);
//					for(int i = 0; i < critterGroupDisplay.size(); i++){
//						critterGroupDisplay.get(i).draw(g);
//					}
					critterDisplay = new CritterDisplay(critter);
					
					if(critter.isInGame()){
						critterDisplay.draw(g);
					}
				}
			}
			
			if(displayMap2){
				MediumMap mediumMap = new MediumMap();
				map = mediumMap.getMediumMap();
				mapDisplay = new MapDisplay(map);
				mapDisplay.draw(g);
				
			}
			
			if(displayMap3){
				HardMap hardMap = new HardMap();
				map = hardMap.getHardMap();
				mapDisplay = new MapDisplay(map);
				mapDisplay.draw(g);
			}
			
			if(displayCustomMap){
				mapDisplay = new MapDisplay(CustomMap);
				mapDisplay.draw(g);
			}
		}
	}
	
	public int spawnTime = 1000, spawnFrame = 0;
	public void spawnCritterGroup() {
    	List<Critter> critterGroup = group.getCritterGroup();
    	
    	if(spawnFrame >= spawnTime){
	    	for(int i = 0; i < critterGroup.size(); i++){
				if(!critterGroup.get(i).isInGame()){
					critterGroup.get(i).spawn(map.getStart());
					critterGroupDisplay.add(new CritterDisplay(critterGroup.get(i)));
					break;
				}
			}
	    	spawnFrame = 0;
    	}
    	else{
    		spawnFrame++;
    	}
	}
	
	
	/**
	 * Game Loop
	 */
	public void run(){

		//Game Loop
		while(gameRunning){
			if(levelStarted){
				if(crittersGenerated){
					if(!critter.isInGame() && !critter.hasReachedExit()){
						System.out.println("critter spawned");
						critter.spawn(map.getStart());
//						critter.move(path.get(1), 40);
					}
					else{
						critter.moveAlongPath(20, player);
					}
				}
			}
//					gameController.spawnCritterGroup(map.getStart(), group);
	/*				for(int i = 0; i < group.getCritterGroup().size(); i++){
						if(!group.getCritterGroup().get(i).isInGame()){
							group.getCritterGroup().get(i).spawn(map.getStart());
							critterGroupDisplay.add(new CritterDisplay(group.getCritterGroup().get(i)));
							break;
						}
					}
	*/				
		
			
			repaint();
			
			if(displayMapDesigner){
				gameRunning = false;
			}
			
			try{
				game.sleep(10);
			} catch(Exception e){}	
			
		}
		
		if(levelStarted){
			
		}
		
		if(displayMapDesigner){
//			userInput.start();
			//mapDesigner.createUserDefinedMap(); 
			mapDesigner.run();
			while(displayMapDesigner){
				
					repaint();
					
				
				try{
					game.sleep(50);
				} catch(Exception e){}	
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
	
	public static void setCustomMap(Map m){
		CustomMap = m;
	}
	
	public static void mouseClickedReset(){
		mouseClicked= new Point(0,0);
	}
	
}
