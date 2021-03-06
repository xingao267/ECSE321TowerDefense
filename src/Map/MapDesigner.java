package Map;

import java.awt.Point;
import java.util.ArrayList;

import Utility.Utils;

/**
 * This class provides all methods for modifying parts of the map and an interface for creating a path through a blank map
 * @author Eric, Justin
 * 
 **/
public class MapDesigner {
	private Map custom; /**Contains the map which will be modified by the designer*/
	
	/**Initializes the designer by setting the map to be worked on*/
	public MapDesigner(Map custom) {
		this.custom = custom;
	}
	
	/**This method modifies the node at the specified coordinates to a path by creating a new path tile and overwriting the scenery tile*/
	public void modifyNodeToPath(int x, int y, Path previous, Path next){
		Path newP = new Path(x, y, previous, next);
		custom.setCell(newP, x, y);
		custom.addPathNode(newP);
	}
	
	/**This method generates a default map from an arraylist of x and y coordinates*/
	public void createDefaultPath(ArrayList<Integer> xCoords, ArrayList<Integer> yCoords){
		modifyNodeToPath(xCoords.get(0), yCoords.get(0), null, null);
		custom.setStart(custom.getPath(0));
		custom.getPath(0).setStart();
		
		Path previous;
		
		for(int i = 1;i < xCoords.size(); i++){
			previous = custom.getPath(i-1);
			modifyNodeToPath(xCoords.get(i), yCoords.get(i), previous, null);
			previous.setNext(custom.getPath(i));
		}
		
		endMap();
	}
	
	public void addPathNodeFromClick(Point p){
		custom.clearIndicators();
		Point mapPoint = Utils.convertScreenToMapCoord(p);
		int ixCoord = (int) mapPoint.getX();
		int iyCoord = (int) mapPoint.getY();
		
		if (custom.pathEmpty()){
			modifyNodeToPath(ixCoord, iyCoord, null, null);
			custom.setStart(custom.getPath(0));
			custom.getPath(0).setStart();
			updateIndicators();
		}
		else{
			int index = custom.pathSize();
			Path previous = custom.getPath(index-1); //verify this
			modifyNodeToPath(ixCoord, iyCoord, previous, null);
			previous.setNext(custom.getPath(index));
			updateIndicators();
		}
		
	}
	
	public void updateIndicators(){
		Path last = custom.getPath(custom.pathSize()-1);
		int lastxCoord = last.getXCoordinate();
		int lastyCoord = last.getYCoordinate();
		
		if(lastxCoord + 1 < custom.getWidth()){
			if(!custom.isPath(lastxCoord + 1, lastyCoord)){
				custom.addIndicator(new Cell(lastxCoord + 1, lastyCoord));
			}	
		}
		if(lastxCoord - 1 >= 0){
			if(!custom.isPath(lastxCoord - 1, lastyCoord)){
				custom.addIndicator(new Cell(lastxCoord - 1, lastyCoord));
			}
		}
		if(lastyCoord + 1 < custom.getHeight()){
			if(!custom.isPath(lastxCoord, lastyCoord + 1)){
				custom.addIndicator(new Cell(lastxCoord, lastyCoord + 1));
			}
		}
		if(lastyCoord - 1 >= 0){
			if(!custom.isPath(lastxCoord, lastyCoord - 1)){
				custom.addIndicator(new Cell(lastxCoord, lastyCoord - 1));
			}
		}
		
	}
	
	public void endMap(){
		custom.setEnd(custom.getPath(custom.pathSize() - 1));
		custom.getPath(custom.pathSize() - 1).setEnd();
	}

}
