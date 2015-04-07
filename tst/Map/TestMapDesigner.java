package Map;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Utility.Utils;

/**
 * 
 * @author Justin
 *
 */
public class TestMapDesigner {
	
	private Map map;
	private MapDesigner mapDesigner;
	private ArrayList<Integer> xCoords= new ArrayList<Integer>();
	private ArrayList<Integer> yCoords= new ArrayList<Integer>();
	
	@Before
	public void setUp() throws Exception {
		
		map = new Map("test", 15, 9);
		mapDesigner = new MapDesigner(map);
		
	}

	@Test
	public void testModifyNodeToPath() {
		
		assertTrue(map.getCell(5, 5).isScenery());
		mapDesigner.modifyNodeToPath(5, 5, null, null);
		assertFalse(map.getCell(5, 5).isScenery());
		
	}

	@Test
	public void testCreateDefaultPath() {
		
		addNextNode(0, 8);
		addNextNode(1, 8);
		addNextNode(1, 7);
		addNextNode(1, 6);
		addNextNode(1, 5);
		
		mapDesigner.createDefaultPath(xCoords, yCoords);
		assertTrue(map.validPath());
	}
	
	@Test
	public void testAddPathNodeFromClick() {
		
		Point mapPoint = Utils.convertMapCoordToScreen(5, 6);
		assertTrue(map.getCell((int) Utils.convertScreenToMapCoord(mapPoint).getX(),(int) Utils.convertScreenToMapCoord(mapPoint).getX()).isScenery());
		mapDesigner.addPathNodeFromClick(mapPoint);
		assertFalse(map.getCell((int) Utils.convertScreenToMapCoord(mapPoint).getX(), (int) Utils.convertScreenToMapCoord(mapPoint).getY()).isScenery());
		
	}
	
	private void addNextNode(int x, int y){
		xCoords.add(x);
		yCoords.add(y);
	}
}
