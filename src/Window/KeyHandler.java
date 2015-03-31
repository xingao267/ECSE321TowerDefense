package Window;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Controllers.GameController;
import Utility.Constants;

public class KeyHandler implements MouseMotionListener, MouseListener {

    public KeyHandler() {
        super();
    }

    public void mouseClicked(MouseEvent m) {
        if (!(m.getButton() == m.BUTTON3)) {
            Screen.mouseClicked =
                    new Point(m.getX() - (Frame.width - Screen.screenWidth) / 2, m.getY()
                            - (Frame.height - Screen.screenHeight) / 2
                            - Constants.KEYHANDLER_OFFSET);

            // System.out.println("Mouse clicked (" + Screen.mouseClicked.getX() + ',' +
            // Screen.mouseClicked.getY() + ')');
            // Screen.rightClicked = false;

            String soundName = Constants.CLICK_ONE_SOUND;
            AudioInputStream audioInputStream = null;
            try {
                audioInputStream =
                        AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            } catch (UnsupportedAudioFileException | IOException e) {
                // Shouldn't be hit
            }
            Clip clip = null;
            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            } catch (LineUnavailableException | IOException e) {
            }

            clip.start();
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
        if (m.isPopupTrigger() && MapSelectPane.isCustomMapHovered()
                && Screen.displayMapSelectorPane) {
            Screen.customMapRightClickMenu = doPop2(m);
        }
    }

    public void mouseReleased(MouseEvent m) {
        if (m.isPopupTrigger() && GameController.getUniqueInstance().isTowerCellHoveredOnMap()) {
            Screen.towerRightClickMenu = doPop(m);
        }
        if (m.isPopupTrigger() && MapSelectPane.isCustomMapHovered()
                && Screen.displayMapSelectorPane) {
            Screen.customMapRightClickMenu = doPop2(m);
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

    private CustomMapRightClickMenu doPop2(MouseEvent e) {
        CustomMapRightClickMenu menu = new CustomMapRightClickMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
        return menu;
    }

}
