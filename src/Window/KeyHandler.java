package Window;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Controllers.GameController;
import Utility.Constants;

public class KeyHandler implements MouseMotionListener, MouseListener {

    public KeyHandler() {
        super();
    }

    public void mouseClicked(MouseEvent m) {
        Screen.mouseClicked =
                new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                        - (Frame.height - Screen.screenHeight) / 2 - Constants.KEYHANDLER_OFFSET);
        // System.out.println("Mouse clicked (" + Screen.mouseClicked.getX() + ',' +
        // Screen.mouseClicked.getY() + ')');
    }

    public void mouseEntered(MouseEvent m) {

    }

    public void mouseExited(MouseEvent m) {

    }

    public void mousePressed(MouseEvent m) {
        if (m.isPopupTrigger() && GameController.getUniqueInstance().isTowerCellHoveredOnMap()) {
            Screen.towerRightClickMenu = doPop(m);
        }
    }

    public void mouseReleased(MouseEvent m) {
        if (m.isPopupTrigger() && GameController.getUniqueInstance().isTowerCellHoveredOnMap()) {
            Screen.towerRightClickMenu = doPop(m);
        }
    }

    public void mouseDragged(MouseEvent m) {
        Screen.mouseLocation =
                new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                        - (Frame.height - Screen.screenHeight) / 2 - Constants.KEYHANDLER_OFFSET);
        // System.out.println("Mouse moved (" + Screen.mouseLocation.getX() + ',' +
        // Screen.mouseLocation.getY() + ')');
    }

    public void mouseMoved(MouseEvent m) {
        Screen.mouseLocation =
                new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                        - (Frame.height - Screen.screenHeight) / 2 - Constants.KEYHANDLER_OFFSET);
        // System.out.println("Mouse moved (" + Screen.mouseLocation.getX() + ',' +
        // Screen.mouseLocation.getY() + ')');
    }

    private TowerRightClickMenu doPop(MouseEvent e) {

        TowerRightClickMenu menu = new TowerRightClickMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
        return menu;
    }

}
