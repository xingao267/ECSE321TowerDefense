package CritterModels;

import TempModels.Cell;

public abstract class Critter {
	
	
	private String type;
	private double speed;							//from 0-1
	private int healthPoints, bounty, strength;
	private boolean isBeingHit;
	private Cell location;
	private int xPos, yPos;
	
	
	public Critter(){
		location = null;
	}
	
	/**
	 * Returns whether the critter is dead or not
	 * @return boolean value representing wether the critter is dead or not
	 */
	public boolean isDead(){
		return (healthPoints <= 0);
	}
	
	/**
	 * Sets the location and the X and Y position of the critter to be the position of the entry point Cell of the Path
	 * @param entryPoint	First Cell on the Path
	 */
	public void spawn(Cell entryPoint){
		location = entryPoint;
		xPos = entryPoint.getXCoord();
		yPos = entryPoint.getYCoord();
	}
	
	public void setLocation(int x, int y){
		setLocation(new Cell(x,y));
	}
	
	public void setLocation(Cell c){
		location = c;
	}
	
	public abstract String getType();
	
	public abstract double getSpeed();
	
	public abstract int getBounty();
	
	public abstract int getStrength();
	
	public abstract int getHealthPoints();
	
	public abstract Cell getLocation();
	
	public abstract int getXPos();
	
	public abstract int getYPos();
	
	public abstract void setType(String type);
	
	public abstract void setSpeed(double speed);
	
	public abstract void setBounty(int bounty);
	
	public abstract void setStrength(int strength);
	
	public abstract void setHealthPoints(int healthPoints);
	
	
	
	public abstract void setXPos(int xPos);
	
	public abstract void setYPos(int yPos);
	
	
}
