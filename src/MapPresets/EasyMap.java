package MapPresets;

import Map.*;

/**
 * This is the Easy Map preset
 * @author Justin
 *
 */
public class EasyMap {
	
	private Map m;
	private MapDesigner d;
	
	public EasyMap(){
		
		this.m = new Map("Easy Map", 15, 9);
		this.d = new MapDesigner(m);
		
		d.modifyNodeToPath(0, 8);
		d.modifyNodeToPath(1, 8);
		d.modifyNodeToPath(1, 7);
		d.modifyNodeToPath(1, 6);
		d.modifyNodeToPath(1, 5);
		d.modifyNodeToPath(1, 4);
		d.modifyNodeToPath(1, 3);
		d.modifyNodeToPath(1, 2);
		d.modifyNodeToPath(1, 1);
		d.modifyNodeToPath(2, 1);
		d.modifyNodeToPath(3, 1);
		d.modifyNodeToPath(3, 2);
		d.modifyNodeToPath(3, 3);
		d.modifyNodeToPath(3, 4);
		d.modifyNodeToPath(3, 5);
		d.modifyNodeToPath(3, 6);
		d.modifyNodeToPath(4, 6);
		d.modifyNodeToPath(5, 6);
		d.modifyNodeToPath(5, 5);
		d.modifyNodeToPath(5, 4);
		d.modifyNodeToPath(5, 3);
		d.modifyNodeToPath(6, 3);
		d.modifyNodeToPath(7, 3);
		d.modifyNodeToPath(7, 4);
		d.modifyNodeToPath(7, 5);
		d.modifyNodeToPath(7, 6);
		d.modifyNodeToPath(7, 7);
		d.modifyNodeToPath(7, 8);
		d.modifyNodeToPath(8, 8);
		d.modifyNodeToPath(9, 8);
		d.modifyNodeToPath(9, 7);
		d.modifyNodeToPath(9, 6);
		d.modifyNodeToPath(9, 5);
		d.modifyNodeToPath(9, 4);
		d.modifyNodeToPath(9, 3);
		d.modifyNodeToPath(9, 2);
		d.modifyNodeToPath(9, 1);
		d.modifyNodeToPath(10, 1);
		d.modifyNodeToPath(11, 1);
		d.modifyNodeToPath(12, 1);
		d.modifyNodeToPath(12, 2);
		d.modifyNodeToPath(12, 3);
		d.modifyNodeToPath(12, 4);
		d.modifyNodeToPath(12, 5);
		d.modifyNodeToPath(12, 6);
		d.modifyNodeToPath(12, 7);
		d.modifyNodeToPath(12, 8);
		d.modifyNodeToPath(13, 8);
		d.modifyNodeToPath(14, 8);
		d.modifyNodeToPath(14, 7);
		d.modifyNodeToPath(14, 6);
		d.modifyNodeToPath(14, 5);
		d.modifyNodeToPath(14, 4);
		d.modifyNodeToPath(14, 3);
		d.modifyNodeToPath(14, 2);
		d.modifyNodeToPath(14, 1);
		
		
		
		m.setStart((Path) m.getCell(0, 8));
		m.setEnd((Path) m.getCell(14, 1)); 
		
	}
	
	public Map getEasyMap(){
		return this.m;
	}
	
}
