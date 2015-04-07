package Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Map.MapLoader;

/**
 * 
 * @author Justin
 *
 */
public class CustomMapRightClickMenu extends JPopupMenu{
	 /** Default serial ID */
    private static final long serialVersionUID = 1L;

    JMenuItem deleteButton;

    public CustomMapRightClickMenu() {

        
        deleteButton = new JMenuItem("Delete");
        
        if (!Screen.levelStarted) {
            add(deleteButton);
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   
                	String hovered = MapSelectPaneView.getHoveredMap();
                	MapLoader loader = MapLoader.getUniqueInstance();
                	loader.deleteMap(hovered);
                	
                	Screen.displayMapDesigner = false;
                    Screen.inGameplay = false;
                    Screen.displayEasyMap = false;
                    Screen.displayMediumMap = false;
                    Screen.displayHardMap = false;
                    Screen.displayCustomMap = false;
                    Screen.displayMapSelectorPane = false;
                    Screen.crittersGenerated = false;
                    Screen.levelStarted = false;
                    Screen.displayMainMenu = true;
                    Screen.gameRunning = true;
                }
            });
            
        }
    }  

    /**
     * @return the deleteButton
     */
    public JMenuItem getdeleteButton() {
        return deleteButton;
    }

    /**
     * @param deleteButton the deleteButton to set
     */
    public void setdeleteButton(JMenuItem deleteButton) {
        this.deleteButton = deleteButton;
    }

    
}
