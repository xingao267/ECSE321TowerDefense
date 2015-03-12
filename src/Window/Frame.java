package Window;

import javax.swing.*;

public class Frame extends JFrame {

	public static String title = "Tower Defense";
	public Frame(){
		new JFrame();
		
//		this.setSize(800, 600);
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(false);
		this.setResizable(true);
		this.setVisible(true);
//		this.setLocationRelativeTo(null);
		
		Screen screen = new Screen(this);
		this.add(screen);
	}
	
	public static void main(String[] args){
		new Frame();
	}
}
