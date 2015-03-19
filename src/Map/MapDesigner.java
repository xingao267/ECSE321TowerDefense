package Map;

import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**This class provides all methods for modifying parts of the map and an interface for creating a path through a blank map*/
public class MapDesigner {
	private Map custom; /**Contains the map which will be modified by the designer*/
	
	/**Initialises the designer by setting the map to be worked on*/
	public MapDesigner(Map custom) {
		this.custom=custom;
	}
	
	/**This method modifies the node at the specified coordinates to a path by creating a new path tile and overwriting the scenery tile*/
	public void modifyNodeToPath(int x, int y, Cell previous, Cell next){
		custom.setCell(new Path(x, y, previous, next), x, y);
	}
	
	//All of this needs to be re written using the GUI as input
	
	/**This is an interface with the user to create a path through a blank map*/
	public void createPath(){
		Scanner keyboard = new Scanner(System.in);
		boolean correct=false;
		boolean completedPath=false;
		while(!completedPath){
			while(!correct){ //loop until a valid value is entered
				System.out.println("Please enter a valid y coordinate of the starting node");
				int y1 = keyboard.nextInt();
				if(y1>=0 && y1<custom.getHeight()){ //ensures start node of path is along the leftmost edge of the map
					modifyNodeToPath(0,y1);
					custom.setStart(custom.getTile(0,y1));//sets the start node of the map
					custom.getTile(0,y1).setStart();//assigns the tile at that point as a start node
				
					correct=true; //end loop
				}
			}
			boolean complete=false;
			Tile current=custom.getStart();
			while(!complete){ //loop until a complete path has been entered
				int currentX=current.getXcoord();
				int currentY=current.getYcoord();
			
				boolean validX=false;
				boolean validY=false;
				int x=0;
				int y=0;
				while(!validX){
					System.out.println("Please enter a valid x coordinate of the next path node");
					x = keyboard.nextInt();
					if(x==currentX || x==(currentX+1)){ //ensures the x value entered is either the same (for up and down movement) or one more (for forward movement) as the current value
						validX=true;
					}
				}	
				while(!validY){
					System.out.println("Please enter a valid y coordinate of the next path node");
					y = keyboard.nextInt();
					//ensures that the path can only move up or down if the new x value is the same as the current x value to avoid diagonal movement
					//as well as preventing a path node from going out of bounds
					if((y==currentY && x!=currentX)|| (y==(currentY+1) && (currentY + 1)<custom.getHeight() && x==currentX) || (y==(currentY-1) && (currentY-1)>=0 && x==currentX)){
						if(!custom.isPath(x, y)){
							validY=true;
						}	
					}
				
				}
				
				//create new path node
				modifyNodeToPath(x,y);
				Tile newTile=custom.getTile(x, y);
				custom.getTile(currentX, currentY).setNext(newTile);
				current=newTile;
				
				//if the new path node is adjacent to the rightmost edge of the map, set it as the end node and exit
				if(x==custom.getWidth()-1){
					custom.setEnd(newTile);
					newTile.setEnd();
					complete=true;		
				}
				
				System.out.println("Path node successfully added");	
			}
			//check if the created path is valid
			boolean valid= custom.validPath();
			if(valid){
				System.out.println("A valid path has been created");
				completedPath=true;
			}
			else{
				System.out.println("Path is not valid, please start over");
				custom.initializeBlankMap();
			}
		}
	}
	
	public void addTower(){
		Scanner keyboard = new Scanner(System.in);
		boolean validX=false;
		boolean validY=false;
		boolean isPath=true;
		int xT=0;
		int yT=0;
		while(isPath){
			//ensure x coordinate is within the bounds of the map
			while(!validX){
				System.out.println("Please enter a valid x coordinate of the tower");
				xT = keyboard.nextInt();
				if(xT>=0 && xT<custom.getWidth()){
					validX=true;
				}
			}
			//ensure y coordinate is within the bounds of the map
			while(!validY){
				System.out.println("Please enter a valid y coordinate of the tower");
				yT = keyboard.nextInt();
				if(yT>=0 && yT<custom.getHeight()){
					validY=true;
				}
			}
			//if the chosen tile is of scenery type, it is valid to place a tower
			if(custom.getTile(xT, yT).tileType()==1){
				System.out.println("Tower successfully placed");
				placeTower(xT, yT);
				isPath=false;
			}
		}	
		
	}

}
