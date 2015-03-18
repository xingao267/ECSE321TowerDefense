package Map;

public class Cell {

	private String cellType;
	private int[] coordinates;
	private boolean hasTower;
	
	/**
	 * Cell constructor with parameters
	 * @param cellType
	 * @param coordinates
	 */
	public Cell(String cellType, int[] coordinates){
		
		this.cellType = cellType;
		this.coordinates = coordinates;
		this.hasTower = false;
		
	}
	
	/**
	 * General Cell constructor. Initialises cellType and coordinates to null
	 */
	public Cell(){
		this.cellType= null;
		this.coordinates = null;
	}
	
	/**
	 * Returns the type of the cell
	 * @return
	 */
	public String getCellType(){
		return cellType;
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
	public void setCellType(String newType){
		this.cellType = newType;
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
