package Map;

public class Cell {

	private boolean scenery;
	private int[] coordinates;
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
		this.coordinates = null;
	}
	
	protected void setCoordinates(int x, int y){
		this.coordinates[0] = x;
		this.coordinates[1]= y;
	}

	/**
	 * Returns the type of the cell
	 * @return
	 */
	public boolean isScenery(){
		return scenery;
	}
	
	/**
	 * Returns the coordinates of the cell in the form {x,y}
	 * @return
	 */
	public int[] getCoordinates(){
		return coordinates;
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
