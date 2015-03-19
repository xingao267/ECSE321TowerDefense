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
		
		setSize(1366, 768);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(false);
		setResizable(true);
		this.setLocationRelativeTo(null);
		width = getWidth();
		height = getHeight();
		
		init();
	}
	
	public void init(){
//		this.setLayout(new GridLayout(1, 1, 0, 0));
		
		Screen screen = new Screen(this);
		this.add(screen);
		
		setVisible(true);
		
//		System.out.println(height);
//		System.out.println(width);
	}
	
	
	public static void main(String[] args){
		new Frame();
	}
}
