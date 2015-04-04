package Map;

/**
 * This class represents the Path object
 * @author Justin, Eric
 *
 */
public class Path extends Cell {
	
	private Path next;
	private Path previous; 
	private boolean isStart;
	private boolean isExit;
	/**
	 * Path Constructor
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param previous previous Path tile
	 * @param next next Path tile
	 */
	public Path(int x, int y, Path previous, Path next){
		this.next = next;
		this.setPath();
		super.setCoordinates(x,y);
		this.isStart = false;
		this.isExit = false;
		//this.previous = previous;	
	}
	
	/**
	 * Path Constructor
	 * @param x
	 * @param y
	 */
	public Path(int x, int y){
		this.setPath();
		super.setCoordinates(x, y);
		this.isStart = false;
		this.isExit = false;
	}
	
	public void setNext(Path next){
		this.next = next;
	}
	
	/**
	 * Returns next cell in path
	 * @return
	 */
	public Path next(){
		return this.next;
	}
	
	/**
	 * Sets Path cell as start
	 */
	public void setStart(){
		this.isStart = true;
	}
	
	/**
	 * Sets Path cell as exit
	 */
	public void setEnd(){
		this.isExit = true;
	}
	
	
	/**
	 * Returns true if cell is entry node
	 * @return
	 */
	public boolean isEntry(){
		return this.isStart;		
	}
	
	/**
	 * Returns true id cell is exit node
	 * @return
	 */
	public boolean isExit(){
		return this.isExit;
	}

	public Path getPrevious() {
		return this.previous;
	}
	
}
