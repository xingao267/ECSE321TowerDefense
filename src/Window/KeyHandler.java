package Window;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Controllers.GameController;
import Utility.Constants;
import Utility.Utils;

/**
 * 
 * @author Jose
 *
 */
public class KeyHandler implements MouseMotionListener, MouseListener {

    public KeyHandler() {
        super();
    }

    public void mouseClicked(MouseEvent m) {
        if (!(m.getButton() == MouseEvent.BUTTON3)) {
            Screen.mouseClicked =
                    new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                            - (Frame.height - Screen.screenHeight) / 2
                            - Constants.KEYHANDLER_OFFSET);

            Utils.playSound(Constants.CLICK_ONE_SOUND, 0);
        }
    }

    public void mouseEntered(MouseEvent m) {

    }

    public void mouseExited(MouseEvent m) {

    }

    public void mousePressed(MouseEvent m) {
        if (m.isPopupTrigger() && GameController.getUniqueInstance().isTowerCellHoveredOnMap()) {

            Screen.towerRightClickMenu = doPop(m);
        }
        if (m.isPopupTrigger() && MapSelectPaneView.isCustomMapHovered()
                && Screen.displayMapSelectorPane) {
            Screen.customMapRightClickMenu = doPop2(m);
        }
    }

    public void mouseReleased(MouseEvent m) {
        if (m.isPopupTrigger() && GameController.getUniqueInstance().isTowerCellHoveredOnMap()) {
            Screen.towerRightClickMenu = doPop(m);
        }
        if (m.isPopupTrigger() && MapSelectPaneView.isCustomMapHovered()
                && Screen.displayMapSelectorPane) {
            Screen.customMapRightClickMenu = doPop2(m);
        }
    }

    public void mouseDragged(MouseEvent m) {
        Screen.mouseLocation =
                new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                        - (Frame.height - Screen.screenHeight) / 2 - Constants.KEYHANDLER_OFFSET);
    }

    public void mouseMoved(MouseEvent m) {
        Screen.mouseLocation =
                new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                        - (Frame.height - Screen.screenHeight) / 2 - Constants.KEYHANDLER_OFFSET);
    }

    private TowerRightClickMenu doPop(MouseEvent e) {

        TowerRightClickMenu menu = new TowerRightClickMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
        return menu;
    }

    private CustomMapRightClickMenu doPop2(MouseEvent e) {
        CustomMapRightClickMenu menu = new CustomMapRightClickMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
        return menu;
    }

}
