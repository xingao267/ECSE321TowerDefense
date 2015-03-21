package Map;
/**
 * This class represents the individual cells of which the map is composed
 * @author Justin, Eric
 *
 */
public class Cell {

	private boolean scenery;
	private int xCoord;
	private int yCoord;
	private boolean hasTower;
	
	/**
	 * Cell constructor with parameters
	 * @param coordinates
	 */
	public Cell(boolean scenery, int x, int y) {
		this.scenery = scenery;
		this.setCoordinates(x, y);
		this.hasTower = false;
	}
	
	/**
	 * General Cell constructor. Initialises cellType and coordinates to null
	 */
	public Cell(){
		this.scenery= true;
		this.xCoord = (Integer) null;
		this.yCoord = (Integer) null;
	}
	
	protected void setCoordinates(int x, int y){
		this.xCoord = x;
		this.yCoord= y;
	}

	/**
	 * Returns the type of the cell
	 * @return
	 */
	public boolean isScenery(){
		return scenery;
	}
	
	/**
	 * Returns the x-coordinate of the cell
	 * @return
	 */
	public int getXCoordinate(){
		return this.xCoord;
	}
	
	/**
	 * Returns the y-coordinate of the cell
	 * @return
	 */
	public int getYCoordinate(){
		return this.yCoord;
	}
	
	/**
	 * Sets the type of the cell
	 * @param newType
	 */
	public void setPath(){
		this.scenery = false;
	}
	
	public void setScenery(){
		this.scenery=true;
	}
	
	/**
	 * Sets whether or not the cell contains a tower
	 * @param hasTower
	 */
	public void setHasTower(boolean hasTower){
		this.hasTower = hasTower;
	}
	
	/**
	 * Returns true if cell contains a tower, false otherwise
	 * @return
	 */
	public boolean hasTower(){
		return hasTower;
	}

}
