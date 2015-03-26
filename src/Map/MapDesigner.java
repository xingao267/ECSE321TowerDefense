package Map;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Utility.Constants;
import Utility.Utils;

/**
 * This class provides all methods for modifying parts of the map and an interface for creating a path through a blank map
 * @author Eric, Justin
 * 
 **/
public class MapDesigner {
	private Map custom; /**Contains the map which will be modified by the designer*/
	
	/**Initialises the designer by setting the map to be worked on*/
	public MapDesigner(Map custom) {
		this.custom=custom;
	}
	
	/**This method modifies the node at the specified coordinates to a path by creating a new path tile and overwriting the scenery tile*/
	public void modifyNodeToPath(int x, int y, Path previous, Path next){
		Path newP=new Path(x, y, previous, next);
		custom.setCell(newP, x, y);
		custom.addPathNode(newP);
		//custom.getCell(x, y).setPath();
	}
	
	/**This method modifies the node at the specified coordinates to a path by creating a new path tile *without linking to others* and overwriting the scenery tile*/
	public void modifyNodeToPath(int x, int y){
		custom.setCell(new Path(x, y), x, y);
	}
	
	//TODO:All of this needs to be rewritten using the GUI as input
	/**This method generates a default map from an arraylist of x and y coordinates*/
	public void createDefaultPath(ArrayList<Integer> xCoords, ArrayList<Integer> yCoords){
		modifyNodeToPath(xCoords.get(0), yCoords.get(0), null, null);
		custom.setStart(custom.getPath(0));
		custom.getPath(0).setStart();
		
		Path previous;
		
		for(int i=1;i<xCoords.size(); i++){
			previous= custom.getPath(i-1);
			modifyNodeToPath(xCoords.get(i), yCoords.get(i), previous, null);
			previous.setNext(custom.getPath(i));
		}
		
		endMap();
	}
	
	public void addPathNodeFromClick(Point p, boolean last){
		custom.clearIndicators();
		Point mapPoint= Utils.convertScreenToMapCoord(p);
		int ixCoord= (int) mapPoint.getX();
		//System.out.println(ixCoord);
		int iyCoord= (int) mapPoint.getY();
		//System.out.println(iyCoord);
		
		if (custom.pathSize()==0){
			modifyNodeToPath(ixCoord, iyCoord, null, null);
			custom.setStart(custom.getPath(0));
			updateIndicators();
		}
		else if(last){
			int index=custom.pathSize();
			Path previous= custom.getPath(index-1); //verify this
			modifyNodeToPath(ixCoord, iyCoord, previous, null);
			previous.setNext(custom.getPath(index-1)); //and this as well
			custom.setEnd(custom.getPath(index-1));
		}
		else{
			int index=custom.pathSize();
			Path previous= custom.getPath(index-1); //verify this
			modifyNodeToPath(ixCoord, iyCoord, previous, null);
			previous.setNext(custom.getPath(index-1));
			updateIndicators();
		}
		
	}
	
	public void updateIndicators(){
		Path last= custom.getPath(custom.pathSize()-1);
		int lastxCoord=last.getXCoordinate();
		int lastyCoord=last.getYCoordinate();
		
		if(lastxCoord+1<custom.getWidth()){
			if(!custom.isPath(lastxCoord+1, lastyCoord)){
				custom.addIndicator(new Cell(lastxCoord+1, lastyCoord));
			}	
		}
		if(lastxCoord-1>=0){
			if(!custom.isPath(lastxCoord-1, lastyCoord)){
				custom.addIndicator(new Cell(lastxCoord-1, lastyCoord));
			}
		}
		if(lastyCoord+1<custom.getHeight()){
			if(!custom.isPath(lastxCoord, lastyCoord+1)){
				custom.addIndicator(new Cell(lastxCoord, lastyCoord+1));
			}
		}
		if(lastyCoord-1>=0){
			if(!custom.isPath(lastxCoord, lastyCoord-1)){
				custom.addIndicator(new Cell(lastxCoord, lastyCoord-1));
			}
		}
		
	}
	
	public void endMap(){
		custom.setEnd(custom.getPath(custom.pathSize()-1));
		custom.getPath(custom.pathSize()-1).setEnd();
	}
	
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
					custom.setStart((Path) custom.getCell(0,y1));//sets the start node of the map
					((Path) custom.getCell(0,y1)).setStart();//assigns the tile at that point as a start node
				
					correct=true; //end loop
				}
			}
			boolean complete=false;
			Cell current=custom.getStart();
			while(!complete){ //loop until a complete path has been entered
				int currentX=current.getXCoordinate();
				int currentY=current.getYCoordinate();
			
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
				Path newCell=(Path) custom.getCell(x, y);
				((Path) custom.getCell(currentX, currentY)).setNext(newCell);
				current=newCell;
				
				//if the new path node is adjacent to the rightmost edge of the map, set it as the end node and exit
				if(x==custom.getWidth()-1){
					custom.setEnd(newCell);
					((Path) newCell).setEnd();
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
			if(custom.getCell(xT, yT).isScenery()){
				System.out.println("Tower successfully placed");
				custom.getCell(xT, yT).setHasTower(true);
				//placeTower(xT, yT);
				isPath=false;
			}
		}	
		
	}

}
