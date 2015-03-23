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
	}
	
	/**Sets the end tile of the map's path to a specified tile*/
	public void setEnd(Path end){
		this.end=end;
	}
	
	/**Returns true if the tile located at the specified coordinates is a path, false otherwise*/
	public boolean isPath(int x, int y){
		if(!this.cells[x][y].isScenery()){
			return true;
		}
		else return false;
	}
	
	public void addPathNode(Path p){
		path.add(p);
	}
	
	public Path getPath(int index){
		return path.get(index);
	}
	
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
	public boolean validPath(){            //TODO:rewrite this method to do a better check
		int max=this.width*this.height;
		int count=0;
		Path current= start;
		while(count<max){
			if(!validNeighbor(current)){
				return false;	
			}
			if(current.next().isExit()){
				return true;
			}
			else current=current.next();
		}
		
		return false;
	}
}
