package Map;

public class Path extends Cell {
	
	private Cell next;
	private Cell previous; 
	
	/**
	 * Path Constructor
	 * @param previous
	 * @param next
	 */
	public Path(int x, int y, Cell previous, Cell next){
		this.next = next;
		this.setPath();
		super.setCoordinates(x,y);
		//this.previous = previous;	
	}
	/**
	 * Returns next cell in path
	 * @return
	 */
	public Cell next(){
		return this.next;
	}
	
	/**
	 * Returns previous cell in path
	 * @return
	 */
	/*public Cell previous(){
		return this.previous;
	}*/
	
	/**
	 * Returns true if cell is entry node
	 * @return
	 */
	public boolean isEntry(){
		
		return this.previous == null;		
	}
	
	/**
	 * Returns true id cell is exit node
	 * @return
	 */
	public boolean isExit(){
		return this.next == null;
	}
	
}
