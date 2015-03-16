package Window;

import java.awt.event.*;
import java.awt.*;

public class KeyHandler implements MouseMotionListener, MouseListener {

	public void mouseClicked(MouseEvent m) {
		
	}

	public void mouseEntered(MouseEvent m) {
		
	}

	public void mouseExited(MouseEvent m) {
		
	}

	public void mousePressed(MouseEvent m) {
		
	}

	public void mouseReleased(MouseEvent m) {
		
	}

	public void mouseDragged(MouseEvent m) {
		Screen.mouseLocation = new Point(m.getX() - ((Frame.width - Screen.screenWidth)/2), m.getY() - ((Frame.height - (Screen.screenHeight)) - (Frame.width - Screen.screenWidth)/2));
	}

	public void mouseMoved(MouseEvent m) {
		Screen.mouseLocation = new Point(m.getX() - ((Frame.width - Screen.screenWidth)/2), m.getY() - ((Frame.height - (Screen.screenHeight)) - (Frame.width - Screen.screenWidth)/2));
	}
	
	

}
