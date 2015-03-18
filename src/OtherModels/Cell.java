package OtherModels;

public class Cell {

	public int id; // 0: Scenery Cell, 1: Path Cell
	private int xCoord;
	private int yCoord;

	public Cell(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public boolean isExitPoint() {
		if (xCoord == 3 && yCoord == 4)
			return true;
		else
			return false;
	}

	public int getCellId() {
		return id;
	}

	public void setCell(int id) {
		this.id = id;
	}

	public int getXCoord() {
		return xCoord;
	}

	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}
}
