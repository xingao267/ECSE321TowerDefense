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
import Map.Map;

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
	
	private String mapName;
	private int customMapWidth;
	private int customMapHeight;

	private boolean jButtonPressed = false;
	
	
	public MapDesignerDisplay(){
		init();
		
	}
	
	public void init(){
		
		map = new Map(mapName, customMapWidth, customMapHeight);
		
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
                
                System.out.println(mapName);
                System.out.println(customMapWidth);
                System.out.println(customMapHeight);
                
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
		g.drawString("Click cells you want to use as a path.", 15, 25);
		
		//Draw Button to return to the main menu
		g.setColor(new Color(0, 0, 0));
		g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(new Color(255, 255, 255));
		g.drawString("Main Menu", mainMenuButton.x + Constants.STORE_BUTTON_SIZE/4 + 2, 
				mainMenuButton.y + Constants.STORE_BUTTON_SIZE/4 + 4);
		
		//transition to main menu window
		if(mainMenuButton.contains(Screen.mouseLocation)){
			g.setColor(new Color(255, 255, 255, 150));
			g.fillRect(mainMenuButton.x, mainMenuButton.y, mainMenuButton.width, mainMenuButton.height);
		}
		if(mainMenuButton.contains(Screen.mouseClicked)){
			Screen.displayMapDesigner = false;
			Screen.displayMainMenu = true;
			
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
			
			//TODO: add method which saves map.
		}
	}

	@Override
	public void run() {
		createUserDefinedMap();
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
