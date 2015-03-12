package Window;

import java.awt.*;

public class Store {

	public static final int BUTTON_SIZE = 50;
	public static final int SPACING = 5;
	public static final int NUM_TOWERS = 8;
	
	public Rectangle[] towers = new Rectangle[NUM_TOWERS];
	
	public Store(){
		define();
	}
	
	public void define(){
		for(int i = 0; i < towers.length; i++){
			towers[i] = new Rectangle(10 +(BUTTON_SIZE+ SPACING)*i, 35, BUTTON_SIZE, BUTTON_SIZE);
		}
	}
	
	public void draw(Graphics g){
		for(int i = 0; i < towers.length; i++){
			g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
		}
	}
}
