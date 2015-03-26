package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Utility.Constants;
import Utility.SpringUtilities;
import Map.Cell;
import Map.Map;
import Map.MapDesigner;
import Map.MapLoader;

/**
 * 
 * @author Jose
 *
 */
public class MapDesignerDisplay implements Runnable{
	
	private JFrame frame;
	public static Thread userInput = new Thread();

	private Rectangle mainMenuButton, saveMapButton;
	
	private Map map;
	private MapDesigner d;
	
	private String mapName;
	private int customMapWidth;
	private int customMapHeight;

	private boolean jButtonPressed = false;
	public MapDisplay display;
	
	private boolean ready=false;
	private boolean click=false;
	
	
	public MapDesignerDisplay(){
		init();
		
	}
	
	public void init(){
		
		//map = new Map(mapName, customMapWidth, customMapHeight);
		map=null;
		
		mainMenuButton = new Rectangle(Constants.MAIN_MENU_XPOS, Constants.MAIN_MENU_YPOS,
				2*Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE/2);
		
		saveMapButton = new Rectangle(Constants.MAIN_MENU_XPOS, Constants.SAVE_BUTTON_YPOS,
				2*Constants.STORE_BUTTON_SIZE, Constants.STORE_BUTTON_SIZE/2);
	}
	
	
	public void createUserDefinedMap() {
		final String[] labels = {"Map Name: ", "Map Width: ", "Map Height: "};
		int labelsLength = labels.length;
		  final List<JTextField> textFields = new ArrayList<JTextField>();
		JPanel userPanel = new JPanel(new SpringLayout());
		
		for (int i = 0; i < labelsLength; i++) {
			JLabel label = new JLabel(labels[i], JLabel.TRAILING);
            userPanel.add(label);
            JTextField textField = new JTextField(10);
            textFields.add(textField);
            label.setLabelFor(textField);
            userPanel.add(textField);
	    }
		
		JButton button = new JButton("OK");
	    userPanel.add(new JLabel());
	    userPanel.add(button);
	    
	    SpringUtilities.makeCompactGrid(userPanel, labelsLength + 1, 2, 7, 7, 7, 7);
	    
	    button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                for (int i = 0; i < textFields.size(); i++) {
                    String s = textFields.get(i).getText();
                    switch(i){
                    	case 0: mapName = s;
                    			break;
                    	case 1: customMapWidth = Integer.parseInt(s);
                    			break;
                    	case 2: customMapHeight = Integer.parseInt(s);
                    }
                }
                
                frame.setVisible(false);
                frame.dispose();
                
                //System.out.println(mapName);
                //System.out.println(customMapWidth);
                //System.out.println(customMapHeight);
                
                if(customMapWidth>15 || customMapHeight>9){
                	createUserDefinedMap();
                }
                else{
                	map = new Map(mapName, customMapWidth, customMapHeight);
                	d= new MapDesigner(map);
                	for(int i=0; i<customMapHeight; i++){
            			map.addIndicator(new Cell(0, i));
            		}
                	ready=true;
                }
               //Screen.setMapDesigning(true);
                //TODO: pause game thread and start this thread then restart 
                //game thread with updated map characteristics
            }
        });
	    
        // Create and set up the window.
        frame = new JFrame("Input Custom Map Parameters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        userPanel.setOpaque(true); // content panes must be opaque
        frame.setContentPane(userPanel);

        // Display the window.
        frame.pack();
        frame.setSize(350, 175);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	
	
	public void draw(Graphics g){
		
		//display instruction string
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Courier New", Font.BOLD, 20));
		g.drawString("Click the orange cells to create a path.", 15, 25);
		
		//Draw Button to return to the main menu
		g.setColor(new Color(0, 0, 0));
		g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(new Color(255, 255, 255));
		g.drawString("Main Menu", mainMenuButton.x + Constants.STORE_BUTTON_SIZE/4 + 2, 
				mainMenuButton.y + Constants.STORE_BUTTON_SIZE/4 + 4);
		
		if(map!=null){
			display = new MapDisplay(map);
     		display.draw(g);
     		if(!display.indicator.isEmpty()){
    			for(Rectangle r : display.indicator){
    				if(r.contains(Screen.mouseClicked)){
    					//System.out.println("indicator clicked");
    					d.addPathNodeFromClick(Screen.mouseClicked, false); 
    					Screen.mouseClickedReset();
    				}		
    			}
    		}
		}
		
		//transition to main menu window
		if(mainMenuButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
		}
		if(mainMenuButton.contains(Screen.mouseClicked)){
			System.out.println("Main Menu");
			Screen.displayMapDesigner = false;
			Screen.inGameplay = false;
			Screen.displayMap1 = false;
			Screen.displayMap2 = false;
			Screen.displayMap3 = false;
			Screen.displayCustomMap = false;
			Screen.displayMapSelectorPane = false;
			Screen.crittersGenerated = false;
			Screen.levelStarted = false;
			Screen.displayMainMenu = true;
			Screen.gameRunning = true;
			
			//TODO: stop/reset everything to do with designing a map.
		}
		
		//Draw button to save map
		g.setColor(new Color(0, 0, 0));
		g.fillRect(saveMapButton.x, saveMapButton.y, saveMapButton.width, saveMapButton.height);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(new Color(255, 255, 255));
		g.drawString("Save Map", saveMapButton.x + Constants.STORE_BUTTON_SIZE/4 + 5, 
				saveMapButton.y + Constants.STORE_BUTTON_SIZE/4 + 4);
		
		//saves map and transitions to map selector window
		if(saveMapButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(saveMapButton.x, saveMapButton.y, saveMapButton.width, saveMapButton.height);
		}
		if(saveMapButton.contains(Screen.mouseClicked)){
			Screen.displayMapDesigner = false;
			Screen.displayMapSelectorPane = true;
			
			MapLoader mapLoader = MapLoader.getUniqueInstance();
			
			d.endMap();
//			System.out.println("were here");
			if(map.validPath()){
				System.out.println("valid path");
				mapLoader.saveMap(map, mapName);
				Screen.gameRunning = true;
				System.out.println("map saved");
//				System.out.println("Last Path is exit: " + map.getPath(map.pathSize()-1).isExit());
			}
		}
		
	}

	@Override
	public void run() {
		createUserDefinedMap();
		while(!ready){
			//System.out.println("phase 1");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
		/*while(!click && ready){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(Screen.clear==1){
				System.out.println("phase 2");
				Screen.clear=0;
			}	
			/*for(Rectangle r : display.indicator){
				if(r.contains(Screen.mouseClicked)){
					System.out.println("indicator clicked");
				}	
			}*/
		//}
		//MapDesigner d= new MapDesigner(map);
		
		//Set the start node
		//Push all potential start nodes to arraylist
		/*for(int i=1; i<customMapHeight; i++){
			map.addIndicator(new Cell(0, i));
			System.out.println("add thing");
		}*/
		//Wait for user selection
		//create new path node, set as previous
		//set start node
		//clear indicators
		
		//while loop till path is done
		//generate next indicators
		//get next entry
		//add next node, set previous next
		//clear indicators
		
	}
	
/*	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createUserDefinedMap();
				}
		});
	}*/
}
