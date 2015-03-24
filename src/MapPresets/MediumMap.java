package MapPresets;

import java.util.ArrayList;

import Map.*;

/**
 * This is the Medium Map preset
 * @author Justin
 */
public class MediumMap {
	
	private Map m;
	private MapDesigner d;
	private ArrayList<Integer> xCoords= new ArrayList<Integer>();
	private ArrayList<Integer> yCoords= new ArrayList<Integer>();
	
	public MediumMap(){
		
		this.m = new Map("Medium Map", 15, 9);
		this.d = new MapDesigner(m);
		
		addNextNode(0, 0);
		addNextNode(1, 0);
		addNextNode(1, 1);
		addNextNode(1, 2);
		addNextNode(1, 3);
		addNextNode(1, 4);
		addNextNode(2, 4);
		addNextNode(3, 4);
		addNextNode(4, 4);
		addNextNode(5, 4);
		addNextNode(5, 5);
		addNextNode(5, 6);
		addNextNode(5, 7);
		addNextNode(5, 8);
		addNextNode(6, 8);
		addNextNode(7, 8);
		addNextNode(8, 8);
		addNextNode(9, 8);
		addNextNode(10, 8);
		addNextNode(11, 8);
		addNextNode(11, 7);
		addNextNode(11, 6);
		addNextNode(11, 5);
		addNextNode(11, 4);
		addNextNode(11, 3);
		addNextNode(12, 3);
		addNextNode(13, 3);
		addNextNode(14, 3);
		
		d.createDefaultPath(xCoords, yCoords);
		boolean valid=m.validPath();
		//System.out.println(valid);
	}
	
	public Map getMediumMap(){
		return this.m;
	}
	
	private void addNextNode(int x, int y){
		xCoords.add(x);
		yCoords.add(y);
	}
	
}
