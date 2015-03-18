package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import OtherModels.Bank;
import OtherModels.Player;

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
	
	public MapSelectPane mapSelectPane;

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
		menu = new MainMenu();	
//		store = new Store();
//		player = new Player();
//		bank = new Bank();
//		mapSelectPane = new MapSelectPane();
	}
	
	public void paintComponent(Graphics g){
		
		if(isFirst) {
			screenWidth = getWidth();
			screenHeight = getHeight();
//			System.out.println(screenHeight);
//			System.out.println(screenWidth);
			init();
			isFirst = false;
		}
		
		
		
		g.setColor(new Color(60, 60, 60));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		//display the main menu
		menu.draw(g);
//		mapSelectPane.draw(g);
//		store.draw(g);
//		player.draw(g);
//		bank.draw(g);
	}
	
	
	/**
	 * Game Loop
	 */
	public void run(){

		//Game Loop
		while(true){
			
			repaint();
			try{
				gameLoop.sleep(1);
			} catch(Exception e){}
			
		}
	}
}
