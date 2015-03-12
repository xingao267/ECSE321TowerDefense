package Window;

import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel implements Runnable{

	public Thread gameLoop = new Thread(this);
	private int fps = 0;
	public Frame frame;
	public Point mouselocation = new Point(0, 0);
	public static int screenWidth;
	public int screenHeight;
	
//	public static Map map;
	public static Store store;
	
	public Screen(Frame frame){
		this.frame = frame;
		gameLoop.start();
	}
	
	public void initialize(){
		store = new Store();
	}
	
	public void paintComponent(Graphics g){
		screenWidth = this.frame.getWidth();
		screenHeight = this.frame.getHeight();
		initialize();
				
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
		
		store.draw(g);
	}
	
	public void run(){
		long lastFrame = System.currentTimeMillis();
		int frames = 0;
		
		while(true){				//Game Loop
			repaint();
			frames++;
			if(System.currentTimeMillis() - 1000 >= lastFrame){
				fps = frames;
				frames = 0;
				lastFrame = System.currentTimeMillis();
			}
			try{
				gameLoop.sleep(1);
			} catch(Exception e){}
			
		}
	}
}
