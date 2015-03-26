package Map;

import java.util.ArrayList;

/**This class contains all parameters and methods associated with a generated map instance
 * 
 * @author Justin, Eric
 * */
public class Map {
	private String name; /**name of the map*/
	private int width;	/**width in number of cells of the map*/
	private int height; /**height in number of cells of the map*/
	private Cell[][] cells; /**2D array of cells which comprise the total map*/
	private Path start; /**the start tile*/
	private Path end; /**the end tile*/
	private ArrayList<Path> path= new ArrayList<Path>();
	private ArrayList<Cell> ind= new ArrayList<Cell>();
	
	/**Map constructor which sets the width, height, name and initialises a blank map with only scenery cells*/
	public Map(String name, int width, int height) {
		this.width=width;
		this.height=height;
		this.name=name;
		
		initializeBlankMap();
		
	}
	
	/**Initialises a blank map comprised of only scenery cells*/
	public void initializeBlankMap(){
		this.cells=new Cell[width][height];
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				this.cells[i][j]= new Cell(true, i, j);
			}
		}
	}
	
	/**Returns the map width in cells*/
	public int getWidth(){
		return this.width;
	}
	
	/**Returns the map height in cells*/
	public int getHeight(){
		return this.height;
	}
	
	/**Returns the tile at specified coordinates of the map*/
	public Cell getCell(int x, int y){
		return this.cells[x][y];
	}
	
	/**Sets the tile at specified coordinates of the map to a new tile*/
	public void setCell(Cell add, int x, int y){
		this.cells[x][y]=add;
	}
	
	/**Returns the map's path starting tile*/
	public Cell getStart(){
		return this.start;
	}
	
	/**Sets the starting tile of the map's path to a specified tile*/
	public void setStart(Path start){
		this.start=start;
		int pathX = start.getXCoordinate();
		int pathY = start.getYCoordinate();
		this.cells[pathX][pathY] = this.start;
	}
	
	/**Sets the end tile of the map's path to a specified tile*/
	public void setEnd(Path end){
		this.end=end;
		int pathX = end.getXCoordinate();
		int pathY = end.getYCoordinate();
		this.cells[pathX][pathY] = this.end;
	}
	
	/**Returns true if the tile located at the specified coordinates is a path, false otherwise*/
	public boolean isPath(int x, int y){
		if(!this.cells[x][y].isScenery()){
			return true;
		}
		else return false;
	}
	
	/**Adds a path node to the arraylist of path nodes*/
	public void addPathNode(Path p){
		path.add(p);
	}
	
	/**Gets the path node from a specific index of the arraylist of path nodes*/
	public Path getPath(int index){
		return path.get(index);
	}
	
	public int pathSize(){
		return this.path.size();
	}
	
	/**Determines if the current path node and the previous path node are adjacent*/
	public boolean validNeighbor(Path current){
		int currentX= current.getXCoordinate();
		int currentY= current.getYCoordinate();
		
		Path previous= current.getPrevious();
		if(previous==null){
			return true;
		}
		int previousX= previous.getXCoordinate();
		int previousY= previous.getYCoordinate();
		
		
		
		if(currentX==previousX){
			if(currentY==previousY+1 || currentY==previousY-1){
				if(isPath(currentX, currentY) || isPath(currentX, currentY)){
					return false;
				}
				else{return true;}
			}
			else{return false;}
		}
		else if(currentY==previousY){
			if(currentX==previousX+1 || currentX==previousX-1){
				if(isPath(currentX, currentY) || isPath(currentX, currentY)){
					return false;
				}
				else{return true;}
			}
			else{return false;}
		}
		else{return false;}
	}
	
	/**Returns true if the path contained by the map has a connected path from the starting tile to the end tile*/
	public boolean validPath(){            //TODO: Put in checks to see which path it's currently at
		int max=this.width*this.height;
		int count=0;
		Path current= start;
//		int currentX= current.getXCoordinate();
//		int currentY= current.getYCoordinate();
//		boolean isExit = current.isExit();
		
		while(count<max){
			
//			System.out.println("Current X: " + currentX);
//			System.out.println("Current Y: " + currentY);
//			System.out.println("Exit Node? " + isExit);
			
			if(!validNeighbor(current)){
//				System.out.println("!validNeighbour");
				return false;	
			}
			if(current.next().isExit()){
				return true;
			}
			current=current.next();
//			currentX= current.getXCoordinate();
//			currentY= current.getYCoordinate();
//			isExit = current.isExit();
			count++;
		}
//		System.out.println("False");
		return false;
	}
	
	/**Returns the coordinates of the next path node for critters*/
	public int[] getNextPathNode(Path p){
		Path next= p.next();
		int[] coords= new int[2];
		coords[0]=next.getXCoordinate();
		coords[1]=next.getYCoordinate();
		
		return coords;
	}
	
	/**Used to add an indicator cell for map designer purposes*/
	public void addIndicator(Cell i){
		ind.add(i);
	}
	/**Used to get a cell for map designer purposes*/
	public Cell getIndicator(int i){
		return ind.get(i);
	}
	/**Used to clear indicator cells after a path node has been selected when designing a map*/
	public void clearIndicators(){
		ind.clear();
	}
	
	public boolean noIndicators(){
		if(ind.isEmpty()){
			return true;
		}
		else{return false;}
	}
	public int numIndicators(){
		return ind.size();
	}
	
}
