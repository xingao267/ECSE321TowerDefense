package MapPresets;

import java.util.ArrayList;

import Map.*;

/**
 * This is the Easy Map preset
 * @author Justin
 *
 */
public class EasyMap {
	
	private Map m;
	private MapDesigner d;
	private ArrayList<Integer> xCoords= new ArrayList<Integer>();
	private ArrayList<Integer> yCoords= new ArrayList<Integer>();
	
	public EasyMap(){
		
		this.m = new Map("Easy Map", 15, 9);
		this.d = new MapDesigner(m);
		
		addNextNode(0, 8);
		addNextNode(1, 8);
		addNextNode(1, 7);
		addNextNode(1, 6);
		addNextNode(1, 5);
		addNextNode(1, 4);
		addNextNode(1, 3);
		addNextNode(1, 2);
		addNextNode(1, 1);
		addNextNode(2, 1);
		addNextNode(3, 1);
		addNextNode(3, 2);
		addNextNode(3, 3);
		addNextNode(3, 4);
		addNextNode(3, 5);
		addNextNode(3, 6);
		addNextNode(4, 6);
		addNextNode(5, 6);
		addNextNode(5, 5);
		addNextNode(5, 4);
		addNextNode(5, 3);
		addNextNode(6, 3);
		addNextNode(7, 3);
		addNextNode(7, 4);
		addNextNode(7, 5);
		addNextNode(7, 6);
		addNextNode(7, 7);
		addNextNode(7, 8);
		addNextNode(8, 8);
		addNextNode(9, 8);
		addNextNode(9, 7);
		addNextNode(9, 6);
		addNextNode(9, 5);
		addNextNode(9, 4);
		addNextNode(9, 3);
		addNextNode(9, 2);
		addNextNode(9, 1);
		addNextNode(10, 1);
		addNextNode(11, 1);
		addNextNode(12, 1);
		addNextNode(12, 2);
		addNextNode(12, 3);
		addNextNode(12, 4);
		addNextNode(12, 5);
		addNextNode(12, 6);
		addNextNode(12, 7);
		addNextNode(12, 8);
		addNextNode(13, 8);
		addNextNode(14, 8);
		addNextNode(14, 7);
		addNextNode(14, 6);
		addNextNode(14, 5);
		addNextNode(14, 4);
		addNextNode(14, 3);
		addNextNode(14, 2);
		addNextNode(14, 1);
		
		d.modifyNodeToPath(xCoords.get(0), yCoords.get(0), null, null);
		m.setStart(m.getPath(0));
		
		Path previous;
		
		for(int i=1;i<xCoords.size(); i++){
			previous= m.getPath(i-1);
			d.modifyNodeToPath(xCoords.get(i), yCoords.get(i), previous, null);
			previous.setNext(m.getPath(i));
		}
		
		m.setEnd(m.getPath(xCoords.size()-1)); 
		
	}
	
	public Map getEasyMap(){
		return this.m;
	}
	
	private void addNextNode(int x, int y){
		xCoords.add(x);
		yCoords.add(y);
	}
	
}
