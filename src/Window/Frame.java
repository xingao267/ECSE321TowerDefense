package Window;

import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author Jose
 *
 */
public class Frame extends JFrame {

	public static String title = "ECSE 321 - Tower Defense";
	public static int width, height;
	
	
	public Frame(){
		new JFrame();
		
		setSize(800, 600);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(false);
		setResizable(false);
		setLocationRelativeTo(null);
		width = getWidth();
		height = getHeight();
		
		init();
	}
	
	public void init(){
//		this.setLayout(new GridLayout(1, 1, 0, 0));
		
		Screen screen = new Screen(this);
		this.add(screen);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args){
		new Frame();
	}
}
