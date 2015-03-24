package MapPresets;

import java.util.ArrayList;

import Map.*;

/**
 * This is the Hard Map preset
 * @author Justin
 */
public class HardMap {
	
	private Map m;
	private MapDesigner d;
	private ArrayList<Integer> xCoords= new ArrayList<Integer>();
	private ArrayList<Integer> yCoords= new ArrayList<Integer>();
	
	public HardMap(){
		
		this.m = new Map("Hard Map", 15, 9);
		this.d = new MapDesigner(m);
		
		addNextNode(0, 0);
		addNextNode(1, 0);
		addNextNode(2, 0);
		addNextNode(3, 0);
		addNextNode(4, 0);
		addNextNode(5, 0);
		addNextNode(6, 0);
		addNextNode(6, 1);
		addNextNode(6, 2);
		addNextNode(6, 3);
		addNextNode(6, 4);
		addNextNode(6, 5);
		addNextNode(7, 5);
		addNextNode(8, 5);
		addNextNode(9, 5);
		addNextNode(10, 5);
		addNextNode(11, 5);
		addNextNode(12, 5);
		addNextNode(13, 5);
		addNextNode(14, 5);
		
		d.createDefaultPath(xCoords, yCoords);
		boolean valid=m.validPath();
		//System.out.println(valid);
	}
	
	public Map getHardMap(){
		return this.m;
	}
	
	private void addNextNode(int x, int y){
		xCoords.add(x);
		yCoords.add(y);
	}
	
}
