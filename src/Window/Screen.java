package Window;

import java.awt.*;

import javax.swing.*;

import TempModels.*;

import com.sun.javafx.scene.KeyboardShortcutsHandler;

/**
 * 
 * @author Jose
 *
 */
public class Screen extends JPanel implements Runnable{

	public Thread gameLoop = new Thread(this);
	
//	private int fps = 10000000 , fpsFrame = 0;
	
	public Frame frame;
	
	public static Point mouseLocation = new Point(0, 0);
	
	public MainMenu menu;

	private boolean isFirst = true;
	
	public static int screenWidth, screenHeight;
	
//	public static Map map;
	public static Store store;
	
	public static Player player;
	
	public static Bank bank;
	
	public Screen(Frame frame){
		this.frame = frame;
		frame.addMouseListener(new KeyHandler());
		frame.addMouseMotionListener(new KeyHandler());
		gameLoop.start();
	}
	
	public void init(){
//		menu = new MainMenu();
		store = new Store();
		player = new Player();
		bank = new Bank();
	}
	
	public void paintComponent(Graphics g){
		
		if(isFirst ) {
			screenWidth = getWidth();
			screenHeight = getHeight();
			init();
			isFirst = false;
		}
		
		
		
		g.setColor(new Color(60, 60, 60));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		//display the main menu
//		menu.draw(g);
		store.draw(g);
		player.draw(g);
		bank.draw(g);
	}
	
	
	/**
	 * Game Loop
	 */
	public void run(){
//		long lastFrame = System.currentTimeMillis();
//		int frames = 0;
		
		//Game Loop
		while(true){				
			repaint();
/*			frames++;
			if(System.currentTimeMillis() - 1000 >= lastFrame){
				fps = frames;
				frames = 0;
				lastFrame = System.currentTimeMillis();
			}
*/			try{
				gameLoop.sleep(1);
			} catch(Exception e){}
			
		}
	}
}
