package Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Map.MapLoader;


public class CustomMapRightClickMenu extends JPopupMenu{
	 /** Default serial ID */
    private static final long serialVersionUID = 1L;

    JMenuItem removeButtom;

    public CustomMapRightClickMenu() {

        
        removeButtom = new JMenuItem("Remove");
        
        if (!Screen.levelStarted) {
            add(removeButtom);
            removeButtom.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   
                	String hovered = MapSelectPane.getHoveredMap();
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
     * @return the removeButtom
     */
    public JMenuItem getRemoveButtom() {
        return removeButtom;
    }

    /**
     * @param removeButtom the removeButtom to set
     */
    public void setRemoveButtom(JMenuItem removeButtom) {
        this.removeButtom = removeButtom;
    }

    
}
