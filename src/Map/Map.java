package Map;
import TowerModels.Tower;

public class Map {
	
	private Cell[][] cells;
	private Tower[] towers;
	private int[] size;
	private int[][] path;
	
	/**
	 * Map constructor. Uses inputs to create Map object in two steps: cell generation and path drawing 
	 * @param size
	 * @param path
	 */
	public Map (int[] size, int[][] path){
		
		generateMap(size);	
		drawPath(path);
	}
	
	/**
	 * Helper method for constructor, creates cell array
	 * @param size
	 */
	private void generateMap(int[] size){
		
		this.size = size;
		this.cells = new Cell[size[0]][size[1]];
		
		for(int x = 0; x < size[0]; x++){
			for(int y = 0; y < size[1]; y++){ 
				
				int[] coordinates = {x,y};
				Cell newCell = new Cell ("scenery", coordinates);
				cells[x][y] = newCell;
			}
		}
	}
	
	/**
	 * Helper method for constructor, converts scenery-type cells into path-type
	 * @param path
	 */
	private void drawPath(int[][] path){
		
		this.path = path;
		
		for(int x = 0; x < path.length; x++){
				
				//getting the cell coordinates from the path array
				int xCoord = path[x][0];
				int yCoord = path[x][1];
				
				//case 1: entry node
				if(x==0){
					
					int nextCellX = path[x+1][0];
					int nextCellY= path[x+1][1];
					
					cells[xCoord][yCoord] = new Path(null, cells[nextCellX][nextCellY]);
					cells[xCoord][yCoord].setCellType("path");
				} 
				//case 2: middle node
				else if (x < path.length - 1){
					
					int prevCellX = path[x-1][0];
					int prevCellY = path[x-1][1];
					int nextCellX = path[x+1][0];
					int nextCellY= path[x+1][1];
					
					cells[xCoord][yCoord] = new Path(cells[prevCellX][prevCellY], cells[nextCellX][nextCellY]);
					cells[xCoord][yCoord].setCellType("path");
				} 
				//case 3: last node
				else {
					
					int prevCellX = path[x-1][0];
					int prevCellY = path[x-1][1];
					
					cells[xCoord][yCoord] = new Path(cells[prevCellX][prevCellY], null);
					cells[xCoord][yCoord].setCellType("path");
				}
		}
	}
	
	/**
	 * Places a tower on the map if valid placement
	 * @param t
	 */
	public void placeTower(Tower t) { //throws Exception{
		
		int[] tCoords = t.getCoordinates();
		Cell test = cells[tCoords[0]][tCoords[1]];
		String testType = test.getCellType();
		
		//if(testType.equals("path") ||  test.hasTower()){
		//System.out.println("Invalid Placement");
			//throw new Exceptionn();
		//} else {
			
			test.setHasTower(true);
		//}		
	}
	/**
	 * Removes a tower from the map
	 * @param t
	 */
	public void removeTower(Tower t) { 
		
		int[] tCoords = t.getCoordinates();
		Cell test = cells[tCoords[0]][tCoords[1]];
		//String testType = test.getCellType();
		
		//if(test.hasTower()){
		//System.out.println("Removing tower");
		  test.setHasTower(false);
		//}		
	}
	
	/**
	 * Helper method to compare if two sets of coordinates are equal
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean isCoordEqual(int[] a, int[] b){
	
		return ((a[0] == b[0]) && (a[1] == b[1]));
			
	}
	
	/**
	 * Method to graphically represent map to be used by MapDriver
	 */
	public void printMap(){
		
		//Formatting to look nicer
		for(int i = 0; i < size[1]; i++){	
			System.out.print("___");
		}
		System.out.println();
		
		//Iterate through all cells, printing type
		for (int x = 0; x < cells.length; x ++){
			for(int y = 0; y < cells[1].length; y++){
				
				Cell test = cells[x][y];
				if (test.getCellType().equals("path")){
					System.out.print("|P|");
				} else if (test.hasTower()){
					System.out.print("|T|");
				} else {
					System.out.print("|S|");
				}
			}
			
			System.out.println();
			
			//Formatting to look nicer
			for(int i = 0; i < 3*size[1]; i++){	
			System.out.print("-");
			}
			System.out.println();
		}
	}
	
	/**
	 * Method to print map, showing indexes instead of type (except for path)
	 */
	public void printMapReference(){
		
		//Formatting to look nicer
		for(int i = 0; i < size[1]; i++){	
			System.out.print("____");
		}
		System.out.println();
		
		//Print index of cells
		int counter = 0; //used to keep track of when to pad with spaces for formatting
		for (int x = 0; x < cells.length; x ++){
			for(int y = 0; y < cells[1].length; y++){
				
				//check to make sure cell is not a path
				if(!cells[x][y].getCellType().equals("path")){ 
					if (counter < 9){
						//pad with spaces
						System.out.print("|" + counter + "| ");
						counter++;
					} else { 
						//dont pad
						System.out.print("|" + counter + "|");
						counter++;
					}
				} else {
					//Cell is a path
					System.out.print("|P| ");
					counter++;
				}
			}
			
			System.out.println();
			
			//Formatting to make it nicer
			for(int i = 0; i < size[1]; i++){	
			System.out.print("----");
			}
			System.out.println();
		}
	}
	
	/**
	 * Used to convert tile indexes in printed map to cell coordinates
	 * @param tiles
	 * @return
	 */
	public int[][] toCoords(int[] tiles){
		
		int[][] coords = new int[tiles.length][2];
		int width = this.size[1];
		
		for(int i =0; i < tiles.length; i++){
			
			int xCoord;
			int yCoord;
			int tile = tiles[i];
			
			xCoord = tile/width; //row number
			yCoord = tile%width; //column number
			
			coords[i][0] = xCoord;
			coords[i][1] = yCoord;
			
		}
		
		return coords;
	}
	
	/**
	 * Verifies the current map is valid based on specifications
	 * @return
	 */
	public boolean isValid(){
		
		//Check that towers haven't been placed on the path
		for(int i=0;i<cells.length; i++){
			for(int j =0; j<cells[0].length; j++){
				
				Cell test = cells[i][j];
				if(test.hasTower() && test.getCellType().equals("path")){
					System.out.println("ERROR: Towers have been placed on path!\nReturning to tower addition phase");
					test.setHasTower(false);
					return false;
				}
				
			}
		}
		
//		for (int i =0; i < towers.length; i++){
//			for (int j =0; j < path.length; j++){
//				if(isCoordEqual(towers[i].getCoordinates(), path[j])){
//					System.out.println("ERROR: Towers have been placed on path!");
//					return false;
//				}
//			}
//		}
		
		//Check that path is continuous 
		for(int i =0; i<path.length -1; i++){
			
			int[] coords1 = path[i];
			int[] coords2 = path[i+1];
			
			//if same column, check if they are in neighbouring rows
			if(coords1[0] == coords2[0]){
				if(coords1[1] != coords2[1] + 1 && coords1[1] != coords2[1] - 1){
					System.out.println("ERROR: Path is not continuous!\nReturning to path construction phase");
					return false;
				}
			} 
			//if same row, check if they are in neighbouring columns
			else if (coords1[1] == coords2[1]){
				if(coords1[0] != coords2[0] + 1 && coords1[0] != coords2[0] - 1){
					System.out.println("ERROR: Path is not continuous!\nReturning to path construction phase");
					return false;
				}
				
			}
			//if not neighbours at all, path is not continuous
			else{
				System.out.println("ERROR: Path is not continuous!\nReturning to path construction phase");
				return false;
			}	
		}
		
		//Check for path errors
		if(path.length > size[0]*size[1] || path.length == 0){
			System.out.println("ERROR: Path either doesn't exist, is too long, or out of bounds. Be careful of what you put in!\nReturning to path construction phase");
			return false;
		}
		
//		//Check that path is not longer than map
//				if(path.length > size[0]*size[1]){
//					System.out.println("ERROR: Path is longer than map!\nReturning to path construction phase");
//					return false;
//				}
//				
//				//Checks that path exists
//				if(path.length == 0){
//					System.out.println("ERROR There is no path!\nReturning to path construction phase");
//					return false;
//				}
		
		//Check for a single entry and exit node
		int entries = 0;
		int exits = 0;
		for(int i=0;i<cells.length; i++){ //count entries and exits
			for(int j =0; j<cells[0].length; j++){
				
				Cell test = cells[i][j];
				if(test.getCellType().equals("path")){
					if(((Path) test).isEntry()){
						entries++;
					} else if (((Path) test).isExit()){
						exits++;
					}
				}		
			}
		}
		
		if(entries != 1 || exits != 1){
			System.out.println("ERROR: Zero or multiple entry or exit nodes!\nReturning to path construction phase");
			return false;
		}
		
		
		
		return true;
	}
	
}
