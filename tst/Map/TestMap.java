package Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Justin
 *
 */
public class TestMap {
	
	Map map;
	
	@Before
	public void setUp() throws Exception {
		map = new Map("test", 15, 9);
	}

	@Test
	public void testInitializeBlankMap() {
		
			for(int i = 0; i < map.getWidth(); i++){
				for(int j = 0; j < map.getHeight(); j++){
					assertTrue(map.getCell(i, j).isScenery());
				}
			}
	}

	@Test
	public void testAddPathNode() {
		
		assertTrue(map.pathEmpty());
		
		Path path = new Path(5, 5);
		map.addPathNode(path);
		 
		assertTrue(map.pathSize() == 1);
		assertTrue(path instanceof Path);
		assertFalse(map.getPath(0).isScenery());

	}

	@Test
	public void testValidNeighbor() {
		
			
			Path path = new Path(5, 5);
			map.addPathNode(path);
			
			Path path1 = new Path(5, 6, path, null);
			map.addPathNode(path1);
			map.getPath(0).setNext(path1);
			
			Path path2 = new Path(13,1, path1, null);
			map.addPathNode(path2);
			map.getPath(1).setNext(path2);
			
			assertTrue(map.validNeighbor(map.getPath(1)));
			assertFalse(map.validNeighbor(map.getPath(2)));
		
	}

	@Test
	public void testValidPath() {

		Path path = new Path(5, 5);
		path.setStart();
		map.addPathNode(path);
		
		Path path1 = new Path(5, 6, path, null);
		map.addPathNode(path1);
		map.getPath(0).setNext(path1);
		
		Path path2 = new Path(6,6, path1, null);
		map.addPathNode(path2);
		map.getPath(1).setNext(path2);
		path2.setEnd();
		
		map.setStart(map.getPath(0));
		map.setEnd(map.getPath(map.pathSize()-1));
		assertTrue(map.validPath());
		
	}
	
	@Test
	public void testValidPathFail() {

		Path path = new Path(5, 5);
		path.setStart();
		map.addPathNode(path);
		
		Path path1 = new Path(5, 6, path, null);
		map.addPathNode(path1);
		map.getPath(0).setNext(path1);
		
		
		Path path2 = new Path(13,6, path1, null);
		map.addPathNode(path2);
		map.getPath(1).setNext(path2);
		path2.setEnd();
		
		
		map.setStart(map.getPath(0));
		map.setEnd(map.getPath(map.pathSize()-1));
		
		assertTrue(map.getStart().equals(map.getPath(0)));
		assertTrue(map.getPath(0).isEntry());
		assertTrue(map.getPath(0).next().equals(map.getPath(1)));
		assertTrue(map.getPath(1).next().equals(map.getPath(2)));
		try {
			assertTrue(map.getPath(2).next().equals(null));
		} catch (Exception e) {
		}
		assertTrue(map.getPath(2).equals(map.getPath(map.pathSize()-1)));
		assertTrue(map.getPath(map.pathSize() -1).isExit());
		
		assertTrue(map.validNeighbor(map.getPath(1)));
		assertFalse(map.validNeighbor(map.getPath(2)));

		assertFalse(map.validPath());
		
	}

}
